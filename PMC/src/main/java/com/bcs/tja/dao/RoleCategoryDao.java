package com.bcs.tja.dao;

import com.bcs.tja.domain.RoleCategory;

public interface RoleCategoryDao {
    /**
     *  根据主键删除数据库的记录,role_category
     *
     * @param id
     */
    int deleteByPrimaryKey(String id);

    /**
     *  新写入数据库记录,role_category
     *
     * @param record
     */
    int insert(RoleCategory record);

    /**
     *  动态字段,写入数据库记录,role_category
     *
     * @param record
     */
    int insertSelective(RoleCategory record);

    /**
     *  根据指定主键获取一条数据库记录,role_category
     *
     * @param id
     */
    RoleCategory selectByPrimaryKey(String id);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,role_category
     *
     * @param record
     */
    int updateByPrimaryKeySelective(RoleCategory record);

    /**
     *  根据主键来更新符合条件的数据库记录,role_category
     *
     * @param record
     */
    int updateByPrimaryKey(RoleCategory record);
}