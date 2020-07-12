package com.icyf.jdbcLearn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @Author: ESy
 * @Date: 2020/6/6 14:55
 */
public class JdbcDemo01 {
    public static void main(String[] args) throws Exception {
        //1、导入驱动jar包（maven
        //2、注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //3、获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", "971234");
//        Connection conn = DriverManager.getConnection("jdbc:mysql:///mydb1", "root", "971234");
        //4、定义sql语句
        String sql = "update scores set degree = 100 where cno ='3-105' and sno = '101'";
        //5、获取执行sql的对象statement
        Statement st = conn.createStatement();
        //6、执行sql，返回受影响的行数
        int i = st.executeUpdate(sql);
        //7、查看结果
        System.out.println(i);
        //8、释放资源
        st.close();
        conn.close();
    }
}
