<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新闻系统 - 首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="description" content="软酷新闻发布系统" />
	<meta name="keywords" content="软酷网 新闻发布" />
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script  src="js/jquery1.8.3.js"></script>
  </head>
  
  <body>
		<!-- header start -->
		
		<!-- header end -->

		<!-- menu start -->
			<jsp:include page="commons/head.jsp"></jsp:include>
		<!-- menu end -->

		<!-- main start -->
		<div class="main">
			<!-- left start -->
			<div class="left">
				<dl class="tbox">
					<dt>
						<strong><a href="ShowNewsTypeAction?state=1&newsTypeId=0&page=1&size=10"><span>国际新闻</span> </a></strong><span
							class="more"><a href="ShowNewsTypeAction?state=1&newsTypeId=0&page=1&size=10">更多...</a> </span>
					</dt>
					<jsp:include page="loadPlugin/loadNewsBox_0.jsp"></jsp:include>
				</dl>

				<dl class="tbox">
					<dt>
						<strong><a href="ShowNewsTypeAction?state=1&newsTypeId=1&page=1&size=10">国内新闻</a> </strong><span
							class="more"><a href="ShowNewsTypeAction?state=1&newsTypeId=1&page=1&size=10">更多...</a> </span>
					</dt>
					<jsp:include page="loadPlugin/loadNewsBox_1.jsp"></jsp:include>
				</dl>

				<dl class="tbox">
					<dt>
						<strong><a href="ShowNewsTypeAction?state=1&newsTypeId=2&page=1&size=10">娱乐新闻</a> </strong><span
							class="more"><a href="ShowNewsTypeAction?state=1&newsTypeId=2&page=1&size=10">更多...</a> </span>
					</dt>
					<jsp:include page="loadPlugin/loadNewsBox_2.jsp"></jsp:include>
				</dl>

				<dl class="tbox">
					<dt>
						<strong><a href="ShowNewsTypeAction?state=1&newsTypeId=3&page=1&size=10">体育新闻</a> </strong><span
							class="more"><a href="ShowNewsTypeAction?state=1&newsTypeId=3&page=1&size=10">更多...</a> </span>
					</dt>
					<jsp:include page="loadPlugin/loadNewsBox_3.jsp"></jsp:include>
				</dl>

				<dl class="tbox">
					<dt>
						<strong><a href="ShowNewsTypeAction?state=1&newsTypeId=4&page=1&size=10">财经频道</a> </strong><span
							class="more"><a href="ShowNewsTypeAction?state=1&newsTypeId=4&page=1&size=10">更多...</a> </span>
					</dt>
					<jsp:include page="loadPlugin/loadNewsBox_4.jsp"></jsp:include>
				</dl>

				<dl class="tbox">
					<dt>
						<strong><a href="ShowNewsTypeAction?state=1&newsTypeId=5&page=1&size=10">汽车频道</a> </strong><span
							class="more"><a href="ShowNewsTypeAction?state=1&newsTypeId=5&page=1&size=10">更多...</a> </span>
					</dt>
					<jsp:include page="loadPlugin/loadNewsBox_5.jsp"></jsp:include>
				</dl>
			</div>
			<!-- left end -->

			<!-- right start -->
			<div class="right">
				<dl class="tbox">
					<dt>
						<strong>最新更新</strong>
					</dt>
					<dd>
						<ul class="ico1">
							<li>
								<a href="detail.jsp">你所不知道的白岩松</a>
							</li>
							<li>
								<a href="detail.jsp">你所不知道的白岩松</a>
							</li>
							<li>
								<a href="detail.jsp">你所不知道的白岩松</a>
							</li>
							<li>
								<a href="detail.jsp">你所不知道的白岩松</a>
							</li>
							<li>
								<a href="detail.jsp">你所不知道的白岩松</a>
							</li>

						</ul>
					</dd>
				</dl>

				<dl class="tbox">
					<dt>
						<strong>热点内容</strong>
					</dt>
					<dd>
						<jsp:include page="loadPlugin/loadHotNewsBox.jsp"></jsp:include>
					</dd>
				</dl>
			</div>
			<!-- right end -->
		</div>
		<!-- main end -->

		<!-- footer start -->
			<jsp:include page="commons/foot.jsp"></jsp:include>
		<!-- footer end -->
	</body>
</html>
