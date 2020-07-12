package com.icyf.jdbcLearn.student;

import com.icyf.jdbcLearn.util.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ESy
 * @Date: 2020/6/6 17:00
 *
 * 将ResultSet对象存入对象中
 */
public class StudentDemo {
    public static void main(String[] args) {
        List<Student> list = new StudentDemo().findAll();

        for (Student s:list){
            System.out.println(s);
        }

    }



    public List<Student> findAll(){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        List<Student> list = null;
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            conn = JdbcUtils.getConnection();
            //定义sql
            String sql = "select * from students";
            //获取执行sql的对象
            st = conn.createStatement();
            //执行sql
            rs = st.executeQuery(sql);
            //遍历结果集
            //创建一个Student对象
            Student student = null;
            list = new ArrayList<>();
            while(rs.next()){
                //获取数据
                //private String id;
                //private String name;
                //private String sex;
                //private String birthday;
                //private String cla;
                String id = rs.getString("sno");
                String name = rs.getString("sname");
                String sex = rs.getString("ssex");
                Date birthday = rs.getDate("sbirthday");
                String cla = rs.getString("class");

                student = new Student();
                student.setId(id);
                student.setName(name);
                student.setSex(sex);
                student.setBirthday(birthday);
                student.setCla(cla);

                //添加到集合
                list.add(student);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            /*if (rs!=null){
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

            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }*/
            JdbcUtils.close(rs);
            JdbcUtils.close(st);
            JdbcUtils.close(conn);


        }
        return list;
    }
}
