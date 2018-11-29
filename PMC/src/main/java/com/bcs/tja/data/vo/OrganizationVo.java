package com.bcs.tja.data.vo;

public class OrganizationVo extends BaseVo {

	private static final long serialVersionUID = 2437578003132334892L;

	private String orgCode;   //机构号
	
	private String name;    //机构名称
	
	 private String pid;  //机构ID

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}
	 
}
