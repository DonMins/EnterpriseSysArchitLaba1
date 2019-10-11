<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 12.09.2019
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
    <link rel="stylesheet" href="css/main4.css" type="text/css">

    <script>
        $(document).ready(function () {
            $('#s-h-pass').click(function () {
                var type = $('#password').attr('type') == "text" ? "password" : 'text',
                    c = $(this).html() == "<span class=\"glyphicon glyphicon-eye-close\" title=\"Скрыть пароль\"></span>" ? "<span class=\"glyphicon glyphicon-eye-open\" title=\"Показать пароль\"></span>" : "<span class=\"glyphicon glyphicon-eye-close\" title=\"Скрыть пароль\"></span>";
                $(this).html(c);
                $('#password').prop('type', type);
            });
        });
    </script>

</head>
<body>
<% Object errorlogin = session.getAttribute("errorlogin"); %>
<% Object errorpassword = session.getAttribute("errorpassword"); %>
<% Object userIn = session.getAttribute("userIn"); %>
<% Object userLogin = session.getAttribute("userLogin"); %>
<%-- Вход --%>
<div class="upper">
    <div class="autorization" id="autorization">
        <%if (userIn != null) {%>
        <div class="inGame">

            ${userLogin}
            <div class="btn_left">
                <form action="${pageContext.request.contextPath}/logout" method="post">
                    <input type="submit" name="signup" value="Выход" class="btn btn-success pull-right">
                </form>
            </div>
                <div class="btn_right">
                    <form action="${pageContext.request.contextPath}/game.jsp" method="post">

                        <input type="submit" name="game_ btn" value="Играть" class="btn btn-success pull-right"  >
                    </form>
                </div>


        </div>




        <% } else { %>
        <div class="autori">

            <form class="leftR" action="${pageContext.request.contextPath}/userLogin" method="post">

                <div class="form-group">
                    <label for="login"> Логин: </label>

                        <input class="form-control" type="text" name="login" id="login" value="${login}" required
                               placeholder="Введите логин">
                    </div>



                <%if (errorlogin != null) {%>
                <span class="errortext"> Неверный логин </span>
                <%}%>
                <div class="form-group">
                    <label for="password">Пароль: </label>
                    <div class="input-group">
                        <input class="form-control" type="password" name="password" id="password" value="${password}" required
                               placeholder="Введите пароль">
                        <div class="input-group-addon" id="s-h-pass"><span class="glyphicon glyphicon-eye-open"
                                                                           title="Показать пароль"></span></div>
                    </div>
                </div>
                <%if (errorpassword != null) {%>
                <span class="errortext"> Неверный пароль </span>
                <%}%>
                <div class="btn_auto">
                    <div class="form-group">
                        <input type="submit" name="signup" value="Войти" class="btn btn-success pull-right">
                    </div>
                </div>


            </form>
            <form class="register" action="${pageContext.request.contextPath}/registration.jsp" method="post">
                <input type="submit" name="registration" id="registration_btn" class="btn btn-success pull-right"
                       value="Регистрация">
            </form>


        </div>

        <%}%>

    </div>
    <div class="image">
        <img src="images/logo.png"height="auto">
    </div>


</div>



<div class="rules">
    <hr class="line">
    <h2 class="heading">Правила</h2>
    <p>Компьютер загадывает 4-х значное число.
        Цифры загаданного числа не повторяются.
        Задача пользователя угадать загаданное число.
        У пользователя неограниченное число попыток.
        В каждую попытку пользователь дает компьютеру свой вариант числа.
        Компьютер сообщает сколько цифр точно угадано (бык) и сколько цифр угадано без учета позиции (корова).
        По ответу компьютера пользователь должен за несколько ходов угадать число.
        Пример: 7328 -- загаданное число 0819 -- 0Б1К 4073 -- 0Б2К 5820 -- 0Б1К 3429 -- 1Б1К 5960 -- 0Б0К 7238 -- 2Б2К
        7328 -- 4Б0К (число угадано)
    </p>
</div>


</body>
</html>
