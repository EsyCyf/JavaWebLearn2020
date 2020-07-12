package com.icyf.druidLearn.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @Author: ESy
 * @Date: 2020/6/8 21:26
 * Druid连接池工具
 */
public class DruidJdbcUtil {
    private static DataSource ds;

    static {

        try {
            Properties pro = new Properties();
            pro.load(DruidJdbcUtil.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(pro);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




    //获取连接方法
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
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


    //获取连接池
    public static DataSource getDataSource(){
        return ds;
    }

}
