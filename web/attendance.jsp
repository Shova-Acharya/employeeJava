<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 11/16/2019
  Time: 11:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Attendance of Employee</title>
</head>
<style>
    .right{
        position: absolute;
        padding-top: 20px;
        padding-left: 20px;
        padding-right: 20px;
        top: 75px;
        right: 44px;
        color: black;
    }
    .banner{
        position: absolute;
        top: 100px;
        left: 25%;
        font-size: 50px;
    }
</style>
<body>
<div class="banner">
    Employee Management System <br/>
</div>
<div class="right">
    <button><a href="home.jsp">Home Page</a></button>
    <button><a href = "logout.jsp">Logout</a></button>
</div>
    <form action="attendance" method="post">
        Employee ID: <input type="text" name="uid"><br/><br/>
        Total Working Days:<input type="number" name="work"> <br/><br/>
        Sick Leave:<input type="number" name="sick"> <br/><br/>
        Paid Leave:<input type="number" name="paid"> <br/><br/>
        Unpaid Leave:<input type="number" name="unpaid"> <br/><br/>
        <button>Submit</button>
    </form>
</body>
</html>
