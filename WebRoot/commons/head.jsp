<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript">
	function submit(){
		var key = document.getElementById("search-keyword").value;
		window.location.href="SearchNewsAction?state=1&key="+key+"&page=1&size=10";
	}
</script>
<div class="header">
	<div class="toplinks">
		<span>【<a href="register.jsp">注册</a>】【<a href="login.jsp">登录</a>】</span>
	</div>
	<div>		
		<h1>
			<img src="http://qr.liantu.com/api.php?text=<%=basePath %>&w=70&m=0"/>
		</h1>
	</div>
	<div>
		<h1>
			<a href="index.jsp"><img src="images/logo.png" width="300" height="70"
					alt="新闻系统" /> </a>
		</h1>
	</div>
</div>
<div class="menu">
	<ul>
		<li>
			<a href="index.jsp"><span>主页</span> </a>
		</li>

		<li>
			<a href="ShowNewsTypeAction?state=1&newsTypeId=0&page=1&size=10"><span>国际新闻</span> </a>
		</li>

		<li>
			<a href="ShowNewsTypeAction?state=1&newsTypeId=1&page=1&size=10"><span>国内新闻</span> </a>
		</li>

		<li>
			<a href="ShowNewsTypeAction?state=1&newsTypeId=2&page=1&size=10"><span>娱乐新闻</span> </a>
		</li>

		<li>
			<a href="ShowNewsTypeAction?state=1&newsTypeId=3&page=1&size=10"><span>体育新闻</span> </a>
		</li>

		<li>
			<a href="ShowNewsTypeAction?state=1&newsTypeId=4&page=1&size=10"><span>财经频道</span> </a>
		</li>

		<li>
			<a href="ShowNewsTypeAction?state=1&newsTypeId=5&page=1&size=10"><span>汽车频道</span> </a>
		</li>

		<li>
			<a href="ShowNewsTypeAction?state=1&newsTypeId=6&page=1&size=10"><span>电子频道</span> </a>
		</li>
	</ul>
	<hr>
	<hr>
	<hr>
	<hr>
	<input name="key" type="text" class="search-keyword"
		id="search-keyword" value="" />
	<input type="button" class="search-submit" value="搜索" onclick="submit()"/>
</div>