package com.bcs.tja.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcs.tja.api.Result;
import com.bcs.tja.dao.OrganizationDao;
import com.bcs.tja.dao.RoleDao;
import com.bcs.tja.data.vo.OrganizationVo;
import com.bcs.tja.domain.Role;


@RestController
@RequestMapping("new/flow")
public class FlowController {

	@Autowired
	private OrganizationDao organizationDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@RequestMapping(value = "/role_list_data")
	public Result<List<Role>> roleListData(ModelMap modelMap,HttpServletRequest request,HttpServletResponse response) {
		//分页信息
		Result<List<Role>>  result = new Result<List<Role>>();
		List<Role> roleList = roleDao.selectByCategoryId("0001");  //检索出所有的选人角色
		
		
		result.setData(roleList);
		return result;
		
	}

	@RequestMapping(value = "/organization_list_data")
	public Result<List<OrganizationVo>> organizationListData(ModelMap modelMap,HttpServletRequest request,HttpServletResponse response) {
		//分页信息
		Result<List<OrganizationVo>>  result = new Result<List<OrganizationVo>>();
		List<OrganizationVo> orgList = organizationDao.findOrgTreeData();
		
		result.setData(orgList);
		return result;
		
	}
	

}
