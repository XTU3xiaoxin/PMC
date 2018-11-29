<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String pathJs = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ pathJs + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>流程详情</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/newbcsyz.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/llui.css" />
	</head>
	<style type="text/css">
		.content {
			padding: 20px;
		}
		
		.content .div-rect {
			padding: 15px;
			border-bottom: 1px solid #ddd;
		}
		
		.content .div-rect1 {
			padding: 15px;
			border-bottom: 1px solid #ddd;
		}
		
		.rect-text {
			width: 5px;
			height: 22px;
			font-weight: 200;
			background: #3B3B3B;
			font-size: 20px;
			display: inline-block;
			vertical-align: middle;
			margin-right: 10px;
		}
		
		.rect-message {
			font-size: 18px;
			height: 22px;
			font-weight: 600;
			vertical-align: middle;
			color: #3B3B3B;
		}
		
		.detail-table {
			width: 100%;
			margin: 5px 0px 25px;
			border-collapse: collapse;
			font-size: 14px;
		}
			
		.detail-table tr td {
			padding: 5px 0px;
		}
			
		.detail-table tr td:nth-child(2n-1) {
			width: 7em;
			padding-right: 10px;
			text-align: right;
		}
		
		.list-table {
			border: 1px solid #DDD;
			width: 100%;
			margin: 30px 0px 25px;
			text-align: center;
			font-size: 14px;
		}
		
		.list-table th {
			border: 1px solid #DDD;
			border-style: solid;
			text-align: center;
			background: #F8F9FB;
			height: 32px;
		}
		
		.list-table td {
			border: 1px solid #DDD;
			border-style: solid;
			height: 32px;
		}
		
		.list-table a {
			color: #8CCAE9;
		}
		
		.btn-box {
			padding: 40px;
			text-align: left;
		}
				
		.affix {
			float: right;
		}
		
		.btn-div {
			margin: 50px auto 0px;
			text-align: center;
		}
		
		.slash {
			color: #8CCAE9;
		}
		
		.table-list .file-a {
			color: blue;
			font-size: 13px;
			cursor: pointer;
			display: block;
			text-align: left;
			padding-right: 30px;
			margin: 2px 0px;
			word-break: break-all;
			position: relative;
		}
		
		.table-list .file-a .file-delete:after {
			content: '×';
			display: inline-block;
			color: red;
			font-size: 22px;
			line-height: 16px;
			position: absolute;
			right: 10px;
			top: 50%;
			margin-top: -8px;
		}
		
		.detail-table {
			width: 98%;
			margin: 30px 0px 20px;
			border-collapse: collapse;
			font-size: 14px;
			padding-bottom: 30px;
			
		}
			
		.detail-table tr td {
			padding: 5px 0px;
		}
			
		.detail-table tr td:nth-child(2n-1) {
			width: 7em;
			padding-right: 10px;
			text-align: right;
		}
	</style>
	<body>
		<div class="page-swrap">
			<div class="tabs">
				<ul>
					<li class="active">基础信息</li>
				</ul>
			</div>
			<div class="page-box">
				<div class="page active">
					<div class="content">
						<div title="详情" class="div-rect">
							<span class="rect-text"></span>
							<span class="rect-message">详情：</span>
						</div>
						<table class="detail-table">
							<tr>
								<td style="vertical-align: top;padding-top: 10px;">
									模型名称：
								</td>
								<td colspan="5">
									<p class="form-input">${model.name }</p>
								</td>
							</tr>
							<tr>
								<td>
									模型描述：
								</td>
								<td colspan="5">
									<p class="form-text">${model.metaInfo}</p>
								</td>
							</tr>
							<tr>
								<td>创建时间：</td>
								<td>
									<p class="form-input"><fmt:formatDate value="${model.createTime }" pattern="yyyy-MM-dd HH:mm:ss" /></p>
								</td>
								<td></td>
								<td></td>
								<td>最后更新时间：</td>
								<td>
									<p class="form-input"><fmt:formatDate value="${model.lastUpdateTime }" pattern="yyyy-MM-dd HH:mm:ss" /></p>
								</td>
							</tr>
						</table>
						<div title="流程绑定" class="div-rect">
							<span class="rect-text"></span>
							<span class="rect-message">流程绑定：</span>
						</div>
						<c:if test="${not empty stvs}">
							<table class="list-table">
								<tr>
									<th width="2%"></th>
									<th width="20%">印章类型名称</th>
									<th width="13%">绑定时间</th>
									<th width="17%">操作</th>
								</tr>
								<c:forEach items="${stvs }" var="stv" varStatus="status">
									<tr>
										<td width="2%">${status.index + 1}</td>
										<td width="20%">${stv.sysSealType.name }</td>
										<td width="12%"><fmt:formatDate value="${stv.sysSealTypeModel.createTime }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
										<td width="17%"><a href="javascript:void(0)" onclick="unSTM('${stv.sysSealTypeModel.id}')">解绑</a></td>
									</tr>
								</c:forEach>
							</table>
						</c:if>
						<c:if test="${not empty sms}">
							<table class="list-table">
								<tr>
									<th width="2%"></th>
									<th width="20%">印章名称</th>
									<th width="20%">所属部门</th>
									<th width="12%">绑定时间</th>
									<th width="17%">操作</th>
								</tr>
								<c:forEach items="${sms }" var="sm" varStatus="status">
									<tr>
										<td width="2%">${status.index + 1}</td>
										<td width="20%">${sm.sysSeal.name }</td>
										<td width="20%">${sm.sysSeal.orgName }</td>
										<td width="12%"><fmt:formatDate value="${sm.sysSealModel.createTime }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
										<td width="17%"><a href="javascript:void(0)" onclick="unSM('${sm.sysSealModel.id}')">解绑</a></td>
									</tr>
								</c:forEach>
							</table>
						</c:if>
						<c:if test="${empty sms and empty stvs}">
							<div style="width: 100%;text-align: center;margin-top: 30px;">无绑定记录!</div>
						</c:if>
						<div title="流程视图" class="div-rect1">
							<span class="rect-text"></span>
							<span class="rect-message">流程视图：</span>
						</div>
						<div align="center">
							<img src='<%=basePath%>new/act/queryModelImg/${id}'/>
						</div>
						<div class="btn-div">
							<button type="button" class="btn white-btn close-btn close">
								关闭
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="<%=basePath %>js/jquery-2.1.1.min.js" charset="utf-8"></script>
		<script type="text/javascript" src="<%=basePath %>js/llui-jquery.js" charset="utf-8"></script>
		<script type="text/javascript" src="<%=basePath %>layui/layui.js" charset="utf-8"></script>
		<script type="text/javascript" src="<%=basePath %>layer/layer.js" charset="utf-8"></script>
		<script type="text/javascript">
			/* 印章类型解绑 */
			function unSTM(id){
				layer.confirm('确定解绑？', {
				  	btn: ['确定','取消'] //按钮
				}, function(){
					$.ajax({
						type:'get',
						url:'<%=basePath %>new/seal/delete_by_sealtypemodel_id/'+id,
						contentType: "application/x-www-form-urlencoded; charset=utf-8",
						success: function(data) {
							if(data.success) {
								parent.showYes('操作成功!');
								location.reload();
							} else {
								parent.showNo(data.msg);
							}
						},
						error: function() {
							alert("请求失败");
						}
					})
				}, function(){
					layer.msg('您取消操作');
				});
			}
			
			/* 印章解绑 */
			function unSM(id){
				layer.confirm('确定解绑？', {
				  	btn: ['确定','取消'] //按钮
				}, function(){
					$.ajax({
						type:'get',
						url:'<%=basePath %>new/seal/delete_by_sealmodel_id/'+id,
						contentType: "application/x-www-form-urlencoded; charset=utf-8",
						success: function(data) {
							if(data.success) {
								parent.showYes('操作成功!');
								location.reload();
							} else {
								parent.showNo(data.msg);
							}
						},
						error: function() {
							alert("请求失败");
						}
					})
				}, function(){
					layer.msg('您取消操作');
				});
			}
		
			//关闭按钮事件
			$('.close-btn').on('click', function() {
				history.go(-1);
			});
		</script>
	</body>
</html>
