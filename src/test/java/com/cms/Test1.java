package com.cms;

import com.cms.mapper.*;
import com.cms.pojo.*;
import com.cms.util.MybatiesUtil;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.Map.Entry;

public class Test1 {

    @Test
    public void m1(){
        SqlSession sqlSession = MybatiesUtil.getSession();
        DoctorMapper mapper = sqlSession.getMapper(DoctorMapper.class);
        Doctor doctor = new Doctor();
        doctor.setName("dsfs");
        doctor.setIdNum("555555555");
        doctor.setPhone("434343244");
        doctor.setTeam_No(2);

        mapper.insert(doctor);
        sqlSession.commit();

        sqlSession.close();
    }
    @Test
    public void m2(){
        SqlSession sqlSession = MybatiesUtil.getSession();
        DoctorMapper mapper = sqlSession.getMapper(DoctorMapper.class);
        Doctor doctor = mapper.queryById("321654987789456132");

        System.out.println(doctor.getName());

        sqlSession.close();
    }
    @Test
    public void m3(){
        Doctor doctor = new Doctor();
        doctor.setIdNum("321654987789456132");
        SqlSession sqlSession = MybatiesUtil.getSession();
        DoctorMapper mapper = sqlSession.getMapper(DoctorMapper.class);
        String dName = mapper.queryNameById("277326360093214192");

        System.out.println(dName);

        sqlSession.close();
    }

    @Test
    public void m4(){
        SqlSession sqlSession = MybatiesUtil.getSession();
        RefereeMapper mapper = sqlSession.getMapper(RefereeMapper.class);
        Referee referee = new Referee();
        referee.setName("dsfs");
        referee.setIdNum("555555555");
        referee.setPhone("434343244");
        referee.setTeam_No(2);

        mapper.insert(referee);
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void m5(){
        SqlSession sqlSession = MybatiesUtil.getSession();
        TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);

        String account = "20191521003";
        String p="000000";
        int no = mapper.queryIdByAccount(account);
        String pw=mapper.queryPassword(account);
        System.out.println(no);
        System.out.println(p.equals(mapper.queryPassword(account)));
        sqlSession.commit();

        sqlSession.close();
    }
    @Test
    public void m6(){

        SqlSession sqlSession = MybatiesUtil.getSession();
        AthleteMapper mapper = sqlSession.getMapper(AthleteMapper.class);

        Athlete athlete = new Athlete();
        athlete.setAge(8);
        athlete.setName("王德恩");
        athlete.setSex("男");
        athlete.setId("339888");
        athlete.setTeam_No(1);
        athlete.setAc_record(9);
        athlete.setNo(mapper.queryAthleteCount()+1);
        try {
            mapper.insert(athlete);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void m7() throws FileNotFoundException {
        Team t =new Team();
        t.settNo(3);
        String url = "D:/CMS/target/CMS/upload/test_compile.txt";
        File uploadDir = new File(url);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        InputStream is = null;
        try {
            is=new FileInputStream(uploadDir);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        byte[] att = new byte[0];
        try {
            ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
            byte[] buff = new byte[100];
            int rc=0;
            while ((rc=is.read(buff,0,100))>0){
                swapStream.write(buff, 0, rc);
            }
            att = swapStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        t.setAttachment(att);

        byte[] test = t.getAttachment();
        for (int i=0;i<att.length;i++){
            System.out.print(test[i]);
        }

        SqlSession sqlSession = MybatiesUtil.getSession();
        TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);

        try {
            mapper.insertAttachment(t);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        sqlSession.commit();

        sqlSession.close();
    }
    @Test
    public void m10() {
        SqlSession sqlSession = MybatiesUtil.getSession();
        GameMapper mapper = sqlSession.getMapper(GameMapper.class);
        List<HashMap> hashMaps = mapper.queryAll();
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
        for(int k=0;k<Games.size();k++)
        {
            System.out.println(Games.get(k).getGameId());
            System.out.println(Games.get(k).getGroupAge());
            System.out.println(Games.get(k).getEventName());
        }
        System.out.println();
        sqlSession.close();

    }
    @Test
    public  void m11()
    {
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
    }
    @Test
    public  void m12()
    {
        SqlSession sqlSession = MybatiesUtil.getSession();
        ScoreMapper mapper = sqlSession.getMapper(ScoreMapper.class);

        //本队参赛信息查询
        List<HashMap> hashMaps = mapper.Competition1();
        List<PersonScore> Com1Persons = new ArrayList<>();

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
    @Test
    public void m15() {
        SqlSession sqlSession = MybatiesUtil.getSession();
        ScoreMapper mapper = sqlSession.getMapper(ScoreMapper.class);


        List<HashMap> hashMaps = mapper.PersonSum();
     List<PersonScore>   PersonsSum = new ArrayList<>();

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

}
