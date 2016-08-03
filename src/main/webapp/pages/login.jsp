<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2016/7/31 0031
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>登陆界面</title>

</head>
<body>
    <script language="JavaScript">
        function check() {
            if(form1.userName.value =="")
            {
                alert("请输入用户名！");
                form1.userName.focus();
                return;
            }else
            if (form1.password.value =="")
            {
                alert("请输入密码！");
                form1.password.focus();
                return;
            }
            else
            {
                form1.submit();
            }
        }
    </script>
    <form action="<%=request.getContextPath()%>/LoginServlet" method="post" accept-charset="UTF-8" name="form1">
        用户名：<input type="text" name="userName"><br>
        密码：<input type="password" name="password"><br>
        <input type="button" name="button" value="登陆" onclick="check()">
        <a href="register.jsp">注册账号</a>
    </form>
</body>
</html>
