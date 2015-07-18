<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新闻系统 - 预览新闻</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/admin.css" rel="stylesheet" media="screen"
			type="text/css" />

  </head>
  
  <body>
		<!-- newsInfor start -->
		<div class="viewbox">
			<div class="title">
				<h2>
					${news.title }
				</h2>
			</div>
			<!-- /title -->
			<div class="info">
				<small>时间:</small>${news.createTime }
				<small>来源:</small>${news.source }
				<small>作者:</small>${news.author }
				<small>点击:</small>${news.click }
			</div>
			<!-- /info -->
			<div class="vContent">
				${news.content }
			</div>
		</div>
		<!-- newsInfor end -->

		<!-- footer start -->
			<jsp:include page="commons/foot.jsp"></jsp:include>
		<!-- footer end -->
	</body>
</html>
