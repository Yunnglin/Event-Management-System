<%--
  Created by IntelliJ IDEA.
  User: Mr.mao
  Date: 2019/5/11
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<div class="layui-header">
    <a class="layui-logo" href="adminIndex.jsp">赛事管理系统后台</a>
    <!-- 头部区域（可配合layui已有的水平导航） -->

    <form id="form" action="" method="post">
        <input type="hidden" name="_method" value="">
    </form>

    <ul class="layui-nav layui-layout-left">
        <li class="layui-nav-item"><a href="javascript:;">赛程安排</a></li>
        <%--<li class="layui-nav-item"><a href="javascript:;">比赛成绩</a></li>--%>
    </ul>

    <ul class="layui-nav layui-layout-right">
        <li class="layui-nav-item">
            <a href="javascript:;">
                管理员
            </a>
            <dl class="layui-nav-child">
                <dd><a href="javascript:;">基本资料</a></dd>
                <dd><a href="javascript:;">安全设置</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item"><a href="index.jsp">退出</a></li>
    </ul>
</div>

<div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
        <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
        <ul class="layui-nav layui-nav-tree">
            <li class="layui-nav-item layui-nav-itemed">
                <a class="" href="javascript:;">人员管理</a>
                <dl class="layui-nav-child">
                    <dd><a id="team" href="team.jsp">队伍</a></dd>
                    <dd><a href="athlete.jsp">队员</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item" >
                <a href="javascript:;">账号管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="teamAccount.jsp">添加队伍</a></dd>
                    <%--<dd><a href="javascript:;">添加教练</a></dd>--%>
                </dl>
            </li>
        </ul>
    </div>
</div>


