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
            height: 180px;
            padding: 10px;
            overflow: hidden;
        }
    </style>
    <title>比赛安排</title>
</head>
<body>
<ul class="nav">
    <!--首次选好的 -->
    <li class="selected">队伍排名</li>
    <li>男子双杠</li>
    <li>女子自由体操</li>
    <li>个人排名</li>

</ul>
<div class="content">
    <div class="list ">
        <table border="3">
            <thead>
            <tr>
                <th>队伍名称</th>
                <th>队号</th>
                <th>队伍得分</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${TeamScores}" var="TeamScore">
                <tr>
                    <td align="center">${TeamScore.getTeamName()}</td>
                    <td align="center">${TeamScore.getTeamId()}</td>
                    <td align="center">${TeamScore.getTeamScore()}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <!--男子双杠-->
    <div  class="list" style="display: none">
        <table border="3">
            <thead>
            <tr>
                <th>编号</th>
                <th>名字</th>
                <th>队伍名</th>
                <th>比赛得分</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${Com1Persons}" var="Com1Person">
                <tr>
                    <td align="center">${Com1Person.getPersonId()}</td>
                    <td align="center">${Com1Person.getName()}</td>
                    <td align="center">${Com1Person.getTeamName()}</td>
                    <td align="center">${Com1Person.getScore()}</td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <!--女子体操-->
    <div  class="list" style="display: none">
        <table border="3">
            <thead>
            <tr>
                <th>编号</th>
                <th>名字</th>
                <th>队伍名</th>
                <th>比赛得分</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${Com2Persons}" var="Com1Person">
                <tr>
                    <td align="center">${Com1Person.getPersonId()}</td>
                    <td align="center">${Com1Person.getName()}</td>
                    <td align="center">${Com1Person.getTeamName()}</td>
                    <td align="center">${Com1Person.getScore()}</td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <!--个人排名-->
    <div  class="list" style="display: none">
        <table border="3">
            <thead>
            <tr>
                <th>编号</th>
                <th>名字</th>
                <th>队伍名</th>
                <th>比赛得分</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${PersonsSum}" var="Com1Person">
                <tr>
                    <td align="center">${Com1Person.getPersonId()}</td>
                    <td align="center">${Com1Person.getName()}</td>
                    <td align="center">${Com1Person.getTeamName()}</td>
                    <td align="center">${Com1Person.getScore()}</td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script>
    $(function(){
        //获取点击事件的对象
        $(".nav li").click(function(){
            //获取要显示或隐藏的对象
            var divShow = $(".content").children('.list');
            //判断当前对象是否被选中，如果没选中的话进入if循环
            if (!$(this).hasClass('selected')) {
                //获取当前对象的索引
                var index = $(this).index();
                //当前对象添加选中样式并且其同胞移除选中样式；
                $(this).addClass('selected').siblings('li').removeClass('selected');
                //索引对应的div块显示
                $(divShow[index]).show();
                //索引对应的div块的同胞隐藏
                $(divShow[index]).siblings('.list').hide();
            }
        });
    });

</script>

</body>
</html>

