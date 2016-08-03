package com.yuan.servlet;

import com.yuan.dao.UserDao;
import com.yuan.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by admin on 2016/8/1.
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName=req.getParameter("userName");
        String password=req.getParameter("password");
        UserDao userDao=new UserDao();
        if(userDao.login(userName,password)!=null){
            User user=userDao.login(userName,password);
            List<User> users=userDao.findAll();
            req.setAttribute("user",user);
            req.setAttribute("users",users);
            req.getRequestDispatcher("pages/pindex.jsp").forward(req,resp);
        }
    }
}
