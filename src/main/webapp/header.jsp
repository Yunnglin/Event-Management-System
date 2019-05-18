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
    <a class="layui-logo" href="adminIndex.jsp"><i class="layui-icon layui-icon-home"></i>赛事管理系统后台</a>
    <!-- 头部区域（可配合layui已有的水平导航） -->

    <form id="form" action="" method="post">
        <input type="hidden" name="_method" value="">
    </form>

    <ul class="layui-nav layui-layout-left">
        <li class="layui-nav-item"><a href="javascript:;"><i class="layui-icon layui-icon-list"></i>赛事相关</a>
            <dl class="layui-nav-child">
                <dd><a href="gameManage.jsp">赛事安排</a></dd>

            </dl>

        </li>
    </ul>

    <ul class="layui-nav layui-layout-right">
        <li class="layui-nav-item">
            <a href="javascript:;"><i class="layui-icon layui-icon-username"></i>管理员</a>
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
                    <dd><a id="team" href="javascript:;" onclick="queryTeam()"><i class="layui-icon layui-icon-group"></i> 队 伍</a></dd>
                    <dd><a href="javascript:;" onclick="queryAthlete()"><i class="layui-icon layui-icon-friends"></i>&nbsp&nbsp&nbsp队 员</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item" >
                <a href="javascript:;">账号管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="teamAccount.jsp"><i class="layui-icon layui-icon-add-circle-fine"></i>添加队伍</a></dd>
                    <%--<dd><a href="javascript:;">添加教练</a></dd>--%>
                </dl>
            </li>
        </ul>
    </div>
</div>

<script>
    function queryTeam(){
        var tmp = document.createElement('form');
        var action = '<%=request.getContextPath()%>/AdminServlet?method=queryTeam';
        tmp.action = action;
        tmp.method = 'post';
        tmp.style.display = 'none';
        var input = document.createElement('input');
        input.type = 'hidden';
        input.name = 'select';
        input.value = 'all';
        tmp.appendChild(input);
        document.body.appendChild(tmp);
        tmp.submit();
    }
    function queryAthlete() {
        var tmp = document.createElement('form');
        var action = '<%=request.getContextPath()%>/AdminServlet?method=queryAthlete';
        tmp.action = action;
        tmp.method = 'post';
        tmp.style.display = 'none';
        document.body.appendChild(tmp);
        tmp.submit();
    }
</script>
