<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: moskitol
  Date: 28.11.2017
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get orders by username</title>
</head>
<body>
    <form method="post" action="/admin/getOrders.html">
        username:
        <input type="text" name="username">
        <input type="submit" value="search">
    </form>
</body>
</html>
