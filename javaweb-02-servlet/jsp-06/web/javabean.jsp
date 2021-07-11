<%@ page import="com.hito.pojo.People" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021-7-6
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
//    People people = new People();
//    people.setAddress();
//    people.setAge();
//    people.setId();
//    people.setName();
%>
<jsp:useBean id="people" class="com.hito.pojo.People" scope="page"/>
<jsp:setProperty name="people" property="address" value="威海"/>
<jsp:setProperty name="people" property="id" value="1"/>
<jsp:setProperty name="people" property="age" value="3"/>
<jsp:setProperty name="people" property="name" value="hito"/>


姓名：<jsp:getProperty name="people" property="name" /><br>
年龄：<jsp:getProperty name="people" property="age" /><br>
ID：<jsp:getProperty name="people" property="id" /><br>
地址：<jsp:getProperty name="people" property="address" /><br>
</body>
</html>
