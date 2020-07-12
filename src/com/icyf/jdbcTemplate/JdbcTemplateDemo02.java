package com.icyf.jdbcTemplate;


import com.icyf.druidLearn.util.DruidJdbcUtil;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Author: ESy
 * @Date: 2020/6/9 16:19
 * JdbcTemplate DML练习
 */
public class JdbcTemplateDemo02 {
    JdbcTemplate template = new JdbcTemplate(DruidJdbcUtil.getDataSource());

    @Test
    public void insertTest(){
        String sql = "insert into scores values(?,?,?)";
        int update = template.update(sql, "999", "9-999", 99);
        System.out.println(update);
    }

    @Test
    public void updateTest(){
        String sql ="update scores set degree = 999 where sno = ?";
        int update = template.update(sql, "999");
        System.out.println(update);
    }

    @Test
    public void deleteTest(){
        String sql = "delete from scores where sno = ?";
        int update = template.update(sql, "999");
        System.out.println(update);
    }


}
