<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Page</title>
</head>
<body>
<h1>Login page</h1>

<form name="frm" action="<c:url value='login'/>" method="post">
    <table>
        <tr> <td>User:</td> <td><input type="text" name="username"></td></tr>

        <tr><td>Password:</td> <td><input type="password" name="password"></td></tr>

        <tr><td colspan="2"><input name="submit" type="submit"></td></tr>
        <tr><td colspan="2"><input name="reset" type="reset"></td></tr>
    </table>
</form>
<a href="registration">Registration</a>
</body>

</html>