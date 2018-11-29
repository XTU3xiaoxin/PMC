package com.bcs.tja.dao;

import java.util.List;

import com.bcs.tja.data.vo.OrganizationVo;
import com.bcs.tja.domain.Organization;

public interface OrganizationDao {
	
	
	List<OrganizationVo> findOrgTreeData();
	
	
    /**
     *  根据主键删除数据库的记录,v_sys_organization
     *
     * @param orgid
     */
    int deleteByPrimaryKey(String orgid);

    /**
     *  新写入数据库记录,v_sys_organization
     *
     * @param record
     */
    int insert(Organization record);

    /**
     *  动态字段,写入数据库记录,v_sys_organization
     *
     * @param record
     */
    int insertSelective(Organization record);

    /**
     *  根据指定主键获取一条数据库记录,v_sys_organization
     *
     * @param orgid
     */
    Organization selectByPrimaryKey(String orgid);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,v_sys_organization
     *
     * @param record
     */
    int updateByPrimaryKeySelective(Organization record);

    /**
     *  根据主键来更新符合条件的数据库记录,v_sys_organization
     *
     * @param record
     */
    int updateByPrimaryKey(Organization record);
}