<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <a href="${pageContext.request.contextPath}/shop/order">Go to shopping cart</a>
    <h2>All goods</h2>
    <ul>
        <c:forEach var="food" items="${foodList}">
            <li>${food.name} - price: ${food.cost}
                <form method="post" action="${pageContext.request.contextPath}/shop/all">
                    <button type="submit" value="${food.id}" name="foodId">add to cart</button>
                </form>
            </li>
        </c:forEach>
        <p>${totalPrice}</p>
        <h3>${msg}</h3>
    </ul>
</body>
</html>
