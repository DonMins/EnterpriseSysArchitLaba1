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
    <form action="${pageContext.request.contextPath}/registration.jsp" method="post">
        <input type="submit" name="registration" id="registration_btn" value="Регистрация" >
    </form>

</div>


</body>
</html>
