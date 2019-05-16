package com.cms.controller;
import com.cms.mapper.GameMapper;
import com.cms.pojo.Game;
import com.cms.pojo.GameResult;
import com.cms.util.MybatiesUtil;
import org.apache.ibatis.binding.BindingException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.*;

public class GameLook extends HttpServlet
{

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
        // 设置响应内容类型
        SqlSession sqlSession = MybatiesUtil.getSession();
        GameMapper mapper = sqlSession.getMapper(GameMapper.class);

        //本队参赛信息查询
        List<HashMap>hashMaps=mapper.getSpecialGamesList(Login.account);
        List<GameResult> Games = new ArrayList<>();

        int length = hashMaps.size();
        GameResult gr;
        for (int j = 0; j < length; j++)
        {
            gr  = new GameResult();
            Iterator iter = hashMaps.get(j).entrySet().iterator();
            int i = 1;
            while (iter.hasNext())
            {
                Map.Entry entry = (Map.Entry) iter.next();
                switch (i) {
                    case 1:
                        gr.setrIdNum((String) entry.getValue());
                        System.out.println(gr.getrIdNum());
                        break;
                    case 2:
                        gr.setEventName((String) entry.getValue());
                        System.out.println(gr.getEventName());
                        break;
                    case 3:
                        gr.setLevel((String) entry.getValue());
                        System.out.println(gr.getLevel());
                        break;
                    case 4:
                        BigDecimal ze = (BigDecimal) entry.getValue();
                        gr.setGameId(ze.intValue());
                        System.out.println(gr.getGameId());
                        break;
                    case 5:
                        gr.setGroupAge((String) entry.getValue());
                        System.out.println(gr.getGroupAge());
                        break;
                }
                i = i + 1;
            }
            Games.add(gr);
        }

        //所有比赛信息
        List<HashMap> hashMapsall = mapper.queryAll();
        List<GameResult> Gamesall = new ArrayList<>();

        int length1 = hashMapsall.size();
        GameResult gr1;
        for (int j = 0; j < length1; j++)
        {
            gr1  = new GameResult();
            Iterator iter = hashMapsall.get(j).entrySet().iterator();
            int i = 1;
            while (iter.hasNext())
            {
                Map.Entry entry = (Map.Entry) iter.next();
                switch (i) {
                    case 1:
                        gr1.setrIdNum((String) entry.getValue());
                        System.out.println(gr1.getrIdNum());
                        break;
                    case 2:
                        gr1.setEventName((String) entry.getValue());
                        System.out.println(gr1.getEventName());
                        break;
                    case 3:
                        gr1.setLevel((String) entry.getValue());
                        System.out.println(gr1.getLevel());
                        break;
                    case 4:
                        BigDecimal ze = (BigDecimal) entry.getValue();
                        gr1.setGameId(ze.intValue());
                        System.out.println(gr1.getGameId());
                        break;
                    case 5:
                        gr1.setGroupAge((String) entry.getValue());
                        System.out.println(gr1.getGroupAge());
                        break;
                }
                i = i + 1;
            }
            Gamesall.add(gr1);
        }
        request.setCharacterEncoding("UTF-8");
        String CONTENT_TYPE = "text/html; charset=GBK";
        response.setContentType(CONTENT_TYPE);
        request.setAttribute("games",Games);
        request.setAttribute("gamesAll",Gamesall);
        request.getRequestDispatcher("/GameShow.jsp").forward(request, response);

    }
}
