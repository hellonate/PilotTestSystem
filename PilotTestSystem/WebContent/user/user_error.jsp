<%@page import="com.Bean.User" import="dataUtil.ErrorUtil" import="java.util.HashMap" %>
<%@page import="com.Bean.Chapter"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.Bean.Error" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
	
		<link rel="stylesheet" href="css/my.css" />
		<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	    <link rel="stylesheet" href="css/bootstrap.css" />
	    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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

    </style>
    
	<body>
		<!--页面中部-->
		<div class="middle">
			
			<!--用户个人信息界面 包括用户的个人信息和考试信息-->
			<div class="information">
				<div class="panel-group" id="accordion">
	                <div class="panel panel-default">
		                <div class="panel-heading">
			                <h4 class="panel-title">
				                <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
					                                        我的错题库
				                </a>
			                </h4>
		                </div>
		            <div id="collapseOne" class="panel-collapse collapse in">
			            <div class="panel-body">
				            <table  class="table table-striped">
					            <thead>
		                            <tr>
		                    	        <th>章节名称</th>
		                    	        <th>选择题个数</th>
		                    	        <th>判断题个数</th>
		                    	        <th>填空题个数</th>
		                    	        <th>是否删除记录</th>
		                            </tr>
	                            </thead>
	                            <tbody>
		                            
			       <% 
			        ArrayList<Chapter> chapters = (ArrayList<Chapter>) request.getAttribute("chapters");
			        User user = (User) request.getAttribute("user");
			       	ErrorUtil errorUtil = new ErrorUtil();
					HashMap<String, Integer> map = null;
					
					for(Chapter chapter:chapters){
						map = errorUtil.getErrorNumByChapterName(user.getId(), chapter.getName());
						if(map.get("hasValue") == 1){%>
						
							<tr>
								<td><a href="<%=request.getContextPath() %>/UserErrorTopicsServlet?param=detail&chapter=
									<%=chapter.getName() %>"><%=chapter.getName() %></a></td>
								<td><%=map.get("choice") %></td>
								<td><%=map.get("judge") %></td>
								<td><%=map.get("blank") %></td>
								<td><a href="<%=request.getContextPath() %>/UserErrorTopicsServlet?param=deleteChapter&chapter=
									<%=chapter.getName() %>" >删除</a></td>
							</tr>

						<%}
					}
			       %>
								

								</tbody>
			                </table>
			            </div>
		            </div>
	                </div>
	                <!-- 
	                 <div class="panel panel-default">
		                <div class="panel-heading">
			                <h4 class="panel-title">
				                <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
					                                         我的统一测试错题库                
				                </a>
			                </h4>
		                </div>
		            <div id="collapseTwo" class="panel-collapse collapse">
			            <div class="panel-body">
				            <table  class="table table-striped">
					            <thead>
		                            <tr>
		                    	        
		                    	        <th>章节名称</th>
		                    	        <th>选择题</th>
		                    	        <th>判断题</th>
		                    	        <th>填空题</th>
		                    	        <th>是否删除记录</th>
		                            </tr>
	                            </thead>
	                            <tbody>
	                            
		                             <tr>
			                            <td><a href="testpage.jsp">十二月月份综合考试</a></td>
					                    <td>30分</td>
					                    <td>30分</td>
					                    <td>40分</td>
					                    <td><a href="#" disabled='ture'>删除</a></td>
			                        </tr>
		                          
	                            </tbody>
			                </table>
			            </div>
		            </div>
	                </div>    
	                -->
                </div>
			</div>
		</div>
	</body>
</html>

