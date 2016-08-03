<%@ page import="com.yuan.domain.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2016/8/2
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户首页</title>
</head>
<body>
    <%
        User user= (User) request.getAttribute("user");
        List<User> users= (List<User>) request.getAttribute("users");
    %>
    欢迎来到人事管理系统！<br>
    <%
        for(int i=0;i<users.size();i++){
            User u=users.get(i);
    %>
    用户名：<%=u.getUserName()%><br>
    姓名：<%=u.getName()%><br>
    性别：<%=u.getSex()%><br>
    手机号码：<%=u.getTelephone()%><br>
    电子邮箱：<%=u.getEmail()%><br>
    毕业学校：<%=u.getSchool()%><br>
    所学专业：<%=u.getMajor()%><br>
    出生日期：<%=u.getBirthday()%><br>
    地址：<%=u.getAddress()%><br>
    用户类型：<%=u.getType()%><br>
    所在公司：<%=u.getCompany()%><br>
    <%
        }
    %>
</body>
</html>
