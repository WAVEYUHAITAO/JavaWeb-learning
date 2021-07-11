<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021-7-4
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>request rest</title>
</head>
<body>
    <h1>登陆</h1>

    <div id="form01">
        <!--这里action直接写路径名字就在相应的servlet路径下了（/r3/login）-->
        <!--jsp用这个获取路径 ${pageContext.request.contextPath}/login -->

        <!--提交到login这个servlet -->
        <form action="${pageContext.request.contextPath}/login" method="post">
            用户名：<input type="text" name="username"><br>
            密码：<input type="password" name="password"><br>
            爱好：
            <input type="checkbox" name="hobby" value="女孩">女孩
            <input type="checkbox" name="hobby" value="唱歌">唱歌
            <input type="checkbox" name="hobby" value="电影">电影
            <input type="checkbox" name="hobby" value="代码">代码
            <br>
            <input type="submit">
        </form>
    </div>
</body>
</html>
