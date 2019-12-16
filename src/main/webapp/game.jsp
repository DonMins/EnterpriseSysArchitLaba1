<%@ page import="com.laba1.Task.Task" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<%if (session.getAttribute("userLogin") != null) {%>
<head>
    <link rel="stylesheet" href="css/font.css" type="text/css">
    <title> Игра быки и коровы </title>

    <script src="http://code.jquery.com/jquery-2.2.4.js" type="text/javascript"></script>
    <%--    <script src="js/app.js" type="text/javascript"></script>--%>

</head>
<body>
<script type="text/javascript">
    <%@include file="js/app.js"%>
</script>

<form action="${pageContext.request.contextPath}/rating" method="post">
    <input type="submit" name="signup" value="Рейтинг игроков" class="btn btn-success pull-right">
</form>

<form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" name="signup" value="Выход">
</form>

<h1> Игра быки и коровы </h1>
<h2> Я загадал число, попробуй угадать его... </h2>

<div class="gameArea">
    <div class="textArea">
        <textarea id="textarea" cols="100" rows="20" readonly></textarea>
    </div>
    <form id="myForm">
        <input class="input" type="text" id="inputNumber" pattern=".{4,4}"
               placeholder="Введите 4-х значное число" required onkeyup="return check(this);"
               onchange="return check(this); "/>
        <button class="button" type="submit" id="toSend">Отправить</button>
    </form>
</div>

</body>
<% } else {
    String redirectURL = "autorization.jsp";
    response.sendRedirect(redirectURL);
}%>
</html>