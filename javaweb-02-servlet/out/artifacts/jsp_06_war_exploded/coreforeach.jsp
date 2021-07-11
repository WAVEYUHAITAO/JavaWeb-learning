<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021-7-6
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    ArrayList<String> people = new ArrayList<>();
    people.add(0,"张三");
    people.add(1,"李四");
    people.add(2,"王五");
    people.add(3,"赵六");
    people.add(4,"田七");
    request.setAttribute("list",people);
%>
<%--var每一次遍历出来的变量， items要遍历的对象--%>
<c:forEach var="people" items="${list}">
    <c:out value="${people}"></c:out>
    <br>
</c:forEach>
<%--begin起始 end终点 step步长--%>
<c:forEach var="people" begin="1" end="4" step="2" items="${list}">
    <c:out value="${people}"></c:out>
    <br>
</c:forEach>
</body>
</html>
