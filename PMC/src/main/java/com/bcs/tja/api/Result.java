package com.bcs.tja.api;

import java.io.Serializable;

public class Result<T> implements Serializable {

	private static final long serialVersionUID = 8622340471497604002L;
	
	private String code = "200";
	
	private String msg;
	
	private T data;
	
	public Result() {
		super();
	}
	
	
	public Result(T data) {   //默认返回成功信息
		super();
		this.msg = "success";
		this.data = data;
	}
	
	public Result(String code,String msg,T data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public T getData() {
		return data;
	}


	public void setData(T data) {
		this.data = data;
	}
	

}
