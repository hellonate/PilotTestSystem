<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
 <link href="../css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="../js/jquery-2.1.1.js" ></script>
</head>
<style type="text/css">
	    .middle{
	        position: absolute;
	        width: 100%;
	        height: 600px;
	        background:   -webkit-gradient(linear,  left  top,  right  bottom,color-stop(0%,#5BC0DE),  color-stop(33%,#C4E3F3),  color-stop(69%,#A6E1EC),  color-stop(100%,#31B0D5));
       }
	
		.middle .create{
			position: absolute;
			width: 740px;
			height:400px;
			background-color: white;
			top: 80px;
			left: 350px;
			z-index: 10;
			
			/*圆角边框*/
            /*border-radius:15px;*/ 
            border-radius:50px 0px 50px 0px;
            
            /*投影*/
            box-shadow: 3px 3px 3px;
			
		}
		
		.middle .create .head{
			text-align: center;
			position: absolute;
			width:720px;
			height: 20%;
			/*background-color: #269ABC;*/
			top: auto;
			left: 10px;
			z-index: 10;
			
		}
		
		
		.middle .create .body{
			position: absolute;
			width: 720px;
			height: 60%;
			/*background-color: #31B0D5;*/
			top: 20%;
			left: 10px;
			z-index: 10;
		}
		
		.middle .create .foot{
			text-align: right;
			position: absolute;
			width: 720px;
			height: 20%;
			/*background-color: #AC2925;*/
			top: 80%;
			left: 10px;
			z-index: 10;
		}
	</style>
	<%request.setCharacterEncoding("utf-8");%>
<body>
		<div class="middle">
	    <div class="create">
	    	
	    	<div class="head">
	    		<button type="reset" class="close">x</button>
                <h3>建立自主测试</h3>
	    	</div>
	    	<div class="body">
	    		<form action="<%=request.getContextPath() %>/UserExamTestServlet?param=create" method="post" >
	    		<table class="table table-striped">
	                    <thead>
		                    <tr>
			                    <th>选择测试章节:</th>
			                    <th><input type="checkbox" name="chapterNames" value="第一章">第一章</th>
			                    <th><input type="checkbox" name="chapterNames" value="第二章">第二章</th>
			                    <th><input type="checkbox" name="chapterNames" value="第三章">第三章</th>
			                    <th><input type="checkbox" name="chapterNames" value="第四章">第四章</th>
			                    <th><input type="checkbox" name="chapterNames" value="第五章">第五章</th>
			                    <th><input type="checkbox" name="chapterNames" value="第六章">第六章</th>
			                    <th><input type="checkbox" name="chapterNames" value="第七章">第七章</th>
			                    <th><input type="checkbox" name="chapterNames" value="第八章">第八章</th>
		                    </tr>
	                    </thead>
                </table>
                <table class="table table-striped">
                	<thead>
                		<tr>
			                <th>选择测试题型:
			                	&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="type" value="choice">选择题
			                	&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="type" value="judge">判断题
			                </th>
		                </tr>
                	</thead>
                </table>
                <table class="table table-striped">
                	<thead>
                		<tr>
			                <th>定义测试时间:
			                	&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="duration" />
			                </th>
		                </tr>
                	</thead>
                </table>
                <table class="table table-striped">
                	<thead>
                		<tr>
			                <th>定义测试数目:
			                	&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="questionNum" />
			                </th>
		                </tr>
                	</thead>
                </table>
                </form>
	    	</div>
	    	<div class="foot">
	    		 <button  type="submit" class="btn btn-primary" style="text-shadow: black 5px 3px 3px;">建立测试</button>
	    	</div>
	    </div>
	    </div>
	</body>
</html>












