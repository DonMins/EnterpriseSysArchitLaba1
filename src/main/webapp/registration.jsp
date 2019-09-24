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
<%@ page import="com.laba1.Entity.Rating" %>
<%@ page import="java.sql.SQLException" %>




<html>
<head>
    <script src="js/app.js" type="text/javascript"></script>
    <script src="http://code.jquery.com/jquery-2.2.4.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/main.css" type="text/css">
</head>
<body>

<%  Object confirmpassword = session.getAttribute("confirmerror"); %>
<% Object errorNewlogin = session.getAttribute("exist");%>
<%-- Вход --%>


<div id="registration" class="registration">
    <h2 class="heading">Регистрация</h2>
    <hr class="line">
    <form action="${pageContext.request.contextPath}/userRegister" method="post">

        <div class="form-group">
            <label for="newLogin"> Логин: </label>
            <div class="input-group">
                <input class="form-control" type="text" name="newLogin" id="newLogin" value="${newLogin}" required
                   placeholder="Введите логин">
            </div>
        </div>

        <%if (errorNewlogin != null) {%>
        <span class="errortext"> Такой логин уже существует </span>
        <%}%>
        <div class="form-group">
            <label for="newPassword">Пароль: </label>
            <div class="input-group">
                <input class="form-control" type="password" name="newPassword" id="newPassword" value="${newPassword}" required
                       placeholder="Введите пароль">
            </div>
        </div>

        <div class="form-group">
            <label for="confirmPassword">Повторите пароль: </label>
            <div class="input-group">
                <input class="form-control" type="password" name="confirmPassword" id="confirmPassword" value="${confirmPassword}" required
                       placeholder="Введите пароль снова">
            </div>
        </div>

        <%if(confirmpassword!=null){%>
        <span  class="errortext"> Пароль не совпадает </span>
        <%}%>
        <div class="form-group">
            <div class="input-group">
                <input type="submit" name="newRegister" value="Регистрация" class="btn btn-success pull-right">
            </div>
        </div>

    </form>

</div >
<img src="images/logo.png" class="img_reg">


</body>
</html>
