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
<body>

<%  Object confirmpassword = session.getAttribute("confirmerror"); %>
<%-- Вход --%>


<div id="registration" class="registration">
    <form action="${pageContext.request.contextPath}/userRegister" method="post">
        <label for="newLogin"> Login: </label>
        <input type="text" name="newLogin" id="newLogin" value="${newLogin}" required>

        <label for="newPassword">Password: </label>
        <input type="text" name="newPassword" id="newPassword" value="${newPassword}" required>

        <label for="confirmPassword">Confirm password: </label>
        <input type="text" name="confirmPassword" id="confirmPassword" value="${confirmPassword}" required>
        <%if(confirmpassword!=null){%>
        <span id="confirmerror"> Пароль не совпадает </span>
        <%}%>

        <input type="submit" name="newRegister" value="Регистрация">
    </form>


</div >


</body>
</html>
