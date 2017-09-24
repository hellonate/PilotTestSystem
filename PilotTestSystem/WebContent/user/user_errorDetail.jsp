<%@page import="java.util.ArrayList" import="com.Bean.Topic"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
	
		<link rel="stylesheet" href="css/my.css" />
		<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	    <link rel="stylesheet" href="css/bootstrap.css" />
	     <script src="../jquery/jquery-2.1.1.js"></script>
	      <script src="../jquery/jquery-2.1.1.js"></script>
	   <!--  <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
    </head>
    
    <style type="text/css">
    	.middle{
	        position: absolute;
	        width: 100%;
	        height: 600px;
	       /*  top: 88px; */
	        /*background-image: url(../img/bg_4.jpg);
	        background-repeat: no-repeat;
	        background-size: cover;*/
	        /*background-color: #A6E1EC;*/
	        background:   -webkit-gradient(linear,  left  top,  right  bottom,color-stop(0%,#5BC0DE),  color-stop(33%,#C4E3F3),  color-stop(69%,#A6E1EC),  color-stop(100%,#31B0D5));
        }

        .middle .information{
	        position: absolute;
	        width: 70%;
	        height: 500px;
	        top: 70px;
	        left: 216px;
	        /*background-color:#000000 ;*/
	        z-index: 10;
        }
        
        .middle .information .midbgcolor{
	        position: absolute;
	        width: 100%;
	        height: 500px;
	        top: auto;
	        left: auto;
	        background-color: white;
	        z-index: 5;	
        } 
        
       

    </style>
    
    <script type="text/javascript">
	$(function(){
		removeSection = function(e) {
			$(e).parents(".section").remove();
			$('[data-spy="scroll"]').each(function () {
				var $spy = $(this).scrollspy('refresh')
				});
		}
		$("#myScrollspy").scrollspy();
    });
    </script>
    
        <script type="text/javascript">
	$(function(){
		alert("fuck");
    });
    </script>
	<body>
		<!--页面中部-->
		<div class="middle">
			
			<div class="information">
				<div class="midbgcolor">
					<!--错题库界面 滚动监听-->
					<!--导航部分-->
					<nav id="navbar-example" class="navbar navbar-default navbar-static" role="navigation">
	                    <div class="container-fluid"> 
		                    <div class="navbar-header">
			                    <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".bs-js-navbar-scrollspy">
				                <span class="sr-only">切换导航</span>
				                <span class="icon-bar"></span>
				                <span class="icon-bar"></span>
			                    </button>
			                    <a class="navbar-brand" href="#"><%=(String)request.getAttribute("chapterName") %></a>
		                    </div>
		                    <div class="collapse navbar-collapse bs-js-navbar-scrollspy">
			                    <ul class="nav navbar-nav">
				                    <li><a href="#choice">选择题</a></li>
				                    <li><a href="#judge">判断题</a></li>
			                    </ul>
		                    </div>
	                    </div> 
                    </nav>
                    <!-- 正文部分-->
                    <div data-spy="scroll" data-target="#navbar-example" data-offset="0" style="height:400px;overflow:auto; position: relative;">
	               
	             <% 
	             	ArrayList<Topic> errorTopics = 
	             		(ArrayList<Topic>) request.getAttribute("errorTopics"); %>
	             		
	             <div class="ch">	
	             	<h4 id="choice">&nbsp;&nbsp;&nbsp;选择题</h4>
	             			    		
	             <% for(Topic topic:errorTopics){
	             		if(topic.getType().equals("choice")){ %>
                       
                       		<td>
	                       		<h5><%=topic.getId() %>:<%=topic.getQuestion() %></h5>
	                       		<p>A:<%=topic.getOptionA() %></p>
	                       		<p>B:<%=topic.getOptionB() %></p>
	                       		<p>C:<%=topic.getOptionC() %></p>
	                       		<p>D:<%=topic.getOptionD() %></p>
	                       		<p>正确答案：<%=topic.getAnswer() %></p>
	                       		
	                       		<p></p>
	                       		<small><a href="#" onclick="removeSection(this);"><!--&times;--> 删除此题</a></small>
                       		<p>&nbsp;</p>
                       		</td>
           				
           				
	             <%		}
	             	}
	             %>  
	             </div>
	         
	  
	                 <div class="ju">
	                 <p></p>
	                 <p></p>
	                 <p></p> 
	                <h4 id="judge">&nbsp;&nbsp;&nbsp;判断题</h4>
	                
	            <% for(Topic topic:errorTopics){
	             		if(topic.getType().equals("judge")){  %> 
                        <ol>
                       		<td>
	                       		<h5><%=topic.getId() %>:<%=topic.getQuestion() %></h5>
	                       		<p>正确答案：<%=topic.getAnswer()%></p>
	                       		<small><a href="#" onclick="removeSection(this);"><!--&times;--> 删除此题</a></small>
                       		    <p>&nbsp;</p>
                       		</td>
           				</ol> 
	             <%		}
	             	}
	             %>      
	                </div>         
	                        
	               <%-- <h4 id="fillin">&nbsp;&nbsp;&nbsp;填空题</h4>
	               
	            <% for(Topic topic:errorTopics){
	             		if(topic.getType().equals("blank")){ %>
                        <ol>
                       		<li>
	                       		<h5><%=topic.getId() %>:<%=topic.getQuestion() %></h5>
	                       		<p>正确答案：<%=topic.getAnswer() %></p>
	                       		<small><a href="#" onclick="removeSection(this);"><!--&times;--> 删除此题</a></small>
                       		</li>
           				</ol> 
	             <%		}
	             	}
	             %>   --%>
	                        
	                        
	                        
                    </div>	
				</div>	
			</div>
		</div>
	</body>
</html>

