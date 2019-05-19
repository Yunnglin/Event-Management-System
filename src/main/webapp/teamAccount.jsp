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
            <form class="layui-form" action="<%=request.getContextPath()%>/AdminServlet?method=addTeam" method="post">
                <input style="display:none">
                <div class="layui-form-item">
                    <label class="layui-form-label">队伍编号</label>
                    <div class="layui-input-inline">
                        <input type="number" name="tno" required  lay-verify="required" placeholder="请输入队伍号" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">队伍名称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="name" required lay-verify="required" placeholder="请输队名" autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">队伍账号</label>
                    <div class="layui-input-inline">
                        <input type="text" name="account" required lay-verify="required" placeholder="请输入账号" autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">队伍密码</label>
                    <div class="layui-input-inline">
                        <input id="newPassword" type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">确认密码</label>
                    <div class="layui-input-inline">
                        <input id="confirmNewPassword" type="password" name="compassword" required lay-verify="required" placeholder="请确认密码" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button lay-submit class="layui-btn" lay-filter="addTeam">立即创建</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
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

    layui.use('form', function(){
        var form = layui.form;

        //监听提交
        form.on('submit(addTeam)', function(data){
            var word1= document.getElementById("newPassword").value;
            var word2 = document.getElementById("confirmNewPassword").value;
            if(word1 !== word2){
                layer.msg("两次输入的新密码不一致！");
                return false;
            }
        });
    });
</script>
</body>
</html>