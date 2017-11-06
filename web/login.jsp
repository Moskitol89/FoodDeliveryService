<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style>
        <%@include file='resources/css/login.css' %>
        <%@include file='resources/css/style.css' %>
    </style>
    <title>Login Page</title>
</head>
<body>
<div class="header">
    <h1>Login page</h1>
</div>
<div class="menu-left">
    <a href="${pageContext.request.contextPath}/index">Main page</a>
    <a href="${pageContext.request.contextPath}/registration">Registration</a>
</div>
<div class="container">
    <form class="form-container" name="frm" action="<c:url value='login'/>" method="post">
        <form class="form-container">
            <div class="form-title"><h2>Sign up</h2></div>
            <div class="form-title">User</div>
            <input class="form-field" type="text" name="username" /><br />
            <div class="form-title">Password</div>
            <input class="form-field" type="password" name="password" /><br />
            <div class="submit-container">
                <input class="submit-button" type="submit" value="Submit" />
            </div>
    </form>
    </form>
</div>

</body>

</html>