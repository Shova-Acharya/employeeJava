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
    <title>Home Page</title>
</head>
<style>
    .add{
        position: absolute;
        top:150px;
        padding-top: 20px;
        padding-left: 20px;
        padding-right: 20px;
        color: black;
        left: 42.1%;
    }
    .banner{
        position: absolute;
        top: 50px;
        left: 25%;
        font-size: 50px;
    }
    .view{
        position: absolute;
        top: 200px;
        /*outline: 1px solid black;*/
        padding-top: 50px;
        padding-left: 50px;
        padding-right: 50px;
        left: 40%;
        color: black;
    }
    .cal {
        position: absolute;
        top: 400px;
        /*outline: 1px solid black;*/
        padding-top: 50px;
        padding-left: 50px;
        padding-right: 50px;
        left: 40%;
        color: black;
    }
    .del {
        position: absolute;
        top: 300px;
        /*outline: 1px solid black;*/
        padding-top: 50px;
        padding-left: 50px;
        padding-right: 50px;
        left: 40%;
        color: black;
    }
    .right{
        position: absolute;
        padding-top: 20px;
        padding-left: 20px;
        padding-right: 20px;
        top: 55px;
        right: 44px;
        color: black;
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
<div class="add">
<form action = "addEmployee.jsp" method = "post"><input type="submit" value ="Add Employee"></form>
</div>
<div class="del">
<form action = "delEmployee.jsp" method = "post"><input type="submit" value ="Delete Employee"></form>
</div>
<div class="view">
<form action = "viewEmployee.jsp" method = "post"><input type="submit" value ="View Employee Details"></form>
</div>
<%--<form action = "attendance.jsp" method = "post"><input type="submit" value ="Attendance"></form> --%>
<div class ="cal">
<form action = "calculation.jsp" method = "post"><input type="submit" value ="Salary Calculation"></form>
</div>



</body>
</html>
