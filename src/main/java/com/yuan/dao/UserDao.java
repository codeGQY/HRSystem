package com.yuan.dao;

import com.yuan.domain.User;
import com.yuan.util.DBUtil;

import java.sql.*;

/**
 * Created by admin on 2016/7/31 0031.
 */
public class UserDao {
    Connection connection= DBUtil.getConnction();
    public Boolean userIsExist(String userName){
        String sql="select * from user where userName=?";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,userName);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnction(connection);
        }
        return false;
    }
    public void saveUser(User user){
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
            preparedStatement.setDate(9, (Date) user.getBirthday());
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
    public Boolean login(String userName,String password){
        String sql="select * from user where userName=? and password=?";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,password);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnction(connection);
        }
        return false;
    }
}
