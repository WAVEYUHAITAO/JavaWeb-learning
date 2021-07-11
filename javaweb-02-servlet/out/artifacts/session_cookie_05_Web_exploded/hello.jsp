<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021-7-5
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Java Server Pages</title>
    <%--Java Server Pages:Java 服务器端页面,也和Servlet一样，用来开发动态页面--%>
<%--
    最大特点：
            1.写JSP就像在写HTML
            2.区别：
                HTML只给用户提供静态的数据
                JSP页面中可以嵌入JAVA代码，为用户提供动态数据
    JSP原理
            tomcat中有一个work目录
            IDEA中使用Tomcat的会在IDEA的tomcat

    浏览器向服务器发送请求，不管访问什么资源，其实都是在访问Servlet
    jsp在tomcat服务器会生成java类
    jsp代码会在用户访问该页面时在服务器下生成响应的java文件
    JSP源码继承HttpJspBase 继承HttpServlet 本质上就是一个servlet

    _jspInit 初始化
    _jspDestroy 销毁
    _jspService(req,resp) 服务
    在jsp中java代码套在 <% %>之中
    取一个参数<%=xxx%>
    在jsp中只要是java代码就会原封不动输出，如果是html代码就会转换为out.write("xxx");

--%>
</head>
<body>

<%
    String name = "hito";
%>

name:<%=name%>
</body>
</html>
