package com.cms.controller;

import com.cms.mapper.TeamMapper;
import com.cms.pojo.Team;
import com.cms.util.MybatiesUtil;
import org.apache.ibatis.binding.BindingException;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.SessionCookieConfig;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class Login extends HttpServlet {

    public static String account;
    private String password;
    public static int tNo;
    public static String teamName;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String CONTENT_TYPE = "text/html; charset=GBK";
        resp.setContentType( CONTENT_TYPE);
        PrintWriter out = resp.getWriter();

        account=req.getParameter("username");
        password=req.getParameter("password");

        String userType = req.getParameter("user_type");

        if(userType.equals("leader")){
            boolean flag = judgeLogin(account,password,req,resp);
            if (flag){
                out.print("<script>window.location.href = 'http://localhost:8080/cms/mainPage.jsp'</script>");
            }
        }else if(userType.equals("admin")){
            if (account.equals("admin")&&password.equals("123456")){
               //out.print("<script>window.location.href = 'http://localhost:8080/cms/adminIndex.jsp'</script>");
                resp.sendRedirect("adminIndex.jsp");
            }else{
                out.print("<script>alert('用户名错误或不存在该用户');window.location.href = 'http://localhost:8080/cms/index.jsp'</script>");
            }
        }

    }

    private boolean judgeLogin(String a,String p,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String CONTENT_TYPE = "text/html; charset=GBK";
        resp.setContentType( CONTENT_TYPE);
        PrintWriter out = resp.getWriter();

        SqlSession sqlSession = MybatiesUtil.getSession();
        TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);

        try {
            Team t = new Team();
            tNo=mapper.queryIdByAccount(a);
            t=mapper.queryByAccount(a);
            teamName = t.getName();
            String pWord = mapper.queryPassword(a);
            if (!p.equals(pWord)){
                out.print("<script>alert('密码错误');window.location.href = 'http://localhost:8080/cms/index.jsp'</script>");
                return false;
            }
        } catch (BindingException e) {
            e.printStackTrace();
            out.print("<script>alert('用户名错误或不存在该用户');window.location.href = 'http://localhost:8080/cms/index.jsp'</script>");
            return false;
        }


        sqlSession.commit();
        sqlSession.close();
        return true;
    }

}
