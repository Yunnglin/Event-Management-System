<%--
  Created by IntelliJ IDEA.
  User: MQD
  Date: 2019/4/9
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<html>
<head>
    <title>mainPage</title>
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="js/mainPage.js" type="text/javascript"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="Css/mainPage.css" type="text/css">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

    <div id="navigation">
        <button id="information_entering">信息录入</button>
    </div>
    <div id="enteringPage">
        <select id="submit_choose" onchange="selectRole()">
            <option value="leader">领队</option>
            <option value="doctor">队医</option>
            <option value="athlete">运动员</option>
            <option value="coach">教练员</option>
            <option value="referee">裁判员</option>
        </select>
        <form class="information" id="leaderPage" action="main/java/com/controller/AddServlet">
            <span  class="s_name">姓名</span>
            <input type="text" class="input_name" placeholder="输入姓名" name="dName">
            <span  class="ID">身份证</span>
            <input type="text" class="input_ID" placeholder="输入身份证" name="dID" onkeyup="value=value.replace(/[\u4e00-\u9fa5]/ig,'')">
            <span  class="phone">电话</span>
            <input type="text" class="input_phone" placeholder="输入电话" name="dPhone"  onkeyup="value=value.replace(/[\u4e00-\u9fa5]/ig,'')">
            <button type="button" class="attachment">上传附件</button>
            <button type="submit" class="submit_button" id="L_submit" name="submitB" value="L">提交</button>
        </form>
        <form class="information" id="doctorPage" action="main/java/com/controller/AddServlet">
            <span  class="s_name">姓名</span>
            <input type="text" class="input_name" placeholder="输入姓名" name="dName">
            <span  class="ID">身份证</span>
            <input type="text" class="input_ID" placeholder="输入身份证" name="dID" onkeyup="value=value.replace(/[\u4e00-\u9fa5]/ig,'')">
            <span  class="phone">电话</span>
            <input type="text" class="input_phone" placeholder="输入电话" name="dPhone"  onkeyup="value=value.replace(/[\u4e00-\u9fa5]/ig,'')">
            <button type="button" class="attachment">上传附件</button>
            <button type="submit" class="submit_button" id="D_submit" name="submitB" value="D">提交</button>
        </form>
        <form class="information" id="refereePage" action="main/java/com/controller/AddServlet">
            <span  class="s_name">姓名</span>
            <input type="text" class="input_name" placeholder="输入姓名" name="dName">
            <span  class="ID">身份证</span>
            <input type="text" class="input_ID" placeholder="输入身份证" name="dID" onkeyup="value=value.replace(/[\u4e00-\u9fa5]/ig,'')">
            <span  class="phone">电话</span>
            <input type="text" class="input_phone" placeholder="输入电话" name="dPhone"  onkeyup="value=value.replace(/[\u4e00-\u9fa5]/ig,'')">
            <button type="button" class="attachment">上传附件</button>
            <button type="submit" class="submit_button" id="R_submit" name="submitB" value="R">提交</button>
        </form>
        <form class="information" id="athletePage" action="main/java/com/controller/AddServlet">
            <span  class="s_name">姓名</span>
            <input type="text" class="input_name" placeholder="输入姓名">
            <span  class="ID">身份证</span>
            <input type="text" class="input_ID" placeholder="输入身份证" onkeyup="value=value.replace(/[\u4e00-\u9fa5]/ig,'')">
            <span  class="age">年龄</span>
            <input type="number" class="input_age" placeholder="输入年龄" onkeyup="value=value.replace(/[\u4e00-\u9fa5]/ig,'')">
            <span  class="group">组别</span>
            <select id="select_group">
                <option value ="seven_eight">7-8</option>
                <option value ="night_ten">9-10</option>
                <option value="elven_twelve">11-12</option>
            </select>
            <span  class="sex">性别</span>
            <select class="select_sex" onclick="selectSex()" name="chooseSex">
                <option value ="男">男</option>
                <option value ="女">女</option>
            </select>
            <span  class="culGrade">文化成绩</span>
            <input type="number" class="input_culGrade" placeholder="文化成绩（可空）">
            <span  class="event">比赛项目</span>
            <div id="male_event">
                    单杠<input type="checkbox" value="horizontalBar">
                    双杠<input type="checkbox" value="parallelBars">
                    吊环<input type="checkbox" value="handRing">
                    跳马<input type="checkbox" value="vault">
                    自由体操<input type="checkbox" value="freeExercises">
                    鞍马<input type="checkbox" value="pommelHorse">
                    蹦床<input type="checkbox" value="trampoline">
            </div>
            <div id="female_event">
                    高低杠<input type="checkbox" value="unevenBar">
                    平衡木<input type="checkbox" value="balanceBeam">
                    跳马<input type="checkbox" value="vault">
                    自由体操<input type="checkbox" value="freeExercises">
                    蹦床<input type="checkbox" value="trampoline">
            </div>
            <button type="button" class="attachment">上传附件</button>
            <button type="submit" class="submit_button" id="athlete_submit" name="submitB" value="A">提交</button>
        </form>
        <form class="information" id="coachPage" action="main/java/com/controller/AddServlet">
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
            <button type="button" class="attachment">上传附件</button>
            <button type="submit" class="submit_button" id="coach_submit" name="submitB" value="C">提交</button>

        </form>
    </div>
</body>
</html>