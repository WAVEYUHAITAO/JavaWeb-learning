<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021-7-7
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //注销后session里存的USER_SESSION为空，页面重定向至登陆页
    //如果设置了filter这里就不需要了，filter里重定向后不能在这里继续调用重定向，会报错
//    Object user_session = request.getSession().getAttribute("USER_SESSION");
//    if(user_session==null){
//        response.sendRedirect("/f7/Login.jsp");
//    }
%>
<h1>主页</h1>
<P>
    <a href="${pageContext.request.contextPath}/servlet/logout">注销</a>
</P>

</body>
</html>
