<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新闻系统 - 编辑管理页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
 <!-- 框架结构：上、中(左边、右边)、下 -->
	<frameset rows="72,*,70" cols="*" frameborder="no">
	  <frame src="header2.jsp" name="topframe" scrolling="no">
	  <frameset cols="180,*" frameborder="no">
		<frame src="adminMenu.jsp" noresize name="menu" scrolling="no">
		<frame src="welcome.jsp" noresize name="main" scrolling="auto">
	  </frameset>
	  <frame src="footer2.jsp" name="bottomframe" scrolling="no">
	</frameset>
	
	<!-- 对不支持Frame框架的浏览器，设置提示信息 -->
	<noframes>
		<body>您的浏览器不支持框架！</body>
	</noframes>
</html>
