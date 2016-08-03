package com.yuan.dao;

import com.yuan.domain.User;
import com.yuan.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/7/31 0031.
 */
public class UserDao {

    public Boolean userIsExist(String userName){
        Connection connection= DBUtil.getConnction();
        String sql="select * from user where userName=?";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,userName);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public void saveUser(User user){
        Connection connection= DBUtil.getConnction();
        String sql="insert into user(userName,password,name,sex,telephone,email,school,major,birthday,address,type,company)"+"values(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getUserName());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getName());
            preparedStatement.setString(4,user.getSex());
            preparedStatement.setString(5,user.getTelephone());
            preparedStatement.setString(6,user.getEmail());
            preparedStatement.setString(7,user.getSchool());
            preparedStatement.setString(8,user.getMajor());
            preparedStatement.setString(9, user.getBirthday());
            preparedStatement.setString(10,user.getAddress());
            preparedStatement.setInt(11,user.getType());
            preparedStatement.setString(12,user.getCompany());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnction(connection);
        }
    }
    public User login(String userName,String password){
        Connection connection= DBUtil.getConnction();
        String sql="select * from user where userName=? and password=?";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,password);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                User user=new User();
                user.setUserName(userName);
                user.setPassword(password);
                user.setBirthday(resultSet.getString("birthday"));
                user.setName(resultSet.getString("name"));
                user.setCompany(resultSet.getString("company"));
                user.setAddress(resultSet.getString("address"));
                user.setEmail(resultSet.getString("email"));
                user.setMajor(resultSet.getString("major"));
                user.setSchool(resultSet.getString("school"));
                user.setTelephone(resultSet.getString("telephone"));
                user.setType(resultSet.getInt("type"));
                return user;
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnction(connection);
        }
        return null;
    }
    public List<User> findAll(){
        Connection connection= DBUtil.getConnction();
        try {

            PreparedStatement preparedStatement = connection.prepareStatement("select * from user");
            List<User> users = new ArrayList<User>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user=new User();
                user.setUserName(resultSet.getString("userName"));
                user.setBirthday(resultSet.getString("birthday"));
                user.setName(resultSet.getString("name"));
                user.setCompany(resultSet.getString("company"));
                user.setAddress(resultSet.getString("address"));
                user.setEmail(resultSet.getString("email"));
                user.setMajor(resultSet.getString("major"));
                user.setSchool(resultSet.getString("school"));
                user.setTelephone(resultSet.getString("telephone"));
                user.setType(resultSet.getInt("type"));
                users.add(user);
                return users;
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnction(connection);
        }
        return null;
    }
}
