<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div id="caijin_pingdao">
	<!-- 财经频道 -->
</div>
<script type="text/javascript">
	$(function(){
		LoadHomePubGroupDiv_4();
	});
	
	function LoadHomePubGroupDiv_4() {
		$("#caijin_pingdao").load("LoadNewsBoxAction?state=1&newsTypeId=4&page=1&size=8", {});
	}
</script>