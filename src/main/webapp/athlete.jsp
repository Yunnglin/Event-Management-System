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

            <table lay-filter="test" id="teamTable">
                <thead>
                <tr>
                    <th lay-data="{field:'ID',align:'center', width:200, sort:true}">身份证号</th>
                    <th lay-data="{field:'no', align:'center',width:200, sort:true}">运动员编号</th>
                    <th lay-data="{field:'name', align:'center',width:100}">姓名</th>
                    <th lay-data="{field:'age',align:'center', minWidth: 100, sort:true}">年龄</th>
                    <th lay-data="{field:'sex', align:'center',minWidth: 100}">性别</th>
                    <th lay-data="{field:'team',align:'center', minWidth: 200,sort:true}">所属队伍</th>
                    <th lay-data="{fixed: 'right', width:250, align:'center', toolbar: '#toolBar'}">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${athletes}" var="a">
                    <tr>
                        <td align="center">${a.getId()}</td>
                        <td align="center">${a.getNo()}</td>
                        <td align="center">${a.getName()}</td>
                        <td align="center">${a.getAge()}</td>
                        <td align="center">${a.getSex()}</td>
                        <td align="center">${a.getTeam_No()}</td>
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
                height: 800 //设置高度
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
                        var tmp = document.createElement('form');
                        var action = '<%=request.getContextPath()%>/AdminServlet?method=delAthlete';
                        tmp.action = action;
                        tmp.method = 'post';
                        tmp.style.display = 'none';
                        var input = document.createElement('input');
                        input.type = 'hidden';
                        input.name = 'athleteID';
                        //var json= JSON.stringify(data);
                        input.value = data.ID;
                        console.log(data.ID);
                        console.log(input.value);
                        tmp.appendChild(input);
                        document.body.appendChild(tmp);
                        tmp.submit();
                    });
                }
            });

        });

    };
</script>

</body>
</html>