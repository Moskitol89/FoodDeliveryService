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
    <title>Edit food</title>
</head>
<body>
<h1>Edit food page</h1>
<p>Here you can edit the existing food.</p>
<form:form method="POST" commandName="food" enctype="multipart/form-data" action="${pageContext.request.contextPath}/admin/editFood/${food.id}.html">
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
            <td>Description:</td>
            <td><form:textarea path="description"/></td>
        </tr>
        <tr>
            <td>Select a image to upload :</td>
            <td><input type="file" name="file" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Edit" /></td>
            <td></td>
        </tr>
        </tbody>
    </table>
</form:form>

<p><a href="${pageContext.request.contextPath}/index">home</a></p>
</body>
</html>
