<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021-7-4
  Time: 2:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Success</h1>
<%--这是jsp的用法,这里的${pageContext.request.contextPath}用来获取当前项目的Application context--%>
<%--这种写法在html中无效--%>
${pageContext.request.contextPath}/login
</body>
</html>
