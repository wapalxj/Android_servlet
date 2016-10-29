<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/5/24
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>get方式登录</h3>
    <form action="/vero/LoginServlet" method="get">
        QQ:<input type="text" name="number">
        密码：<input type="text" name="pwd">
        <input type="submit" value="登录">
    </form>
    <hr>
    <h3>post方式登录</h3>
    <form action="/vero/LoginServlet" method="post">
        QQ:<input type="text" name="number">
        密码：<input type="text" name="pwd">
        <input type="submit" value="登录">
    </form>
</body>
</html>
