<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021-7-6
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    try {
        pageContext.forward("/index.jsp"); //这是前端的实现页面转发
    } catch (ServletException e) {
        e.printStackTrace();
    }
    //request.getRequestDispatcher("/index.jsp").forward(request,response);//这是后端实现
%>
</body>
</html>
