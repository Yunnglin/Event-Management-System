package com.cms;

import com.cms.mapper.*;
import com.cms.pojo.*;
import com.cms.util.MybatiesUtil;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import java.io.*;
import java.util.*;

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
    public void m8(){
        SqlSession sqlSession = MybatiesUtil.getSession();
        GameMapper mapper=sqlSession.getMapper(GameMapper.class);
//        List<HashMap> hashMaps=mapper.queryAll();
//        JSONArray jsonArray= new JSONArray(hashMaps);
//        System.out.println(jsonArray.toString());
        Game game=mapper.queryById(3);
        game.setrIdNum("577332460093214327");
        mapper.updateRId(game);
        System.out.println(game.toString());
    }
    @Test
    public void m9(){
        SqlSession sqlSession = MybatiesUtil.getSession();
<<<<<<< HEAD
        EventMapper mapper = sqlSession.getMapper(EventMapper.class);
        int a = mapper.queryIDbyName("双杠");
        System.out.println(a);
=======
        TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);
        List<Team> team = mapper.queryByName("湖北");

    }
    @Test
    public void m10(){
        SqlSession sqlSession = MybatiesUtil.getSession();
        RefereeMapper mapper = sqlSession.getMapper(RefereeMapper.class);
        System.out.println(mapper.queryById("123"));
>>>>>>> c3e96fe3e50415d81f3fcbc254a21e6d6c82e7fc
    }

}
