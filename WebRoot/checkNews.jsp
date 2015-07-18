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
    
    <title>新闻系统 - 审核新闻页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link href="css/admin.css" rel="stylesheet" media="screen" type="text/css" />
	<!-- 预览新闻时，使用JavaScript脚本打开新窗口显示信息 -->
	<script>
		function preview(newsId) {
			window.open("PreviewNewsAction?newsId="+newsId,'预览','resizable=no,toolbar=no,width=620,height=500,top=50,left=200');
		}
	</script>	
  </head>
  
  <body>
		<table>
			<tr bgcolor="#E7E7E7">
				<td height="24" colspan="6">
					&nbsp;审核新闻&nbsp;
				</td>
			</tr>
			<tr align="center" bgcolor="#F4F8FB" height="22">
				<td width="6%">
					序号
				</td>
				<td width="24%">
					文章标题
				</td>
				<td width="18%">
					录入时间
				</td>
				<td width="8%">
					栏目
				</td>
				<td width="6%">
					录入者
				</td>
				<td width="12%">
					操作
				</td>
			</tr>
			
			<c:forEach items="${pageModel.list}" var="news" varStatus="status">
				<tr align='center' height="22">
					<td>${(page-1)*5+status.index+1 }</td>
					<td align="left">
						<a href="javascript:preview(${news.id })">${news.title }</a>
					</td>
					<td>${news.createTime }</td>
					<td>${news.newsType }</td>
					<td>${news.author }</td>	
					<td>
						<a href="CheckNewsAction?newsId=${news.id }&state=1&page=${page}&size=${size}" target="main">通过</a> | 
						<a href="CheckNewsAction?newsId=${news.id }&state=2&page=${page}&size=${size}" target="main">不通过</a>
					</td>
				</tr>	
			</c:forEach>

			<tr>
				<td height="24" colspan="6">
					&nbsp;
				</td>
			</tr>			
			<tr bgcolor="#F4F8FB">
				<td colspan="9" align="right" style="padding:0 52px;">
					现在是第${pageModel.page }页，共${pageModel.totalPage }页
					${pageModel.totalCount }条记录&nbsp;&nbsp;
					<a href="ShowCheckNewsAction?state=0&page=1&size=${pageModel.size}">首页</a>
					<a href="ShowCheckNewsAction?state=0&page=${pageModel.pre}&size=${pageModel.size}">上一页</a>" 
					<a href="ShowCheckNewsAction?state=0&page=${pageModel.next}&size=${pageModel.size}">下一页</a>"
					<a href="ShowCheckNewsAction?state=0&page=${pageModel.totalPage}&size=${pageModel.size}">末页</a>"
				</td>
			</tr>
		</table>
	</body>
</html>
