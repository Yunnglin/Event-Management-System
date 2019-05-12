<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%--%>
    <%--String path = request.getContextPath();--%>
    <%--String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";--%>
    <%--request.setAttribute("path", basePath);--%>
<%--%>--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>赛事管理系统</title>
    <link rel="stylesheet" href="plugins/layui/css/layui.css">

</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">

    <jsp:include page="header.jsp"/>

    <div class="layui-body" style="background-color: #eeeeee;  ">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">

            <form class="layui-form" action="<%=request.getContextPath()%>/AdminServlet" method="post">
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button type="submit" class="layui-btn">查询</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
            <table lay-filter="test">
                <thead>
                <tr>
                    <th lay-data="{field:'number', width:100, sort:true}">队号</th>
                    <th lay-data="{field:'name', width:250}">队名</th>
                    <th lay-data="{field:'account', minWidth: 180}">账号</th>
                    <th lay-data="{field:'password', minWidth: 180}">密码</th>
                    <th lay-data="{fixed: 'right', width:250, align:'center', toolbar: '#toolBar'}">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${teams}" var="team">
                    <tr>
                        <td align="center">${team.gettNo()}</td>
                        <td align="center">${team.getName()}</td>
                        <td align="center">${team.getAccount()}</td>
                        <td align="center">${team.getPassword()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <jsp:include page="footer.jsp"/>
</div>

<script src="plugins/layui/layui.js"></script>

<script type="text/html" id="toolBar">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="detail">查看</button>
        <button class="layui-btn layui-btn-sm" lay-event="delete">删除</button>
        <button class="layui-btn layui-btn-sm" lay-event="update">编辑</button>
    </div>
</script>

<script>
    window.onload=function() {
        layui.use('element', function(){
            var element = layui.element;
            element.render();
        });

        layui.use('table', function () {
            var table = layui.table;
            //转换静态表格
            table.init('test', {
                height: 315 //设置高度
                ,page:true
                ,limit: 10 //注意：请务必确保 limit 参数（默认：10）是与你服务端限定的数据条数一致
            });
        });
    };



</script>
</body>
</html>