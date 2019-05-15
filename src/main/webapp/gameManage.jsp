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
            <table lay-filter="test" id="teamTable">
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
    layui.use('table', function(){
        var table = layui.table;

        //第一个实例
        table.render({
            elem: '#teamTable'
            ,height: 400
            ,url: '<%=request.getContextPath()%>/AdminServlet' //数据接口
            ,method: 'get'
            ,size: 'lg'
            ,page:true
            ,cols: [[ //表头
                {field: 'GAMEID', title: '编号', width:150, sort: true}
                ,{field: 'EVENTNAME', title: '项目名', width:150}
                ,{field: 'GAMEAGE', title: '年龄组', width:150, sort: true}
                ,{field: 'REFEREENUM', title: '裁判编号', width:200,edit:'text'}
                ,{field: 'GAMELEVEL', title: '等级', width: 150}
            ]]
        });
        //监听单元格编辑
        table.on('edit(test)', function(obj){
            var value = obj.value //得到修改后的值
                ,data = obj.data //得到所在行所有键值
                ,field = obj.field; //得到字段
            layer.msg('['+ data.id +'] ' + field + ' 更改为：'+ value);
        });

    });
</script>
</body>
</html>