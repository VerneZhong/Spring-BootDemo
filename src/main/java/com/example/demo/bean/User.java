package com.example.demo.bean;

import com.example.demo.common.JsonUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private String name;
    /**
     *敏感字段不显示
     */
    @JsonIgnore
    private String password;
    private Integer age;
    /**
     * json 格式化字段
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date birthday;
    /**
     * 如果为null，则过滤掉该字段
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String desc;

    public User() {
    }

    public User(String name, String password, Integer age, Date birthday, String desc) {
        this.name = name;
        this.password = password;
        this.age = age;
        this.birthday = birthday;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return JsonUtil.getInstance().toJson(this);
    }
}
