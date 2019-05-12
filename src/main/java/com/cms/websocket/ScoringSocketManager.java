package com.cms.websocket;

import com.cms.pojo.Game;

import java.util.ArrayList;
import java.util.HashMap;
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
    }
}
