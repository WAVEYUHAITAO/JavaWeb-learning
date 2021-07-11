<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021-7-6
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>我是TAG2</h1>
<%--取出参数--%>
名字：<%=request.getParameter("name")%>
年龄: <%=request.getParameter("age")%>
</body>
</html>
