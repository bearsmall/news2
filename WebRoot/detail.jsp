<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新闻系统 - 新闻详情页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
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
					<strong>当前位置:</strong> 主页 &gt; 文章查看
				</div>

				<div class="viewbox">
					<div class="title">
						<h2>
							人无完人，但要注意怎么做人
						</h2>
					</div>
					<div class="info">
						<small>时间:</small>2010-09-07
						<small>来源:</small>asdads
						<small>作者:</small>asd
						<small>点击:</small>13次
					</div>
					<div class="content">
						人无完人，但要注意怎么做人云中芳草 一个人——
						穷一点可以，但人穷志不能穷！不要成为了人穷志短的人，要勇闯世界，做不了顶天立地的人,最起码要做个有用的人，做个对得起自己的人。
						丑一点可以，但人丑心不能丑！仁慈善良不在乎一个人的外表，只在乎人的内心！
						瘦小一点可以，但人小心不能小！任何一个人都不会喜欢一个小心眼的人。敞开心扉，宅心仁厚总能让人倍感安慰。
						脆弱一点可以，但人脆弱内心不能懦弱！懦弱的人总是自悲的，所以，一定要有勇气、有主见、有自信！
						眼睛瞎一点可以，但眼瞎心不能瞎！要心知肚明，要有远见！
						有一点野心可以，但人不能野。不要为了野心把自己变成为魔鬼！否则，你不入地狱，谁入地狱？
						笨一点可以，但学习是不论早晚的，只要肯学，相信一点一点的，没有学不会的，就怕你不学！
						聪明一点可以，但不要自以为聪明！否则，要么你是个傻瓜，要么全世界的人都是傻瓜。
						糊涂一点可以，但不要糊涂一时。最难得的还是“聪明一时，糊涂一世”的人！
						懒一点可以，但不能一直懒惰下去。该做的还得要做，并且还要做好，多少都要付出一些，否则，就是一条十足的寄生虫。
						省一点可以，但是检省不是守财，否则，会为了金钱而扭曲一个人的人格，会成为一个守财奴。要知道，往往会花钱的人，更会赚钱！
						讲究一点可以，但是讲究不是奢侈，讲究要有分寸，不要因为讲究让平凡的生活变了质。
						宽容一点可以，但宽容不是放纵！再宽容也要有尊严，有辱人格尊严的，决不能宽容！
						有点脾气可以，但有脾气不等于有实力。要学会沉默，储蓄知识财富，做个真正有个性、有脾气的人。不在沉默中爆发，就在沉默中灭亡！
						苦一点可以，但吃苦时不能怕苦，苦尽甘来！吃得苦中苦，方为人上人！
					</div>
					
				</div>
				<!-- viewbox end -->

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
