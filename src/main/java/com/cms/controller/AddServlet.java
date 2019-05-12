package com.cms.controller;

import com.cms.mapper.*;
import com.cms.pojo.*;
import com.cms.util.MybatiesUtil;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import com.cms.controller.Login;

public class AddServlet extends HttpServlet {

    private Doctor d = new Doctor();
    private Leader l = new Leader();
    private Referee r = new Referee();
    private Coach c = new Coach();
    private Athlete a = new Athlete();
    private Game g = new Game();
    private Participation p =new Participation();
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
        int tNo = Login.tNo;
        summitType=req.getParameter("submitB");
        boolean flag = false;
        switch (summitType){
            case "L":
                l.setName(req.getParameter("dName"));
                l.setIdNum(req.getParameter("dID"));
                l.setPhone(req.getParameter("dPhone"));
                l.setTeam_No(tNo);
                flag = addLeader(l,req,resp);
                break;
            case "D":
                d.setName(req.getParameter("dName"));
                d.setIdNum(req.getParameter("dID"));
                d.setPhone(req.getParameter("dPhone"));
                d.setTeam_No(tNo);
                flag = addDoctor(d,req,resp);
                break;
            case "A":
                a.setName(req.getParameter("aName"));
                a.setId(req.getParameter("aID"));
                a.setAge(Integer.parseInt(req.getParameter("aAge")));
                a.setSex(req.getParameter("aSex"));
                g.setGroupAge(req.getParameter("ageGroup"));
                System.out.println(g.getGroupAge());
                g.setLevel("初赛");
                if (req.getParameter("aCGrade").equals("")){
                    a.setAc_record(0);
                }else{
                    a.setAc_record(Integer.parseInt(req.getParameter("aCGrade")));
                }
                a.setTeam_No(tNo);

                boolean add1 = addGame(g,req,resp);
                boolean add2 = addAthlete(a,req,resp);
                boolean add3 = addParticipation(p);
                flag = add1 && add2 && add3;
                break;
            case "C":
                c.setName(req.getParameter("cName"));
                c.setIdNum(req.getParameter("cID"));
                c.setPhone(req.getParameter("cPhone"));
                c.setSex(req.getParameter("cSex"));
                c.setTeam_No(tNo);
                flag = addCoach(c,req,resp);
                break;
            case "R":
                r.setName(req.getParameter("dName"));
                r.setIdNum(req.getParameter("dID"));
                r.setPhone(req.getParameter("dPhone"));
                r.setTeam_No(tNo);
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

            doctor.setTeam_No(d.getTeam_No());

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

            leader.setTeam_No(l.getTeam_No());

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

            referee.setTeam_No(r.getTeam_No());

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

            coach.setTeam_No(c.getTeam_No());

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

    public boolean addAthlete(Athlete a,HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String CONTENT_TYPE = "text/html; charset=GBK";
        resp.setContentType( CONTENT_TYPE);
        PrintWriter out = resp.getWriter();
        try {
            SqlSession sqlSession = MybatiesUtil.getSession();
            AthleteMapper mapper = sqlSession.getMapper(AthleteMapper.class);
            Athlete athlete = new Athlete();
            athlete.setName(a.getName());
            athlete.setId(a.getId());
            athlete.setAge(a.getAge());
            athlete.setSex(a.getSex());
            athlete.setAc_record(a.getAc_record());
            athlete.setTeam_No(a.getTeam_No());
            athlete.setNo(mapper.queryAthleteCount()+1);
            p.setAthleteNo(athlete.getNo());

            if (athlete.getAc_record()==0){
                try {
                    mapper.insertNotGrade(athlete);
                } catch (PersistenceException e) {
                    e.printStackTrace();
                    if (a.getName()==""){
                        out.print("<script>alert('名字不能为空,请重新输入');window.location.href = 'http://localhost:8080/cms/mainPage.jsp'</script>");
                    }else if (a.getId()==""){
                        out.print("<script>alert('身份证不能为空,请重新输入');window.location.href = 'http://localhost:8080/cms/mainPage.jsp'</script>");
                    }else if (a.getAge()==0){
                        out.print("<script>alert('年龄不能为空,请重新输入');window.location.href = 'http://localhost:8080/cms/mainPage.jsp'</script>");
                    }
                }
            }else{
                try {

                    mapper.insert(athlete);
                } catch (PersistenceException e) {
                    e.printStackTrace();
                    if (a.getName()==""){
                        out.print("<script>alert('名字不能为空,请重新输入');window.location.href = 'http://localhost:8080/cms/mainPage.jsp'</script>");
                    }else if (a.getId()==""){
                        out.print("<script>alert('身份证不能为空,请重新输入');window.location.href = 'http://localhost:8080/cms/mainPage.jsp'</script>");
                    }else if (a.getAge()==0){
                        out.print("<script>alert('年龄不能为空,请重新输入');window.location.href = 'http://localhost:8080/cms/mainPage.jsp'</script>");
                    }
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

    public boolean addGame(Game g,HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String CONTENT_TYPE = "text/html; charset=GBK";
        resp.setContentType( CONTENT_TYPE);
        PrintWriter out = resp.getWriter();
        try {
            SqlSession sqlSession = MybatiesUtil.getSession();
            GameMapper mapper = sqlSession.getMapper(GameMapper.class);
            Game game = new Game();
            String[] events = req.getParameterValues("event");
            game.setLevel(g.getLevel());
            game.setGroupAge(g.getGroupAge());

            if (events.length==0){
                out.print("<script>alert('比赛项目为空，请选择至少一门比赛');window.location.href = 'http://localhost:8080/cms/mainPage.jsp'</script>");
            }else {
                for (int i=0;i<events.length;i++){
                    System.out.println(Integer.parseInt(events[i]));
                    game.setGameId(mapper.queryGameCount()+1);
                    game.setEventId(Integer.parseInt(events[i]));
                    System.out.println(game.getGameId());
                    int exist = 0;
                    try {
                        exist = mapper.queryIsExist(game);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (exist == 0){
                        try {
                            mapper.insetGame(game);
                            p.setGameId(game.getGameId());
                        } catch (PersistenceException e) {
                            e.printStackTrace();
                            return false;
                        }
                    }else {
                        p.setGameId(exist);
                    }

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
    
    public boolean addParticipation(Participation p){
        try {
            SqlSession sqlSession = MybatiesUtil.getSession();
            ParticipationMapper mapper = sqlSession.getMapper(ParticipationMapper.class);
            Participation participation = new Participation();
            participation.setAthleteNo(p.getAthleteNo());
            participation.setGameId(p.getGameId());

            mapper.inserP(participation);

            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }

}
