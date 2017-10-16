<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: moskitol
  Date: 16.10.2017
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>confirm purchase</title>
</head>
<body>
    <ul>
        <c:forEach var="foodFromCart" items="${foodSet}">
            <li>${foodFromCart.name} - price: ${foodFromCart.cost}</li>
        </c:forEach>
        <li>Your name : ${user.firstName}</li>
        <li>Your phone number : ${user.phoneNumber}</li>
        <li>Your address for deliver : ${user.address}</li>
        <li>Total price : ${totalPrice}</li>
        <li>
            <form method="post" action="${pageContext.request.contextPath}/shop/confirm">
                <input type="submit" value="confirm">
            </form>
        </li>
    </ul>
</body>
</html>
