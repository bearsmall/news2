<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新闻系统 - 登录页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta name="description" content="软酷新闻发布系统" />
	<meta name="keywords" content="软酷网 新闻发布" />
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript">
		function check(){
			//获取输入信息：用户名、密码。“.value”即获取此元素的值。
			var name = document.getElementById("name").value;
			var password = document.getElementById("password").value;

			//验证用户名不为空
			if (name == "") {
 				// 在页面弹出提示框
 				alert("请填写用户名！"); 
 				// 返回false，阻止表单提交
		 		return false;
	 		}

			if (password == "") {
	 			alert("请填写密码！"); 
	 			return false;
	 		}
		}
		</script>
	</head>

	<body>
		<!-- header start -->
		
		<!-- header end -->

		<!-- menu start -->
			<jsp:include page="commons/head.jsp"></jsp:include>
		<!-- menu end -->

		<!-- main start -->
		<div class="main">
			<form action="LoginAction" method="post">
				<div class="register_main">
					<table>
						<tr>
							<td width="60">
								用户名：
							</td>
							<td width="180">
								<!-- 为元素定义id属性，可通过document对象访问 -->
								<input type="text" name="user.name" id="name" value="" />
							</td>
							<td width="220"></td>
						</tr>

						<tr>
							<td>
								密&nbsp;&nbsp;&nbsp;码：
							</td>
							<td>
								<input type="password" name="user.password" id="password" value="" />
							</td>
							<td></td>
						</tr>

						<tr>
							<td colspan="3">
								<!-- 此处显示提示信息 -->
							</td>
						</tr>

						<tr>
							<td colspan="3">
								<!-- 为提交按钮设置onclick事件，当点击鼠标时，会触发调用JavaScript
								函数，进行表单验证，通过return将函数的结果返回，以阻止表单验证失败后提交-->
								<input type="submit" value="登录" class="button" onclick="return check()"/>
							</td>
						</tr>
					</table>
				</div>
			</form>
		</div>
		<!-- main end -->

		<!-- footer start -->
		<div class="footer">
			<p>Copyright&nbsp;&copy;&nbsp;软酷卓越实验室&nbsp;<a href="http://www.ruanko.com" title="软酷网" target="_blank"><strong>软酷网</strong></a>&nbsp;版权所有</p>
		</div>
		<!-- footer end -->
	</body>
</html>