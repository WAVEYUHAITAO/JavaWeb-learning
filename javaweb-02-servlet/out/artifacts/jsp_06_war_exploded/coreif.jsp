<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%--JSTL标签库使用，先导入jstl核心标签库--%>

<html>
<head>
    <title>Title</title>
</head>
<body>

<h4>if测试</h4>
<hr>
<form action="coreif.jsp" method="post">
    <%--
    EL表达式获取表单中的数据
    ${param.参数名}
    --%>
    <input type="text" name="username">
    <input type="submit" value="登陆">
    <c:out value="测试"/>
</form>

<c:if test="${param.username=='admin'}" var="isAdmin">
    <c:out value="管理员欢迎你"/>
</c:if>
<c:out value="${isAdmin}"></c:out>
</body>
</html>
