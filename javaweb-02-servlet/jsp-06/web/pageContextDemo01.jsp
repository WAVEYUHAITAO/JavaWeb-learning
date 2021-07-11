<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021-7-5
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<%--内置对象
request:客户向服务端发送请求，产生的数据，用户用完就没用了，比如：新闻
session:用户用完了一会儿还有用，比如：购物车
application：一个用户用完了，其他用户还可能使用，比如：聊天数据
--%>
<%
  pageContext.setAttribute("name1","hito1");//保存的数据只在一个页面中有效
  request.setAttribute("name2","hito2");//保存的数据只在一次请求中有效，请求转发会携带这个数据
  session.setAttribute("name3","hito3");//保存的数据只在一次会话中有效，从打开浏览器到关闭浏览器
  application.setAttribute("name4","hito4");//保存的数据只在服务器中有效，从打开服务器到关闭服务器
%>

<%--脚本片段中的代码，会被原封不动的生成java代码，所以里面的注释要用//--%>
<%
  //从pageContext取出，我们通过寻找的方式来
  String name1 = (String) pageContext.findAttribute("name1");
  String name2 = (String) pageContext.findAttribute("name2");
  String name3 = (String) pageContext.findAttribute("name3");
  String name4 = (String) pageContext.findAttribute("name4");
  String name5 = (String) pageContext.findAttribute("name5");
//  try {
//    pageContext.forward("/pageContextDemo02.jsp");
//  } catch (ServletException e) {
//    e.printStackTrace();
//  }
%>

<%--使用EL表达式输出 ${}  如果没有值就不回输出任何东西
    如果使用jsp普通尖括号百分号，没值输出null--%>
<h1>取出的值为：</h1>
<h3>${name1}</h3>
<h3>${name2}</h3>
<h3>${name3}</h3>
<h3>${name4}</h3>
<h3>${name5}</h3>
<h3><%=name5%></h3>
</body>
</html>
