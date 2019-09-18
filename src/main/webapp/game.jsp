<%--
  Created by IntelliJ IDEA.
  User: DonMin
  Date: 15.09.2019
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.laba1.Task.Task" %>
<%@ page import="java.util.ArrayList" %><%--
<%--
  Created by IntelliJ IDEA.
  User: DonMin
  Date: 30.07.2019
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" href="css/font.css" type="text/css">
    <title> Игра быки и коровы </title>

    <script src="http://code.jquery.com/jquery-2.2.4.js"
            type="text/javascript"></script>
    <script src="js/app.js" type="text/javascript"></script>

</head>
<body>
<li class="rating"><a href="rating.jsp">Рейтинг игроков</a></li>

<form action="${pageContext.request.contextPath}/logout" method="post">
      <input type="submit" name="signup" value="Выход">
</form>

<h1> Игра быки и коровы </h1>
<h2> Я загадал число, попробуй угадать его... </h2>


<table >
    <tr>
        <th style="width: 800px"> <textarea  readonly id="textarea"></textarea></th>
    </tr>
    <tr>
        <th><div class="text">Поле для ввода числа:</div>
            <input class="input" type="text" id="inputNumber" maxlength='4' minlength='4'
                   placeholder="Введите 4-х значное число" onkeyup="return check(this);"
                   onchange="return check(this); " required/></th>

    </tr>
    <th><span id="error"> </span></th>
    <tr>
        <th><button  class="button" type="submit"  id="toSend">Отправить</button></th>

    </tr>


</table>

</body>
</html>