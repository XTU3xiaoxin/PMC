package com.bcs.tja.domain;

import java.io.Serializable;

public class RoleCategory implements Serializable {
    /**  role_category.id */
    private String id;

    /**  role_category.name */
    private String name;

    /**  role_category.desc */
    private String desc;

    /**  role_category.deleteStatus */
    private Boolean deletestatus;

    private static final long serialVersionUID = 1L;

    /**
     *  获取 role_category.id
     */
    public String getId() {
        return id;
    }

    /**
     *  设置 role_category.id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     *  获取 role_category.name
     */
    public String getName() {
        return name;
    }

    /**
     *  设置 role_category.name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     *  获取 role_category.desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     *  设置 role_category.desc
     */
    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    /**
     *  获取 role_category.deleteStatus
     */
    public Boolean getDeletestatus() {
        return deletestatus;
    }

    /**
     *  设置 role_category.deleteStatus
     */
    public void setDeletestatus(Boolean deletestatus) {
        this.deletestatus = deletestatus;
    }
}