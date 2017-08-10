<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Moskitol
  Date: 10.08.2017
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit team</title>
</head>
<body>
<h1>Edit food page</h1>
<p>Here you can edit the existing food.</p>
<form:form method="POST" commandName="food" action="${pageContext.request.contextPath}/food/edit/${food.id}.html">
    <table>
        <tbody>
        <tr>
            <td>Name:</td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td>Cost:</td>
            <td><form:input path="cost" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Edit" /></td>
            <td></td>
        </tr>
        </tbody>
    </table>
</form:form>

<p><a href="${pageContext.request.contextPath}/index.html">home</a></p>
</body>
</html>
