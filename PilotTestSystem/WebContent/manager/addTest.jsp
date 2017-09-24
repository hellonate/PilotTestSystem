<%@page import="com.utils.Page"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.Bean.Exam"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	    <link rel="stylesheet" href="css/bootstrap.css" />
	    <script type="text/javascript" src="js/jquery-2.1.1.js" ></script>
	    	<script type="text/javascript">
			$(function(){
				$("#option1").click(function(){
						window.location.href="manager/manager_examTest.jsp";
				});
			})
		
	</script>
		      <script type="text/javascript">
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
	    	})
	    </script>
	    <!-- 修改 -->
<!-- 	    <script type="text/javascript">
	    $(document).ready(function(){
	    	   //找到所有td节点
	    	    var tds =$("td:not(.notme)");
	    	   //给所有的td节点增加点击事件
	    	   tds.click(tdclick);
	    	});
	    	function tdclick(){
	    	    var clickfunction = this;
	    	   //0,获取当前的td节点
	    	    var td =$(this);
	    	   //1,取出当前td中的文本内容保存起来
	    	    var text =$(this).text();
	    	   //2，清空td里边内同
	    	   td.html("");
	    	   //3,建立一个文本框，也就是建一个input节点
	    	    var input =$("<input>");
	    	   //4,设置文本框中值是保存起来的文本内容
	    	   input.attr("value",text);
	    	   //4.5让文本框可以相应键盘按下的事件
	    	   input.keyup(function(event){
	    	      //记牌器当前用户按下的键值
	    	       var myEvent= event || window.event;//获取不同浏览器中的event对象
	    	       var kcode =myEvent.keyCode;
	    	      //判断是否是回车键按下
	    	       if(kcode ==13){
	    	          var inputnode = $(this);
	    	         //获取当前文本框的内容
	    	          var inputext= inputnode.val();
	    	         //清空td里边的内容,然后将内容填充到里边
	    	          var tdNode =inputnode.parent();
	    	         tdNode.html(inputext);
	    	         //让td重新拥有点击事件
	    	         tdNode.click(tdclick);
	    	       }
	    	    });
	    	   //5，把文本框加入到td里边去
	    	   td.append(input);
	    	   //5.5让文本框里边的文章被高亮选中
	    	   //需要将jquery的对象转换成dom对象
	    	    var inputdom= input.get(0);
	    	   inputdom.select();
	    	   
	    	   //6,需要清楚td上的点击事件
	    	   td.unbind("click");
	    	}
	    </script> -->
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
	        font-family: "å¾®è½¯éé»";
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

        .middle .welcome .table_out{
	        position: absolute;
	        width: 100%;
	        /*height: 500px;*/
	        top: 57px;
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
		List<Exam> exams=(List<Exam>)request.getAttribute("examlist"); 
		Page pg=(Page)request.getAttribute("page");
	%>
	<body>
		<div class="middle">
			<div class="welcome">
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
			    <div class="search">
				    <form class="navbar-form navbar-left" role="search" 
				    	action="<%=request.getContextPath() %>/ManagerSearchServlet?param=exam" method="post">
						<div class="form-group">
							<input class="form-control" type="text" name="searchValue"/>
						</div> <button type="submit" class="btn btn-primary glyphicon glyphicon-search" style="text-shadow: black 5px 3px 3px;">搜索</button>
					</form>
			    </div>
			    <div class="midbgcolor"></div>
			    <div class="table_out">
			    	<table class="table">
	                    <thead>
		                    <tr>
		                    
		                    <th>编号</th>
		                    <th>考试时间</th>
			                <th>考试名称</th>
			                <th>考试方式</th>
			                <th>时长</th>
			                <th>出题人</th>
			                <th>操作</th>
			             
		                    </tr>
	                    </thead>
	                    <tbody>
	                    	<%for(Exam exam:exams){ %>
		                    <tr>
		                    
		                    <td><%=exam.getId() %></td>
		                    <td><%=exam.getExamTime()%></td>
			                <td><%=exam.getExamName() %></td>
			                <td><%=exam.getType() %></td>
			                <td><%=exam.getDuration() %></td>
			                <td><%=exam.getCreator() %></td>
			                <td><a href="DealTestServlet?delete_exam_name=<%=exam.getExamName()%>">删除</a>
			              <!--  <a href="DealTestServlet?update_exam_name=<%=exam.getExamName() %>">更新</a></td> -->
			                </tr>
			                <%} %>
	                    </tbody>
                    </table>
			    </div>
			    <div class="page">
			   	<ul class="pagination">
				    <li><a href="LoginServlet?exam=<%=pg.getCurPage()-1%>">&laquo;</a></li>
				 	<% for(int i=0;i<pg.getPageCount();i++){ %>
				    <li><a href="LoginServlet?exam=<%= i+1%>"><%= i+1%></a></li>
					<%} %>
				    <li><a href="LoginServlet?exam=<%=pg.getCurPage()+1%>">&raquo;</a></li>
				</ul>
			    </div>
			</div>
		</div>
	</body>
</html>




