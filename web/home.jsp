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
</head>
<body>
    <h1>Welcome to food delivery service by Moskitol</h1>
    <a href="${pageContext.request.contextPath}/login">login</a>
    <br>
    <security:authorize access="hasRole('ROLE_ADMIN')">
        <a href="${pageContext.request.contextPath}/admin/home">for admins</a>
    </security:authorize>
    <br>
    <security:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">
        <a href="${pageContext.request.contextPath}/shop/all">go to the store</a>
    </security:authorize>

</body>
</html>
