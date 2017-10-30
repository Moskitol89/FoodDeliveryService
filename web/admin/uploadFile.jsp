<%--
  Created by IntelliJ IDEA.
  User: moskitol
  Date: 30.10.2017
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>uploadFile</title>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/admin/uploadFile.html" enctype="multipart/form-data">
        File to upload: <input type="file" name="file">
        <br>
        <input type="submit" value="Upload">
    </form>
</body>
</html>
