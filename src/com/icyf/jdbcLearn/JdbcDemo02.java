package com.icyf.jdbcLearn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author: ESy
 * @Date: 2020/6/6 16:06
 */
public class JdbcDemo02 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //sql语句
            String sql = "update scores set degree=80 where sno='101' and cno='3-105'";
            //创建连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", "971234");
            //创建执行sql的对象
            st = conn.createStatement();
            //执行sql
            int i = st.executeUpdate(sql);
            if (i >0){
                System.out.println("执行成功");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (st!=null){
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
