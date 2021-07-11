<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

<h1>当前有<span style="color: blue">${OnlineCount}</span>人在线</h1>
<h1>当前有<span style="color: blue"><%=request.getServletContext().getAttribute("OnlineCount")%></span>人在线</h1>


</script>
</body>
</html>
