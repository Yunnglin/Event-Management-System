package com.cms.controller;

import com.cms.mapper.AthleteMapper;
import com.cms.mapper.TeamMapper;
import com.cms.pojo.Athlete;
import com.cms.pojo.Team;
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
import java.util.List;

public class AdminServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post");

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String CONTENT_TYPE = "text/html; charset=GBK";
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();

        SqlSession sqlSession = MybatiesUtil.getSession();
        String method = request.getParameter("method");
        try {
            if (method.equals("queryTeam")) {
                TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);
                List<Team> teams = mapper.queryAll();
                request.setAttribute("teams", teams);
                request.getRequestDispatcher("/team.jsp").forward(request, response);
            } else if (method.equals("queryAthlete")) {
                AthleteMapper mapper = sqlSession.getMapper(AthleteMapper.class);
                List<Athlete> athletes = mapper.queryAll();
                request.setAttribute("athletes", athletes);
                request.getRequestDispatcher("/athlete.jsp").forward(request, response);
            } else if (method.equals("addTeam")) {
                Team team = new Team();
                team.settNo(Integer.valueOf(request.getParameter("tno")));
                team.setName(request.getParameter("name"));
                team.setAccount(request.getParameter("account"));
                team.setPassword(request.getParameter("password"));

                System.out.println(team.toString());

                TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);
                if (mapper.queryById(team.gettNo()) != null) {
                    out.print("<script>alert('队号重复,添加失败');window.location.href = 'http://localhost:8080/cms/teamAccount.jsp'</script>");

                } else if(mapper.queryByAccount(team.getAccount()) != null){
                    //out.print("<script>alert('编号重复')</script>");
                    out.print("<script>alert('帐号重复,添加失败');window.location.href = 'http://localhost:8080/cms/teamAccount.jsp'</script>");
                }else{
                    mapper.insert(team);
                    out.print("<script>alert('添加成功');window.location.href = 'http://localhost:8080/cms/teamAccount.jsp'</script>");
                }
            }
        } catch (BindingException e) {
            out.print("<script>alert('错误!')</script>");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("get");

    }
}
