<%--
  Created by IntelliJ IDEA.
  User: Moskitol
  Date: 03.08.2017
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Home page</title>
  </head>
  <body>
    <h1>Welcome to food delivery service by Moskitol</h1>
    <h3>${msg}</h3>
    <a href="${pageContext.request.contextPath}/admin/foodList.html">show list of food</a>
    <br>
    <a href="${pageContext.request.contextPath}/admin/add.html">add new food</a>
    <br>
    <a href="${pageContext.request.contextPath}/admin/userList.html">show list of users</a>
  </body>
</html>