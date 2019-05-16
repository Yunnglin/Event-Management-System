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

            <form class="layui-form" action="<%=request.getContextPath()%>/AdminServlet?method=queryTeam" method="post">
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button type="submit" class="layui-btn">查询</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
            <table lay-filter="test" id="teamTable">
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
        <button class="layui-btn layui-btn-sm" lay-event="delete">删除</button>
        <button class="layui-btn layui-btn-sm" lay-event="edit">编辑</button>
    </div>
</script>
<script>
    window.onload = function () {
        layui.use('element', function () {
            var element = layui.element;
            element.render();
        });

        layui.use('table', function () {
            var table = layui.table;
            //转换静态表格
            table.init('test', {
                height: 315 //设置高度
                , page: true
                , limit: 10 //注意：请务必确保 limit 参数（默认：10）是与你服务端限定的数据条数一致
            });

            //监听工具条
            table.on('tool(test)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
                var data = obj.data; //获得当前行数据
                var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
                var tr = obj.tr; //获得当前行 tr 的DOM对象

                if (layEvent === 'detail') { //查看
                    //do somehing
                } else if (layEvent === 'delete') { //删除
                    layer.confirm('确定删除吗？', function (index) {
                        obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                        layer.close(index);
                        //向服务端发送删除指令
                    });
                } else if (layEvent === 'edit') { //编辑
                    //do something
                    //同步更新缓存对应的值
                    obj.update({
                        name: '123'
                        , number: 'xxx'
                    });
                    //从js向服务器发送post请求
                    var tmp = document.createElement("form");
                    var action = "<%=request.getContextPath()%>/AdminServlet?method=queryTeam";
                    tmp.action = action;
                    tmp.method = "post";
                    tmp.style.display = "none";
                    document.body.appendChild(tmp);
                    tmp.submit();
                }
            });


        });

    };
</script>
</body>
</html>