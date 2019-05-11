package com.cms.websocket;

import java.util.ArrayList;

public class ScoringSocketManager {

    public static ScoringSocketManager instance = new ScoringSocketManager();
    private ArrayList<ScoringServer> clientList;

    private ScoringSocketManager(){
        clientList = new ArrayList<ScoringServer>();
        System.out.println("Socket Manager initializes");
    }

    void addClient(ScoringServer node){
        synchronized (clientList) {
            clientList.add(node);
        }
        System.out.println("referee " + node.referee.getName() + " in");
    }

    void removeClient(ScoringServer node){
        synchronized (clientList) {
            clientList.remove(node);
        }
        System.out.println("referee " + node.referee.getName() + " out");
    }

}
