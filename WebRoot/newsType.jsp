<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新闻系统 - 栏目新闻列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta name="description" content="软酷新闻发布系统" />
	<meta name="keywords" content="软酷网 新闻发布" />
	<link href="css/style.css" rel="stylesheet" type="text/css" />

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
				<div class="place">
					<strong>当前位置:</strong> 主页 &gt; 文章列表
				</div>
				<!-- place end -->
				<ul class="newslist">

					<li>
						<a href="detail.jsp" class="title">人无完人，但要注意怎么做人</a>
						<small>日期：</small>2010-09-07
						<small>点击：</small>3
					</li>

					<li>
						<a href="detail.jsp" class="title">人无完人，但要注意怎么做人</a>
						<small>日期：</small>2010-09-07
						<small>点击：</small>3
					</li>

					<li>
						<a href="detail.jsp" class="title">人无完人，但要注意怎么做人</a>
						<small>日期：</small>2010-09-07
						<small>点击：</small>3
					</li>

					<li>
						<a href="detail.jsp" class="title">人无完人，但要注意怎么做人</a>
						<small>日期：</small>2010-09-07
						<small>点击：</small>3
					</li>

					<li>
						<a href="detail.jsp" class="title">人无完人，但要注意怎么做人</a>
						<small>日期：</small>2010-09-07
						<small>点击：</small>3
					</li>

					<li>
						<a href="detail.jsp" class="title">人无完人，但要注意怎么做人</a>
						<small>日期：</small>2010-09-07
						<small>点击：</small>3
					</li>

					<li>
						<a href="detail.jsp" class="title">人无完人，但要注意怎么做人</a>
						<small>日期：</small>2010-09-07
						<small>点击：</small>3
					</li>

					<li>
						<a href="detail.jsp" class="title">人无完人，但要注意怎么做人</a>
						<small>日期：</small>2010-09-07
						<small>点击：</small>3
					</li>

					<li>
						<a href="detail.jsp" class="title">人无完人，但要注意怎么做人</a>
						<small>日期：</small>2010-09-07
						<small>点击：</small>3
					</li>

					<li>
						<a href="detail.jsp" class="title">人无完人，但要注意怎么做人</a>
						<small>日期：</small>2010-09-07
						<small>点击：</small>3
					</li>
				</ul>
				<!-- newslist end -->
				
				<ul class="pagelist">
					<li>
						<a href='index.jsp'>首页</a>
					</li>
					<li>
						<a href='#'>上一页</a>
					</li>
					<li>
						<a href='#'>下一页</a>
					</li>
					<li>
						<a href='#'>末页</a>
					</li>
					<li>
						<span class="pageinfo">
						现在是第<strong>2</strong>页,
						共 <strong>2</strong>页
						<strong>13</strong>条</span>
					</li>
				</ul>
				<!-- pagelist end -->
				
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
								<a href="#">你所不知道的白岩松</a>
							</li>
							<li>
								<a href="#">你所不知道的白岩松</a>
							</li>
							<li>
								<a href="#">你所不知道的白岩松</a>
							</li>
							<li>
								<a href="#">你所不知道的白岩松</a>
							</li>
							<li>
								<a href="#">你所不知道的白岩松</a>
							</li>

						</ul>
					</dd>
				</dl>

				<dl class="tbox">
					<dt>
						<strong>热点内容</strong>
					</dt>
					<dd>
						<ul class="ico2">
							<li>
								<a href="#">教师节，那些代课老师们</a>
							</li>
							<li>
								<a href="#">十堰他日必大兴</a>
							</li>
							<li>
								<a href="#">城市千金，我要远离农村婆婆</a>
							</li>
							<li>
								<a href="#">你所不知道的白岩松</a>
							</li>
							<li>
								<a href="#">菲律宾总统再次将香港旅客被劫杀惨剧当笑料</a>
							</li>
							<li>
								<a href="#">十堰他日必大兴</a>
							</li>
							<li>
								<a href="#">十堰他日必大兴</a>
							</li>
							<li>
								<a href="#">你所不知道的白岩松</a>
							</li>
							<li>
								<a href="#">你所不知道的白岩松</a>
							</li>
							<li>
								<a href="#">你所不知道的白岩松</a>
							</li>
						</ul>
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
