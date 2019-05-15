<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <table id="teamTable" class="layui-table" lay-data="{height:400, page:true, url:'<%=request.getContextPath()%>/AdminServlet'}" lay-filter="test">
                <thead>
                <tr>
                    <th lay-data="{field: 'GAMEID', align:'center',  width:150, sort: true}">编号</th>
                    <th lay-data="{field: 'EVENTNAME',  align:'center', width:200}">项目名</th>
                    <th lay-data="{field: 'GAMEAGE', align:'center',  width:150, sort: true}">年龄组</th>
                    <th lay-data="{field: 'REFEREENUM', align:'center',  width:200,edit:'text'}">裁判编号</th>
                    <th lay-data="{field: 'GAMELEVEL',  align:'center', width: 200}">等级</th>
                    <th lay-data="{fixed: 'right', width:150, align:'center', toolbar: '#toolBar'}">操作</th>
                </tr>
                </thead>
            </table>
        </div>
    </div>

    <jsp:include page="footer.jsp"/>
</div>
<script type="text/html" id="toolBar">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="start">开始比赛</button>
    </div>
</script>
<script src="plugins/layui/layui.js"></script>
<script src="js/jquery-3.3.1.min.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
    layui.use('table', function(){
        var table = layui.table;

        //监听单元格编辑
        table.on('edit(test)', function(obj){
            var value = obj.value //得到修改后的值
                ,data = obj.data //得到所在行所有键值
                ,field = obj.field; //得到字段
            layer.msg(field + ' 更改为：'+ value);
        });

        table.on('tool(test)', function(obj){
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象

            if(layEvent === 'start'){//点击开始比赛后的操作
                //do somehing
                console.log("start"+data.GAMEID);
            }
        });

    });
</script>
</body>
</html>