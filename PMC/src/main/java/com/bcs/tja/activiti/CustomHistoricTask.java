package com.bcs.tja.activiti;

import java.util.Date;
import java.util.List;

import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.persistence.entity.AttachmentEntity;
import org.activiti.engine.impl.persistence.entity.CommentEntity;


/**
 * @ClassName: CustomHistoricTask.java
 * @Description: 审批进度，即审批信息,自定义封装
 * @date 2017年11月16日 下午5:53:18
 */

public class CustomHistoricTask {

	/** 任务信息 **/
	private HistoricTaskInstance 	historicTaskInstance;
	/** 审批意见 **/
	private List<CommentEntity> 	comments;
	/** 审批附件 （已移除，没有使用）**/
	private List<AttachmentEntity> 	attachments;
	/** 任务处理人Id**/
	private String 					assigneeId;
	/** 任务处理人姓名**/
	private String 					assigneeName;
	
	/** 任务创建时间**/
	private Date 					createTime;
	/** 意见**/
	private String 					comment;
	/** 部门名称**/
	private String 					deptName;
	

	public HistoricTaskInstance getHistoricTaskInstance() {
		return historicTaskInstance;
	}

	public void setHistoricTaskInstance(HistoricTaskInstance historicTaskInstance) {
		this.historicTaskInstance = historicTaskInstance;
	}

	public List<CommentEntity> getComments() {
		return comments;
	}

	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}

	public List<AttachmentEntity> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<AttachmentEntity> attachments) {
		this.attachments = attachments;
	}

	public String getAssigneeId() {
		return assigneeId;
	}

	public void setAssigneeId(String assigneeId) {
		this.assigneeId = assigneeId;
	}

	public String getAssigneeName() {
		return assigneeName;
	}

	public void setAssigneeName(String assigneeName) {
		this.assigneeName = assigneeName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
}
