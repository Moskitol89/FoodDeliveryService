<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: moskitol
  Date: 10.09.2017
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home page</title>
    <style>
        <%@include file='resources/css/style.css' %>
    </style>
    <link href="resources/css/style.css" rel="stylesheet"/>
</head>
<body>
    <div class="header">
        <h1>Welcome to the food delivery service! <br> Created by Moskitol</h1>
    </div>

    <div class="menu-left">
    <security:authorize access="hasRole('ROLE_ANONYMOUS')">
    <a href="${pageContext.request.contextPath}/login">Login</a>
    </security:authorize>
    <security:authorize access="hasRole('ROLE_ADMIN')">
        <a href="${pageContext.request.contextPath}/admin/home">For admins</a>
    </security:authorize>
    <security:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">
        <a href="${pageContext.request.contextPath}/shop/all">Go to the store</a>
    </security:authorize>
    <security:authorize access="hasRole('ROLE_USER')">
        <a href="${pageContext.request.contextPath}/editProfile">Edit your profile</a>
    </security:authorize>
    <security:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">
        <a href="${pageContext.request.contextPath}/logout">Logout</a>
    </security:authorize>
    </div>
    <div class="msg">
        <h4>${msg} Text for css</h4>
    </div>
    <div class="text">SOKDOSPKDopsakdposakdpoadkospdkadpkoadkopsakdaopdakowkdaowdkaodkaowdaw<br>
        saaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaadsadasdasdd</div>
</body>
</html>
