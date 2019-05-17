<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <h1>裁判组</h1>
            <hr/>
            <h2>当前所查看赛事编号：<span id="gameId"></span></h2>
            <hr/>
            <form class="layui-form" action="<%=request.getContextPath()%>/AdminServlet?method=addRefereeService"
                  method="post">
                <div class="layui-form-item">
                    <label class="layui-form-label">裁判编号</label>
                    <div class="layui-input-block layui-col-md3">
                        <input type="text" name="input" lay-verify="" placeholder="请输入裁判编号..." autocomplete="off"
                               class="layui-input">
                    </div>
                    <div class="layui-input-block layui-col-md3">
                        <button type="submit" class="layui-btn">添加裁判</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
            <table id="teamTable" class="layui-table"
                   lay-data="{height:400, url:'<%=request.getContextPath()%>/AdminServlet?method=queryRefereeGroup',method:'post'}"
                   lay-filter="test">
                <thead>
                <tr>
                    <th lay-data="{field: 'team_No',  align:'center', width:200,sort:true}">所属队伍</th>
                    <th lay-data="{field: 'idNum', align:'center',  width:200, sort: true}">裁判身份编号</th>
                    <th lay-data="{field: 'name',  align:'center', width:200}">裁判姓名</th>
                    <th lay-data="{fixed: 'right', width:250, align:'center', toolbar: '#toolBar'}">操作</th>
                </tr>
                </thead>
            </table>
        </div>
    </div>

    <jsp:include page="footer.jsp"/>
</div>
<script type="text/html" id="toolBar">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="delete">删除</button>
    </div>
</script>
<script src="plugins/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    document.getElementById("gameId").innerText = sessionStorage.getItem('gameId');
    layui.use('element', function () {
        var element = layui.element;

    });
    layui.use('table', function () {
        var table = layui.table;


        table.on('tool(test)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象

            if (layEvent === 'delete') {
                layer.confirm('确定删除吗？', function (index) {
                    obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                    layer.close(index);
                    //向服务端发送删除指令
                    var tmp = document.createElement('form');
                    var action = '<%=request.getContextPath()%>/AdminServlet?method=delRefereeService';
                    tmp.action = action;
                    tmp.method = 'post';
                    tmp.style.display = 'none';
                    var input = document.createElement('input');
                    input.type = 'hidden';
                    input.name = 'rId';
                    //var json= JSON.stringify(data);
                    input.value = data.idNum;
                    tmp.appendChild(input);
                    document.body.appendChild(tmp);
                    tmp.submit();

                });
            }


        });
    });

</script>
</body>
</html>