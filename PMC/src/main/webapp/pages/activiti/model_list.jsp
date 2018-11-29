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
		<title>模型管理列表</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/newbcsyz.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/llui.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath %>layer/skin/layer.css">
	</head>
	<style type="text/css">
		.table-list {
			height: 100%;
			padding: 10px 20px;
			box-sizing: border-box;
		}
		
		.head-table {
			width: 100%;
			border-bottom: 1px solid #DDD;
			padding-bottom: 30px;
		}
		
		.search-bar-div {
			text-align: left;
			padding: 10px;
		}
		
		.div-model {
			width: 100%;
			padding: 20px;
			
		}
		
		.div-model tr td:nth-child(2n-1) {
			width: 80px;
			white-space: pre;
			text-align: center;
		}
		
		.div-model tr td:nth-child(2n) {
			min-width: 170px;
		}
		
		.footer-table {
			padding-top: 20px;
			font-size: 14px;
		}
		
		.list-table tr:hover {
			background-color: #F8F9FB;
		}
		
		.list-table {
			border: 1px solid #DDD;
			width: 100%;
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
		
		.list-table td a {
			color: #8CCAE9;
		}
		
		.list-table td span {
			color: #8CCAE9;
		}
		
		.page-footer .pp{
			float: right;
		}
		.deploy-btn {
		    width: 100px;
		    height: 32px;
		    line-height: 32px;
		}
	</style>
	<body>
		<div class="table-list">
			<div class="head-table">
				<div class="search-bar-div"></div>
				<form id="searchForm">
					<table class="div-model">
						<tr>
							<td>模型名称：</td>
							<td>
								<input type="text" class="form-input" name="name"/>
							</td>
							<td></td>
							<td style="text-align: right;">
								<button type="button" id="search" class="btn red-btn add-btn search">搜索</button>
								<button type="button" class="btn red-btn deploy-btn deploy">一键部署</button>
							</td>
						</tr>
					</table>
				</form> 
			</div>
			<div class="footer-table" id="ajax-list">
			</div>
		<script type="text/javascript" src="<%=basePath %>js/jquery-2.1.1.min.js" charset="utf-8"></script>
		<script type="text/javascript" src="<%=basePath %>js/llui-jquery.js" charset="utf-8"></script>
		<script type="text/javascript" src="<%=basePath %>layer/layer.js" charset="utf-8"></script>
		<script type="text/javascript">
			$(".deploy").click(function(){
				layer.confirm('确定一键部署?', {
				  	btn: ['确定','取消'] //按钮
				}, function(){
					layer.closeAll();
					var ids = $("input[name='ids']").val();
					mylayer.open({
						type: '1',
						title: '部署结果',
						area: ['50%','90%'],
						shadeClose: false,
						url: '<%=basePath%>new/act/model_to_alldeploy',
						data: {
							ids : 0
						},
					});
				}, function(){
				  	layer.msg("取消操作!")
				});
				
			})
		</script>
		<script type="text/javascript">
		
			$(function() {
				search();
			});
			
			$(".search").click(function(){
				search();
			})
			function search(pageNum){
				if(!pageNum) {
					pageNum = 1;
				}
				var arr = $('#searchForm').serialize();  
			    $.param(arr);
			    
			    $.ajax({
					type: 'post',
					url: '<%=basePath %>new/act/model_to_list_ajax?page='+pageNum,
					data: arr,
					contentType: "application/x-www-form-urlencoded; charset=utf-8",
					success: function(data) {
						$('#ajax-list').html(data);
					},
					error: function() {
						alert("请求失败");
					}
				});
			}
		
			// 初始化选择框
			$('.myselect').mySelect({
				title: '请选择',
				width: '100%',
				height: '32px',
				background: '#fff',
				color: '#000000',
				icolor: '#A5A5A5',
				border: '#DDDDDD',
				onChange: function() {

				}
			});
			
		</script>
	</body>
</html>

