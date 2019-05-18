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
            <h1>赛事安排</h1>
            <hr/>
            <table id="teamTable" class="layui-table" lay-data="{height:400, url:'<%=request.getContextPath()%>/AdminServlet?method=queryGame',method:'post'}" lay-filter="test">
                <thead>
                <tr>
                    <th lay-data="{field: 'GAMEID', align:'center',  width:150, sort: true}">赛事编号</th>
                    <th lay-data="{field: 'EVENTNAME',  align:'center', width:200}">项目名</th>
                    <th lay-data="{field: 'GAMEAGE', align:'center',  width:150, sort: true}">年龄组</th>
                    <th lay-data="{field: 'REFEREENUM', align:'center',  width:200,edit:'text'}">主裁判编号</th>
                    <th lay-data="{field: 'GAMELEVEL',  align:'center', width: 200}">等级</th>
                    <th lay-data="{fixed: 'right', width:350, align:'center', toolbar: '#toolBar'}">操作</th>
                </tr>
                </thead>
            </table>
        </div>
    </div>



    <jsp:include page="footer.jsp"/>
</div>
<script type="text/html" id="toolBar">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="update">更新</button>
        <button class="layui-btn layui-btn-sm" lay-event="refereeGroup">查看裁判组</button>
        <button class="layui-btn layui-btn-sm" lay-event="addGroup">查看比赛小组</button>
        <button class="layui-btn layui-btn-sm" lay-event="start" id="start">开始比赛</button>
    </div>
</script>
<script src="plugins/layui/layui.js"></script>
<script src="js/jquery-3.3.1.min.js"></script>
<script>
    //JavaScript代码区域

    layui.use('element', function(){
        var element = layui.element;

    });
    layui.use(['table','jquery'], function(){
        var $=layui.jquery;
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
                //start the game
                console.log(data);

                //判断裁判人数
                //不足5个或者比赛未设置主裁判则不可开始
                var param={"gameId":data.GAMEID};
                var referCount=0;
                $.ajax({
                    type:"POST",
                    url:"<%=request.getContextPath()%>/AdminServlet?method=refereeCount",
                    async:true,
                    data:param,
                    dataType:"json",
                    success:function (res) {
                        console.log(res.referCount);
                        referCount=res.referCount;
                        if(referCount < 2){
                            alert("裁判数量不足五位！");
                        }else if(referCount === 3){
                            console.log(tr);
                            scoreSocket.send(JSON.stringify({
                                groupAge: data.GAMEAGE,
                                level: data.GAMELEVEL,
                                gameId: data.GAMEID,
                                rIdNum: data.REFEREENUM
                            }));
                        }
                    },
                    error:function (err) {
                        console.log(err);
                    }
                });

            }else if(layEvent === 'update'){
                var tmp = document.createElement('form');
                var action = '<%=request.getContextPath()%>/AdminServlet?method=addReferee';
                tmp.action = action;
                tmp.method = 'post';
                tmp.style.display = 'none';
                var input = document.createElement('input');
                input.type = 'hidden';
                input.name = 'gameJson';
                input.value = JSON.stringify(data);
                console.log(data);
                tmp.appendChild(input);
                document.body.appendChild(tmp);
                tmp.submit();
            }else if(layEvent === 'addGroup'){
                sessionStorage.setItem('gameId',data.GAMEID);
                var tmp = document.createElement('form');
                var action = '<%=request.getContextPath()%>/AdminServlet?method=gameGroup';
                tmp.action = action;
                tmp.method = 'post';
                tmp.style.display = 'none';
                var input = document.createElement('input');
                input.type = 'hidden';
                input.name = 'gameId';
                input.value = data.GAMEID;
                tmp.appendChild(input);
                document.body.appendChild(tmp);
                tmp.submit();
            }else if(layEvent === 'refereeGroup'){
                sessionStorage.setItem('gameId',data.GAMEID);
                var tmp = document.createElement('form');
                var action = '<%=request.getContextPath()%>/AdminServlet?method=refereeGroup';
                tmp.action = action;
                tmp.method = 'post';
                tmp.style.display = 'none';
                var input = document.createElement('input');
                input.type = 'hidden';
                input.name = 'gameId';
                input.value = data.GAMEID;
                tmp.appendChild(input);
                document.body.appendChild(tmp);
                tmp.submit();
            }
        });

    });

    //socket连接与监听事件绑定
    var wsUri ="ws://localhost:8080/cms/score_admin";
    var isConn = false;
    var scoreSocket = new WebSocket(wsUri);
    scoreSocket.onopen = function(evt) {
        isConn = true;
        console.log(evt);
        // scoreSocket.send(JSON.stringify({
        //     //发送开始消息
        // }))
    };
    scoreSocket.onclose = function (evt) {
        console.log(evt);
    };
    scoreSocket.onerror = function (evt) {
        console.error(evt);
    };
    scoreSocket.onmessage = function (evt) {
        var data = JSON.parse(evt.data);
        if(data.started!=undefined && data.started){
            alert("比赛已开始!");
        } else if(data.started!=undefined && !data.started){
            alert("裁判尚未就绪，等待中");
        } else if(data.ended!=undefined && data.ended){
            alert("比赛已结束");
            //maybe remove something about finished game then
        }
    };
</script>
</body>
</html>