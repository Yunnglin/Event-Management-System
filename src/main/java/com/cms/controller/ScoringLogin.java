package com.cms.controller;

import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.RefereeMapper;
import com.cms.mapper.TeamMapper;
import com.cms.pojo.Referee;
import com.cms.util.MybatiesUtil;
import com.cms.websocket.ScoringSocketManager;
import org.apache.ibatis.binding.BindingException;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet("/scorelogin")
public class ScoringLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "GET,POST");

        String account = req.getParameter("account");
        String name = req.getParameter("name");
        SqlSession sqlSession = MybatiesUtil.getSession();
        RefereeMapper mapper = sqlSession.getMapper(RefereeMapper.class);
        TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
        Referee referee = mapper.queryByAccountName(account, name);

        Writer out = resp.getWriter();
        JSONObject res = new JSONObject();
        if(referee==null){
            res.put("flag", false);
            res.put("account", true);
            try{
                int tno = teamMapper.queryIdByAccount(account);
            } catch (BindingException be){
                System.out.println(be.getMessage());
                res.put("account", false);
            }
        }else{
            res.put("flag", true);
            res.put("idnum", referee.getIdNum());
            if(ScoringSocketManager.instance.isInProgress &&
                    referee.getIdNum().equals(ScoringSocketManager.instance.getScoringGame().getrIdNum())){
                res.put("leader", true);
            }else{
                res.put("leader", false);
            }
        }
        out.write(res.toJSONString());
        out.flush();

        sqlSession.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
