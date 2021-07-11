<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021-7-7
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/servlet/login" method="post">
    <input type="text" name="username">
    <input type="submit">
</form>
</body>
</html>
