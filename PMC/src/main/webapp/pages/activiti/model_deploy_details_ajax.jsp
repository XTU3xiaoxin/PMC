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
		<th width="58%">模型名称</th>
		<th width="40%">部署情况</th>
	</tr>
	<c:if test="${not empty data}">
		<c:forEach items="${data }" var="d" varStatus="status">
			<tr>
				<td>${status.index +1 }</td>
				<td>${d.msg }</td>
				<td width="20%">
					<c:if test="${d.success == true}"><span style="color:#7DD43B;">部署成功</span></c:if>
					<c:if test="${d.success == false}"><span style="color:#E82734;">部署失败</span>
						<a href="<%=basePath %>new/act/report_deploy/${d.id}">(错误报告)</a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</c:if>
	<c:if test="${empty data}">
		<td>&nbsp;&nbsp;</td>
		<td colspan="3">暂无符合条件的结果</td>
	</c:if>
</table>
<footer class="page-footer1" style="margin-top: 40px;">
	<button type="button" class="btn red-btn tj-btn">
		关闭
	</button>
</footer>
	<script type="text/javascript">
		$(".tj-btn").click(function(){
			location.reload();
		})
	</script>
</html>