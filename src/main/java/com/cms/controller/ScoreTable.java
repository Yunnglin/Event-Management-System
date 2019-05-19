package com.cms.controller;
import com.cms.mapper.ScoreMapper;
import com.cms.pojo.*;
import com.cms.util.MybatiesUtil;
import org.apache.ibatis.binding.BindingException;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

class MyThread1 extends Thread
{
    public static List<EventScore>Com1Persons;
    public static List<EventScore>Com2Persons;
    public static List<EventScore>Com3Persons;
    public  void GetCom1Score()
    {
        SqlSession sqlSession = MybatiesUtil.getSession();
        ScoreMapper mapper = sqlSession.getMapper(ScoreMapper.class);

        //本队参赛信息查询
        List<HashMap> hashMaps = mapper.Competition1();
        Com1Persons = new ArrayList<>();

        int length = hashMaps.size();
        EventScore gr;
        for (int j = 0; j < length; j++) {
            gr = new EventScore();
            Iterator iter = hashMaps.get(j).entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                if (((String) entry.getKey()).equals("PERSONID"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setPersonId(ze2.intValue());
                    System.out.println(gr.getPersonId());
                }
                if (((String) entry.getKey()).equals("SCORE"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setScore(ze2.intValue());
                    System.out.println(gr.getScore());
                }
                if (((String) entry.getKey()).equals("PENALTY"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setPenalty(ze2.intValue());
                    System.out.println(gr.getPenalty());
                }
                if (((String) entry.getKey()).equals("GROUPAGE"))
                {
                    gr.setGroupAge((String) entry.getValue());
                    System.out.println(gr.getGroupAge());
                }
                if (((String) entry.getKey()).equals("TEAMNAME"))
                {
                    gr.setTeamName((String) entry.getValue());
                    System.out.println(gr.getTeamName());
                }
                if (((String) entry.getKey()).equals("BONUS"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setBonus(ze2.intValue());
                    System.out.println(gr.getBonus());
                }
                if (((String) entry.getKey()).equals("LV"))
                {
                    gr.setLevel((String) entry.getValue());
                    System.out.println(gr.getLevel());
                }
                if (((String) entry.getKey()).equals("NAME"))
                {
                    gr.setName((String) entry.getValue());
                    System.out.println(gr.getName());
                }
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
        EventScore gr;
        for (int j = 0; j < length; j++) {
            gr = new EventScore();
            Iterator iter = hashMaps.get(j).entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                if (((String) entry.getKey()).equals("PERSONID"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setPersonId(ze2.intValue());
                    System.out.println(gr.getPersonId());
                }
                if (((String) entry.getKey()).equals("SCORE"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setScore(ze2.intValue());
                    System.out.println(gr.getScore());
                }
                if (((String) entry.getKey()).equals("PENALTY"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setPenalty(ze2.intValue());
                    System.out.println(gr.getPenalty());
                }
                if (((String) entry.getKey()).equals("GROUPAGE"))
                {
                    gr.setGroupAge((String) entry.getValue());
                    System.out.println(gr.getGroupAge());
                }
                if (((String) entry.getKey()).equals("TEAMNAME"))
                {
                    gr.setTeamName((String) entry.getValue());
                    System.out.println(gr.getTeamName());
                }
                if (((String) entry.getKey()).equals("BONUS"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setBonus(ze2.intValue());
                    System.out.println(gr.getBonus());
                }
                if (((String) entry.getKey()).equals("LV"))
                {
                    gr.setLevel((String) entry.getValue());
                    System.out.println(gr.getLevel());
                }
                if (((String) entry.getKey()).equals("NAME"))
                {
                    gr.setName((String) entry.getValue());
                    System.out.println(gr.getName());
                }
            }
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
        EventScore gr;
        for (int j = 0; j < length; j++) {
            gr = new EventScore();
            Iterator iter = hashMaps.get(j).entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                if (((String) entry.getKey()).equals("PERSONID"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setPersonId(ze2.intValue());
                    System.out.println(gr.getPersonId());
                }
                if (((String) entry.getKey()).equals("SCORE"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setScore(ze2.intValue());
                    System.out.println(gr.getScore());
                }
                if (((String) entry.getKey()).equals("PENALTY"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setPenalty(ze2.intValue());
                    System.out.println(gr.getPenalty());
                }
                if (((String) entry.getKey()).equals("GROUPAGE"))
                {
                    gr.setGroupAge((String) entry.getValue());
                    System.out.println(gr.getGroupAge());
                }
                if (((String) entry.getKey()).equals("TEAMNAME"))
                {
                    gr.setTeamName((String) entry.getValue());
                    System.out.println(gr.getTeamName());
                }
                if (((String) entry.getKey()).equals("BONUS"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setBonus(ze2.intValue());
                    System.out.println(gr.getBonus());
                }
                if (((String) entry.getKey()).equals("LV"))
                {
                    gr.setLevel((String) entry.getValue());
                    System.out.println(gr.getLevel());
                }
                if (((String) entry.getKey()).equals("NAME"))
                {
                    gr.setName((String) entry.getValue());
                    System.out.println(gr.getName());
                }
            }
            Com3Persons.add(gr);
        }
    }
    @Override
    public void run()
    {
        GetCom1Score();
        GetCom2Score();
        GetCom3Score();
    }
}
class MyThread2 extends Thread
{
    public static List<EventScore>Com4Persons;
    public static List<EventScore>Com5Persons;
    public static List<EventScore>Com6Persons;
    public  void GetCom4Score()
    {
        SqlSession sqlSession = MybatiesUtil.getSession();
        ScoreMapper mapper = sqlSession.getMapper(ScoreMapper.class);

        //本队参赛信息查询
        List<HashMap> hashMaps = mapper.Competition4();
        Com4Persons = new ArrayList<>();

        int length = hashMaps.size();
        EventScore gr;
        for (int j = 0; j < length; j++) {
            gr = new EventScore();
            Iterator iter = hashMaps.get(j).entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                if (((String) entry.getKey()).equals("PERSONID"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setPersonId(ze2.intValue());
                    System.out.println(gr.getPersonId());
                }
                if (((String) entry.getKey()).equals("SCORE"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setScore(ze2.intValue());
                    System.out.println(gr.getScore());
                }
                if (((String) entry.getKey()).equals("PENALTY"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setPenalty(ze2.intValue());
                    System.out.println(gr.getPenalty());
                }
                if (((String) entry.getKey()).equals("GROUPAGE"))
                {
                    gr.setGroupAge((String) entry.getValue());
                    System.out.println(gr.getGroupAge());
                }
                if (((String) entry.getKey()).equals("TEAMNAME"))
                {
                    gr.setTeamName((String) entry.getValue());
                    System.out.println(gr.getTeamName());
                }
                if (((String) entry.getKey()).equals("BONUS"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setBonus(ze2.intValue());
                    System.out.println(gr.getBonus());
                }
                if (((String) entry.getKey()).equals("LV"))
                {
                    gr.setLevel((String) entry.getValue());
                    System.out.println(gr.getLevel());
                }
                if (((String) entry.getKey()).equals("NAME"))
                {
                    gr.setName((String) entry.getValue());
                    System.out.println(gr.getName());
                }
            }
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
        EventScore gr;
        for (int j = 0; j < length; j++) {
            gr = new EventScore();
            Iterator iter = hashMaps.get(j).entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                if (((String) entry.getKey()).equals("PERSONID"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setPersonId(ze2.intValue());
                    System.out.println(gr.getPersonId());
                }
                if (((String) entry.getKey()).equals("SCORE"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setScore(ze2.intValue());
                    System.out.println(gr.getScore());
                }
                if (((String) entry.getKey()).equals("PENALTY"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setPenalty(ze2.intValue());
                    System.out.println(gr.getPenalty());
                }
                if (((String) entry.getKey()).equals("GROUPAGE"))
                {
                    gr.setGroupAge((String) entry.getValue());
                    System.out.println(gr.getGroupAge());
                }
                if (((String) entry.getKey()).equals("TEAMNAME"))
                {
                    gr.setTeamName((String) entry.getValue());
                    System.out.println(gr.getTeamName());
                }
                if (((String) entry.getKey()).equals("BONUS"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setBonus(ze2.intValue());
                    System.out.println(gr.getBonus());
                }
                if (((String) entry.getKey()).equals("LV"))
                {
                    gr.setLevel((String) entry.getValue());
                    System.out.println(gr.getLevel());
                }
                if (((String) entry.getKey()).equals("NAME"))
                {
                    gr.setName((String) entry.getValue());
                    System.out.println(gr.getName());
                }
            }
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
        EventScore gr;
        for (int j = 0; j < length; j++) {
            gr = new EventScore();
            Iterator iter = hashMaps.get(j).entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                if (((String) entry.getKey()).equals("PERSONID"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setPersonId(ze2.intValue());
                    System.out.println(gr.getPersonId());
                }
                if (((String) entry.getKey()).equals("SCORE"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setScore(ze2.intValue());
                    System.out.println(gr.getScore());
                }
                if (((String) entry.getKey()).equals("PENALTY"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setPenalty(ze2.intValue());
                    System.out.println(gr.getPenalty());
                }
                if (((String) entry.getKey()).equals("GROUPAGE"))
                {
                    gr.setGroupAge((String) entry.getValue());
                    System.out.println(gr.getGroupAge());
                }
                if (((String) entry.getKey()).equals("TEAMNAME"))
                {
                    gr.setTeamName((String) entry.getValue());
                    System.out.println(gr.getTeamName());
                }
                if (((String) entry.getKey()).equals("BONUS"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setBonus(ze2.intValue());
                    System.out.println(gr.getBonus());
                }
                if (((String) entry.getKey()).equals("LV"))
                {
                    gr.setLevel((String) entry.getValue());
                    System.out.println(gr.getLevel());
                }
                if (((String) entry.getKey()).equals("NAME"))
                {
                    gr.setName((String) entry.getValue());
                    System.out.println(gr.getName());
                }
            }
            Com6Persons.add(gr);
        }
    }
    @Override
    public void run()
    {
        GetCom4Score();
        GetCom5Score();
        GetCom6Score();
    }
}
class MyThread3 extends Thread
{
    public static List<EventScore>Com7Persons;
    public static List<EventScore>Com8Persons;
    public static List<EventScore>Com9Persons;
    public  void GetCom7Score()
    {
        SqlSession sqlSession = MybatiesUtil.getSession();
        ScoreMapper mapper = sqlSession.getMapper(ScoreMapper.class);

        //本队参赛信息查询
        List<HashMap> hashMaps = mapper.Competition7();
        Com7Persons = new ArrayList<>();
        int length = hashMaps.size();
        EventScore gr;
        for (int j = 0; j < length; j++) {
            gr = new EventScore();
            Iterator iter = hashMaps.get(j).entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                if (((String) entry.getKey()).equals("PERSONID"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setPersonId(ze2.intValue());
                    System.out.println(gr.getPersonId());
                }
                if (((String) entry.getKey()).equals("SCORE"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setScore(ze2.intValue());
                    System.out.println(gr.getScore());
                }
                if (((String) entry.getKey()).equals("PENALTY"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setPenalty(ze2.intValue());
                    System.out.println(gr.getPenalty());
                }
                if (((String) entry.getKey()).equals("GROUPAGE"))
                {
                    gr.setGroupAge((String) entry.getValue());
                    System.out.println(gr.getGroupAge());
                }
                if (((String) entry.getKey()).equals("TEAMNAME"))
                {
                    gr.setTeamName((String) entry.getValue());
                    System.out.println(gr.getTeamName());
                }
                if (((String) entry.getKey()).equals("BONUS"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setBonus(ze2.intValue());
                    System.out.println(gr.getBonus());
                }
                if (((String) entry.getKey()).equals("LV"))
                {
                    gr.setLevel((String) entry.getValue());
                    System.out.println(gr.getLevel());
                }
                if (((String) entry.getKey()).equals("NAME"))
                {
                    gr.setName((String) entry.getValue());
                    System.out.println(gr.getName());
                }
            }
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
        EventScore gr;
        for (int j = 0; j < length; j++) {
            gr = new EventScore();
            Iterator iter = hashMaps.get(j).entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                if (((String) entry.getKey()).equals("PERSONID"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setPersonId(ze2.intValue());
                    System.out.println(gr.getPersonId());
                }
                if (((String) entry.getKey()).equals("SCORE"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setScore(ze2.intValue());
                    System.out.println(gr.getScore());
                }
                if (((String) entry.getKey()).equals("PENALTY"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setPenalty(ze2.intValue());
                    System.out.println(gr.getPenalty());
                }
                if (((String) entry.getKey()).equals("GROUPAGE"))
                {
                    gr.setGroupAge((String) entry.getValue());
                    System.out.println(gr.getGroupAge());
                }
                if (((String) entry.getKey()).equals("TEAMNAME"))
                {
                    gr.setTeamName((String) entry.getValue());
                    System.out.println(gr.getTeamName());
                }
                if (((String) entry.getKey()).equals("BONUS"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setBonus(ze2.intValue());
                    System.out.println(gr.getBonus());
                }
                if (((String) entry.getKey()).equals("LV"))
                {
                    gr.setLevel((String) entry.getValue());
                    System.out.println(gr.getLevel());
                }
                if (((String) entry.getKey()).equals("NAME"))
                {
                    gr.setName((String) entry.getValue());
                    System.out.println(gr.getName());
                }
            }
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
        EventScore gr;
        for (int j = 0; j < length; j++) {
            gr = new EventScore();
            Iterator iter = hashMaps.get(j).entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                if (((String) entry.getKey()).equals("PERSONID"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setPersonId(ze2.intValue());
                    System.out.println(gr.getPersonId());
                }
                if (((String) entry.getKey()).equals("SCORE"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setScore(ze2.intValue());
                    System.out.println(gr.getScore());
                }
                if (((String) entry.getKey()).equals("PENALTY"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setPenalty(ze2.intValue());
                    System.out.println(gr.getPenalty());
                }
                if (((String) entry.getKey()).equals("GROUPAGE"))
                {
                    gr.setGroupAge((String) entry.getValue());
                    System.out.println(gr.getGroupAge());
                }
                if (((String) entry.getKey()).equals("TEAMNAME"))
                {
                    gr.setTeamName((String) entry.getValue());
                    System.out.println(gr.getTeamName());
                }
                if (((String) entry.getKey()).equals("BONUS"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setBonus(ze2.intValue());
                    System.out.println(gr.getBonus());
                }
                if (((String) entry.getKey()).equals("LV"))
                {
                    gr.setLevel((String) entry.getValue());
                    System.out.println(gr.getLevel());
                }
                if (((String) entry.getKey()).equals("NAME"))
                {
                    gr.setName((String) entry.getValue());
                    System.out.println(gr.getName());
                }
            }
            Com9Persons.add(gr);
        }
    }
    @Override
    public void run()
    {
        GetCom7Score();
        GetCom8Score();
        GetCom9Score();
    }
}
class MyThread4 extends Thread
{
    public static List<EventScore>Com10Persons;
    public static List<EventScore>Com11Persons;
    public static List<EventScore>Com12Persons;
    public  void GetCom10Score()
    {
        SqlSession sqlSession = MybatiesUtil.getSession();
        ScoreMapper mapper = sqlSession.getMapper(ScoreMapper.class);

        //本队参赛信息查询
        List<HashMap> hashMaps = mapper.Competition10();
        Com10Persons = new ArrayList<>();
        int length = hashMaps.size();
        EventScore gr;
        for (int j = 0; j < length; j++) {
            gr = new EventScore();
            Iterator iter = hashMaps.get(j).entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                if (((String) entry.getKey()).equals("PERSONID"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setPersonId(ze2.intValue());
                    System.out.println(gr.getPersonId());
                }
                if (((String) entry.getKey()).equals("SCORE"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setScore(ze2.intValue());
                    System.out.println(gr.getScore());
                }
                if (((String) entry.getKey()).equals("PENALTY"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setPenalty(ze2.intValue());
                    System.out.println(gr.getPenalty());
                }
                if (((String) entry.getKey()).equals("GROUPAGE"))
                {
                    gr.setGroupAge((String) entry.getValue());
                    System.out.println(gr.getGroupAge());
                }
                if (((String) entry.getKey()).equals("TEAMNAME"))
                {
                    gr.setTeamName((String) entry.getValue());
                    System.out.println(gr.getTeamName());
                }
                if (((String) entry.getKey()).equals("BONUS"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setBonus(ze2.intValue());
                    System.out.println(gr.getBonus());
                }
                if (((String) entry.getKey()).equals("LV"))
                {
                    gr.setLevel((String) entry.getValue());
                    System.out.println(gr.getLevel());
                }
                if (((String) entry.getKey()).equals("NAME"))
                {
                    gr.setName((String) entry.getValue());
                    System.out.println(gr.getName());
                }
            }
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
        EventScore gr;
        for (int j = 0; j < length; j++) {
            gr = new EventScore();
            Iterator iter = hashMaps.get(j).entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                if (((String) entry.getKey()).equals("PERSONID"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setPersonId(ze2.intValue());
                    System.out.println(gr.getPersonId());
                }
                if (((String) entry.getKey()).equals("SCORE"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setScore(ze2.intValue());
                    System.out.println(gr.getScore());
                }
                if (((String) entry.getKey()).equals("PENALTY"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setPenalty(ze2.intValue());
                    System.out.println(gr.getPenalty());
                }
                if (((String) entry.getKey()).equals("GROUPAGE"))
                {
                    gr.setGroupAge((String) entry.getValue());
                    System.out.println(gr.getGroupAge());
                }
                if (((String) entry.getKey()).equals("TEAMNAME"))
                {
                    gr.setTeamName((String) entry.getValue());
                    System.out.println(gr.getTeamName());
                }
                if (((String) entry.getKey()).equals("BONUS"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setBonus(ze2.intValue());
                    System.out.println(gr.getBonus());
                }
                if (((String) entry.getKey()).equals("LV"))
                {
                    gr.setLevel((String) entry.getValue());
                    System.out.println(gr.getLevel());
                }
                if (((String) entry.getKey()).equals("NAME"))
                {
                    gr.setName((String) entry.getValue());
                    System.out.println(gr.getName());
                }
            }
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
        EventScore gr;
        for (int j = 0; j < length; j++) {
            gr = new EventScore();
            Iterator iter = hashMaps.get(j).entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                if (((String) entry.getKey()).equals("PERSONID"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setPersonId(ze2.intValue());
                    System.out.println(gr.getPersonId());
                }
                if (((String) entry.getKey()).equals("SCORE"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setScore(ze2.intValue());
                    System.out.println(gr.getScore());
                }
                if (((String) entry.getKey()).equals("PENALTY"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setPenalty(ze2.intValue());
                    System.out.println(gr.getPenalty());
                }
                if (((String) entry.getKey()).equals("GROUPAGE"))
                {
                    gr.setGroupAge((String) entry.getValue());
                    System.out.println(gr.getGroupAge());
                }
                if (((String) entry.getKey()).equals("TEAMNAME"))
                {
                    gr.setTeamName((String) entry.getValue());
                    System.out.println(gr.getTeamName());
                }
                if (((String) entry.getKey()).equals("BONUS"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setBonus(ze2.intValue());
                    System.out.println(gr.getBonus());
                }
                if (((String) entry.getKey()).equals("LV"))
                {
                    gr.setLevel((String) entry.getValue());
                    System.out.println(gr.getLevel());
                }
                if (((String) entry.getKey()).equals("NAME"))
                {
                    gr.setName((String) entry.getValue());
                    System.out.println(gr.getName());
                }
            }
            Com12Persons.add(gr);
        }
    }
    @Override
    public void run()
    {
        GetCom10Score();
        GetCom11Score();
        GetCom12Score();
    }
}
class MyThread5 extends Thread
{
    public static List<PersonScore>PersonsSum;
    public static List<TeamPerson>TeamPersons;
    public static List<TeamScore>TeamScores;
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
                if (((String) entry.getKey()).equals("PERSONID"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setId(ze2.intValue());
                    System.out.println(gr.getId());
                }
                if (((String) entry.getKey()).equals("SCORE"))
                {
                    BigDecimal ze3 = (BigDecimal) entry.getValue();
                    gr.setScore(ze3.intValue());
                    System.out.println(gr.getScore());
                }
                if (((String) entry.getKey()).equals("GAMENAME"))
                {
                    gr.setGameName((String) entry.getValue());
                    System.out.println(gr.getGameName());
                }
                if (((String) entry.getKey()).equals("TEAMNAME"))
                {
                    gr.setTeamName((String) entry.getValue());
                    System.out.println(gr.getTeamName());
                }
                if (((String) entry.getKey()).equals("SEX"))
                {
                    gr.setSex((String) entry.getValue());
                    System.out.println(gr.getSex());
                }
                if (((String) entry.getKey()).equals("NAME"))
                {
                    gr.setName((String) entry.getValue());
                    System.out.println(gr.getName());
                }
            }
            TeamPersons.add(gr);
        }

    }
    public void GetTeamSum() {
        SqlSession sqlSession = MybatiesUtil.getSession();
        ScoreMapper mapper = sqlSession.getMapper(ScoreMapper.class);

        //本队参赛信息查询
        List<HashMap> hashMaps = mapper.TeamScore();
        TeamScores = new ArrayList<>();
        int length = hashMaps.size();
        TeamScore gr;
        for (int j = 0; j < length; j++) {
            gr = new TeamScore();
            Iterator iter = hashMaps.get(j).entrySet().iterator();
            int i = 1;
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                if (((String) entry.getKey()).equals("TEAMNAME")) {
                    gr.setTeamName((String) entry.getValue());

                }
                if (((String) entry.getKey()).equals("TEAMSCORE")) {
                    BigDecimal ze = (BigDecimal) entry.getValue();
                    gr.setTeamScore(ze.intValue());

                }
                if (((String) entry.getKey()).equals("TEAMID")) {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    String aa = "" + ze2.intValue();
                    gr.setTeamId(aa);
                }
            }
            int m = j + 1;
            gr.setOrder(m);
            TeamScores.add(gr);

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
        for (int j = 0; j < length; j++)
        {
            gr = new PersonScore();
            Iterator iter = hashMaps.get(j).entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                if (((String) entry.getKey()).equals("PERSONID"))
                {
                    BigDecimal ze = (BigDecimal) entry.getValue();
                    gr.setPersonId(""+ze.intValue());
                    System.out.println(gr.getPersonId());
                }
                if (((String) entry.getKey()).equals("SUMSCORE"))
                {
                    BigDecimal ze2 = (BigDecimal) entry.getValue();
                    gr.setScore(ze2.intValue());
                    System.out.println(gr.getScore());
                }
                if (((String) entry.getKey()).equals("NAME"))
                {
                    gr.setName((String) entry.getValue());
                    System.out.println(gr.getName());
                }
                if (((String) entry.getKey()).equals("TEAMNAME"))
                {
                    gr.setTeamName((String) entry.getValue());
                    System.out.println(gr.getTeamName());
                }
            }
            int m=j+1;
            gr.setOrder(m);
            PersonsSum.add(gr);
        }
    }
    @Override
    public void run()
    {
        GetSumScore();
        GetOwnPersonScore();
        GetTeamSum();
    }
}
public class ScoreTable extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException
    {
        MyThread1 m1 =new MyThread1();
        MyThread2 m2=new MyThread2();
        MyThread3 m3=new MyThread3();
        MyThread4 m4=new MyThread4();
        MyThread5 m5=new MyThread5();
        m1.start();
        m2.start();
        m3.start();
        m4.start();
        m5.start();
        int a=0;
        while (a==0)
        {
            if(m1.isAlive()||m2.isAlive()||m3.isAlive()||m4.isAlive()||m5.isAlive())
            {
                a=0;
            }
            else
            {
                a=1;
            }
        }


        request.setCharacterEncoding("UTF-8");
        String CONTENT_TYPE = "text/html; charset=GBK";
        response.setContentType(CONTENT_TYPE);
        request.setAttribute("Com1Persons",MyThread1.Com1Persons);
        request.setAttribute("Com2Persons",MyThread1.Com2Persons);
        request.setAttribute("Com3Persons",MyThread1.Com3Persons);
        request.setAttribute("Com4Persons",MyThread2.Com4Persons);
        request.setAttribute("Com5Persons",MyThread2.Com5Persons);
        request.setAttribute("Com6Persons",MyThread2.Com6Persons);
        request.setAttribute("Com7Persons",MyThread3.Com7Persons);
        request.setAttribute("Com8Persons",MyThread3.Com8Persons);
        request.setAttribute("Com9Persons",MyThread3.Com9Persons);
        request.setAttribute("Com10Persons",MyThread4.Com10Persons);
        request.setAttribute("Com11Persons",MyThread4.Com11Persons);
        request.setAttribute("Com12Persons",MyThread4.Com12Persons);
        request.setAttribute("TeamPersons",MyThread5.TeamPersons);
        request.setAttribute("PersonsSum",MyThread5.PersonsSum);
        request.setAttribute("TeamScores",MyThread5.TeamScores);
        request.getRequestDispatcher("/ScoreTable.jsp").forward(request, response);

    }
}
