package com.icyf.jdbcLearn;

import java.sql.*;

/**
 * @Author: ESy
 * @Date: 2020/6/6 16:44
 * ResultSet遍历
 */
public class JdbcDemo03 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //sql语句
            String sql = "select * from scores";
            //创建连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", "971234");
            //创建执行sql的对象
            st = conn.createStatement();
            //执行sql
            rs = st.executeQuery(sql);

//            //游标开始默认指向第一行的上一行，故需要游标向下移动一行
//            rs.next();
//            //获取数据
//            int sno = rs.getInt(1);
//            String cno = rs.getString(2);
//            int degree = rs.getInt(3);
//
//            System.out.println(sno+"\n"+cno+"\n"+degree);

            //boolean next() throws SQLException;
            //遍历ResultSet
            while (rs.next()){
                int sno = rs.getInt(1);
                String cno = rs.getString(2);
                int degree = rs.getInt(3);

                System.out.println(sno + " | " + cno + " | " + degree);

            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

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
