package com.bcs.tja.controller ;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.Model;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bcs.tja.activiti.CustomActivityImpl;
import com.bcs.tja.activiti.util.ActivitiUtils;
import com.bcs.tja.data.MessageInfo;
import com.bcs.tja.data.PageDataView;
import com.bcs.tja.service.WorkflowTraceService;
import com.bcs.tja.utils.UUIDGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @ClassName: ActivitiController.java
 * @Description:
 * @date 2017年11月13日 下午3:16:39
 */
@Controller
@RequestMapping("new/act")
public class ActivitiController {

	private static final Logger logger = LoggerFactory.getLogger(ActivitiController.class);
	
	@Autowired
	private RepositoryService repositoryService;
	@Autowired  
    HistoryService historyService;
//	@Autowired
//	private ISysOrganizationService sysOrganizationService;
//	@Autowired
//	private ISysSealModelService sysSealModelService;
//	@Autowired
//	private ISysSealTypeModelService sysSealTypeModelService;
//	@Autowired
//	private ISysSealTypeService sysSealTypeService;
//	@Autowired
//	private ISysSealService sysSealService;
	@Autowired  
  protected RuntimeService runtimeService;
	@Autowired  
	protected WorkflowTraceService traceService;
	
	
	@RequestMapping("model_to_list")
	public ModelAndView modelToList() {
		return new ModelAndView("newpages/activiti/model_list");
	}

	@RequestMapping("model_to_list_ajax")
	@ResponseBody
	public ModelAndView modelToListAjax(ModelMap modelMap,String name,Integer page,Integer rows) {
		page = page == null?1:page;
		rows = rows == null?10:rows;
		PageDataView<Model> list = new PageDataView<Model>();
		List<Model> model = new ArrayList<Model>();
		int total = 0;
		page = page - 1;
		if(StringUtils.isBlank(name)) {
			model = repositoryService.createModelQuery().orderByCreateTime().desc().listPage(page*rows, rows);
			total = (int) repositoryService.createModelQuery().count();
		}else {
			model = repositoryService.createModelQuery().modelNameLike("%"+name+"%").orderByCreateTime().desc().listPage(page*rows, rows);
			total = (int) repositoryService.createModelQuery().modelNameLike("%"+name+"%").count();
		}
		if(!model.isEmpty()) {
			for (int i = 0; i < model.size(); i++) {
				String metaInfo = model.get(i).getMetaInfo();
				JSONObject jsonObject = JSON.parseObject(metaInfo);
				metaInfo = jsonObject.get("description").toString();
				model.get(i).setMetaInfo(metaInfo);
			}
		}
		list.setRows(model);
		list.setTotal(total);
		modelMap.put("data", list);
		modelMap.put("pageNumb", page);
		modelMap.put("rowsNumb", rows);
		return new ModelAndView("newpages/activiti/model_list_ajax",modelMap);
	}

	/**
	 * 删除
	 * 
	 * @param modelId
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "deleteModel/{modelId}")
	@ResponseBody
	public JSONObject deleteModel(@PathVariable("modelId") String modelId, HttpServletResponse response) {
		JSONObject jsonObject = new JSONObject();
		try {
			repositoryService.deleteModel(modelId);
			jsonObject.put("flag", true);
			return jsonObject;
		} catch (Exception e) {
			jsonObject.put("flag", false);
			jsonObject.put("msg", "删除失败！");
			return jsonObject;
		}
	}

	/**
	 * 部署
	 */
	@RequestMapping(value = "deployModel/{modelId}")
	@ResponseBody
	public JSONObject deploy(@PathVariable("modelId") String modelId) {
		JSONObject jsonObject = new JSONObject();
		Model modelData = repositoryService.getModel(modelId);
		try {
			BpmnJsonConverter jsonConverter = new BpmnJsonConverter();
			// 获取节点信息
			byte[] arg0 = ActivitiUtils.getInstance().getModelEditorSource(modelData.getId());
			JsonNode editorNode = new ObjectMapper().readTree(arg0);
			// 将节点信息转换为XML
			BpmnModel bpmnModel = jsonConverter.convertToBpmnModel(editorNode);
			BpmnXMLConverter xmlConverter = new BpmnXMLConverter();
			byte[] bpmnBytes = xmlConverter.convertToXML(bpmnModel);
			InputStream in = new ByteArrayInputStream(bpmnBytes);
			// System.out.println(IOUtils.toString(in, "UTF-8"));
			Deployment deployInputStream = repositoryService.createDeployment()
					.name(modelData.getId()).addInputStream(modelData.getId()+".bpmn", in).deploy();
			if (deployInputStream != null) {
				Model singleResult = repositoryService.createModelQuery().modelId(modelId).singleResult();
				singleResult.setDeploymentId(deployInputStream.getId());
				repositoryService.saveModel(singleResult);
				jsonObject.put("flag", true);
				return jsonObject;
			}
			jsonObject.put("flag", false);
			jsonObject.put("msg", "部署失败！");
			return jsonObject;
		} catch (Exception e) {
			logger.error("部署失败;模型ID：{},模型名称：{},{}!",modelData.getName(),modelData.getId(),e.getMessage());
			jsonObject.put("flag", false);
			jsonObject.put("msg", "部署失败！");
			return jsonObject;
		}
	}
	
	/**
	 * 一键部署
	 * @param modelMap
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "model_to_alldeploy")
	public ModelAndView deployAll(ModelMap modelMap,String ids) {
		return new ModelAndView("activiti/model_deploy_details",modelMap);
	}
	
	/**
	 * 一键部署
	 * @param modelMap
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "model_to_alldeploy_ajax")
	public ModelAndView deployAllAjax(HttpServletResponse response,ModelMap modelMap,String ids) {
		List<MessageInfo> msgs = new ArrayList<MessageInfo>();
		List<Model> model = repositoryService.createModelQuery().list();
		for (Model m : model) {
			MessageInfo deployByModle = deployByModle(m);
			msgs.add(deployByModle);
		}
		modelMap.put("data", msgs);
		return new ModelAndView("/activiti/model_deploy_details_ajax",modelMap);
	}
	
	public MessageInfo deployByModle(Model model) {
		MessageInfo info = new MessageInfo();
		info.setMsg(model.getName());
		info.setSuccess(false);
		info.setId(model.getId());
		try {
			BpmnJsonConverter jsonConverter = new BpmnJsonConverter();
			// 获取节点信息
			byte[] arg0 = repositoryService.getModelEditorSource(model.getId());
			JsonNode editorNode = new ObjectMapper().readTree(arg0);
			// 将节点信息转换为XML
			BpmnModel bpmnModel = jsonConverter.convertToBpmnModel(editorNode);
			BpmnXMLConverter xmlConverter = new BpmnXMLConverter();
			byte[] bpmnBytes = xmlConverter.convertToXML(bpmnModel);
			InputStream in = new ByteArrayInputStream(bpmnBytes);
			// System.out.println(IOUtils.toString(in, "UTF-8"));
			Deployment deployInputStream = repositoryService.createDeployment()
					.name(model.getId()).addInputStream(model.getId()+".bpmn", in).deploy();
			if (deployInputStream != null) {
				Model singleResult = repositoryService.createModelQuery().modelId(model.getId()).singleResult();
				singleResult.setDeploymentId(deployInputStream.getId());
				repositoryService.saveModel(singleResult);
				info.setSuccess(true);
			}
		} catch (Exception e) {
			logger.error("一键部署失败;模型ID：{},模型名称：{},{}!",model.getName(),model.getId(),e.getMessage());
			info.setSuccess(false);
			String stackMsg = getStackMsg(e);
			info.setReport("标题："+e.getMessage() + "\n" + stackMsg);
			return info;
		}
		return info;
	}
	
	private static String getStackMsg(Exception e) {  
        StringBuffer sb = new StringBuffer();  
        StackTraceElement[] stackArray = e.getStackTrace();  
        for (int i = 0; i < stackArray.length; i++) {  
            StackTraceElement element = stackArray[i];  
            sb.append(element.toString() + "\n");  
        }  
        return sb.toString();  
    } 
	
	@RequestMapping(value = "report_deploy/{id}")
	public void reportDeploy(HttpServletRequest request,HttpServletResponse response,@PathVariable("id") String id) {
		try {
			Model modelData = repositoryService.getModel(id);
			MessageInfo deployByModle = deployByModle(modelData);
			byte[] data = deployByModle.getReport().getBytes();
		    String fileName = modelData.getName()+"-错误报告" + ".txt";
		    fileName = URLEncoder.encode(fileName, "UTF-8");  
		    response.reset();  
		    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");  
		    response.addHeader("Content-Length", "" + data.length);  
		    response.setContentType("application/octet-stream;charset=UTF-8");  
		    OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());  
		    outputStream.write(data);  
		    outputStream.flush();  
		    outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 创建模型
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping("create")
	public void create(HttpServletRequest request, HttpServletResponse response) {
		try {
			ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

			RepositoryService repositoryService = processEngine.getRepositoryService();

			ObjectMapper objectMapper = new ObjectMapper();
			ObjectNode editorNode = objectMapper.createObjectNode();
			editorNode.put("id", "canvas");
			editorNode.put("resourceId", "canvas");
			ObjectNode stencilSetNode = objectMapper.createObjectNode();
			stencilSetNode.put("namespace", "http://b3mn.org/stencilset/bpmn2.0#");
			editorNode.put("stencilset", stencilSetNode);
			Model modelData = repositoryService.newModel();

			ObjectNode modelObjectNode = objectMapper.createObjectNode();
			modelObjectNode.put(ModelDataJsonConstants.MODEL_NAME, "流程名称");
			modelObjectNode.put(ModelDataJsonConstants.MODEL_REVISION, 1);
			String description = "备注描述";
			modelObjectNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, description);
			modelData.setMetaInfo(modelObjectNode.toString());
			modelData.setName("流程名称");
			String uuid = UUIDGenerator.getId();
			modelData.setKey(uuid);
			// 保存模型
			repositoryService.saveModel(modelData);
			repositoryService.addModelEditorSource(modelData.getId(), editorNode.toString().getBytes("utf-8"));
			response.sendRedirect(request.getContextPath() + "/modeler.html?modelId=" + modelData.getId());
		} catch (Exception e) {
			System.out.println("创建模型失败：");
		}
	}

	/**
	 * 查看模型图片
	 * 
	 * @throws IOException
	 **/
	@RequestMapping("queryModelImg/{modelId}")
	public void queryModelImg(ModelMap model, @PathVariable String modelId, HttpServletResponse response)
			throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		byte[] modelEditorSourceExtra = repositoryService.getModelEditorSourceExtra(modelId);
		InputStream in = new ByteArrayInputStream(modelEditorSourceExtra);
		byte[] b = new byte[1024];
		int len;
		while ((len = in.read(b, 0, 1024)) != -1) {
			response.getOutputStream().write(b, 0, len);
		}
	}

	/** 获取下一环节信息 **/
	public List<CustomActivityImpl> next(ActivityImpl activityImpl) {
		List<CustomActivityImpl> list = new ArrayList<CustomActivityImpl>();
		List<PvmTransition> pvmTransitions = activityImpl.getOutgoingTransitions();// 取出节点的所有出去的线
		// 对所有的线进行遍历
		for (PvmTransition pvmTransition : pvmTransitions) {
			// 取出的线的目标节点
			ActivityImpl pvmActivityImpl = (ActivityImpl) pvmTransition.getDestination();
			if (!pvmActivityImpl.getProperty("type").equals("userTask")) {
				List<CustomActivityImpl> next = next(pvmActivityImpl);
				return next;
			}
			CustomActivityImpl custom = new CustomActivityImpl();
			custom.setActivityImpl(pvmActivityImpl);
			custom.setName(pvmActivityImpl.getProperty("name").toString());
			custom.setActivityId(pvmActivityImpl.getId());
			list.add(custom);
		}
		return list;
	}

	@RequestMapping("/getOrgTrees")
	@ResponseBody
	public JSONObject getOrgTrees(HttpServletRequest request, HttpServletResponse response) {
		//String treeNodes = sysOrganizationService.initOrganizations();
		String treeNodes = "{name:\"长沙银行\"}";
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("treeNodes", treeNodes);
		return jsonObject;
	}
	
	/**
     * 读取资源，通过流程ID
     *
     * @param resourceType      资源类型(xml|image)
     * @param processInstanceId 流程实例ID
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/resource/process-instance")
    public void loadByProcessInstance(@RequestParam("type") String resourceType, @RequestParam("pid") String processInstanceId, HttpServletResponse response)
            throws Exception {
    	//response.setContentType("text/html;charset=UTF-8");
        InputStream resourceAsStream = null;
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
        /*ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(processInstance.getProcessDefinitionId())
                .singleResult();*/
        //String resourceName = "";
        /*if (resourceType.equals("image")) {
            resourceName = processDefinition.getDiagramResourceName();
        } else if (resourceType.equals("xml")) {
            resourceName = processDefinition.getResourceName();
        }*/
        Model singleResult = repositoryService.createModelQuery().deploymentId(processInstance.getDeploymentId()).singleResult();
        byte[] modelEditorSourceExtra = repositoryService.getModelEditorSourceExtra(singleResult.getId());
        resourceAsStream = new ByteArrayInputStream(modelEditorSourceExtra);
        //resourceAsStream = repositoryService.getResourceAsStream(processDefinition.getDeploymentId(), resourceName);
        byte[] b = new byte[1024];
        int len = -1;
        while ((len = resourceAsStream.read(b, 0, 1024)) != -1) {
            response.getOutputStream().write(b, 0, len);
        }
    }
	
    /**
     * 输出跟踪流程信息
     *
     * @param processInstanceId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/process/trace")
    @ResponseBody
    public List<Map<String, Object>> traceProcess(@RequestParam("pid") String processInstanceId) throws Exception {
        List<Map<String, Object>> activityInfos = traceService.traceProcess(processInstanceId);
        return activityInfos;
    }
}
