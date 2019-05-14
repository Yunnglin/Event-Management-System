package com.cms.websocket;

import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.RefereeSeviceMapper;
import com.cms.pojo.Game;
import com.cms.pojo.Referee;
import com.cms.util.MybatiesUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScoringSocketManager {

    public static ScoringSocketManager instance = new ScoringSocketManager();
    private Map<String, ScoringServer> clientMap;
    private Game game;

    private ScoringSocketManager(){
        clientMap = new HashMap<String, ScoringServer>();
        System.out.println("Socket Manager initializes");
    }

    void addClient(ScoringServer node){
        synchronized (clientMap) {
            clientMap.put(node.referee.getIdNum(), node);
        }
        System.out.println("referee " + node.referee.getName() + " in");
    }

    void removeClient(ScoringServer node){
        synchronized (clientMap) {
            clientMap.remove(node.referee.getIdNum());
        }
        System.out.println("referee " + node.referee.getName() + " out");
    }

    public synchronized Game getScoringGame(){
        return game;
    }

    public synchronized void setScoringGame(Game game){
        this.game = game;
    }

    public void startGame(Game game){
        int gameId = game.getGameId();
        String groupAge = game.getGroupAge();
        String lv = game.getLevel();
        String leaderID = game.getrIdNum();

        SqlSession sqlSession = MybatiesUtil.getSession();
        RefereeSeviceMapper mapper1 = sqlSession.getMapper(RefereeSeviceMapper.class);
        List<Referee> referees = mapper1.queryRelatedReferee(gameId);


        JSONObject msg = new JSONObject();
        JSONObject g = new JSONObject();
        g.put("gameid", gameId);
        g.put("name", )
        msg.put("type", 0);
        msg.put()

        synchronized (clientMap) {
            for (Referee r : referees) {
                ScoringServer server = clientMap.get(r.getIdNum());
                server.send();
            }
        }
    }
}
