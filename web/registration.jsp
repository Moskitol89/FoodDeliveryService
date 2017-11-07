<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: moskitol
  Date: 13.09.2017
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <style>
        <%@include file='resources/css/style.css' %>
        <%@include file='resources/css/registration.css' %>
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
    <form:form method="POST" commandName="user" action="/registration/process.html">
        <table>
            <tbody>
                <tr>
                    <td class="form-title">Username:</td>
                    <td><form:input class="form-field" path="username"/></td>
                </tr>
                <tr>
                    <td class="form-title">Password:</td>
                    <td><input class="form-field" type="password" name="password1"></td>
                </tr>
                <tr>
                    <td class="form-title">Repeat password:</td>
                    <td><input class="form-field" type="password" name="password2"></td>
                </tr>
                <tr>
                    <td class="form-title">First name:</td>
                    <td><form:input class="form-field" path="firstName"/></td>
                </tr>
                <tr>
                    <td class="form-title">Last name:</td>
                    <td><form:input class="form-field" path="lastName"/></td>
                </tr>
                <tr>
                    <td class="form-title">Phone number:</td>
                    <td><form:input class="form-field" type="tel" path="phoneNumber"/></td>
                </tr>
                <tr>
                    <td class="form-title">Address:</td>
                    <td><form:input class="form-field" path="address"/></td>
                </tr>
                <tr>
                    <td><input type="submit" class="submit-button" value="registration"></td>
                </tr>
            </tbody>
        </table>
    </form:form>
</div>
</body>
</html>
