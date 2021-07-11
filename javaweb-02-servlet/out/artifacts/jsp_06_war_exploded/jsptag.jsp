<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021-7-6
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:forward page="/jsptag2.jsp">
    <jsp:param name="name" value="hito"/>
    <jsp:param name="age" value="20"/>
</jsp:forward>
</body>
</html>
