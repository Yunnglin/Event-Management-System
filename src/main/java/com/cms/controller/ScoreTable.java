package com.cms.controller;
import com.cms.mapper.GameMapper;
import com.cms.mapper.ScoreMapper;
import com.cms.pojo.*;
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
    public List<PersonScore>Com3Persons;
    public List<PersonScore>Com4Persons;
    public List<PersonScore>Com5Persons;
    public List<PersonScore>Com6Persons;
    public List<PersonScore>Com7Persons;
    public List<PersonScore>Com8Persons;
    public List<PersonScore>Com9Persons;
    public List<PersonScore>Com10Persons;
    public List<PersonScore>Com11Persons;
    public List<PersonScore>Com12Persons;
    public List<PersonScore>PersonsSum;
    public List<TeamPerson>TeamPersons;

    public  void GetOwnPersonScore()
    {
        SqlSession sqlSession = MybatiesUtil.getSession();
        ScoreMapper mapper = sqlSession.getMapper(ScoreMapper.class);

        //本队参赛信息查询
        List<HashMap>hashMaps=mapper.TeamPerson(Login.account);
        TeamPersons = new ArrayList<>();

        int length = hashMaps.size();
        TeamPerson gr;
        for (int j = 0; j < length; j++)
        {
            gr  = new TeamPerson();
            Iterator iter = hashMaps.get(j).entrySet().iterator();
            int i = 1;
            while (iter.hasNext())
            {
                Map.Entry entry = (Map.Entry) iter.next();
                switch (i) {
                    case 1:
                        BigDecimal ze2 = (BigDecimal) entry.getValue();
                        gr.setId(ze2.intValue());
                        System.out.println(gr.getId());
                        break;
                    case 2:
                        BigDecimal ze3 = (BigDecimal) entry.getValue();
                        gr.setScore(ze3.intValue());
                        System.out.println(gr.getScore());
                        break;
                    case 3:
                        gr.setGameName((String) entry.getValue());
                        System.out.println(gr.getGameName());
                        break;
                    case 4:
                        gr.setTeamName((String) entry.getValue());
                        System.out.println(gr.getTeamName());
                        break;
                    case 5:
                        gr.setSex((String) entry.getValue());
                        System.out.println(gr.getSex());
                        break;
                    case 6:
                        gr.setName((String) entry.getValue());
                        System.out.println(gr.getName());
                        break;
                }
                i = i + 1;
            }
            TeamPersons.add(gr);
        }
    }
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
                        gr.setTeamName((String) entry.getValue());
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
            int m=j+1;
            gr.setOrder(m);
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
            int m = j+1;
            gr.setOrder(m);
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
            int m=j+1;
            gr.setOrder(m);
            Com2Persons.add(gr);
        }
    }
    public  void GetCom3Score()
    {
        SqlSession sqlSession = MybatiesUtil.getSession();
        ScoreMapper mapper = sqlSession.getMapper(ScoreMapper.class);

        //本队参赛信息查询
        List<HashMap> hashMaps = mapper.Competition3();
        Com3Persons = new ArrayList<>();

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
            int m=j+1;
            gr.setOrder(m);
            Com3Persons.add(gr);
        }
    }
    public  void GetCom4Score()
    {
        SqlSession sqlSession = MybatiesUtil.getSession();
        ScoreMapper mapper = sqlSession.getMapper(ScoreMapper.class);

        //本队参赛信息查询
        List<HashMap> hashMaps = mapper.Competition4();
        Com4Persons = new ArrayList<>();

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
            int m=j+1;
            gr.setOrder(m);
            Com4Persons.add(gr);
        }
    }
    public  void GetCom5Score()
    {
        SqlSession sqlSession = MybatiesUtil.getSession();
        ScoreMapper mapper = sqlSession.getMapper(ScoreMapper.class);

        //本队参赛信息查询
        List<HashMap> hashMaps = mapper.Competition5();
        Com5Persons = new ArrayList<>();
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
            int m=j+1;
            gr.setOrder(m);
            Com5Persons.add(gr);
        }
    }
    public  void GetCom6Score()
    {
        SqlSession sqlSession = MybatiesUtil.getSession();
        ScoreMapper mapper = sqlSession.getMapper(ScoreMapper.class);

        //本队参赛信息查询
        List<HashMap> hashMaps = mapper.Competition6();
        Com6Persons = new ArrayList<>();
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
            int m=j+1;
            gr.setOrder(m);
            Com6Persons.add(gr);
        }
    }
    public  void GetCom7Score()
    {
        SqlSession sqlSession = MybatiesUtil.getSession();
        ScoreMapper mapper = sqlSession.getMapper(ScoreMapper.class);

        //本队参赛信息查询
        List<HashMap> hashMaps = mapper.Competition7();
        Com7Persons = new ArrayList<>();
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
            int m=j+1;
            gr.setOrder(m);
            Com7Persons.add(gr);
        }
    }
    public  void GetCom8Score()
    {
        SqlSession sqlSession = MybatiesUtil.getSession();
        ScoreMapper mapper = sqlSession.getMapper(ScoreMapper.class);

        //本队参赛信息查询
        List<HashMap> hashMaps = mapper.Competition8();
        Com8Persons = new ArrayList<>();
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
            int m=j+1;
            gr.setOrder(m);
            Com8Persons.add(gr);
        }
    }
    public  void GetCom9Score()
    {
        SqlSession sqlSession = MybatiesUtil.getSession();
        ScoreMapper mapper = sqlSession.getMapper(ScoreMapper.class);

        //本队参赛信息查询
        List<HashMap> hashMaps = mapper.Competition9();
        Com9Persons = new ArrayList<>();
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
            int m=j+1;
            gr.setOrder(m);
            Com9Persons.add(gr);
        }
    }
    public  void GetCom10Score()
    {
        SqlSession sqlSession = MybatiesUtil.getSession();
        ScoreMapper mapper = sqlSession.getMapper(ScoreMapper.class);

        //本队参赛信息查询
        List<HashMap> hashMaps = mapper.Competition10();
        Com10Persons = new ArrayList<>();
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
            int m=j+1;
            gr.setOrder(m);
            Com10Persons.add(gr);
        }
    }
    public  void GetCom11Score()
    {
        SqlSession sqlSession = MybatiesUtil.getSession();
        ScoreMapper mapper = sqlSession.getMapper(ScoreMapper.class);

        //本队参赛信息查询
        List<HashMap> hashMaps = mapper.Competition11();
        Com11Persons = new ArrayList<>();
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
            int m=j+1;
            gr.setOrder(m);
            Com11Persons.add(gr);
        }
    }
    public  void GetCom12Score()
    {
        SqlSession sqlSession = MybatiesUtil.getSession();
        ScoreMapper mapper = sqlSession.getMapper(ScoreMapper.class);

        //本队参赛信息查询
        List<HashMap> hashMaps = mapper.Competition12();
        Com12Persons = new ArrayList<>();
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
            int m=j+1;
            gr.setOrder(m);
            Com12Persons.add(gr);
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
                      //  System.out.println(gr.getTeamName());
                        break;
                    case 2:
                        BigDecimal ze = (BigDecimal) entry.getValue();
                        gr.setTeamScore(ze.intValue());
                        //System.out.println(gr.getTeamScore());
                        break;
                    case 3:
                        BigDecimal ze2 = (BigDecimal) entry.getValue();
                        String aa=""+ze2.intValue();
                        gr.setTeamId(aa);
                       // System.out.println(gr.getTeamId());
                        break;
                }
                i = i + 1;
            }
            int m= j+1;
            gr.setOrder(m);
            TeamScores.add(gr);
        }
        for(int k=0;k<TeamScores.size();k++)
        {
            System.out.println( TeamScores.get(k).getTeamName());
        }
        GetCom1Score();
        GetCom2Score();
        GetCom3Score();
        GetCom4Score();
        GetCom5Score();
        GetCom6Score();
        GetCom7Score();
        GetCom8Score();
        GetCom9Score();
        GetCom10Score();
        GetCom11Score();
        GetCom12Score();
        GetSumScore();
        GetOwnPersonScore();
        request.setCharacterEncoding("UTF-8");
        String CONTENT_TYPE = "text/html; charset=GBK";
        response.setContentType(CONTENT_TYPE);
        request.setAttribute("Com1Persons",Com1Persons);
        request.setAttribute("Com2Persons",Com2Persons);
        request.setAttribute("Com3Persons",Com3Persons);
        request.setAttribute("Com4Persons",Com4Persons);
        request.setAttribute("Com5Persons",Com5Persons);
        request.setAttribute("Com6Persons",Com6Persons);
        request.setAttribute("Com7Persons",Com7Persons);
        request.setAttribute("Com8Persons",Com8Persons);
        request.setAttribute("Com9Persons",Com9Persons);
        request.setAttribute("Com10Persons",Com10Persons);
        request.setAttribute("Com11Persons",Com11Persons);
        request.setAttribute("Com12Persons",Com12Persons);
        request.setAttribute("TeamPersons",TeamPersons);
        request.setAttribute("PersonsSum",PersonsSum);
        request.setAttribute("TeamScores",TeamScores);
        request.getRequestDispatcher("/ScoreTable.jsp").forward(request, response);

    }
}
