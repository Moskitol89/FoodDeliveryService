<%--
  Created by IntelliJ IDEA.
  User: moskitol
  Date: 16.10.2017
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirmed</title>
    <style>
        <%@include file="../resources/css/style.css"%>
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
<div class="msg">
    <h3 style="text-align: center">${msg}</h3>
</div>
</body>
</html>
