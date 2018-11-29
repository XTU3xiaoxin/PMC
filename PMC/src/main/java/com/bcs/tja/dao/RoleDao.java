package com.bcs.tja.dao;

import java.util.List;

import com.bcs.tja.domain.Role;

public interface RoleDao {
	
	List<Role> selectByCategoryId(String categoryId);
    /**
     *  根据主键删除数据库的记录,role
     *
     * @param id
     */
    int deleteByPrimaryKey(String id);

    /**
     *  新写入数据库记录,role
     *
     * @param record
     */
    int insert(Role record);

    /**
     *  动态字段,写入数据库记录,role
     *
     * @param record
     */
    int insertSelective(Role record);

    /**
     *  根据指定主键获取一条数据库记录,role
     *
     * @param id
     */
    Role selectByPrimaryKey(String id);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,role
     *
     * @param record
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     *  根据主键来更新符合条件的数据库记录,role
     *
     * @param record
     */
    int updateByPrimaryKey(Role record);
}