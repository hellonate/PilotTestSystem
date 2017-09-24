<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>管理员界面</title>
		<link rel="stylesheet" href="../css/bootstrap.css" />
		<link rel="stylesheet" href="../css/my.css" />
		<script type="text/javascript" src="../js/jquery-2.1.1.js" ></script>
		<script type="text/javascript" src="../js/bootstrap.js" ></script>
<script>
	$(function() {
		$("[data-toggle='popover']").popover();
	});
</script>
<style type="text/css">
.exit {
	position: absolute;
	left: 70%;
	top: 50px;
}

</style>
</head>
	<body>
		<div class="top">
					<div class="nav_top_pic"></div>
					<div class="user_top_nav">
								<ul class="nav nav-tabs" style="position: absolute;top:38px;left:500px">
								    <li >
								        <a href="../LoginServlet?user=1" target="midFrame">用户信息 </a></li>
								    <li>
								        <a href="../LoginServlet?exam=1" target="midFrame">考试管理</a></li>
								    <li>
								        <a href="../LoginServlet?param_=show_chapter" target="midFrame">章节管理</a></li>
								    <li>
								        <a href="../LoginServlet?page=1" target="midFrame">试题管理</a></li>
								</ul>
					</div>

		<div class="exit">
			<ul>
				<li><a href="../ExitServlet?" target="allFrame">退出</a></li>
			</ul>
		</div>
		
	</div>
	</body>
</html>






