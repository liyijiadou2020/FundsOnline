package com.atguigu.crowd.entity;

public class Auth {

    /**
     * 权限id
     */
    private Integer id;

    /**
     * 权限名。用于比对
     */
    private String name;

    /**
     * 权限的身份。用户阅读
     */
    private String title;

    /**
     * 权限类型
     */
    private Integer categoryId;

    public Auth() {

    }

    public Auth(Integer id, String name, String title, Integer categoryId) {
        super();
        this.id = id;
        this.name = name;
        this.title = title;
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Auth [id=" + id + ", name=" + name + ", title=" + title + ", categoryId=" + categoryId + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
