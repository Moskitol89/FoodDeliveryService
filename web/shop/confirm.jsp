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
    <style>
        <%@include file="../resources/css/style.css"%>
        <%@include file="../resources/css/registration.css"%>
    </style>
</head>
<body>
<div class="header">
    <h1>
        Welcome to the food delivery service! <br> Created by Moskitol.</h1>
</div>

<div class="menu-left">
    <a href="${pageContext.request.contextPath}/index">Main page</a>
    <a href="${pageContext.request.contextPath}/shop/all">Go to the store</a>
</div>
<div class="container">
    <ul>
        <c:forEach var="foodFromCart" items="${foodSet}">
            <li>${foodFromCart.name} - price: ${foodFromCart.cost}</li>
        </c:forEach>
        <br>
        <li class="form-title">Total price : ${totalPrice}</li>
        <li class="form-title">Your name : ${user.firstName}</li>
        <li class="form-title">Your phone number : ${user.phoneNumber}</li>
        <li>
        <form method="post" action="${pageContext.request.contextPath}/shop/confirm">
            Your address for deliver :
            <br>
            <label>
                <textarea class="form-title form-field" rows="5" cols="45" name="addressTextArea">${user.address}</textarea>
            </label>
            <br>
            <input class="submit-button" style="left: 200px" type="submit" value="confirm">
        </form>
        </li>
    </ul>
</div>
</body>
</html>
