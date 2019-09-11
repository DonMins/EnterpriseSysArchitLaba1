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
    <title>JavaBean с JSP!</title>
</head>
<body>
<h2>${hello.message}</h2>
<%getFormattedDate();%>
</body>
</html>