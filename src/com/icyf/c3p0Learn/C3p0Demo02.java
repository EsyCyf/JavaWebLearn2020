package com.icyf.c3p0Learn;

import com.icyf.jdbcLearn.util.JdbcUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author: ESy
 * @Date: 2020/6/6 21:56
 */
public class C3p0Demo02 {
    public static void main(String[] args) throws SQLException {
        //1、获取DataSource
//        DataSource ds = new ComboPooledDataSource();
        DataSource ds = new ComboPooledDataSource("test");
        //2、获取连接
        Connection conn = null;
        for (int i = 0;i<=20;i++){
            conn = ds.getConnection();
            System.out.println(i+""+conn);
        }
        JdbcUtils.close(conn);
    }
}
