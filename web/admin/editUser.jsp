<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>Edit food</title>
</head>
<body>
<h1>Edit food page</h1>
<p>Here you can edit the existing food.</p>
<form:form method="POST" commandName="user" action="${pageContext.request.contextPath}/admin/editUser/${user.id}.html">
    <table>
        <tbody>
        <tr>
            <td>Username</td>
            <td><form:input path="username"/></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><form:input path="password"/></td>
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
        <tr>
            <td>Role</td>
            <td><form:input path="role"/></td>
        </tr>
        <tr>
            <td>Enabled</td>
            <td><form:checkbox path="enabled"/></td>
        </tr>
            <td><input type="submit" value="Edit" /></td>
            <td></td>
        </tbody>
    </table>
</form:form>

<p><a href="${pageContext.request.contextPath}/index">home</a></p>
</body>
</html>
