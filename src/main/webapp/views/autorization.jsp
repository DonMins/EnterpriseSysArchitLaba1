<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 12.09.2019
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ page import="com.laba1.Entity.User" %>
<%@ page import="com.laba1.service.UserService" %>
<%@ page import="com.laba1.service.RatingService" %>
<%@ page import="com.laba1.Entity.Rating" %>
<%@ page import="java.sql.SQLException" %>





<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type= "text/css" rel="stylesheet" media="screen" href="css/main.css" />
    <title>Title</title>
</head>
<body>
<header class="header">
    <div class="container">
        <div class="header_inner">
            <nav class="nav">
                <a class="nav_link" href="views/index.jsp">Правила</a>
                <a class="nav_link" href="#">Игра</a>
                <a class="nav_link" href="views/autorization.jsp">Авторизация</a>
            </nav>

        </div>
    </div>
</header>

<form method="POST" action='<%= response.encodeURL("j_security_check") %>' >
    <table border="0" cellspacing="5">
        <tr>
            <th align="right">Username:</th>
            <td align="left"><input type="text" name="j_username"></td>
        </tr>
        <tr>
            <th align="right">Password:</th>
            <td align="left"><input type="password" name="j_password"></td>
        </tr>
        <tr>
            <td align="right"><input type="submit" value="Log In"></td>
            <td align="left"><input type="reset"></td>
        </tr>
    </table>
</form>

</body>
</html>
