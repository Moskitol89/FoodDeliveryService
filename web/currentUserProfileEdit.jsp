<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: moskitol
  Date: 22.10.2017
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>user edit</title>
    <style>
        <%@include file="resources/css/style.css"%>
        <%@include file="resources/css/registration.css"%>
    </style>
</head>
<body>
<div class="header">
    <h1>Login page</h1>
</div>
<div class="menu-left">
    <a href="${pageContext.request.contextPath}/index">Main page</a>
</div>
<div class="msg">
    <h4 style="text-align: center">${msg}</h4>
</div>
<div class="container">
<form:form method="POST" commandName="user" action="${pageContext.request.contextPath}/editProfile.html">
    <table>
        <tbody>
        <tr>
            <td class="form-title">Old password</td>
            <td><input class="form-field" type="password" name="oldPassword"/></td>
        </tr>
        <tr>
            <td class="form-title">New password:</td>
            <td><input class="form-field" type="password" name="password1"></td>
        </tr>
        <tr>
            <td class="form-title">Repeat new password:</td>
            <td><input class="form-field" type="password" name="password2"></td>
        </tr>
        <tr>
            <td class="form-title">First name</td>
            <td><form:input class="form-field" path="firstName"/></td>
        </tr>
        <tr>
            <td class="form-title">Last name</td>
            <td><form:input class="form-field" path="lastName"/></td>
        </tr>
        <tr>
            <td class="form-title">Phone number</td>
            <td><form:input class="form-field" path="phoneNumber"/></td>
        </tr>
        <tr>
            <td class="form-title">Address</td>
            <td><form:input class="form-field" path="address"/></td>
        </tr>
        <td><input class="submit-button" type="submit" value="Edit" /></td>
        </tbody>
    </table>
</form:form>
</div>
</body>
</html>
