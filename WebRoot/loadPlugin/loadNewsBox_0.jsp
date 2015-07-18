<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div id="guoji_xinwen">
	<!-- 国际新闻  -->
</div>
<script type="text/javascript">
	$(function(){
		LoadHomePubGroupDiv_0();
	});
	
	function LoadHomePubGroupDiv_0() {
		$("#guoji_xinwen").load("LoadNewsBoxAction?state=1&newsTypeId=0&page=1&size=8", {});
	}
</script>