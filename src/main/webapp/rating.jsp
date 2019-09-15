<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.laba1.Bean.GameServlet" %>
<%@ page import="com.laba1.Bean.RatingServlet" %><%--
  Created by IntelliJ IDEA.
  User: DonMin
  Date: 15.09.2019
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Рейтинг</title>
</head>
<body>

<div class="container center-block">
    <h1>Рейтинг игроков</h1>
    <table class="table" border="1">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Игроки</th>
            <th scope="col">Рейтинг</th>
        </tr>
        </thead>
        <tbody>
        <%--        <jsp:useBean id="item" class="com.laba1.Bean.RatingServlet" scope="page">--%>
        <c:forEach items="${map}" var="">

        </c:forEach>
        <%--        </jsp:useBean>--%>
        </tbody>
    </table>
</div>
</body>
</html>