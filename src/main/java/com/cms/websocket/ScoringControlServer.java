package com.cms.websocket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cms.pojo.Game;
import com.cms.util.JSONUtil;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/score_admin")
public class ScoringControlServer {

    @OnOpen
    public void onOpen(){
        System.out.println("评分系统管理员登录");
    }

    @OnMessage
    public void onMessage(String message, Session session){
        JSONObject msgObj = JSON.parseObject(message);
        Game game = JSONUtil.JSONObjtoGame(msgObj);
        ScoringSocketManager.instance.setScoringGame(game);
    }
}
