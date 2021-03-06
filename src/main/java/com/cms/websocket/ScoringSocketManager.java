package com.cms.websocket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.GameMapper;
import com.cms.mapper.GroupMapper;
import com.cms.mapper.ParticipationMapper;
import com.cms.mapper.RefereeSeviceMapper;
import com.cms.pojo.Athlete;
import com.cms.pojo.Game;
import com.cms.pojo.Participation;
import com.cms.pojo.Referee;
import com.cms.util.MybatiesUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScoringSocketManager {

    public static ScoringSocketManager instance = new ScoringSocketManager();
    private ScoringControlServer admin;
    private Map<String, ScoringServer> clientMap;
    private Game game;
    private List<Athlete> athletesIn;
    private int currentAthlete;
    private List<Referee> relatedReferees;
    public boolean isInProgress;

    private ScoringSocketManager(){
        clientMap = new HashMap<String, ScoringServer>();
        System.out.println("Socket Manager initializes");
    }

    void addClient(ScoringServer node){
        synchronized (clientMap) {
            clientMap.put(node.referee.getIdNum(), node);
        }
        if(!this.isInProgress && this.refereesAllReady()){
            startGame();
        }
        System.out.println("referee " + node.referee.getName() + " in");
    }

    void removeClient(ScoringServer node){
        synchronized (clientMap) {
            clientMap.remove(node.referee.getIdNum());
        }
        System.out.println("referee " + node.referee.getName() + " out");
    }

    public void setAdmin(ScoringControlServer admin) {
        this.admin = admin;
    }

    public Game getScoringGame(){
        return game;
    }

    public void setScoringGame(Game game){
        this.game = game;
        synchronized (clientMap){
            if(this.clientMap.get(game.getrIdNum())!=null) {
                JSONObject msg = new JSONObject();
                msg.put("type", 4);
                msg.put("leader", true);
                try {
                    this.clientMap.get(game.getrIdNum()).send(msg.toJSONString());
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("发送信息失败");
                }
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("睡眠被中断");
                }
            }
        }
        if(!this.isInProgress && refereesAllReady()){
            startGame();
        }
    }

    private void startGame(){
        String boyPhoto = "http://04.imgmini.eastday.com/mobile/20180706/20180706171410_baf98c58c58879e2e6831bb1383e54cc_2.png";
        String girlPhoto = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1557860198364&di=62587cc340d5c2f1c2fc9c8b53507ee7&imgtype=0&src=http%3A%2F%2Fimg3.cache.netease.com%2Fgz2010%2F2010%2F10%2F18%2F20101018143916b51a4.jpg";


        int gameId = game.getGameId();
        String groupAge = game.getGroupAge();
        String lv = game.getLevel();
        String leaderID = game.getrIdNum();

        SqlSession sqlSession = MybatiesUtil.getSession();
        RefereeSeviceMapper mapper1 = sqlSession.getMapper(RefereeSeviceMapper.class);
        List<Referee> referees = mapper1.queryRelatedReferee(gameId);
        this.relatedReferees = referees;
        GameMapper mapper2 = sqlSession.getMapper(GameMapper.class);
        GroupMapper mapper3 = sqlSession.getMapper(GroupMapper.class);

        String gname = mapper2.queryNameById(gameId);
        List<Athlete> athletes = mapper3.queryAthletesOrdered(game);
        this.athletesIn = athletes;

        JSONObject msg = new JSONObject();
        JSONObject g = new JSONObject();
        JSONArray aths = new JSONArray();

        for(Athlete a : athletes){
            JSONObject a2json = new JSONObject();
            a2json.put("name", a.getName());
            a2json.put("no", a.getNo());
            if(a.getSex().equals("男"))
                a2json.put("photo", boyPhoto);
            else
                a2json.put("photo", girlPhoto);
            aths.add(a2json);
        }
        g.put("gameid", gameId);
        g.put("name", gname);
        g.put("lv", lv);

        msg.put("type", 0);
        msg.put("game", g);
        msg.put("athletes", aths);
        msg.put("refereeNum", referees.size());

        publish2AllReferees(msg);
        this.isInProgress = true;
        this.currentAthlete = -1;
        sqlSession.close();

        JSONObject msg1 = new JSONObject();
        msg1.put("started", true);
        try {
            if(this.admin!=null)
                this.admin.feedback(msg1.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("发送给管理员提示信息失败");
        }

        if(athletesIn!=null && athletesIn.size()!=0){
            nextAthleteToScore();
        }else {
            endGame();
        }

    }

    private void nextAthleteToScore() {
        currentAthlete++;
        JSONObject msg = new JSONObject();
        msg.put("type", 1);
        msg.put("no", athletesIn.get(currentAthlete).getNo());
        msg.put("revise", false);

        publish2AllReferees(msg);
    }

    private void publish2AllReferees(JSONObject msg){
        synchronized (clientMap) {
            for (Referee r : this.relatedReferees) {
                ScoringServer server = clientMap.get(r.getIdNum());
                try {
                    if(server!=null)
                        server.send(msg.toJSONString());
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("发送失败");
                }
            }
        }
    }

    private void endGame(){
        JSONObject msg = new JSONObject();
        msg.put("type", 2);
        publish2AllReferees(msg);

        this.game = null;
        this.athletesIn = null;
        this.relatedReferees = null;
        this.isInProgress = false;

        JSONObject msg1 = new JSONObject();
        msg1.put("ended", true);
        if(this.admin!=null){
            try {
                this.admin.feedback(msg1.toJSONString());
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("发送给管理员提示信息失败");
            }
        }
    }

    private boolean refereesAllReady(){
        if(this.game==null){
            return false;
        } else{
            SqlSession sqlSession = MybatiesUtil.getSession();
            RefereeSeviceMapper seviceMapper = sqlSession.getMapper(RefereeSeviceMapper.class);
            List<Referee> referees = seviceMapper.queryRelatedReferee(this.game.getGameId());
            synchronized (clientMap) {
                for (int i = 0; i < referees.size(); i++) {
                    if (!clientMap.keySet().contains(referees.get(i).getIdNum()))
                        return false;
                }
            }

            sqlSession.close();
        }

        return true;
    }

    public void transitMessage(JSONObject msg) {

        if(!isInProgress){
            System.out.println("客户端未在比赛期间进行发送信息");
            return;
        }

        Integer type = msg.getInteger("type");
        JSONObject data = msg.getJSONObject("data");
        switch (type){
            case 0:
                sendScoreToLeader(data);
                break;
            case 1:
                setScore(data);
                break;
            case 2:
                sendRescoreCmdToClient(data);
                break;
        }
    }

    private void sendScoreToLeader(JSONObject scoreData){
        String id = game.getrIdNum();
        JSONObject msg = new JSONObject();
        msg.put("type", 3);
        msg.put("data", scoreData);
        synchronized (clientMap) {
            ScoringServer leaderServer = clientMap.get(id);
            try {
                leaderServer.send(msg.toJSONString());
            } catch (IOException e) {
                System.out.println("发送给裁判长失败");
                e.printStackTrace();
            }
        }
    }

    private void sendRescoreCmdToClient(JSONObject refereeData) {
        JSONObject msg = new JSONObject();
        msg.put("type", 1);
        msg.put("no", athletesIn.get(currentAthlete).getNo());
        msg.put("revise", true);
        synchronized (clientMap) {
            try {
                clientMap.get(refereeData.getString("idnum")).send(msg.toJSONString());
            } catch (IOException e) {
                System.out.println("发送重评命令失败");
                e.printStackTrace();
            }
        }
    }

    private void setScore(JSONObject scores) {

        int gameId = this.game.getGameId();
        int ano = this.athletesIn.get(currentAthlete).getNo();
        Participation participation = new Participation();
        participation.setAthleteNo(ano);
        participation.setGameId(gameId);

        DecimalFormat formatter = new DecimalFormat("#.00");
        participation.setScore(Double.valueOf(formatter.format(scores.getDouble("score"))));
        participation.setPenalty(Double.valueOf(formatter.format(scores.getDouble("penalty"))));
        participation.setBonus(Double.valueOf(formatter.format(scores.getDouble("bonus"))));

        SqlSession sqlSession = MybatiesUtil.getSession();
        ParticipationMapper participationMapper = sqlSession.getMapper(ParticipationMapper.class);
        participationMapper.updateScores(participation);
        sqlSession.commit();
        sqlSession.close();

        if(currentAthlete < athletesIn.size()-1) {
            nextAthleteToScore();
        } else {
            endGame();
        }


    }
}
