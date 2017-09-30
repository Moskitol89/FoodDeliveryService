<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: moskitol
  Date: 26.09.2017
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>all goods</title>
</head>
<body>
    <h3>${msg}</h3>
    <h2>All goods</h2>
    <ul>
        <c:forEach var="food" items="${foodList}">
            <li>${food.name} - price: ${food.cost} - ${food.id}
                <form:form method="POST" commandName="foodToBasket" action="${pageContext.request.contextPath}/shop/all.html">
                    <%--<form:button value="${food.id}"/>--%>
                </form:form>
        </c:forEach>
    </ul>
</body>
</html>
