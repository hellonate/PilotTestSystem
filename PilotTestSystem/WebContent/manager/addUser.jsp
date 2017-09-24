<%@page import="com.utils.Page"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.Bean.User" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	    <link rel="stylesheet" href="css/bootstrap.css" />
	   <script type="text/javascript" src="js/jquery-2.1.1.js" ></script>
	   <script>
	   	    	$(function(){
	    		 $("tbody>tr").click(function(){
					if($(this).hasClass('selected')){
						//如果选中了 再次点击就取消
						$(this).removeClass('selected').find(':checkbox').attr('checked',false);
					}
					else{
						$(this).addClass('selected').find(':checkbox').attr('checked',true);
					}
				}); 
	    	
	    		$("#option1").click(function(){
	    			window.location.href="manager_addUser.jsp";
	    		});
	    	})
	    </script>
	
	</head>
	<style type="text/css">
	.selected{
				background: coral;
			}
		.middle{
	        position: absolute;
	        width: 100%;
	        height: 600px;
	        /*background-image: url(../img/bg_4.jpg);
	        background-repeat: no-repeat;
	        background-size: cover;*/
	        /*background-color: #A6E1EC;*/
	        background:   -webkit-gradient(linear,  left  top,  right  bottom,color-stop(0%,#5BC0DE),  color-stop(33%,#C4E3F3),  color-stop(69%,#A6E1EC),  color-stop(100%,#31B0D5));
        }

        .middle .welcome{
	        position: absolute;
	        width: 70%;
	        height: 400px;
	        top: 40px;
	        left: 216px;
	        /*background-color:#000000;*/
	        z-index: 10;
	        font-family: "微软雅黑";
	        /*font-size: medium;*/
        }
        
        .middle .welcome .operate{
	        position: absolute;
	        width: 30%;
	        height: 40px;
	        top: 15px;
	        left: auto;
	        /*background-color: #5CB85C;*/
	        z-index: 10;
        }

        .middle .welcome .search{
	        position: absolute;
	        width: 40%;
	        height: 40px;
	        top: 10px;
	        left: 675px;
	        /*background-color: #AC2925;*/
	        z-index: 10;
        }

        .middle .welcome .table{
	        position: absolute;
	        width: 100%;
	        /*height: 500px;*/
	        top: 27px;
	        left: auto;
	        /*background-color: #FCF8E3;*/
	        z-index: 10;
	        text-align-last: center;
        }

        .middle .welcome .midbgcolor{
	        position: absolute;
	        width: 100%;
	        height: 400px;
	        top: 60px;
	        left: auto;
	        background-color: white;
	        z-index: 5;	
        }  

        .middle .welcome .page{
	        position: absolute;
	        width: 40%;
	        height: 40px;
	        top: 455px;
	        left: 360px;
	        /*background-color: #2F4F4F;*/
	        z-index: 10;
        }
	</style>
	
	<%  
		List <User>  users = (List<User>)request.getAttribute("userlist"); 
		Page pg = (Page)request.getAttribute("page");
	%>
	<body>
		<!--页面中部-->
		<div class="middle">
            <!--用户登录成功后的第一个界面大小-->    
			<div class="welcome">
				<!--管理员界面特有  增删改功能-->
				<div class="operate">
					<div class="btn-group; btn-block" data-toggle="buttons" style="text-shadow: black 5px 3px 3px;">
	                    <label class="btn btn-primary glyphicon glyphicon-plus">
		                    <input type="radio" name="options" id="option1">添加
	                    </label>
	                 <!--    <label class="btn btn-danger glyphicon glyphicon-trash">
		                    <input type="radio" name="options" id="option2"> 删除
	                    </label>
	                    <label class="btn btn-warning glyphicon glyphicon-upload">
		                    <input type="radio" name="options" id="option3"> 上传
	                    </label>  -->
                    </div>	
			    </div>
			    <!--管理员界面特有 搜索功能-->
			    <div class="search">
				    <form class="navbar-form navbar-left" role="search" 
				    	action="<%=request.getContextPath() %>/ManagerSearchServlet?param=user" method="post">
						<div class="form-group">
							<input class="form-control" type="text" name="searchValue"/>
						</div> 
						<button type="submit" class="btn btn-primary glyphicon glyphicon-search" style="text-shadow: black 5px 3px 3px;">搜索</button>
					</form>
			    </div>
			    <!--表格背景层 因为不加背景层实在是太丑了-->
			    <div class="midbgcolor"></div>
			    <!--表格区域-->
			    <div class="table">
			    	<table class="table">
	                    <thead>
		                    <tr>
		                    
			                <th>编号</th>
			                <th>姓名</th>
			                <th>身份证号</th>
			                <th>密码</th>
			                <th>操作</th>
		                    </tr>
	                    </thead>
	                    <tbody>
	                    	
		          <%for(User user:users){ %>
				<tr>
				
					
					<td><%=user.getId()%></td>
					<td><%=user.getName() %></td>
					<td><%=user.getIdentity() %></td>
					<td><%=user.getPassword() %></td>
					<td><a href="DealUserServlet?delete_user_name=<%=user.getName()%>">删除</a>丨
					<a href="UpdateUserServlet?name=<%=user.getName() %>
					">更新</a></td>
				</tr>
				<% }%>
		                
	                    </tbody>
                    </table>
			    </div>
			    <!--分页标签-->
			    <div class="page">
			        <ul class="pagination">
	                <li><a href="LoginServlet?user=<%=pg.getCurPage()-1%>">&laquo;</a></li>
				 	<% for(int i=0;i<pg.getPageCount();i++){ %>
				    <li><a href="LoginServlet?user=<%= i+1%>"><%= i+1%></a></li>
					<%} %>
				    <li><a href="LoginServlet?user=<%=pg.getCurPage()+1%>">&raquo;</a></li>
                   </ul>
			    </div>
			</div>
		</div>
	</body>
</html>

