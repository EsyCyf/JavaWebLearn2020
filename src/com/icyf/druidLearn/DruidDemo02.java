package com.icyf.druidLearn;

import com.icyf.druidLearn.util.DruidJdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: ESy
 * @Date: 2020/6/8 21:33
 * 测试一下工具类DruidJdbcUtil
 */
public class DruidDemo02 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DruidJdbcUtil.getConnection();
            String sql = "select * from students";
            ps = conn.prepareStatement(sql);
//            ps.setString(1,"students");
            rs = ps.executeQuery();
            while (rs.next()){
                String sno = rs.getString("sno");
                String sname = rs.getString("sname");
                String ssex = rs.getString("ssex");
                String sbirthday = rs.getString("sbirthday");
                String aClass = rs.getString("class");
                System.out.println(sno+"\t"+sname+"\t"+ssex+"\t"+sbirthday+"\t"+aClass);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DruidJdbcUtil.close(rs);
            DruidJdbcUtil.close(ps);
            DruidJdbcUtil.close(conn);
        }

    }
}
