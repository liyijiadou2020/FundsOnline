package com.atguigu.crowd.entity;

public class Role {
    /**
     * 角色的标识
     */
    private Integer id;

    /**
     * 角色名称
     */
    private String name;

    public Role() {
        // TODO Auto-generated constructor stub
    }

    public Role(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role [id=" + id + ", name=" + name + "]";
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
}
