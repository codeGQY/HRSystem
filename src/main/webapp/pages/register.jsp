<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2016/7/31 0031
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
    <form action="/RegServlet" method="post">
        用户名：<input type="text" name="userName"><br>
        密码：<input type="password" name="password"><br>
        姓名：<input type="text" name="name"><br>
        性别：<input type="radio" name="sex" value="男"> 男 <input type="radio" name="sex" value="女"> 女<br>
        手机号码：<input type="text" name="telephone"><br>
        电子邮箱：<input type="text" name="email"><br>
        毕业学校：<input type="text" name="school"><br>
        所学专业：<input type="text" name="major"><br>
        出生日期：<input type="date" name="birthday"><br>
        地址：<input type="text" name="address"><br>
        用户类型：<input type="text" name="type"><br>
        所在公司：<input type="text" name="company"><br>
        <input type="submit" name="submit" value="注册"><input type="reset" name="reset" value="重置"><br>
    </form>
</body>
</html>
