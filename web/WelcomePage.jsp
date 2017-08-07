<%--
  Created by IntelliJ IDEA.
  User: Moskitol
  Date: 04.08.2017
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <h1>First test page</h1>
    <h2>${msg}</h2>
    <c:forEach var="food" items="${foodList}">
        <td>${food.id}</td>
        <td>${food.name}</td>
        <td>${food.cost}</td>
    </c:forEach>
</body>
</html>
