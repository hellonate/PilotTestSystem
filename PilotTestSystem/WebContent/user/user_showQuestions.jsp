<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.Bean.Topic"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/bootstrap.css" />
		<script type="text/javascript" src="js/jquery-2.1.1.js" ></script>
	 	<script type="text/javascript" src="js/bootstrap.js" ></script>
	<script>
			var i=0;
			function add(i){
				$(".progress-bar").css("width",i+"%").html(i+"%");
			}
			//创建一个累加方法
			function leijia(){
				if (i>100) {
					$(".tip").html("考试完成").fadeIn("slow");
					return;
				} else{
					setTimeout("leijia()",100)
					add(i);
		    		i++;
					}
			}
			$(document).ready(function(){	
				leijia();
			});
		</script>
		
		<script>
		$(function(){
			$("#next_topic").click(function(){
			if ( ($("input:radio[name='options']:checked")).length==0 ) {
					alert("请答题!");
			}
			/*else{
				$.post("/PilotTestSystem/UserExamTestServlet?param=next",{
					value:$("input:radio[name='options']:checked").val()
				})
			}*/
			});
			
		})
		</script>
<style type="text/css">
.user_mid{
	position: absolute;
	width:100%;
	height: 650px;
	background-color: #31B0D5;
}
/** 接下来是mid_top以及里面的样式**/
.mid_top{
	position:absolute;
	width:1000px;
	height:80px;
	left:200px;
}
.mid_top .label{
position:absolute;
width: 40px;
height: 20px;
top:50px;
}

.mid_top .panel{
position:absolute;
width:170px;
top:40px;
height:40px;
left:50px;
z-index:11;
}
/** 接下来是inner里面的样式**/
.mid_inner{
	position:absolute;
	width:1000px;
	height:500px;
	top:80px;
	left:200px;	
	background:#FFFFFF;
}
.inner_top{
	position: absolute;
	width: 100%;
	height:40px;
	background-color:#DFF0D8;
}
.list-group{
position: absolute;
float:left;
bottom:-20px;
left:60px;
z-index:10;
}

.btn{
position:absolute;
bottom:0px;
left:895px;
}
.DoWork{
position:absolute;
width:800px;
height:300px;
left:105px;
top:60px;
z-index:20;
background-color: #ccc;

}
.Question{
position:absolute;
width:600px;
height:40px;
left:200px;
z-index:20;
}
#quesion{
	position: absolute; 
	height:40px;
	margin-left:200px;
	width:500px;
}
#Answer{
position:relative;
width:60%;
height:200px;
top:50px;
margin-left:-800px;
background-color: #ffffff;
}
</style>
    </head>
    <body>
    <% Topic topic=(Topic)request.getAttribute("topic"); 
       String isLast = (String) request.getAttribute("isLast");
    %>
    	<div class="user_mid">
    		<div class="mid_top">
    			<span class="label label-warning" >警告:</span>
    			<div class="panel panel-default">
		    		<div class="panel-footer">一经提交，不可更改!</div>
				</div>
		
    		</div>
    		<div class="mid_inner">
    			 <div class="inner_top" >
    				<div class="progress progress-striped active " style="position:absolute;width: 500px;left:200px;top:10px;">
						<div class="progress-bar" style="width:60%">
						</div>
					</div>
    			</div> 

		<%if(isLast.equals("true")){%>
		
		<form action="<%=request.getContextPath() %>/UserExamTestServlet?param=submit" method="post">
    	<%} else{%>
		<form action="<%=request.getContextPath() %>/UserExamTestServlet?param=next" method="post">
		<%} %>
		<div class="DoWork">
					
					<div class="Question">
					  <h4 id="question" style="left:400px;"><%=request.getAttribute("num") %>:
					  <%=topic.getQuestion() %> </h4>
					</div>
			
			
			<% if(topic.getType().equals("choice")){ %>
				
				<div class="btn-group" data-toggle="buttons" id="Answer"> 
				    <label class="btn btn-default btn-lg btn-block"  style="height: 40px">
				        <input type="radio" name="options" id="option1" value="A">
				        <%=topic.getOptionA() %>
				    </label>
				    <label class="btn btn-default btn-lg btn-block"  style="height: 40px;top:5px;">
				       <input type="radio" name="options" id="option2" value="B">
				         <%=topic.getOptionB() %>
				    </label>
				     <label class="btn btn-default btn-lg btn-block"  style="height: 40px;top:5px;">
				        <input type="radio" name="options" id="option3" value="C">
				       <%=topic.getOptionC() %>
				    </label>
				    <label class="btn btn-default btn-lg btn-block"  style="height: 40px;top:5px;">
				        <input type="radio" name="options" id="option4" value="D">
				         <%=topic.getOptionD() %>
				    </label>
				 </div>
					
			<%	}else if(topic.getType().equals("judge")){ %>
					
				<div class="btn-group" data-toggle="buttons" id="Answer"> 
				    <label class="btn btn-default btn-lg btn-block"  style="height: 40px">
				        <input type="radio" name="options" id="option1" value="true">
				        正确
				    </label>
				    <label class="btn btn-default btn-lg btn-block"  style="height: 40px;top:5px;">
				       <input type="radio" name="options" id="option2" value="false">
				         错误
				    </label>
				 </div>
					
			<% 	} %>
			
				 
		</div>
		
		<% if(isLast.equals("false")){ %>
		<button type="submit"   class="btn  btn-success"  id="next_topic" style="position: absolute;left:310px;top:430px;width:300px;height:30px;">
		下一题
		</button>
		<%}else{ %>
		<button type="submit"   class="btn  btn-success"  id="next_topic" style="position: absolute;left:310px;top:430px;width:300px;height:30px;">
		提交
		</button>
		<%} %>
		</form>			
				</div>
    			
    		
    		</div>
    
 	</body>
</html>
