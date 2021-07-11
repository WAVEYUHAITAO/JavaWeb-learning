<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021-7-5
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--定制错误页面--%>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--这里图片路径需要加上动态前缀${pageContext.request.contextPath}--%>
    <img src="${pageContext.request.contextPath}/img/500错误.gif" alt="内部错误500">
</body>
</html>
