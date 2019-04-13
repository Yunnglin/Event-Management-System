<%--
  Created by IntelliJ IDEA.
  User: MQD
  Date: 2019/4/13
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    String userName = request.getParameter("username");
    String passWord = request.getParameter("password");
    if (userName.equals("123abc") && passWord.equals("12345")) {
        pageContext.forward("mainPage.jsp");
    }else{
        pageContext.forward("index.jsp");
    }
%>
</body>
</html>
