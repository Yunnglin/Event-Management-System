package com.cms.websocket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cms.pojo.Game;
import com.cms.util.JSONUtil;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/score_admin")
public class ScoringControlServer {
    private Session session;

    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        System.out.println("评分系统管理员登录");
    }

    @OnMessage
    public void onMessage(String message, Session session){
        JSONObject msgObj = JSON.parseObject(message);
        Game game = JSONUtil.JSONObjtoGame(msgObj);
        ScoringSocketManager.instance.setScoringGame(game);

        JSONObject jsonObject = new JSONObject();

        if(ScoringSocketManager.instance.isInProgress){
            jsonObject.put("started", true);
        }else{
            jsonObject.put("started", false);
        }
        try {
            feedback(jsonObject.toJSONString());
        } catch (IOException e) {
            System.out.println("发送失败");
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    private void feedback(String info) throws IOException {
        session.getBasicRemote().sendText(info);
    }
}
