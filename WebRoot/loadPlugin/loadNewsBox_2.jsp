<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div id="yule_xinwen">
	<!-- 娱乐新闻  -->
</div>
<script type="text/javascript">
	$(function(){
		LoadHomePubGroupDiv_2();
	});
	
	function LoadHomePubGroupDiv_2() {
		$("#yule_xinwen").load("LoadNewsBoxAction?state=1&newsTypeId=2&page=1&size=8", {});
	}
</script>