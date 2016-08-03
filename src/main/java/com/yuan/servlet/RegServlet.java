package com.yuan.servlet;

import com.yuan.dao.UserDao;
import com.yuan.domain.User;
import com.yuan.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Connection;

/**
 * Created by admin on 2016/8/1.
 */
public class RegServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName=req.getParameter("userName");
        String password=req.getParameter("password");
        String name=req.getParameter("name");
        String sex=req.getParameter("sex");
        String telephone=req.getParameter("telephone");
        String email=req.getParameter("email");
        String school=req.getParameter("school");
        String major=req.getParameter("major");
        String birthday=req.getParameter("birthday");
        String address=req.getParameter("address");
        int type= Integer.parseInt(req.getParameter("type"));
        String company=req.getParameter("company");
        UserDao userDao=new UserDao();
        PrintWriter out=resp.getWriter();

        if(userName!=null&&!userName.isEmpty()) {
            if (userDao.userIsExist(userName)) {

                out.println("该用户已经存在，请登录");
            }else{
                User user=new User();
                user.setUserName(userName);
                user.setPassword(password);
                user.setName(name);
                user.setSex(sex);
                user.setTelephone(telephone);
                user.setEmail(email);
                user.setSchool(school);
                user.setMajor(major);
                user.setBirthday(birthday);
                user.setAddress(address);
                user.setType(type);
                user.setCompany(company);
                userDao.saveUser(user);
                out.println("注册成功");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
