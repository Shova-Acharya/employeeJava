<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 11/15/2019
  Time: 9:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Employee Page</title>
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
    .down{
        position: absolute;
        top:200px;
        left: 40%
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
<div class="down">
<form action="delEmp" method="post">
    Employee ID: <input type="text" name="empid"><br/><br/>
    First Name: <input type="text" name="fname"><br/><br/>
    Last Name: <input type="text" name="lname"><br/><br/>
    <center><input type="submit" value="Delete"> </center>
</form>
</div>
</body>
</html>

