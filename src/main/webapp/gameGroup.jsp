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
            <h1>队伍分组</h1>
            <hr/>
            <h2>当前所查看赛事编号：<span id="gameId"></span></h2>
            <hr/>

            <table id="teamTable" class="layui-table"
                   lay-data="{height:400, url:'<%=request.getContextPath()%>/AdminServlet?method=queryGameGroup',method:'post'}"
                   lay-filter="test">
                <thead>
                <tr>
                    <th lay-data="{field: 'team_No',  align:'center', width:200,sort:true}">小组编号</th>
                    <th lay-data="{field: 'team_No',  align:'center', width:200,sort:true}">队员编号</th>
                    <th lay-data="{field: 'idNum', align:'center',  width:200, sort: true}">队员姓名</th>
                    <th lay-data="{field: 'name',  align:'center', width:200}">裁判姓名</th>
                    <th lay-data="{fixed: 'right', width:250, align:'center', toolbar: '#toolBar'}">操作</th>
                </tr>
                </thead>
            </table>
        </div>
    </div>

    <jsp:include page="footer.jsp"/>
</div>
<script src="plugins/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
</body>
</html>