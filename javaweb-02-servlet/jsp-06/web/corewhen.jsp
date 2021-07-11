<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021-7-6
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--定义一个变量为score，值为85--%>
<form action="corewhen.jsp" method="post">
    <input type="text" name="score" value="${param.score}">
    <input type="submit" value="评分">
</form>

<c:choose>
    <c:when test="${param.score>=90}">
        <c:out value="你的成绩为优秀"/>
    </c:when>
    <c:when test="${param.score>=80}">
        <c:out value="你的成绩为良好"/>
    </c:when>
    <c:when test="${param.score>=60}">
        <c:out value="你的成绩为及格"/>
    </c:when>
    <c:when test="${param.score<60}">
        <c:out value="你的成绩不及格"/>
    </c:when>
</c:choose>
</body>
</html>
