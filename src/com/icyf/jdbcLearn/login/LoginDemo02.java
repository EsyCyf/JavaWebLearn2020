package com.icyf.jdbcLearn.login;

import com.icyf.jdbcLearn.util.JdbcUtils;

import java.sql.*;
import java.util.Scanner;

/**
 * @Author: ESy
 * @Date: 2020/6/6 19:48
 * 使用preparestatement改进
 */
public class LoginDemo02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = sc.nextLine();
        System.out.println("请输入密码:");
        String password = sc.nextLine();

        boolean flag = new LoginDemo01().login(username, password);
        if (flag){
            System.out.println("登录成功");
        }else {
            System.out.println("用户名或密码错误");
        }

    }



    public boolean login(String userid,String password){
        if (userid == null || password == null){
            return false;
        }

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from user where username = ? and password = ?";
            //获取sql对象
            ps = conn.prepareStatement(sql);
            //给？赋值
            ps.setString(1,userid);
            ps.setString(2,password);
            rs = ps.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(rs);
            JdbcUtils.close(ps);
            JdbcUtils.close(conn);
        }


        return false;
    }
}
