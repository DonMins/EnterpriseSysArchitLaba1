<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.laba1.Servlet.RatingServlet" %>
<%@ page import="javax.ejb.EJB" %>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="java.util.Map" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<%if (session.getAttribute("userLogin")!= null){%>
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
        <c:forEach items="${map}" var="item" varStatus="status">
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
<% } else {
    String redirectURL = "autorization.jsp";
    response.sendRedirect(redirectURL);
}%>
</html>