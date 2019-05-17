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
            <h1>队伍信息</h1>
            <hr/>
            <form class="layui-form" action="<%=request.getContextPath()%>/AdminServlet?method=queryTeam" method="post">
               <div class="layui-form-item layui-row">
                   <label class="layui-form-label">查询方式</label>
                   <div class="layui-input-block layui-col-md3">
                       <select name="select" lay-verify="" lay-search>
                           <option value="all" selected>--全部--</option>
                           <option value="tNo">队号</option>
                           <option value="name">队名</option>
                       </select>
                   </div>
               </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">查询内容</label>
                    <div class="layui-input-block layui-col-md3">
                        <input type="text" name="input"  lay-verify="" placeholder="请输入..." autocomplete="off" class="layui-input">
                    </div>
                    <br>
                    <div class="layui-input-block layui-col-md3">
                        <button type="submit" class="layui-btn">查询</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>

            </form>
            <table lay-filter="test" id="teamTable">
                <thead>
                <tr>
                    <th lay-data="{field:'tNo', width:100, sort:true}">队号</th>
                    <th lay-data="{field:'name', width:250,edit:'text'}">队名</th>
                    <th lay-data="{field:'account', minWidth: 180}">账号</th>
                    <th lay-data="{field:'password', minWidth: 180,edit:'text'}">密码</th>
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
        <button class="layui-btn layui-btn-sm" lay-event="update">更新</button>
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
                height: 700 //设置高度
                , page: true
                , limit: 10 //注意：请务必确保 limit 参数（默认：10）是与你服务端限定的数据条数一致
            });

            //监听单元格编辑
            table.on('edit(test)', function(obj){
                var value = obj.value //得到修改后的值
                    ,data = obj.data //得到所在行所有键值
                    ,field = obj.field; //得到字段
                layer.msg('[队号: '+ data.tNo +'] ' + field + ' 更改为：'+ value);
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
                        var action = '<%=request.getContextPath()%>/AdminServlet?method=delTeam';
                        tmp.action = action;
                        tmp.method = 'post';
                        tmp.style.display = 'none';
                        var input = document.createElement('input');
                        input.type = 'hidden';
                        input.name = 'teamNo';
                        //var json= JSON.stringify(data);
                        input.value = data.tNo;
                        console.log(data.tNo);
                        console.log(input.value);
                        tmp.appendChild(input);
                        document.body.appendChild(tmp);
                        tmp.submit();
                    });
                } else if (layEvent === 'update') { //编辑
                    //从js向服务器发送post请求
                    var tmp = document.createElement('form');
                    var action = '<%=request.getContextPath()%>/AdminServlet?method=updateTeam';
                    tmp.action = action;
                    tmp.method = 'post';
                    tmp.style.display = 'none';
                    var input = document.createElement('input');
                    input.type = 'hidden';
                    input.name = 'teamJson';
                    input.value = JSON.stringify(data);
                    console.log(data);
                    tmp.appendChild(input);
                    document.body.appendChild(tmp);
                    tmp.submit();
                }
            });


        });

    };
</script>
</body>
</html>