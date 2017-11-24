<%--
  Created by IntelliJ IDEA.
  User: Moskitol
  Date: 18.08.2017
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Access denied</title>
    <style>
        <%@include file='/resources/css/style.css' %>
    </style>
</head>
<body>
<div class="header">
    <h1>
        Access denied.
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
