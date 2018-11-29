package com.bcs.tja.domain;

import java.io.Serializable;

public class User implements Serializable {
    /**  t_user.id */
    private Integer id;

    /**  t_user.name */
    private String name;

    /**  t_user.address */
    private String address;

    private static final long serialVersionUID = 1L;

    /**
     *  获取 t_user.id
     */
    public Integer getId() {
        return id;
    }

    /**
     *  设置 t_user.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *  获取 t_user.name
     */
    public String getName() {
        return name;
    }

    /**
     *  设置 t_user.name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     *  获取 t_user.address
     */
    public String getAddress() {
        return address;
    }

    /**
     *  设置 t_user.address
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}