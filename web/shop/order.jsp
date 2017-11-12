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
    <style>
        <%@include file="../resources/css/style.css"%>
        <%@include file="../resources/css/button.css"%>
    </style>
</head>
<body>
<div class="header">
    <h1>
        Welcome to the food delivery service! <br> Created by Moskitol.</h1>
</div>

<div class="menu-left">
    <a href="${pageContext.request.contextPath}/index">Main page</a>
</div>
<div class="msg">
    <h4 style="text-align: center">${msg}</h4>
</div>
<div class="container" style="float: left;padding-top: 1%;padding-left: 5%;">
    <ul>
        <c:forEach items="${foodSet}" var="food">
            <li>${food.name} - ${food.cost}
                <form method="post" action="${pageContext.request.contextPath}/shop/order">
                    <button name="foodId" class="submit-button" value="${food.id}" type="submit">remove</button>
                </form>
            </li>
        </c:forEach>
        <p>Total price: ${totalPrice}</p>
            <li>
                <form method="get" action="${pageContext.request.contextPath}/shop/confirm">
                    <input type="submit" class="submit-button" value="confirm">
                </form>
            </li>
    </ul>
</div>
</body>
</html>
