<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Moskitol
  Date: 05.09.2017
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h1>List of users</h1>
<p>Here you can see the list of users.</p>
<br><p>For searching please use ctrl+f</p>
<table border="1px" cellpadding="0" cellspacing="0" >
    <thead>
    <tr>
        <th width="10%">id</th><th width="15%">username</th><th width="10%">first name</th>
        <th width="10%">last name</th> <th width="10%">phone number</th>
        <th width="15%">address</th><th width="5%">enabled</th><th width="10%">actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.phoneNumber}</td>
            <td>${user.address}</td>
            <td>${user.enabled}</td>
            <td>
                <a href="${pageContext.request.contextPath}/admin/editUser/${user.id}.html">Edit</a>
                <a href="${pageContext.request.contextPath}/admin/deleteUser/${user.id}.html">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="${pageContext.request.contextPath}/index">Home page.</a>
</body>
</html>