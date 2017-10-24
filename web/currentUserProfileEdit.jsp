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
</head>
<body>
<form:form method="POST" commandName="user" action="${pageContext.request.contextPath}/editProfile.html">
    <h4>${msg}</h4>
    <table>
        <tbody>
        <tr>
            <td>Old password</td>
            <td><input type="password" name="oldPassword"/></td>
        </tr>
        <tr>
            <td>New password:</td>
            <td><input type="password" name="password1"></td>
        </tr>
        <tr>
            <td>Repeat new password:</td>
            <td><input type="password" name="password2"></td>
        </tr>
        <tr>
            <td>First name</td>
            <td><form:input path="firstName"/></td>
        </tr>
        <tr>
            <td>Last name</td>
            <td><form:input path="lastName"/></td>
        </tr>
        <tr>
            <td>Phone number</td>
            <td><form:input path="phoneNumber"/></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><form:input path="address"/></td>
        </tr>
        <td><input type="submit" value="Edit" /></td>
        </tbody>
    </table>
</form:form>

<p><a href="${pageContext.request.contextPath}/index">home</a></p>
</body>
</html>
