<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div id="tiyu_xinwen">
	<!-- 体育新闻  -->
</div>
<script type="text/javascript">
	$(function(){
		LoadHomePubGroupDiv_3();
	});
	
	function LoadHomePubGroupDiv_3() {
		$("#tiyu_xinwen").load("LoadNewsBoxAction?state=1&newsTypeId=3&page=1&size=8", {});
	}
</script>