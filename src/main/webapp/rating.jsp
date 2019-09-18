<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.laba1.Bean.RatingServlet" %>
<%--
  Created by IntelliJ IDEA.
  User: DonMin
  Date: 15.09.2019
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="pageScope" class="com.laba1.Bean.RatingServlet" scope="page" />
<html>
<head>

    <%
        RatingServlet ratingServlet = new RatingServlet();
        Map<Double, String> map = ratingServlet.rating();
        pageContext.setAttribute("map", map);
    %>

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
        <c:forEach items="${pageScope.map}" var="item" varStatus="status">
            <tr>
                <th scope="row">${status.index+1}</th>
                <td>${item.value}</td>
                <td>${item.key}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
</body>
</html>