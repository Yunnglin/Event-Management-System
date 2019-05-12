package com.cms.controller;

import com.cms.mapper.CoachMapper;
import com.cms.mapper.DoctorMapper;
import com.cms.mapper.LeaderMapper;
import com.cms.mapper.RefereeMapper;
import com.cms.pojo.Coach;
import com.cms.pojo.Doctor;
import com.cms.pojo.Leader;
import com.cms.pojo.Referee;
import com.cms.util.MybatiesUtil;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class AddServlet extends HttpServlet {

    private Doctor d = new Doctor();
    private Leader l = new Leader();
    private Referee r = new Referee();
    private Coach c = new Coach();
    private String summitType;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String CONTENT_TYPE = "text/html; charset=GBK";
        summitType=req.getParameter("submitB");
        boolean flag = false;
        switch (summitType){
            case "L":
                l.setName(req.getParameter("dName"));
                l.setIdNum(req.getParameter("dID"));
                l.setPhone(req.getParameter("dPhone"));
                flag = addLeader(l,req,resp);
                break;
            case "D":
                d.setName(req.getParameter("dName"));
                d.setIdNum(req.getParameter("dID"));
                d.setPhone(req.getParameter("dPhone"));
                flag = addDoctor(d,req,resp);
                break;
            case "A":
                break;
            case "C":
                c.setName(req.getParameter("cName"));
                c.setIdNum(req.getParameter("cID"));
                c.setPhone(req.getParameter("cPhone"));
                c.setSex(req.getParameter("cSex"));
                System.out.println(c.getSex());
                flag = addCoach(c,req,resp);
                break;
            case "R":
                r.setName(req.getParameter("dName"));
                r.setIdNum(req.getParameter("dID"));
                r.setPhone(req.getParameter("dPhone"));
                flag=addReferee(r,req,resp);
                break;
                default:
                    break;
        }



        if (flag){
            resp.setContentType( CONTENT_TYPE);
            PrintWriter out = resp.getWriter();
            out.print("<script>alert('提交成功');window.location.href = 'http://localhost:8080/cms/mainPage.jsp'</script>");

        }

    }

    public boolean addDoctor(Doctor d,HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String CONTENT_TYPE = "text/html; charset=GBK";
        resp.setContentType( CONTENT_TYPE);
        PrintWriter out = resp.getWriter();
        try {
            SqlSession sqlSession = MybatiesUtil.getSession();
            DoctorMapper mapper = sqlSession.getMapper(DoctorMapper.class);
            Doctor doctor = new Doctor();

            doctor.setName(d.getName());

            doctor.setIdNum(d.getIdNum());

            doctor.setPhone(d.getPhone());

            doctor.setTeam_No(1);

            try {
                mapper.insert(doctor);
            } catch (PersistenceException e) {
                e.printStackTrace();
                if (d.getName()==""){
                    out.print("<script>alert('名字不能为空,请重新输入');window.location.href = 'http://localhost:8080/cms/mainPage.jsp'</script>");
                }else if (d.getIdNum()==""){
                    out.print("<script>alert('身份证不能为空,请重新输入');window.location.href = 'http://localhost:8080/cms/mainPage.jsp'</script>");
                }else if (d.getPhone()==""){
                    out.print("<script>alert('电话不能为空,请重新输入');window.location.href = 'http://localhost:8080/cms/mainPage.jsp'</script>");
                }

            }
            sqlSession.commit();

            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean addLeader(Leader l, HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String CONTENT_TYPE = "text/html; charset=GBK";
        resp.setContentType( CONTENT_TYPE);
        PrintWriter out = resp.getWriter();
        try {
            SqlSession sqlSession = MybatiesUtil.getSession();
            LeaderMapper mapper = sqlSession.getMapper(LeaderMapper.class);
            Leader leader = new Leader();

            leader.setName(l.getName());

            leader.setIdNum(l.getIdNum());

            leader.setPhone(l.getPhone());

            leader.setTeam_No(1);

            try {
                mapper.insert(leader);
            } catch (PersistenceException e) {
                e.printStackTrace();
                if (l.getName()==""){
                    out.print("<script>alert('名字不能为空,请重新输入');window.location.href = 'http://localhost:8080/cms/mainPage.jsp'</script>");
                }else if (l.getIdNum()==""){
                    out.print("<script>alert('身份证不能为空,请重新输入');window.location.href = 'http://localhost:8080/cms/mainPage.jsp'</script>");
                }else if (l.getPhone()==""){
                    out.print("<script>alert('电话不能为空,请重新输入');window.location.href = 'http://localhost:8080/cms/mainPage.jsp'</script>");
                }

            }
            sqlSession.commit();

            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean addReferee(Referee r, HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String CONTENT_TYPE = "text/html; charset=GBK";
        resp.setContentType( CONTENT_TYPE);
        PrintWriter out = resp.getWriter();
        try {
            SqlSession sqlSession = MybatiesUtil.getSession();
            RefereeMapper mapper = sqlSession.getMapper(RefereeMapper.class);
            Referee referee = new Referee();

            referee.setName(r.getName());

            referee.setIdNum(r.getIdNum());

            referee.setPhone(r.getPhone());

            referee.setTeam_No(1);

            try {
                mapper.insert(referee);
            } catch (PersistenceException e) {
                e.printStackTrace();
                if (r.getName()==""){
                    out.print("<script>alert('名字不能为空,请重新输入');window.location.href = 'http://localhost:8080/cms/mainPage.jsp'</script>");
                }else if (r.getIdNum()==""){
                    out.print("<script>alert('身份证不能为空,请重新输入');window.location.href = 'http://localhost:8080/cms/mainPage.jsp'</script>");
                }else if (r.getPhone()==""){
                    out.print("<script>alert('电话不能为空,请重新输入');window.location.href = 'http://localhost:8080/cms/mainPage.jsp'</script>");
                }

            }
            sqlSession.commit();

            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean addCoach(Coach c,HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String CONTENT_TYPE = "text/html; charset=GBK";
        resp.setContentType( CONTENT_TYPE);
        PrintWriter out = resp.getWriter();
        try {
            SqlSession sqlSession = MybatiesUtil.getSession();
            CoachMapper mapper = sqlSession.getMapper(CoachMapper.class);
            Coach coach = new Coach();

            coach.setName(c.getName());

            coach.setIdNum(c.getIdNum());

            coach.setPhone(c.getPhone());

            coach.setSex(c.getSex());

            coach.setTeam_No(1);

            try {
                mapper.insert(coach);
            } catch (PersistenceException e) {
                e.printStackTrace();
                if (r.getName()==""){
                    out.print("<script>alert('名字不能为空,请重新输入');window.location.href = 'http://localhost:8080/cms/mainPage.jsp'</script>");
                }else if (r.getIdNum()==""){
                    out.print("<script>alert('身份证不能为空,请重新输入');window.location.href = 'http://localhost:8080/cms/mainPage.jsp'</script>");
                }else if (r.getPhone()==""){
                    out.print("<script>alert('电话不能为空,请重新输入');window.location.href = 'http://localhost:8080/cms/mainPage.jsp'</script>");
                }

            }
            sqlSession.commit();

            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
