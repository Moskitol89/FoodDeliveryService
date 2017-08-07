<%--
  Created by IntelliJ IDEA.
  User: Moskitol
  Date: 04.08.2017
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>List of food</h1>
<p>Here you can see the list of the food.</p>
<table border="1px" cellpadding="0" cellspacing="0" >
    <thead>
    <tr>
        <th width="10%">id</th><th width="15%">name</th><th width="10%">cost</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="food" items="${foodList}">
        <tr>
            <td>${food.id}</td>
            <td>${food.name}</td>
            <td>${food.cost}</td>
        </tr>
    </c:forEach>
    </tbody>
    <h4>just for tests: ${food1Name}</h4>
</table>

