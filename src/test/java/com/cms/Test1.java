package com.cms;

import com.cms.mapper.DoctorMapper;
import com.cms.mapper.TeamMapper;
import com.cms.pojo.Doctor;
import com.cms.pojo.Leader;
import com.cms.mapper.LeaderMapper;
import com.cms.pojo.Referee;
import com.cms.mapper.RefereeMapper;
import com.cms.util.MybatiesUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
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

        String account = "3337001";
        String p="000000";
        String pw=mapper.queryPassword(account);
        System.out.println(pw);
        System.out.println(p.equals(mapper.queryPassword(account)));
        sqlSession.commit();

        sqlSession.close();
    }
}
