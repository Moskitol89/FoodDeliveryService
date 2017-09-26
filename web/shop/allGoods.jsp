<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: moskitol
  Date: 26.09.2017
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>all goods</title>
</head>
<body>
    <h2>All goods</h2>
    <ul>
        <c:forEach var="food" items="${foodList}">
            <li>${food.name} - price: ${food.cost} - <a href="/">add to cart</a> </li>
        </c:forEach>
    </ul>
</body>
</html>
