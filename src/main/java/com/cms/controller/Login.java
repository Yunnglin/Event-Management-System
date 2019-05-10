package com.cms.controller;

import com.cms.mapper.TeamMapper;
import com.cms.util.MybatiesUtil;
import org.apache.ibatis.binding.BindingException;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet {

    private String account;
    private String password;

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
        boolean flag = judgeLogin(account,password,req,resp);
        if (flag){
            out.print("<script>window.location.href = 'http://localhost:8080/cms/mainPage.jsp'</script>");
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
            int tNo=mapper.queryIdByAccount(a);
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
