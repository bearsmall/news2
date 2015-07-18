<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新闻系统 — 新用户</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/admin.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body>
		<!-- header start -->
		<div class="header" style="height:55px">
			<div class="toplinks">
				您好：ruanko，欢迎使用新闻系统！
				<span>【<a href="index.jsp">返回首页</a>】【<a href="login.jsp">注销登录</a>】</span>
			</div>
			<h1>
				<a href="#" target="_top"><img src="images/logo.png" height="56"
						width="260" alt="新闻系统" /> </a>
			</h1>
		</div>
		<!-- header end -->

		<!-- main start -->
		<div class="content" style="width:98%;height:450px;">
			<p>
				欢迎使用新闻系统！
			</p>
		</div>
		<!-- main end -->

		<!-- footer start -->
			<jsp:include page="commons/foot.jsp"></jsp:include>
		<!-- footer end -->
	</body>
</html>
