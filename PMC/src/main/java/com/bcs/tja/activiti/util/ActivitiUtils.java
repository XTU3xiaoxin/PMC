package com.bcs.tja.activiti.util;

import java.io.InputStream;
import java.util.List;

import javax.annotation.PostConstruct;

import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * 
 * @ClassName: ActivitiUtils.java
 * @Description: 封装了一些常用的方法（不建议再使用该类，完全可以使用activiti的api）
 * @author XCH
 * @date 2018年10月26日 上午11:40:14
 */
@Deprecated
@Component
public class ActivitiUtils {
	
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private HistoryService historyService;
	@Autowired
	private IdentityService identityService;
	
	private static ActivitiUtils single=null;  

	private ActivitiUtils() {}
	
    //静态工厂方法   
	public static ActivitiUtils getInstance() {  
		if (single == null) {    
			single = new ActivitiUtils();  
		}    
        return single;  
    }
	
	@PostConstruct 
	public void init() { 
		single = this; 
		single.repositoryService = this.repositoryService;
		single.runtimeService = this.runtimeService;
		single.taskService = this.taskService;
		single.historyService = this.historyService;

	} 
	
	/**
	 * 根据任务id获取任务活动信息
	 * @param taskId 任务id
	 * @return ActivityImpl
	 */
	public ActivityImpl getActivityImpl(String taskId) {
		// 取得当前任务.当前任务节点
		HistoricTaskInstance currTask = historyService.createHistoricTaskInstanceQuery().taskId(taskId).singleResult();
		if (currTask == null) {
      		return null;
      	}
		// 取得流程实例，流程实例
	    ProcessInstance instance = runtimeService.createProcessInstanceQuery().processInstanceId(currTask.getProcessInstanceId()).singleResult();
	    if (instance == null) {
      		return null;
      	}
	    // 取得流程定义
      	ProcessDefinitionEntity definition = (ProcessDefinitionEntity) ((RepositoryServiceImpl) repositoryService)
      			.getDeployedProcessDefinition(currTask
      			.getProcessDefinitionId());
      	if (definition == null) {
      		return null;
     	}
      	// 取得当前活动
      	ActivityImpl currActivity = definition.findActivity(instance.getActivityId());
      	return currActivity;
	}
	
	/***
	 * 根据流程实例ID获取 已审批的信息
	 * @param processInstanceId 流程实例ID
	 * @return List<HistoricTaskInstance>
	 */
	public List<HistoricTaskInstance> getHistoricTask(String processInstanceId){
		List<HistoricTaskInstance> list =  historyService.createHistoricTaskInstanceQuery().processInstanceId(processInstanceId).list();
		return list;
	}
	
	/**
	 * 获取完成的历史流程
	 * @param assignee 用户id
	 * @return List<HistoricProcessInstance>
	 */
	public List<HistoricProcessInstance> getFinishedHistoriProcessInstance(String assignee) {
		List<HistoricProcessInstance> list = historyService.createHistoricProcessInstanceQuery().startedBy(assignee).finished().list();
		return list;
	}
	
	/**
	 * 获取未完成的历史流程
	 * @param assignee 用户id
	 * @return List<HistoricProcessInstance>
	 */
	public List<HistoricProcessInstance> getUnFinishedHistoricProcessInstance(String assignee) {
		List<HistoricProcessInstance> list = historyService.createHistoricProcessInstanceQuery().startedBy(assignee).unfinished().list();
		return list;
	}
	
	/**
	 * 获取正在运行的流程实例
	 * @param assignee 用户id
	 * @return List<ProcessInstance>
	 */
	public List<ProcessInstance> getProcessInstance(String assignee) {
		List<ProcessInstance> list = runtimeService.createProcessInstanceQuery().involvedUser(assignee).list();
		return list;
	}
	
	public ProcessInstance getProcessInstanceByProcessInstanceId(String processInstanceId) {
		ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
		return processInstance;
	}
	
	/**
	 * 获取历史任务实例（审批记录）创建时间升序排列
	 * @param processInstanceId 流程实例id
	 * @return List<HistoricTaskInstance>
	 */
	public List<HistoricTaskInstance> getHistoricTaskInstance(String processInstanceId) {
		List<HistoricTaskInstance> list = historyService.createHistoricTaskInstanceQuery().processInstanceId(processInstanceId).finished().orderByTaskCreateTime().asc().list();
		return list;
	}
	
	/**
	 * 获取已部署的最新版本流程定义
	 * @return
	 */
	public List<ProcessDefinition> getProcessDefinition() {
		List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().latestVersion().list();
		return list;
	}
	
	/**
	 * 获取最新版本的流程模型
	 * @return
	 */
	public List<Model> getModel() {
		List<Model> list = repositoryService.createModelQuery().latestVersion().list();
		return list;
	}
	
	public Model getModel(String modelId) {
		Model model = repositoryService.getModel(modelId);
		return model;
	}
	
	public byte[] getModelEditorSource(String modelId) {
		byte[] modelEditorSource = repositoryService.getModelEditorSource(modelId);
		return modelEditorSource;
	}

	/**
	 * 
	 * @param name 部署包名
	 * @param resourceName 资源名称，即Model的key
	 * @param in
	 * @return
	 */
	public Deployment deployInputStream(String name,String resourceName,InputStream in) {
		Deployment deployment = repositoryService.createDeployment().name(name).addInputStream(resourceName+".bpmn", in).deploy();
		return deployment;
	}
	
	public ProcessDefinition checkedStart(String modelId) throws Exception {
		Model singleResult = repositoryService.createModelQuery().modelId(modelId).singleResult();
		if(singleResult == null) {
			throw new RuntimeException("流程模型不存在");
		}
		//核实流程是否启动
		ProcessDefinition singleResult2 = repositoryService.createProcessDefinitionQuery().deploymentId(singleResult.getDeploymentId()).singleResult();
		if(singleResult2 == null) {
			throw new RuntimeException("流程没有部署");
		}
		return singleResult2;
	}

	public RuntimeService getRuntimeService() {
		return runtimeService;
	}

	public void setRuntimeService(RuntimeService runtimeService) {
		this.runtimeService = runtimeService;
	}

	public RepositoryService getRepositoryService() {
		return repositoryService;
	}

	public void setRepositoryService(RepositoryService repositoryService) {
		this.repositoryService = repositoryService;
	}

	public TaskService getTaskService() {
		return taskService;
	}

	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	public HistoryService getHistoryService() {
		return historyService;
	}

	public void setHistoryService(HistoryService historyService) {
		this.historyService = historyService;
	}

	public IdentityService getIdentityService() {
		return identityService;
	}

	public void setIdentityService(IdentityService identityService) {
		this.identityService = identityService;
	}

}
