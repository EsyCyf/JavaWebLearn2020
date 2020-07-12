package com.icyf.jdbcTemplate;

import java.util.Date;

/**
 * @Author: ESy
 * @Date: 2020/6/9 16:20
 */
public class Student {
    public Student() {
    }

    public Student(String id, String name, String sex, Date birthday, String cla) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.cla = cla;
    }

    private String id;
    private String name;
    private String sex;
    private Date birthday;
    private String cla;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCla() {
        return cla;
    }

    public void setCla(String cla) {
        this.cla = cla;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", cla='" + cla + '\'' +
                '}';
    }
}
