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
    <link rel="stylesheet" href="css/main.css" type="text/css">
</head>
<body>
<%  Object errorlogin = session.getAttribute("errorlogin"); %>
<%  Object errorpassword = session.getAttribute("errorpassword"); %>
<%  Object userIn = session.getAttribute("userIn"); %>
<%  Object userLogin= session.getAttribute("userLogin"); %>
<%-- Вход --%>

<div class="autorization" id="autorization">
    <%if(userIn !=null){%>
    <form action="${pageContext.request.contextPath}/game.jsp" method="post">
        ${userLogin}| <a href="">Выйти</a>
        <input type="submit" name="game_ btn" value="Играть">
    </form>



    <% }else{ %>

    <form action="${pageContext.request.contextPath}/userLogin" method="post">
        <label for="login"> Login: </label>
        <input type="text" name="login" id="login" value="${login}" required>

        <%if(errorlogin!=null){%>
        <span id="errorlogin"> Не верный лоин </span>
        <%}%>
        <label for="password">Password: </label>
        <input type="text" name="password" id="password" value="${password}" required>
        <%if(errorpassword!=null){%>
        <span id="errorpassword"> Не верный пароль </span>
        <%}%>
        <input type="submit" name="signup" value="Войти">
    </form>

    <form class="register" action="${pageContext.request.contextPath}/registration.jsp" method="post">
        <input type="submit" name="registration" id="registration_btn" value="Регистрация">
    </form>
    <%}%>

</div>
<hr class="line">
<div class = "rules">
    <h2 class="heading">Правила</h2>
    <p>Компьютер загадывает 4-х значное число.
        Цифры загаданного числа не повторяются.
        Задача пользователя угадать загаданное число.
        У пользователя неограниченное число попыток.
        В каждую попытку пользователь дает компьютеру свой вариант числа.
        Компьютер сообщает сколько цифр точно угадано (бык) и сколько цифр угадано без учета позиции (корова).
        По ответу компьютера пользователь должен за несколько ходов угадать число.
        Пример: 7328 -- загаданное число 0819 -- 0Б1К 4073 -- 0Б2К 5820 -- 0Б1К 3429 -- 1Б1К 5960 -- 0Б0К 7238 -- 2Б2К 7328 -- 4Б0К (число угадано)
    </p>
</div>




</body>
</html>
