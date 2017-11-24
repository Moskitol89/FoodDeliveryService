<%--
  Created by IntelliJ IDEA.
  User: moskitol
  Date: 18.10.2017
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>General Error</title>
    <style>
        <%@include file='/resources/css/style.css' %>
    </style>
</head>
<body>
<div class="header">
    <h1>
       General error.
    </h1>
</div>

<div class="menu-left">
    <a href="${pageContext.request.contextPath}/index">Main page</a>
</div>
<div class="msg">
    <h4 style="text-align: center">${msg}</h4>
</div>
<div class="text"></div>
</body>
</html>
