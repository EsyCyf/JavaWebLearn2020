package com.icyf.jdbcTemplate;

import com.icyf.druidLearn.util.DruidJdbcUtil;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Author: ESy
 * @Date: 2020/6/9 17:24
 * JdbcTemplate DQL练习
 */
public class JdbcTemplateDemo03 {
    JdbcTemplate template = new JdbcTemplate(DruidJdbcUtil.getDataSource());

    //.queryForMap(sql)
    @Test
    public void selectTest01(){
        String sql = "select * from students where sno = ?";
        //.queryForMap()只能取一行记录
        Map<String, Object> map = template.queryForMap(sql,"101");
        System.out.println(map);
        //{sno=101, sname=李军, ssex=男, sbirthday=1976-02-20 00:00:00.0, class=95033}
    }

    //.queryForList(sql)
    @Test
    public void selectTest02(){
        String sql="select * from students";
        List<Map<String, Object>> maps = template.queryForList(sql);
        for (Map<String, Object> map:maps){
            System.out.println(map);
        }
    }

    //.query(sql, new RowMapper<Student>() {}) 重写方法(太复杂
    @Test
    public void selectTest03(){
        String sql = "select * from students";
        List<Student> query = template.query(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                Student student = new Student();
                student.setId(resultSet.getString("sno"));
                student.setName(resultSet.getString("sname"));
                student.setSex(resultSet.getString("ssex"));
                student.setBirthday(resultSet.getDate("sbirthday"));
                student.setCla(resultSet.getString("class"));
                return student;
            }
        });

        for (Student s : query){
            System.out.println(s);
        }
    }

    //.query(sql,new BeanPropertyRowMapper<Student>(Student.class));
    //不重写，用已有的实现类new BeanPropertyRowMapper<Student>(Student.class)
    @Test
    public void selectTest03_2(){
        String sql = "select * from students";
        List<Student> query = template.query(sql,
                new BeanPropertyRowMapper<Student>(Student.class));

        for (Student s : query){
            System.out.println(s);
        }
    }

    //queryForObject(sql,Long.class);
    //一般用于聚合函数
    @Test
    public void selectTest04(){
        String sql = "select count(*) from students";
        Long aLong = template.queryForObject(sql,Long.class);
        System.out.println(aLong);
    }

}
