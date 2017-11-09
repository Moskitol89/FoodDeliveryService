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
    <title>All goods</title>
    <style>
        <%@include file="../resources/css/style.css"%>
        <%@include file="../resources/css/allGoods.css"%>
    </style>
</head>
<body>
<div class="header">
    <h1>
        Welcome to the food delivery service! <br> Created by Moskitol.</h1>
</div>

<div class="menu-left">
    <a href="${pageContext.request.contextPath}/shop/order">Go to shopping cart</a>
</div>
<div class="msg">
    <h3 style="text-align: center">${msg}</h3>
</div>
<div class="allGoods">
    <ul>
        <c:forEach var="food" items="${foodList}">
            <li>
                <img src="/resources/images/${food.imageTitle}">
                <p class="desc">${food.description}</p>
                <p>${food.name} - price: ${food.cost} </p>
                <form method="post" action="${pageContext.request.contextPath}/shop/all">
                    <button class="submit-button" type="submit" value="${food.id}" name="foodId">add to cart</button>
                </form>
            </li>
        </c:forEach>
        <p>${totalPrice}</p>
    </ul>
</div>
</body>
</html>
