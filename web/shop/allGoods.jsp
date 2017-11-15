<%@ page import="org.webjars.WebJarAssetLocator" %>
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
    <script
           type="text/javascript" src="${pageContext.request.contextPath}/webjars/jquery/3.2.1/jquery.min.js">
    </script>
</head>
<body>
<div class="header">
    <h1>
        Welcome to the food delivery service! <br> Created by Moskitol.</h1>
</div>

<div class="menu-left">
    <a href="${pageContext.request.contextPath}/index">Main page</a>
    <a href="${pageContext.request.contextPath}/shop/order">Go to shopping cart</a>
</div>
<div class="msg">
    <h3 style="text-align: center">${msg}</h3>
</div>
    <ul>
        <c:forEach var="food" items="${foodList}">
            <li class="hide">
                <img src="/resources/images/${food.imageTitle}">
                <div class="desc">${food.description}</div>
                <p class="name">${food.name} - price: ${food.cost} </p>
                <form method="post" action="${pageContext.request.contextPath}/shop/all">
                    <button class="submit-button" type="submit" value="${food.id}" name="foodId">add to cart</button>
                </form>
            </li>
        </c:forEach>
    </ul>
<script>
    $(document).ready(function(){
        $("li:eq(0)").show("fast", function () {
            $(this).next().show("fast", arguments.callee);
        });
    });
</script>
</body>
</html>
