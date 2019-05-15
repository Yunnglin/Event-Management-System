package com.cms.websocket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.RefereeMapper;
import com.cms.pojo.Referee;
import com.cms.util.MybatiesUtil;
import org.apache.ibatis.session.SqlSession;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * Websocket 端点类
 */

@ServerEndpoint("/score/{id}")
public class ScoringServer {
    private Session session;
    public Referee referee;

    @OnOpen
    public void onOpen(@PathParam(value="id") String idnum, Session session, EndpointConfig config){
        SqlSession sqlSession = MybatiesUtil.getSession();
        RefereeMapper refereeMapper = sqlSession.getMapper(RefereeMapper.class);
        this.referee = refereeMapper.queryById(idnum);
        this.session = session;
        if(this.referee == null){
            try {
                this.session.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            ScoringSocketManager.instance.addClient(this);
        }
        sqlSession.close();
    }

    @OnMessage
    public void onMessage(String message, Session session){
        JSONObject msg = JSON.parseObject(message);
        
    }

    @OnClose
    public void onClose()
    {
        ScoringSocketManager.instance.removeClient(this);
    }

    public void send(String data) throws IOException {
        this.session.getBasicRemote().sendText(data);
    }

}
