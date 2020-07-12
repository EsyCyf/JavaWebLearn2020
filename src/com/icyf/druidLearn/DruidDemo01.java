package com.icyf.druidLearn;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @Author: ESy
 * @Date: 2020/6/8 21:05
 */
public class DruidDemo01 {
    public static void main(String[] args) throws Exception {
        //加载配置文件
        Properties pro = new Properties();
        //InputStream getResourceAsStream(String name)
        //返回用于读取指定资源的输入流。
        InputStream is = DruidDemo01.class.getClassLoader().getResourceAsStream("druid.properties");
//        pro.load(new FileReader("src/druid.properties"));
        pro.load(is);

        //获取连接池对象
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        //获取链接
        Connection conn = ds.getConnection();

        System.out.println(conn);
        conn.close();
    }
}
