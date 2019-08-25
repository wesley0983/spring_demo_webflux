package com.example.demo.model;

public class User {

    private String id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 描述
     */
    private Integer age;

    public User() {
    }

    public User(String id, String name, Integer desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

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

    public Integer getDesc() {
        return desc;
    }

    public void setDesc(Integer desc) {
        this.desc = desc;
    }
}
