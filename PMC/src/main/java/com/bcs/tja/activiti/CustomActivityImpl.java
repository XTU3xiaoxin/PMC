package com.bcs.tja.activiti;

import java.util.List;

import org.activiti.engine.impl.pvm.process.ActivityImpl;

/**
 * @ClassName: CustomActivityImpl.java
 * @Description: 自定义节点信息
 * @date 2017年11月15日 上午11:48:35
 */
public class CustomActivityImpl implements Comparable<CustomActivityImpl>{
	
	/** 节点信息 **/
	private 	ActivityImpl 	activityImpl;
	private 	String 			name;//节点名称，不可自定义，必须是节点的mane属性值
	@Deprecated
	private 	String 			nickname;//节点昵称，可自定义
	/** 节点ID **/
	private 	String 			activityId;
	/** 当前节点是否需要人（页面操作选项会根据这个数显来判断是否选人）**/
	private 	boolean 		setPerson;
	/** 节点类型，用户任务还是服务任务**/
	private 	String 			type;
	private 	String 			assignee;
	/** 审批进度**/
	private 	List<CustomHistoricTask> comments;
	
	public ActivityImpl getActivityImpl() {
		return activityImpl;
	}

	public void setActivityImpl(ActivityImpl activityImpl) {
		this.activityImpl = activityImpl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public boolean isSetPerson() {
		return setPerson;
	}

	public void setSetPerson(boolean setPerson) {
		this.setPerson = setPerson;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public List<CustomHistoricTask> getComments() {
		return comments;
	}

	public void setComments(List<CustomHistoricTask> comments) {
		this.comments = comments;
	}

	@Override
	public int compareTo(CustomActivityImpl o) {
		String v1 = this.name.substring(this.name.lastIndexOf("(")+1, this.name.lastIndexOf(")"));
		String v2 = o.getName().substring(o.getName().lastIndexOf("(")+1, o.getName().lastIndexOf(")"));
		double d1 = Double.parseDouble(v1);
		double d2 = Double.parseDouble(v2);
		return Double.compare(d1, d2);
		//return (int) ((Double.parseDouble(v1) - Double.parseDouble(v2)));
	}

}
