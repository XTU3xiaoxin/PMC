package com.bcs.tja.data.vo;

import java.io.Serializable;

public class BaseVo implements Serializable{

	private static final long serialVersionUID = 2441208045675723999L;
	
	private String id;
	
	public BaseVo() {}
	
	public BaseVo(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

}
