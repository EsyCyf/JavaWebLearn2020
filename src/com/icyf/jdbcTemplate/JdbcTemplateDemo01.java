package com.icyf.jdbcTemplate;

import com.icyf.druidLearn.util.DruidJdbcUtil;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Author: ESy
 * @Date: 2020/6/9 16:11
 * JdbcTemplate入门
 */
public class JdbcTemplateDemo01 {
    public static void main(String[] args) {
        //创建对象
        JdbcTemplate template = new JdbcTemplate(DruidJdbcUtil.getDataSource());
        //调用方法
        String sql = "update scores set degree = ? where sno = ?";
        int count = template.update(sql, 100, "101");
        System.out.println(count); //2
    }
}
