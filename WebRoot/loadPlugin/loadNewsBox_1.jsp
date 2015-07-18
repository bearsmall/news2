<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div id="guonei_xinwen">
	<!-- 国内新闻  -->
</div>
<script type="text/javascript">
	$(function(){
		LoadHomePubGroupDiv_1();
	});
	
	function LoadHomePubGroupDiv_1() {
		$("#guonei_xinwen").load("LoadNewsBoxAction?state=1&newsTypeId=1&page=1&size=8", {});
	}
</script>