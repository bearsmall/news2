<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新闻系统 - 菜单栏</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<link href="css/admin.css" rel="stylesheet" type="text/css" />

  </head>
  
 	<body>
		<div class="menu">
			<ul class="c1 ico3">
                <li><a href="createNews.jsp" target="main">创建新闻</a></li>
                <li><a href="ShowNewsAction?page=1&size=5" target="main">我的新闻</a></li>
			</ul>
		</div>
	</body>
</html>
