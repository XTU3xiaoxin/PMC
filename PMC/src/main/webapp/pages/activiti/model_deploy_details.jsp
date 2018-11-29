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
		<title>流程模型部署详情</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/font-awesome.min.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/newbcsyz.css"/>
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/mystyle.css" />
		<style type="text/css">
			 
			.wapper {
				width: 98%;
				padding: 20px 0px;
			}
			
			.add-list {
				width: 100%;
			}
			
			.add-list tr td {
				padding: 5px;
			}
			.add-list tr td:nth-child(2n-1) {
				text-align: right;
				width: 22%;
				padding-right: 20px;
			}
			
			.form-input {
				border: 1px solid #DDD;
				/* background: #F9F9F9; */
				background: #fff;
				width: 80%;
				height: 32px;
				line-height: 30px;
				border-radius: 5px;
				outline: none;
				padding: 3px 6px;
				box-sizing: border-box;
			}
			
			.form-text {
				border: 1px solid #DDD;
				background: #F9F9F9;
				width: 80%;
				line-height: 25px;
				min-height: 202px;
				border-radius: 5px;
				outline: none;
				padding: 3px 6px;
				box-sizing: border-box;
			}
			
			
			.form-textarea {
				border: 1px solid #DDD;
				background: #fff;
				width: 80%;
				line-height: 30px;
				border-radius: 5px;
				outline: none;
				padding: 0px 6px;
				box-sizing: border-box;
			}
			.tj-btn {
				width: 200px;
				height: 35px;
				line-height: 35px;
			}
			
			.back-btn {
				width: 200px;
				height: 35px;
				line-height: 35px;
				margin-left: 50px;
			}
			
			.input-p {
				position: relative;
				padding-right: 80px;
				margin-bottom: 20px;
			}
			
			.input-p span{
				display: block;
				line-height: 30px;
				height: 30px;
				min-width: 200px;
				border: 1px solid #ddd;
				padding-left: 10px;
				box-sizing: border-box;
				border-right: none;
				border-radius: 5px 0px 0px 5px;
			}
			
			.input-p button {
				position: absolute;
				top: 0px;
				right: 0px;
				border-radius: 0px 5px 5px 0px;
			}
			
			.page-footer1 {
				text-align: center;
			}
		</style>
	</head>                    
	<body>
		<div class="wapper" id="deploy-div">
			正在部署中...
		</div>
	</body>
	<script src="<%=basePath %>js/jquery-2.1.1.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=basePath %>js/jquery.form.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
	$(function() {
		deploy();
	});
	
	function deploy(){
	    $.ajax({
			type: 'post',
			url: '<%=basePath %>new/act/model_to_alldeploy_ajax',
			contentType: "application/x-www-form-urlencoded; charset=utf-8",
			success: function(data) {
				$('#deploy-div').html(data);
			},
			error: function() {
				alert("请求失败");
			}
		});
	}
	</script>
</html>