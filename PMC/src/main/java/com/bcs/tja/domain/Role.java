package com.bcs.tja.domain;

import java.io.Serializable;

public class Role implements Serializable {
    /**  role.id */
    private String id;

    /**  role.name */
    private String name;

    /**  role.desc */
    private String desc;

    /**  role.categoryId */
    private String categoryid;

    /**  role.deleteStatus */
    private Integer deletestatus;

    private static final long serialVersionUID = 1L;

    /**
     *  获取 role.id
     */
    public String getId() {
        return id;
    }

    /**
     *  设置 role.id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     *  获取 role.name
     */
    public String getName() {
        return name;
    }

    /**
     *  设置 role.name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     *  获取 role.desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     *  设置 role.desc
     */
    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    /**
     *  获取 role.categoryId
     */
    public String getCategoryid() {
        return categoryid;
    }

    /**
     *  设置 role.categoryId
     */
    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid == null ? null : categoryid.trim();
    }

    /**
     *  获取 role.deleteStatus
     */
    public Integer getDeletestatus() {
        return deletestatus;
    }

    /**
     *  设置 role.deleteStatus
     */
    public void setDeletestatus(Integer deletestatus) {
        this.deletestatus = deletestatus;
    }
}