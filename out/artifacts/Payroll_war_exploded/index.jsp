<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 11/15/2019
  Time: 9:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Welcome Page</title>
    <style>
      .banner{
        position: absolute;
        top: 100px;
        left: 25%;
        font-size: 50px;
      }
      .right{
        position: absolute;
        padding-top: 20px;
        padding-left: 20px;
        padding-right: 20px;
        top: 75px;
        right: 44px;
        color: black;
      }
      .center {
        position: absolute;
        top: 400px;
        /*outline: 1px solid black;*/
        padding-top: 50px;
        padding-left: 50px;
        padding-right: 50px;
        left: 40%;
        color: black;
      }
    </style>
  </head>
  <body>
  <div class="banner">
    Welcome to Employee Management System <br/>
  </div>
  <div class="center">
    <a href = login.jsp><button><font size="+1">Click here to continue</font></button></a>
  </div>
  </body>
