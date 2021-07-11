<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021-7-6
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--脚本片段中的代码，会被原封不动的生成java代码，所以里面的注释要用//--%>
<%
    //从pageContext取出，我们通过寻找的方式来
    String name1 = (String) pageContext.findAttribute("name1");
    String name2 = (String) pageContext.findAttribute("name2");
    String name3 = (String) pageContext.findAttribute("name3");
    String name4 = (String) pageContext.findAttribute("name4");
    String name5 = (String) pageContext.findAttribute("name5");
%>

<%--使用EL表达式输出 ${}  如果没有值就不回输出任何东西
    如果使用jsp普通尖括号百分号，没值输出null--%>
<%--这是一个测试数据存储作用域的实验--%>
<%--name1，name2，name3,name4分别是pagecontext, request，session,application--%>
<%--前两个是在页面和单词请求中有效，后两个一个是在一个session中，一个是在服务器端保存，所以后两个取到了值，最后的null是因为非EL表达式输出空值--%>
<h1>取出的值为：</h1>
<h3>${name1}</h3>
<h3>${name2}</h3>
<h3>${name3}</h3>
<h3>${name4}</h3>
<h3>${name5}</h3>
<h3><%=name5%></h3>
</body>
</html>
