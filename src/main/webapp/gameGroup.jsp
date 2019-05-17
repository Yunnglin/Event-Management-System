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
            <h1>队伍分组</h1>
            <hr/>
            <h2>当前所查看赛事编号：<span id="gameId"></span></h2>
            <hr/>

            <form id="groupForm" class="layui-form" action="<%=request.getContextPath()%>/AdminServlet?method=addGameGroup"
                  method="post">
                <div class="layui-form-item layui-col-md3">
                    <label class="layui-form-label">小组编号</label>
                    <div class="layui-input-block ">
                        <input type="number" name="groupId" lay-verify="" autocomplete="off"
                               required class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item layui-col-md3">
                    <label class="layui-form-label">队员编号</label>
                    <div class="layui-input-block ">
                        <select name="athleteNo" lay-verify="required">
                            <c:forEach items="${athletes}" var="athlete">
                                <option value="${athlete.getNo()}">${athlete.getNo()}${athlete.getName()}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <%--<div class="layui-form-item layui-col-md3">--%>
                    <%--<label class="layui-form-label">出场顺序</label>--%>
                    <%--<div class="layui-input-block ">--%>
                        <%--<input type="number" name="turn" lay-verify=""  autocomplete="off"--%>
                               <%--required class="layui-input">--%>
                    <%--</div>--%>
                <%--</div>--%>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="formDemo">添加小组队员</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
            <table id="teamTable" class="layui-table"
                   lay-data="{height:400, url:'<%=request.getContextPath()%>/AdminServlet?method=queryGameGroup',method:'post'}"
                   lay-filter="test">
                <thead>
                <tr>
                    <th lay-data="{field: 'GROUPID',  align:'center', width:200,sort:true}">小组编号</th>
                    <th lay-data="{field: 'ANO',  align:'center', width:200,sort:true}">队员编号</th>
                    <th lay-data="{field: 'NAME', align:'center',  width:200}">队员姓名</th>
                    <th lay-data="{field: 'TURN',  align:'center', width:200, sort: true}">出场顺序</th>
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
                    var action = '<%=request.getContextPath()%>/AdminServlet?method=delGameGroup';
                    tmp.action = action;
                    tmp.method = 'post';
                    tmp.style.display = 'none';
                    var input = document.createElement('input');
                    input.type = 'hidden';
                    input.name = 'ano';
                    //var json= JSON.stringify(data);
                    input.value = data.ANO;
                    tmp.appendChild(input);
                    document.body.appendChild(tmp);
                    tmp.submit();

                });
            }

        });
    });
    layui.use('form', function(){
        var form = layui.form;
        //监听提交
        form.on('submit(formDemo)', function(data){
            //layer.msg(JSON.stringify(data.field));
            return true;
        });
    });

</script>
</body>
</html>