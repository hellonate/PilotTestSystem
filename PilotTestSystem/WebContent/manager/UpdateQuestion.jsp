<%@page import="com.Bean.Topic"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
	<link href="css/bootstrap.css" rel="stylesheet">
        <script src="js/jquery-2.1.1.js"></script>
        <script src="js/bootstrap.js"></script>
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
			width: 600px;
			height:650px;
			background-color: white;
			top: -18px;
			left: 400px;
			z-index: 10;
			
            /*圆角边框*/
            /*border-radius:15px;*/ 
            border-radius:100px 0px 100px 0px;
            
            /*投影*/
            box-shadow: 3px 3px 3px;
            
		}
		
		.middle .create .head{
			text-align: center;
			position: absolute;
			width:580px;
			height: 10%;
			/*background-color: #269ABC;*/
			top: auto;
			left: 10px;
			z-index: 10;	
		}
		
		.middle .create .body{
			text-align: center;
			position: absolute;
			width: 500px;
			height: 85%;
			/*background-color: #31B0D5;*/
			top: 10%;
			left: 30px;
			z-index: 10;
		}
		
		.middle .create .foot{
			text-align: center;
			position: absolute;
			width: 580px;
			height: 5%;
			/*background-color: #AC2925;*/
			top:93%;
			left: 10px;
			z-index: 10;
		}
	</style>
	<% Topic topic=(Topic)request.getAttribute("topic"); %>
	<body>
		<div class="middle">
		<form action="DealQuestionServlet?param=update" method="post">
	        <div class="create">
	    	    <div class="head">
	    		    <button  type="reset" class="close">x</button>
                    <h3>添加试题</h3>
	    	    </div>
	    	    <div class="body">
                <table class="table table-striped">
                	<thead>
                		<tr>
			                <th>ID</th>
			                <th><input type="text" readonly="true" value="<%=topic.getId() %>" name="id" style="width: 410px;"/></th>
		                </tr>
		                <tr>
			                <th>题目问题</th>
			                <th><input type="text" value="<%=topic.getQuestion() %>" name="question" style="width: 410px;"/></th>
		                </tr>
		                <tr>
			                <th>试题答案</th>
			                <th><input type="text" value="<%=topic.getAnswer() %>" name="answer" style="width: 410px;"/></th>
		                </tr>
		                <tr>
			                <th>题目类型</th>
			                <th><input type="text"  value="<%=topic.getType() %>" name="type" style="width: 410px;"/></th>
		                </tr>
		                <tr>
			                <th>题目分值</th>
			                <th><input type="text" value="<%=topic.getScore()%>"   name="score" style="width: 410px;"/></th>
		                </tr>
		                <tr>
			                <th>chapterID</th>
			                <th><input type="text" value="<%=topic.getChapterId()%>"  name="chapterId" style="width: 410px;"/></th>
		                </tr>
		                <tr>
			                <th>chapterName</th>
			                <th><input type="text"  value="<%=topic.getChapterName()%>" name="chapterName" style="width: 410px;"/></th>
		                </tr>
		                <tr>
			                <th>sectionName</th>
			                <th><input type="text" value="<%=topic.getSectionName()%>"  name="sectionName" style="width: 410px;"/></th>
		                </tr>
		                <tr>
			                <th>optionA</th>
			                <th><input type="text" value="<%=topic.getOptionA()%>"  name="optionA" style="width: 410px;"/></th>
		                </tr>
		                <tr>
			                <th>optionB</th>
			                <th><input type="text" value="<%=topic.getOptionB()%>"  name="optionB" style="width: 410px;"/></th>
		                </tr>
		                <tr>
			                <th>optionC</th>
			                <th><input type="text"  value="<%=topic.getOptionC()%>" name="optionC" style="width: 410px;"/></th>
		                </tr>
		                <tr>
			                <th>optionD</th>
			                <th><input type="text"  value="<%=topic.getOptionD()%>" name="optionD" style="width: 410px;"/></th>
		                </tr>
                	</thead>
                </table>
	    	</div>
	    	<div class="foot">
	    		 <button type="submit"  class="btn btn-primary" style="text-shadow: black 5px 3px 3px;" value="submit">提交</button>
	    	</div>
	        </div>
	        </form>
	    </div>	
	</body>
</html>






