<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021-7-5
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <%--JSP表达式
  作用：用来将程序的输出，输出到客户端
  --%>
  <%= new Date()%>

  <hr>
  <%--jsp脚本片段--%>
  <%
    int sum = 0;
    for (int i = 0; i < 100; i++) {
      sum+=i;
    }
    out.println("<h1> sum="+sum+"</h1>");
  %>

  <%
    int x = 10;
    out.println(x);
  %>
  <p>这是一个jsp文档</p>
  <%
    int y = 20;
    out.println(y);
  %>

  <hr>
  <%--在代码中嵌入html元素--%>

  <%
    for (int i = 0; i < 5; i++) {

  %>
  <h1>Hello World <%=i%></h1>
  <%
    }
  %>

  <hr>
  <%--JSP声明：会被编译到JSP生成java的类中！其他的，就会被生成到_jspService方法中--%>
  <%--在jsp中嵌入java--%>
  <%!
    static{
      System.out.println("loading servlet!");
    }
    private int globalVar=0;

    public void hito(){
      System.out.println("进入了方法hito");
    }
  %>



  </body>
</html>
