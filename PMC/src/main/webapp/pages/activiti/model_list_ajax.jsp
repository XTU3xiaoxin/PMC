<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String pathJs = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ pathJs + "/";
%>
<table class="list-table">
	<tr>
		<th width="2%"></th>
		<th width="20%">模型名称</th>
		<th width="36%">模型描述</th>
		<th width="13%">创建时间</th>
		<th width="13%">最后更新时间</th>
		<th width="20%">操作</th>
	</tr>
	<c:if test="${not empty data.rows}">
		<c:forEach items="${data.rows}" var="e" varStatus="status">
			<tr>
				<td>${status.index + 1}</td>
				<td>${e.name }</td>
				<td width="20%">${e.metaInfo}</td>
				<td><fmt:formatDate value="${e.createTime }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td><fmt:formatDate value="${e.lastUpdateTime }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td>
					<a href="javascript:void(0)" onclick="editModel('${e.id}')">修改</a>&nbsp;<span>/</span>
					<a href="javascript:void(0)" onclick="deployModel('${e.id}')">部署</a>&nbsp;<span>/</span>
					<a href="javascript:void(0)" onclick="queryModelImg('${e.id}')">查看</a>&nbsp;<span>/</span>
					<a href="javascript:void(0)" onclick="deleteModel('${e.id}')">删除</a>
				</td>
			</tr>
		</c:forEach>
	</c:if>
	<c:if test="${empty data or empty data.rows}">
		<td>&nbsp;&nbsp;</td>
		<td colspan="5">暂无符合条件的结果</td>
	</c:if>
</table>
<div class="page-footer">
	<div class="pp"></div>
</div>
<script type="text/javascript" src="<%=basePath %>layer/layer.js" charset="utf-8"></script>
<script type="text/javascript">
	
	function editModel(id){
		location.href="<%=basePath %>modeler.html?modelId="+id;
	}
	
	function deployModel(id){
		
		layer.confirm('是否部署该流程？', {
   			btn: ['确定','取消'] //按钮
   		}, function(){
   			$.ajax({
   	         type: "get",
   	         url: "<%=basePath %>new/act/deployModel/"+id,
   	         success: function(data){
   	        	if(data.flag) {
   	        		parent.showYes('部署成功！');
   	        		layer.closeAll();
   					/* location.reload(); */
   				} else {
   					parent.showNo(data.msg);
   					layer.closeAll();
   				}
   	         }
   	      });
   		}, function(){
   			layer.msg('您取消操作');
   		});
		
	}
	function deleteModel(id){
		layer.confirm('是删除署该流程？', {
   			btn: ['确定','取消'] //按钮
   		}, function(){
   			$.ajax({
   	         type: "get",
   	         url: "<%=basePath %>new/act/deleteModel/"+id,
   	         success: function(data){
   	        	if(data.flag) {
   	        		parent.showYes('删除成功！');
   	        		location.reload();
   				} else {
   					parent.showNo(data.msg);
   					layer.closeAll();
   				}
   	         }
   	      });
   		}, function(){
   			layer.msg('您取消操作');
   		});
	}
	
	function queryModelImg(id){
		location.href="<%=basePath%>new/act/model_to_details/"+id;
	}

	//分页插件
	$('.pp').llPage({
		curPage: '${pageNumb+1}',
		allNumb: '${data.total}',
		rows: '${rowsNumb}',
		callBack: function(numb){
			search(numb);
		}
	});
</script>