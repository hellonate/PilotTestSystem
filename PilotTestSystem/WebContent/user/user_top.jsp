<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="../css/my.css" />
		<link rel="stylesheet" href="../css/bootstrap.css" />
		<script type="text/javascript" src="../js/jquery-2.1.1.js" ></script>
		<script type="text/javascript" src="../js/bootstrap.js" ></script>
<style type="text/css">
.user_top_nav {
	position: absolute;
	left: 400px;
	top: 30px;
}

.exit {
	position: absolute;
	left: 70%;
	top: 50px;
}
</style>
</head>
	<body>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span12">
					<div class="top">
							<div class="user_top_nav">
								<ul class="nav nav-tabs">
								    <li class="active">
								        <a href="user_welcome.html" target="umidFrame">首页</a></li>
								    <li>
								        <a href="../UserInfoServlet" target="umidFrame">个人信息</a></li>
								    <li>
								        <a href="user_examTest.jsp" target="umidFrame">在线考试</a></li>
								    <li>
								        <a href="../UserErrorTopicsServlet?param=chapter" target="umidFrame">错题库</a></li>
								</ul>
					
							</div>

					<div class="exit">
						<ul>
							<li><a href="../ExitServlet?" target="allFrame">退出</a></li>
						</ul>
					</div>
				</div>
			
				</div>
			
		</div>
	</div>
	</body>
</html>






