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
<body>
<%  Object errorlogin = session.getAttribute("errorlogin"); %>
<%  Object errorpassword = session.getAttribute("errorpassword"); %>

<%-- Вход --%>
<div id="registration" class="registration" hidden>
    <form action="${pageContext.request.contextPath}/userRegister" method="post">
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
        <label for="confirdPassword">Password: </label>
        <input type="text" name="confirdPassword" id="confirdPassword" value="${confirdPassword}" required>
        <%if(errorpassword!=null){%>
        <span id="errorpassword"> Не верный пароль </span>
        <%}%>

        <input type="submit" name="signup" value="Войти">
    </form>
</div >
<div class="autorization" id="autorization">
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

    <script type="text/javascript">
        function toggle_visibility() {
            var e1 = document.getElementById("registration");
            var e2 = document.getElementById("autorization");
            e1.style.display = 'block';
            e2.style.display = 'none';

        }
    </script>
        <input type="submit" name="registration" id="registration_btn" value="Регистрация" onclick="toggle_visibility(); ">

</div>

</body>
</html>
