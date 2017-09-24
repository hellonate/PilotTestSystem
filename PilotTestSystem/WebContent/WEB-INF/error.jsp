<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		
		<link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery-2.1.1.js"></script>
        <script src="js/bootstrap.min.js"></script>
		
	</head>
	
	<style type="text/css">
	    .middle{
	        position: absolute;
	        width: 100%;
	        height: 600px;
	        top: 40px;
	        /*background:   -webkit-gradient(linear,  left  top,  right  bottom,color-stop(0%,#5BC0DE),  color-stop(33%,#C4E3F3),  color-stop(69%,#A6E1EC),  color-stop(100%,#31B0D5));*/
       }
       
       .middle .wrong{
       	position: absolute;
       	width: 50%;
       	height: 50%;
       	/*background-color: #000000;*/
       	margin: 150px 360px auto 400px;
       }
       
       .middle .word{
       	position: absolute;
       	width: 50%;
       	height: 50%;
       	/*background-color: #000000;*/
       	margin: 230px 360px auto 360px;
       }
	
		
	</style>
	
	<body>
		<div class="middle">
			<div class="wrong">
				<img src="img/error.gif" />
			</div>
			<div class="word" align="center">
				<h3>¥ÌŒÛ–≈œ¢£∫</h3>
				<br>
				<h5><%=request.getAttribute("errorMessage") %></h5>
			</div>
	   </div>
	</body>
</html>

