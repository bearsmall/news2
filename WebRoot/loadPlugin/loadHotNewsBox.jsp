<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div id="hotNews">
	<!-- 国际新闻  -->
</div>
<script type="text/javascript">
	$(function(){
		LoadHomePubHotDiv();
	});
	
	function LoadHomePubHotDiv() {
		$("#hotNews").load("LoadHotNewsBoxAction?state=1&page=1&size=12", {});
	}
</script>