<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
	    
	    <title>新闻系统 - 热点新闻列表</title>
	    
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta name="description" content="软酷新闻发布系统" />
		<meta name="keywords" content="软酷网 新闻发布" />
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<script>
			function preview(newsId) {
				window.location.href="PreviewNewsAction?newsId="+newsId;
			}
		</script>
	</head>
	
	<body>
		<ul class="ico2">
			<c:forEach items="${pageModel.list}" var="news" varStatus="status">
				<li>
					<a href="javascript:preview(${news.id })" class="title">${news.title }</a>
				</li>
			</c:forEach>
		</ul>
	</body>
</html>

