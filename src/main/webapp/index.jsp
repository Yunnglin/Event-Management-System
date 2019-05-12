<%--
  Created by IntelliJ IDEA.
  User: MQD
  Date: 2019/4/2
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<html>
<head>
    <title>运动员管理系统</title>
    <link rel="stylesheet" href="Css/login.css" type="text/css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="js/login.js" type="text/javascript"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div id="backImg">
    <img src="img/login_surface.jpg" id="surface">
    <div id="black"></div>
    <form id="login_main" action="<%=request.getContextPath()%>/Login" method="post">
        <div id="login_title">登录</div>
        <span  id="login_user">用户名</span>
        <input type="text" id="username" placeholder="输入用户名" name="username">
        <span  id="login_password">密码</span>
        <input type="password" id="password" placeholder="输入密码" name="password">
        <button type="submit" class="btn btn-primary" id="login_leader">领队登录</button>
        <button type="button" class="btn btn-primary" id="login_adm">管理员登录</button>
        <button type="button" class="btn btn-primary" id="login_coach">教练登录</button>
    </form>
    <%--<div id="" action="" >--%>
    <%----%>
    <%--</div>--%>
</div>
</body>
</html>
