<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: moskitol
  Date: 11.10.2017
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your order</title>
</head>
<body>
    <ul>
        <c:forEach items="${foodSet}" var="food">
            <li>${food.name}
                <form method="post" action="${pageContext.request.contextPath}/shop/order">
                    <button name="foodId" value="${food.id}" type="submit">remove</button>
                </form>
            </li>
        </c:forEach>
    </ul>
</body>
</html>
