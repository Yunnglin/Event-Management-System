<%--
  Created by IntelliJ IDEA.
  User: Mr.mao
  Date: 2019/5/11
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="layui-header">
    <a class="layui-logo" href="index.jsp">赛事管理系统后台</a>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
        <li class="layui-nav-item"><a href="">赛程安排</a></li>
        <li class="layui-nav-item"><a href="">比赛成绩</a></li>
    </ul>
    <ul class="layui-nav layui-layout-right">
        <li class="layui-nav-item">
            <a href="javascript:;">
                管理员
            </a>
            <dl class="layui-nav-child">
                <dd><a href="">基本资料</a></dd>
                <dd><a href="">安全设置</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item"><a href="">退出</a></li>
    </ul>
</div>

<div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
        <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
        <ul class="layui-nav layui-nav-tree" lay-shrink="">
            <li class="layui-nav-item layui-nav-itemed">
                <a class="" href="javascript:;">赛事管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="team.jsp">队伍</a></dd>
                    <dd><a href="javascript:;">队员</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item" >
                <a href="javascript:;">账号管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="teamAccount.jsp">队伍账号</a></dd>
                    <dd><a href="javascript:;">教练账号</a></dd>
                </dl>
            </li>
        </ul>
    </div>
</div>
