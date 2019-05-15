package com.cms.websocket;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.GameMapper;
import com.cms.mapper.ParticipationMapper;
import com.cms.mapper.RefereeSeviceMapper;
import com.cms.pojo.Athlete;
import com.cms.pojo.Game;
import com.cms.pojo.Referee;
import com.cms.util.MybatiesUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScoringSocketManager {

    public static ScoringSocketManager instance = new ScoringSocketManager();
    private Map<String, ScoringServer> clientMap;
    private Game game;
    public boolean isInProgress;

    private ScoringSocketManager(){
        clientMap = new HashMap<String, ScoringServer>();
        System.out.println("Socket Manager initializes");
    }

    void addClient(ScoringServer node){
        synchronized (clientMap) {
            clientMap.put(node.referee.getIdNum(), node);
        }
        if(this.refereesAllReady()){
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

    public Game getScoringGame(){
        return game;
    }

    public void setScoringGame(Game game){
        this.game = game;
        if(refereesAllReady()){
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
        GameMapper mapper2 = sqlSession.getMapper(GameMapper.class);
        ParticipationMapper mapper3 = sqlSession.getMapper(ParticipationMapper.class);

        String gname = mapper2.queryNameById(gameId);
        List<Athlete> athletes = mapper3.queryAthletesByGameID(gameId);

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

        synchronized (clientMap) {
            for (Referee r : referees) {
                ScoringServer server = clientMap.get(r.getIdNum());
                try {
                    server.send(msg.toJSONString());
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("发送失败");
                }
            }
        }
        this.isInProgress = true;

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
        }

        return true;
    }
}
