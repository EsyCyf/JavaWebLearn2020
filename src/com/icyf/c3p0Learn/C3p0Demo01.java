package com.icyf.c3p0Learn;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author: ESy
 * @Date: 2020/6/6 21:51
 */
public class C3p0Demo01 {
    public static void main(String[] args) throws SQLException {
        //1、创建数据库连接池对象
        DataSource ds = new ComboPooledDataSource();
        //2、获取连接对象
        Connection conn = ds.getConnection();
        //3、打印
        System.out.println(conn);
        //com.mchange.v2.c3p0.impl.NewProxyConnection@31b7dea0 [wrapping: com.mysql.jdbc.JDBC4Connection@45ae8a77]


    }
}
