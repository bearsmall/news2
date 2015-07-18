<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新闻系统 - 注册页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta name="description" content="软酷新闻发布系统" />
	<meta name="keywords" content="软酷网 新闻发布" />
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript">
		function check(){
			//获取输入信息，“.value”即获取此元素的值。
			var name = document.getElementById("name").value;
			var password = document.getElementById("password").value;
			var password2 = document.getElementById("password2").value;

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
	 		
	 		if (password2 == "" || password2 != password) {
	 			alert("重复密码需要与密码保持一致！"); 
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
			<form action="RegisterAction" method="post">
				<div class="register_main">
					<table>
						<tr>
							<td width="80"> 用户名： </td>
							<td width="480">
								<input type="text" name="user.name" id="name" value="" />
							</td>
							<td align="left"></td>
						</tr>
						<tr>
							<td class="info" colspan="3">
								会员名须以字母开头，至少4位（可用字母、数字、下划线；建议用email作会员名）。
							</td>
						</tr>

						<tr>
							<td> 密码： </td>
							<td>
								<input type="password" name="user.password" id="password" value="" />
							</td>
							<td align="left"></td>
						</tr>
						<tr>
							<td class="info" colspan="3">
								密码设置请勿过于简单，至少6位；建议使用数字、字母混合排列，区分大小写。
							</td>
						</tr>
						<tr>
							<td> 重复密码： </td>
							<td>
								<input type="password" name="password2" id="password2" value="" />
							</td>
							<td align="left"></td>
						</tr>
						<tr>
							<td class="info" colspan="3">
								重复密码设置一定要与上边密码设置一致。
							</td>
						</tr>
						<tr>
							<td colspan="3">
								<!-- 此处显示提示信息 -->
							</td>
						</tr>
						<tr>
							<td colspan="3">
								<input type="submit" value="提交" class="button" onclick="return check()"/>
							</td>
						</tr>
					</table>
				</div>
			</form>
		</div>
		<!-- main end -->

		<!-- footer start -->
			<jsp:include page="commons/foot.jsp"></jsp:include>
		<!-- footer end -->
	</body>
</html>
