<%--
  Created by IntelliJ IDEA.
  User: MQD
  Date: 2019/4/9
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" import="com.cms.controller.Login"%>
<html>
<head>
    <title>mainPage</title>
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="js/mainPage.js" type="text/javascript"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="Css/mainPage.css" type="text/css">
    <link rel="stylesheet" href="plugins/layui/css/layui.css">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <ul class="layui-nav layui-bg-cyan" style="z-index: 5">
        <li class="layui-nav-item  layui-this"><a href="mainPage.jsp">录入信息</a></li>
        <li class="layui-nav-item"><a  href="showServlet">赛程安排</a></li>
        <li class="layui-nav-item "><a href="ScoreServlet">成绩查询</a></li>
        <li class="layui-nav-item layui-layout-right"><a href="index.jsp">退出</a></li>
    </ul>

    <div id="enteringPage">
        <select id="submit_choose" onchange="selectRole()">
            <option value="leader">领队</option>
            <option value="doctor">队医</option>
            <option value="athlete">运动员</option>
            <option value="coach">教练员</option>
            <option value="referee">裁判员</option>
        </select>

        <form class="information" id="leaderPage" action="<%=request.getContextPath()%>/AddServlet">
            <span  class="s_name">姓名</span>
            <input type="text" class="input_name" placeholder="输入姓名" name="dName">
            <span  class="ID">身份证</span>
            <input type="text" class="input_ID" placeholder="输入身份证" name="dID" onkeyup="value=value.replace(/[\u4e00-\u9fa5]/ig,'')">
            <span  class="phone">电话</span>
            <input type="text" class="input_phone" placeholder="输入电话" name="dPhone"  onkeyup="value=value.replace(/[\u4e00-\u9fa5]/ig,'')">
            <button type="submit" class="submit_button layui-btn layui-btn-normal layui-btn-radius" id="L_submit" name="submitB" value="L">提交</button>
        </form>
        <form class="information" id="doctorPage" action="<%=request.getContextPath()%>/AddServlet">
            <span  class="s_name">姓名</span>
            <input type="text" class="input_name" placeholder="输入姓名" name="dName">
            <span  class="ID">身份证</span>
            <input type="text" class="input_ID" placeholder="输入身份证" name="dID" onkeyup="value=value.replace(/[\u4e00-\u9fa5]/ig,'')">
            <span  class="phone">电话</span>
            <input type="text" class="input_phone" placeholder="输入电话" name="dPhone"  onkeyup="value=value.replace(/[\u4e00-\u9fa5]/ig,'')">
            <button type="submit" class="submit_button layui-btn layui-btn-normal layui-btn-radius" id="D_submit" name="submitB" value="D">提交</button>
        </form>
        <form class="information" id="refereePage" action="<%=request.getContextPath()%>/AddServlet">
            <span  class="s_name">姓名</span>
            <input type="text" class="input_name" placeholder="输入姓名" name="dName">
            <span  class="ID">身份证</span>
            <input type="text" class="input_ID" placeholder="输入身份证" name="dID" onkeyup="value=value.replace(/[\u4e00-\u9fa5]/ig,'')">
            <span  class="phone">电话</span>
            <input type="text" class="input_phone" placeholder="输入电话" name="dPhone"  onkeyup="value=value.replace(/[\u4e00-\u9fa5]/ig,'')">
            <button type="submit" class="submit_button layui-btn layui-btn-normal layui-btn-radius" id="R_submit" name="submitB" value="R">提交</button>
        </form>
        <form class="information" id="athletePage" action="<%=request.getContextPath()%>/AddServlet">
            <span  class="s_name">姓名</span>
            <input type="text" class="input_name" placeholder="输入姓名" name="aName">
            <span  class="ID">身份证</span>
            <input type="text" class="input_ID" placeholder="输入身份证" onkeyup="value=value.replace(/[\u4e00-\u9fa5]/ig,'')" name="aID">
            <span  class="age" >年龄</span>
            <input id="a_age" type="number" class="input_age" placeholder="输入年龄" onkeyup="value=value.replace(/[\u4e00-\u9fa5]/ig,'')" name="aAge">
            <span  class="group">组别</span>
            <select id="select_group" name="ageGroup">
                <option value ="7-8">7-8</option>
                <option value ="9-10">9-10</option>
                <option value="11-12">11-12</option>
            </select>
            <span  class="sex">性别</span>
            <select class="select_sex" onclick="selectSex()" name="aSex">
                <option value ="男">男</option>
                <option value ="女">女</option>
            </select>
            <span  class="culGrade">文化成绩</span>
            <input type="number" class="input_culGrade" placeholder="文化成绩（可空）" name="aCGrade">
            <span  class="event">比赛项目</span>
            <div id="male_event">
                    单杠<input type="checkbox" value="单杠" name="event">
                    双杠<input type="checkbox" value="双杠" name="event">
                    吊环<input type="checkbox" value="吊环" name="event">
                    跳马<input type="checkbox" value="男子跳马" name="event">
                    自由体操<input type="checkbox" value="男子自由体操" name="event">
                    鞍马<input type="checkbox" value="鞍马" name="event">
                    蹦床<input type="checkbox" value="男子蹦床" name="event">
            </div>
            <div id="female_event">
                    高低杠<input type="checkbox" value="高低杠" name="event">
                    平衡木<input type="checkbox" value="平衡木" name="event">
                    跳马<input type="checkbox" value="女子跳马" name="event">
                    自由体操<input type="checkbox" value="女子自由体操" name="event">
                    蹦床<input type="checkbox" value="女子蹦床" name="event">
            </div>
            <button type="submit" class="submit_button layui-btn layui-btn-normal layui-btn-radius" id="athlete_submit" name="submitB" value="A">提交</button>
        </form>
        <form class="information" id="coachPage" action="<%=request.getContextPath()%>/AddServlet">
            <span  class="s_name">姓名</span>
            <input type="text" class="input_name" placeholder="输入姓名" name="cName">
            <span  class="ID">身份证</span>
            <input type="text" class="input_ID" placeholder="输入身份证" onkeyup="value=value.replace(/[\u4e00-\u9fa5]/ig,'')" name="cID">
            <span  class="phone">电话</span>
            <input type="text" class="input_phone" placeholder="输入电话" onkeyup="value=value.replace(/[\u4e00-\u9fa5]/ig,'')" name="cPhone">
            <span  class="sex">性别</span>
            <select class="select_sex" name="cSex">
                <option value ="男">男</option>
                <option value ="女">女</option>
            </select>
            <button type="submit" class="submit_button layui-btn layui-btn-normal layui-btn-radius" id="coach_submit" name="submitB" value="C">提交</button>
        </form>
        <form method="post" action="<%=request.getContextPath()%>/UploadServlet" enctype="multipart/form-data" class="attachment">
            选择附件:
            <input type="file" name="uploadFile" />
            <br/>
            <input type="submit" value="上传" />
        </form>

    </div>

</body>
</html>
