<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2016/7/31 0031
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆界面</title>
</head>
<body>
    <form action="/LoginServlet" method="post">
        用户名：<input type="text" name="userName"><br>
        密码：<input type="password" name="password"><br>
        <input type="submit" name="submit" value="登陆">
    </form>
</body>
</html>
