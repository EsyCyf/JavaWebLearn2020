package com.icyf.jdbcLearn.login;

import com.icyf.jdbcLearn.util.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @Author: ESy
 * @Date: 2020/6/6 19:28
 * 实现登录
 */
public class LoginDemo01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.nextLine();
        System.out.println("请输入密码");
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
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();
            String sql = "select * from user where username = '"+userid+"' and password = '"+password+"'";
            rs = st.executeQuery(sql);
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(rs);
            JdbcUtils.close(st);
            JdbcUtils.close(conn);
        }


        return false;
    }
}
