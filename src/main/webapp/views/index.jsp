<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ page import="com.laba1.Entity.User" %>
<%@ page import="com.laba1.service.UserService" %>
<%@ page import="com.laba1.service.RatingService" %>
<%@ page import="com.laba1.Entity.Rating" %>
<%@ page import="java.sql.SQLException" %>

<jsp:useBean id="hello" class="com.laba1.Bean.Bean" scope="page" />

<%!
    void getFormattedDate() throws SQLException {

    }
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type= "text/css" rel="stylesheet" media="screen" href="css/main.css" />
    <title>Главная страница</title>
</head>
<body>
<header class="header">
    <div class="container">
        <div class="header_inner">
            <nav class="nav">
                <a class="nav_link" href="#views/index.jsp">Правила</a>
                <a class="nav_link" href="#">Игра</a>
                <a class="nav_link" href="views/autorization.jsp">Авторизация</a>
            </nav>

        </div>
    </div>
</header>
<h2 class="intro_suptitle">ПРАВИЛА ИГРЫ</h2>
<section class="section">
        <div class="section_header">
            <h3 class="section_title">Прочитайте правила</h3>
            <div>
                <p class="section_text">Компьютер загадывает 4-х значное число.
                    Цифры загаданного числа не повторяются.
                    Задача пользователя угадать загаданное число.
                    У пользователя неограниченное число попыток.
                    В каждую попытку пользователь дает компьютеру свой вариант числа.
                    Компьютер сообщает сколько цифр точно угадано (бык) и сколько цифр угадано без учета позиции (корова).
                    По ответу компьютера пользователь должен за несколько ходов угадать число.
                    Пример: 7328 -- загаданное число 0819 -- 0Б1К 4073 -- 0Б2К 5820 -- 0Б1К 3429 -- 1Б1К 5960 -- 0Б0К 7238 -- 2Б2К 7328 -- 4Б0К (число угадано)

                </p>
            </div>
        </div>
</section>
<%getFormattedDate();%>
</body>
</html>