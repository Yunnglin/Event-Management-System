package com.cms.controller;
import com.cms.mapper.GameMapper;
import com.cms.mapper.ScoreMapper;
import com.cms.pojo.Game;
import com.cms.pojo.GameResult;
import com.cms.pojo.PersonScore;
import com.cms.pojo.TeamScore;
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

public class ScoreTable extends HttpServlet
{
    public List<PersonScore>Com1Persons;
    public List<PersonScore>Com2Persons;
    public List<PersonScore>PersonsSum;

    public  void GetSumScore()
    {
        SqlSession sqlSession = MybatiesUtil.getSession();
        ScoreMapper mapper = sqlSession.getMapper(ScoreMapper.class);


        List<HashMap> hashMaps = mapper.PersonSum();
        PersonsSum = new ArrayList<>();

        int length = hashMaps.size();
        PersonScore gr;
        for (int j = 0; j < length; j++) {
            gr = new PersonScore();
            Iterator iter = hashMaps.get(j).entrySet().iterator();
            int i = 1;
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                switch (i) {
                    case 1:
                        BigDecimal ze2 = (BigDecimal) entry.getValue();
                        gr.setPersonId("" + ze2.intValue());
                        System.out.println(gr.getPersonId());
                        break;

                    case 2:
                        gr.setTeamName((String)entry.getValue());
                        System.out.println(gr.getTeamName());
                        break;
                    case 3:
                        BigDecimal ze1 = (BigDecimal) entry.getValue();
                        gr.setScore(ze1.intValue());
                        System.out.println(gr.getScore());
                        break;
                    case 4:
                        gr.setName((String) entry.getValue());
                        System.out.println(gr.getName());
                        break;
                }
                i = i + 1;
            }
            PersonsSum.add(gr);

        }
    }
    public  void GetCom1Score()
    {
        SqlSession sqlSession = MybatiesUtil.getSession();
        ScoreMapper mapper = sqlSession.getMapper(ScoreMapper.class);

        //本队参赛信息查询
        List<HashMap> hashMaps = mapper.Competition1();
        Com1Persons = new ArrayList<>();

        int length = hashMaps.size();
        PersonScore gr;
        for (int j = 0; j < length; j++) {
            gr = new PersonScore();
            Iterator iter = hashMaps.get(j).entrySet().iterator();
            int i = 1;
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                switch (i) {
                    case 1:
                        BigDecimal ze2 = (BigDecimal) entry.getValue();
                        gr.setPersonId(""+ze2.intValue());
                        System.out.println(gr.getPersonId());
                        break;

                    case 2:
                        BigDecimal ze1=(BigDecimal)entry.getValue();
                        gr.setScore(ze1.intValue());
                        System.out.println(gr.getScore());
                        break;
                    case 3:
                        gr.setTeamName((String)entry.getValue());
                        System.out.println(gr.getTeamName());
                        break;
                    case 4:
                        gr.setName((String) entry.getValue());
                        System.out.println(gr.getName());
                        break;
                }
                i = i + 1;
            }
            Com1Persons.add(gr);
        }
    }
    public  void GetCom2Score()
    {
        SqlSession sqlSession = MybatiesUtil.getSession();
        ScoreMapper mapper = sqlSession.getMapper(ScoreMapper.class);

        //本队参赛信息查询
        List<HashMap> hashMaps = mapper.Competition2();
        Com2Persons = new ArrayList<>();

        int length = hashMaps.size();
        PersonScore gr;
        for (int j = 0; j < length; j++) {
            gr = new PersonScore();
            Iterator iter = hashMaps.get(j).entrySet().iterator();
            int i = 1;
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                switch (i) {
                    case 1:
                        BigDecimal ze2 = (BigDecimal) entry.getValue();
                        gr.setPersonId(""+ze2.intValue());
                        System.out.println(gr.getPersonId());
                        break;

                    case 2:
                        BigDecimal ze1=(BigDecimal)entry.getValue();
                        gr.setScore(ze1.intValue());
                        System.out.println(gr.getScore());
                        break;
                    case 3:
                        gr.setTeamName((String)entry.getValue());
                        System.out.println(gr.getTeamName());
                        break;
                    case 4:
                        gr.setName((String) entry.getValue());
                        System.out.println(gr.getName());
                        break;
                }
                i = i + 1;
            }
            Com2Persons.add(gr);
        }
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
        // 设置响应内容类型
        SqlSession sqlSession = MybatiesUtil.getSession();
        ScoreMapper mapper = sqlSession.getMapper(ScoreMapper.class);

        //本队参赛信息查询
        List<HashMap> hashMaps = mapper.TeamScore();
        List<TeamScore> TeamScores = new ArrayList<>();

        int length = hashMaps.size();
        TeamScore gr;
        for (int j = 0; j < length; j++) {
            gr = new TeamScore();
            Iterator iter = hashMaps.get(j).entrySet().iterator();
            int i = 1;
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                switch (i) {
                    case 1:
                        gr.setTeamName((String) entry.getValue());
                        System.out.println(gr.getTeamName());
                        break;
                    case 2:
                        BigDecimal ze = (BigDecimal) entry.getValue();
                        gr.setTeamScore(ze.intValue());
                        System.out.println(gr.getTeamScore());
                        break;
                    case 3:
                        BigDecimal ze2 = (BigDecimal) entry.getValue();
                        String aa=""+ze2.intValue();
                        gr.setTeamId(aa);
                        System.out.println(gr.getTeamId());
                        break;
                }
                i = i + 1;
            }
            TeamScores.add(gr);
        }
        for(int k=0;k<TeamScores.size();k++)
        {
            System.out.println( TeamScores.get(k).getTeamName());
        }
        GetCom1Score();
        GetCom2Score();
        GetSumScore();
        request.setCharacterEncoding("UTF-8");
        String CONTENT_TYPE = "text/html; charset=GBK";
        response.setContentType(CONTENT_TYPE);
        request.setAttribute("Com1Persons",Com1Persons);
        request.setAttribute("Com2Persons",Com2Persons);
        request.setAttribute("PersonsSum",PersonsSum);
        request.setAttribute("TeamScores",TeamScores);
        request.getRequestDispatcher("/ScoreTable.jsp").forward(request, response);

    }
}
