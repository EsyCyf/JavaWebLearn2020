package com.icyf.jdbcLearn.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @Author: ESy
 * @Date: 2020/6/6 17:24
 */
public class JdbcUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    static {
        try {
            Properties prop = new Properties();
            prop.load(new FileReader("src/jdbc.properties"));
//            prop.load(new FileReader("D:\\workspaceIII\\JavaWebLearn2020\\src\\jdbc.properties"));
            url=prop.getProperty("url");
            user=prop.getProperty("user");
            password=prop.getProperty("password");
            driver=prop.getProperty("driver");

            Class.forName(driver);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //获取连接
    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(url, user, password);

        return conn;
    }

    //close释放资源
    public static void close(Connection conn){
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    public static void close(Statement st){
        if (st!=null){
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(ResultSet rs){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(PreparedStatement ps){
        if (ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
