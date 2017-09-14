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
</head>
<body>
    <form:form method="POST" commandName="user" action="/registration/process.html">
        <table>
            <tbody>
                <tr>
                    <td>Username:</td>
                    <td><form:input path="username"/></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><form:input path="password"/></td>
                </tr>
                <tr>
                    <td>First name:</td>
                    <td><form:input path="firstName"/></td>
                </tr>
                <tr>
                    <td>Last name:</td>
                    <td><form:input path="lastName"/></td>
                </tr>
                <tr>
                    <td>Phone number:</td>
                    <td><form:input path="phoneNumber"/></td>
                </tr>
                <tr>
                    <td>Address:</td>
                    <td><form:input path="address"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="registration"></td>
                </tr>
            </tbody>
        </table>
    </form:form>
</body>
</html>
