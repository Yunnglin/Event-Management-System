<%--
  Created by IntelliJ IDEA.
  User: hjx
  Date: 2019/5/15
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="">
    <link rel="stylesheet" href="plugins/layui/css/layui.css">
    <script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
    <style>
        .nav {
            overflow: hidden;
            text-align: center;
            background-color: #f4f4f4;
        }
        .nav li {
            float: left;
            padding: 5px;
            width: 100px;
            color: #666;
            list-style: none;
            border-left: 1px solid #f4f4f4;
            cursor: pointer;
        }
        .nav li:hover,.selected {
            background-color:#ecebeb;
            border-left: 1px solid #ecebeb;
        }
        .content{
            border: 1px solid #f4f4f4;
            height: 880px;
            padding: 10px;
            overflow: hidden;
        }
    </style>
    <title>成绩查询</title>
</head>
<body>
    <ul class="layui-nav layui-bg-cyan" style="z-index: 5">
        <li class="layui-nav-item"><a href="mainPage.jsp">录入信息</a></li>
        <li class="layui-nav-item"><a  href="showServlet">赛程安排</a></li>
        <li class="layui-nav-item layui-this"><a href="ScoreServlet">成绩查询</a></li>
        <li class="layui-nav-item layui-layout-right"><a href="index.jsp">退出</a></li>
    </ul>
<ul class="nav">
    <a>男子单项成绩查询&nbsp;&nbsp;</a>
    <select name="" class="select" onChange="javascript:test('mune_x'+this.value)" >
        <option>请选择</option>
        <option value="1">单杠</option>
        <option value="2">双杠</option>
        <option value="3">吊环</option>
        <option value="4">跳马</option>
        <option value="5">自由体操</option>
        <option value="6">鞍马</option>
        <option value="7">蹦床</option>
    </select>
    <a>&nbsp;&nbsp;</a>
    <a>女子单项成绩查询</a>
    <a>&nbsp;&nbsp;</a>
    <select name="" class="select" onChange="javascript:test('mune_x'+this.value)" >
        <option>请选择</option>
        <option value="8">跳马</option>
        <option value="9">高低杠</option>
        <option value="10">平衡木</option>
        <option value="11">自由体操</option>
        <option value="12">蹦床</option>
    </select>
    <a>&nbsp;&nbsp;</a>
    <a>排名查询&nbsp;&nbsp;</a>
    <select name="" class="select" onChange="javascript:test('mune_x'+this.value)" >
        <option>请选择</option>
        <option value="13">本队参赛成绩</option>
        <option value="14">个人全能排名</option>
        <option value="15">队伍总排名</option>
    </select>

</ul>
<div class="page-container">
    <!--男子单杠-->
    <div id="x1" style="display:none;">
        <table border="3" align="center" width=75%>
            <thead>
            <tr>
                <th>编号</th>
                <th>名字</th>
                <th>队伍名</th>
                <th>年龄分组</th>
                <th>比赛级别</th>
                <th>最终得分</th>
                <th>Bonus</th>
                <th>Penalty</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${Com1Persons}" var="Com1Person">
                <tr>

                    <td align="center">${Com1Person.getPersonId()}</td>
                    <td align="center">${Com1Person.getName()}</td>
                    <td align="center">${Com1Person.getTeamName()}</td>
                    <td align="center">${Com1Person.getGroupAge()}</td>
                    <td align="center">${Com1Person.getLevel()}</td>
                    <td align="center">${Com1Person.getScore()}</td>
                    <td align="center">${Com1Person.getBonus()}</td>
                    <td align="center">${Com1Person.getPenalty()}</td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <!--男子双杠-->
    <div  id="x2" style="display: none;">
        <table border="3" align="center" width=75%>
            <thead>
            <tr>
                <th>编号</th>
                <th>名字</th>
                <th>队伍名</th>
                <th>年龄分组</th>
                <th>比赛级别</th>
                <th>最终得分</th>
                <th>Bonus</th>
                <th>Penalty</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${Com2Persons}" var="Com1Person">
                <tr>

                    <td align="center">${Com1Person.getPersonId()}</td>
                    <td align="center">${Com1Person.getName()}</td>
                    <td align="center">${Com1Person.getTeamName()}</td>
                    <td align="center">${Com1Person.getGroupAge()}</td>
                    <td align="center">${Com1Person.getLevel()}</td>
                    <td align="center">${Com1Person.getScore()}</td>
                    <td align="center">${Com1Person.getBonus()}</td>
                    <td align="center">${Com1Person.getPenalty()}</td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <!--男子吊环-->
    <div  id ="x3" style="display:none;">
        <table border="3" align="center" width=75%>
            <thead>
            <tr>
                <th>编号</th>
                <th>名字</th>
                <th>队伍名</th>
                <th>年龄分组</th>
                <th>比赛级别</th>
                <th>最终得分</th>
                <th>Bonus</th>
                <th>Penalty</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${Com3Persons}" var="Com1Person">
                <tr>

                    <td align="center">${Com1Person.getPersonId()}</td>
                    <td align="center">${Com1Person.getName()}</td>
                    <td align="center">${Com1Person.getTeamName()}</td>
                    <td align="center">${Com1Person.getGroupAge()}</td>
                    <td align="center">${Com1Person.getLevel()}</td>
                    <td align="center">${Com1Person.getScore()}</td>
                    <td align="center">${Com1Person.getBonus()}</td>
                    <td align="center">${Com1Person.getPenalty()}</td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <!--男子跳马-->
    <div  id ="x4" style="display:none;">
        <table border="3" align="center" width=75%>
            <thead>
            <tr>
                <th>编号</th>
                <th>名字</th>
                <th>队伍名</th>
                <th>年龄分组</th>
                <th>比赛级别</th>
                <th>最终得分</th>
                <th>Bonus</th>
                <th>Penalty</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${Com3Persons}" var="Com1Person">
                <tr>

                    <td align="center">${Com1Person.getPersonId()}</td>
                    <td align="center">${Com1Person.getName()}</td>
                    <td align="center">${Com1Person.getTeamName()}</td>
                    <td align="center">${Com1Person.getGroupAge()}</td>
                    <td align="center">${Com1Person.getLevel()}</td>
                    <td align="center">${Com1Person.getScore()}</td>
                    <td align="center">${Com1Person.getBonus()}</td>
                    <td align="center">${Com1Person.getPenalty()}</td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
        </table>
    </div>
    <!--男子自由体操-->
    <div  id ="x5" style="display:none;">
        <table border="3" align="center" width=75%>
            <thead>
            <tr>
                <th>编号</th>
                <th>名字</th>
                <th>队伍名</th>
                <th>年龄分组</th>
                <th>比赛级别</th>
                <th>最终得分</th>
                <th>Bonus</th>
                <th>Penalty</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${Com5Persons}" var="Com1Person">
                <tr>

                    <td align="center">${Com1Person.getPersonId()}</td>
                    <td align="center">${Com1Person.getName()}</td>
                    <td align="center">${Com1Person.getTeamName()}</td>
                    <td align="center">${Com1Person.getGroupAge()}</td>
                    <td align="center">${Com1Person.getLevel()}</td>
                    <td align="center">${Com1Person.getScore()}</td>
                    <td align="center">${Com1Person.getBonus()}</td>
                    <td align="center">${Com1Person.getPenalty()}</td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <!--男子鞍马-->
    <div  id ="x6" style="display:none;">
        <table border="3" align="center" width=75%>
            <thead>
            <tr>
                <th>编号</th>
                <th>名字</th>
                <th>队伍名</th>
                <th>年龄分组</th>
                <th>比赛级别</th>
                <th>最终得分</th>
                <th>Bonus</th>
                <th>Penalty</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${Com6Persons}" var="Com1Person">
                <tr>

                    <td align="center">${Com1Person.getPersonId()}</td>
                    <td align="center">${Com1Person.getName()}</td>
                    <td align="center">${Com1Person.getTeamName()}</td>
                    <td align="center">${Com1Person.getGroupAge()}</td>
                    <td align="center">${Com1Person.getLevel()}</td>
                    <td align="center">${Com1Person.getScore()}</td>
                    <td align="center">${Com1Person.getBonus()}</td>
                    <td align="center">${Com1Person.getPenalty()}</td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <!--男子蹦床-->
    <div  id ="x7" style="display:none;">
        <table border="3" align="center" width=75%>
            <thead>
            <tr>
                <th>编号</th>
                <th>名字</th>
                <th>队伍名</th>
                <th>年龄分组</th>
                <th>比赛级别</th>
                <th>最终得分</th>
                <th>Bonus</th>
                <th>Penalty</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${Com7Persons}" var="Com1Person">
                <tr>

                    <td align="center">${Com1Person.getPersonId()}</td>
                    <td align="center">${Com1Person.getName()}</td>
                    <td align="center">${Com1Person.getTeamName()}</td>
                    <td align="center">${Com1Person.getGroupAge()}</td>
                    <td align="center">${Com1Person.getLevel()}</td>
                    <td align="center">${Com1Person.getScore()}</td>
                    <td align="center">${Com1Person.getBonus()}</td>
                    <td align="center">${Com1Person.getPenalty()}</td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <!--女子跳马-->
    <div  id ="x8" style="display:none;">
        <table border="3" align="center" width=75%>
            <thead>
            <tr>
                <th>编号</th>
                <th>名字</th>
                <th>队伍名</th>
                <th>年龄分组</th>
                <th>比赛级别</th>
                <th>最终得分</th>
                <th>Bonus</th>
                <th>Penalty</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${Com8Persons}" var="Com1Person">
                <tr>

                    <td align="center">${Com1Person.getPersonId()}</td>
                    <td align="center">${Com1Person.getName()}</td>
                    <td align="center">${Com1Person.getTeamName()}</td>
                    <td align="center">${Com1Person.getGroupAge()}</td>
                    <td align="center">${Com1Person.getLevel()}</td>
                    <td align="center">${Com1Person.getScore()}</td>
                    <td align="center">${Com1Person.getBonus()}</td>
                    <td align="center">${Com1Person.getPenalty()}</td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <!--女子高低杠-->
    <div  id ="x9" style="display:none;">
        <table border="3" align="center" width=75%>
            <thead>
            <tr>
                <th>编号</th>
                <th>名字</th>
                <th>队伍名</th>
                <th>年龄分组</th>
                <th>比赛级别</th>
                <th>最终得分</th>
                <th>Bonus</th>
                <th>Penalty</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${Com9Persons}" var="Com1Person">
                <tr>

                    <td align="center">${Com1Person.getPersonId()}</td>
                    <td align="center">${Com1Person.getName()}</td>
                    <td align="center">${Com1Person.getTeamName()}</td>
                    <td align="center">${Com1Person.getGroupAge()}</td>
                    <td align="center">${Com1Person.getLevel()}</td>
                    <td align="center">${Com1Person.getScore()}</td>
                    <td align="center">${Com1Person.getBonus()}</td>
                    <td align="center">${Com1Person.getPenalty()}</td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <!--女子平衡木-->
    <div  id ="x10" style="display:none;">
        <table border="3" align="center" width=75%>
            <thead>
            <tr>
                <th>编号</th>
                <th>名字</th>
                <th>队伍名</th>
                <th>年龄分组</th>
                <th>比赛级别</th>
                <th>最终得分</th>
                <th>Bonus</th>
                <th>Penalty</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${Com10Persons}" var="Com1Person">
                <tr>

                    <td align="center">${Com1Person.getPersonId()}</td>
                    <td align="center">${Com1Person.getName()}</td>
                    <td align="center">${Com1Person.getTeamName()}</td>
                    <td align="center">${Com1Person.getGroupAge()}</td>
                    <td align="center">${Com1Person.getLevel()}</td>
                    <td align="center">${Com1Person.getScore()}</td>
                    <td align="center">${Com1Person.getBonus()}</td>
                    <td align="center">${Com1Person.getPenalty()}</td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <!--女子自由体操-->
    <div  id ="x11" style="display:none;">
        <table border="3" align="center" width=75%>
            <thead>
            <tr>
                <th>编号</th>
                <th>名字</th>
                <th>队伍名</th>
                <th>年龄分组</th>
                <th>比赛级别</th>
                <th>最终得分</th>
                <th>Bonus</th>
                <th>Penalty</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${Com11Persons}" var="Com1Person">
                <tr>

                    <td align="center">${Com1Person.getPersonId()}</td>
                    <td align="center">${Com1Person.getName()}</td>
                    <td align="center">${Com1Person.getTeamName()}</td>
                    <td align="center">${Com1Person.getGroupAge()}</td>
                    <td align="center">${Com1Person.getLevel()}</td>
                    <td align="center">${Com1Person.getScore()}</td>
                    <td align="center">${Com1Person.getBonus()}</td>
                    <td align="center">${Com1Person.getPenalty()}</td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <!--女子蹦床-->
    <div  id ="x12" style="display:none;">
        <table border="3" align="center" width=75%>
            <thead>
            <tr>
                <th>编号</th>
                <th>名字</th>
                <th>队伍名</th>
                <th>年龄分组</th>
                <th>比赛级别</th>
                <th>最终得分</th>
                <th>Bonus</th>
                <th>Penalty</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${Com12Persons}" var="Com1Person">
                <tr>

                    <td align="center">${Com1Person.getPersonId()}</td>
                    <td align="center">${Com1Person.getName()}</td>
                    <td align="center">${Com1Person.getTeamName()}</td>
                    <td align="center">${Com1Person.getGroupAge()}</td>
                    <td align="center">${Com1Person.getLevel()}</td>
                    <td align="center">${Com1Person.getScore()}</td>
                    <td align="center">${Com1Person.getBonus()}</td>
                    <td align="center">${Com1Person.getPenalty()}</td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <!--队伍成员-->
    <div  id ="x13" style="display:none;">
        <table border="3" align="center" width=75%>
            <thead>
            <tr>
                <th>运动员编号</th>
                <th>运动员名称</th>
                <th>队伍名称</th>
                <th>性别</th>
                <th>比赛名称</th>
                <th>比赛得分</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${TeamPersons}" var="Com1Person">
                <tr>
                    <td align="center">${Com1Person.getId()}</td>
                    <td align="center">${Com1Person.getName()}</td>
                    <td align="center">${Com1Person.getTeamName()}</td>
                    <td align="center">${Com1Person.getSex()}</td>
                    <td align="center">${Com1Person.getGameName()}</td>
                    <td align="center">${Com1Person.getScore()}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <!--个人排名-->
    <div  id ="x14" style="display:none;">
        <table border="3" align="center" width=75%>
            <thead>
            <tr>
                <th>排名</th>
                <th>编号</th>
                <th>名字</th>
                <th>队伍名</th>
                <th>比赛得分</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${PersonsSum}" var="Com1Person">
                <tr>
                    <td align="center">${Com1Person.getOrder()}</td>
                    <td align="center">${Com1Person.getPersonId()}</td>
                    <td align="center">${Com1Person.getName()}</td>
                    <td align="center">${Com1Person.getTeamName()}</td>
                    <td align="center">${Com1Person.getScore()}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <!--队伍排名-->
    <div  id ="x15" style="display:none;">
        <table border="3" align="center" width=75%>
            <thead>
            <tr>
                <th>排名</th>
                <th>队伍名称</th>
                <th>队号</th>
                <th>队伍得分</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${TeamScores}" var="TeamScore">
                <tr>
                    <td align="center">${TeamScore.getOrder()}</td>
                    <td align="center">${TeamScore.getTeamName()}</td>
                    <td align="center">${TeamScore.getTeamId()}</td>
                    <td align="center">${TeamScore.getTeamScore()}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>


</div>
    <!--根据选项切换内容-->
    <script language="javascript" type="text/javascript">
        function test(Names){
            var Name
            for (var i=1;i<16;i++){
                var tempname="mune_x"+i
                var NewsHot="x"+i
                if (Names==tempname){
                    Nnews=document.getElementById(NewsHot)
                    Nnews.style.display='';
                }else{
                    Nnews=document.getElementById(NewsHot)
                    Nnews.style.display='none';
                }
            }
        }
    </script>
</body>
</html>

