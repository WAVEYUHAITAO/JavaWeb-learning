<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021-7-5
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@include会将两个页面合二为一--%>
<%--区别，这里的3段代码其实是连在一起，参数公用--%>
    <%@include file="common/header.jsp"%>
    <h1>项目主体</h1>
    <%@include file="common/footer.jsp"%>

    <hr>
<%--jsp标签--%>
<%--jsp:include 拼接页面 本质还是3个，一般用这个--%>
<%----%>
    <jsp:include page="common/header.jsp"/>
    <h1>项目主体</h1>
    <jsp:include page="common/footer.jsp"/>
</body>
</html>
