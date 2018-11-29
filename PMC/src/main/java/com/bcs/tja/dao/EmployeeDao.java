package com.bcs.tja.dao;

import com.bcs.tja.domain.Employee;

public interface EmployeeDao {
    /**
     *  根据主键删除数据库的记录,v_sys_employee
     *
     * @param empid
     */
    int deleteByPrimaryKey(String empid);

    /**
     *  新写入数据库记录,v_sys_employee
     *
     * @param record
     */
    int insert(Employee record);

    /**
     *  动态字段,写入数据库记录,v_sys_employee
     *
     * @param record
     */
    int insertSelective(Employee record);

    /**
     *  根据指定主键获取一条数据库记录,v_sys_employee
     *
     * @param empid
     */
    Employee selectByPrimaryKey(String empid);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,v_sys_employee
     *
     * @param record
     */
    int updateByPrimaryKeySelective(Employee record);

    /**
     *  根据主键来更新符合条件的数据库记录,v_sys_employee
     *
     * @param record
     */
    int updateByPrimaryKey(Employee record);
}