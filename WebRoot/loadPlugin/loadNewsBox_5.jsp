<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div id="qiche_pindao">
	<!-- 汽车频道 -->
</div>
<script type="text/javascript">
	$(function(){
		LoadHomePubGroupDiv_5();
	});
	
	function LoadHomePubGroupDiv_5() {
		$("#qiche_pindao").load("LoadNewsBoxAction?state=1&newsTypeId=5&page=1&size=8", {});
	}
</script>