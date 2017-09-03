<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Moskitol
  Date: 09.08.2017
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <h1>List of food</h1>
    <p>Here you can see the list of the food.</p>
    <table border="1px" cellpadding="0" cellspacing="0" >
        <thead>
        <tr>
            <th width="10%">id</th><th width="15%">name</th><th width="10%">cost</th><th width="10%">actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="food" items="${foodList}">
            <tr>
                <td>${food.id}</td>
                <td>${food.name}</td>
                <td>${food.cost}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/edit/${food.id}.html">Edit</a>
                    <a href="${pageContext.request.contextPath}/admin/delete/${food.id}.html">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/index.html">Home page.</a>
</body>
</html>
