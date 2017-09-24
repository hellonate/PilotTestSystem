<%@page import="com.Bean.Paper"%>
<%@page import="DaoImpl.PaperDaoImpl"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.Bean.User" import="com.Bean.Exam" %>
<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" href="css/xxq.css" />
		<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	    <link rel="stylesheet" href="css/bootstrap.css" />
	    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
	<body>
		<div class="middle">
			<div class="information">
				<div class="panel-group" id="accordion">
	                <div class="panel panel-default">
		                <div class="panel-heading">
			                <h4 class="panel-title">
				                <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
					                                我的个人信息
				                </a>
			                </h4>
		                </div>
		            <% User user = (User) request.getAttribute("user"); 
		            %>
		            <div id="collapseOne" class="panel-collapse collapse in">
			            <div class="panel-body">
				            <table  class="table table-striped">
					            <thead>
                                    <tr>
                                    <th>姓名</th>
                                    <th>身份证号</th>
                                    <th>账户密码</th>
                                    <th>问题</th>
                                    <th>答案</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                    <td><%=user.getName()%></td>
                                    <td><%=user.getIdentity() %></td>
                                    <td><%=user.getPassword() %></td>
                                    <td><%=user.getQuestion() %></td>
                                    <td><%=user.getAnswer() %></td>
                                    </tr> 
                                </tbody>
                                
			                </table>
			                <table  class="table table-striped">
					            <thead>
                                    <tr>
                                    <th>已完成题目</th>
                                    <th>做对题目</th>
                                    <th>做错题目</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                    <td><%=user.getFinishNum() %></td>
                                    <td><%=user.getRightNum() %></td>
                                    <td><%=user.getErrorNum() %></td>
                                    </tr> 
                                </tbody>
                                
			                </table>
			            </div>
		            </div>
	                </div>
	                
	                <div class="panel panel-default">
		                <div class="panel-heading">
			                <h4 class="panel-title">
				                <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
					                                我做过的自主测试
				                </a>
			                </h4>
		                </div>
		            <div id="collapseTwo" class="panel-collapse collapse">
			            <div class="panel-body">
				            <table  class="table table-striped">
					            <thead>
                                    <tr>
                                    <th>考试名称</th>
                                    <th>成绩</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <% ArrayList<Exam> zikao = (ArrayList<Exam>) request.getAttribute("zikao"); %>
                                <% for(Exam exam:zikao){ %>
                                 <tr>
                                    <td><%=exam.getExamName()%></td>
                                	<td><%=exam.getChoiceScore()+exam.getJudgeScore()+exam.getBlankScore() %></td>
                                 </tr> 
                                 <%}%>   
                                </tbody>
			                </table>
			            </div>
		            </div>
	                </div>
	                
	                <div class="panel panel-default">
		                <div class="panel-heading">
			                <h4 class="panel-title">
				                <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
					                                我做过的统一测试
				                </a>
			                </h4>
		                </div>
		            <div id="collapseThree" class="panel-collapse collapse">
			            <div class="panel-body">
				            <table class="table table-striped">
					            <thead>
                                    <tr>
                                    <th>考试名称</th>
                                    <th>成绩</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <% ArrayList<Exam> tongkao = (ArrayList<Exam>) request.getAttribute("tongkao"); %>
                                <% 
                                	PaperDaoImpl paperDaoImpl = new PaperDaoImpl();
                                	for(Exam exam:tongkao){ 
                                		if(paperDaoImpl.getPaperByExamId(exam.getId()) != null){
                                			Paper paper = paperDaoImpl.getPaperByExamId(exam.getId());
                                %>
                                 <tr>
                                    <td><%=exam.getExamName()%></td>
                                	<td><%=paper.getScore() %></td>
                                 </tr> 
                                 <%}}%>  
                                </tbody>
			                </table>
			            </div>
		            </div>
	                </div>
                
                	<div class="panel panel-default">
		                <div class="panel-heading">
			                <h4 class="panel-title">
				                <a data-toggle="collapse" data-parent="#accordion" href="#collapseFour">
					                                未参加的统考考试
				                </a>
			                </h4>
		                </div>
		            <div id="collapseFour" class="panel-collapse collapse">
			            <div class="panel-body">
				            <table  class="table table-striped">
					            <thead>
                                    <tr>
                                    <th>考试名称</th>
                                    <th>状态</th>
                                    </tr>
                                </thead>
                                 <tbody>
                                <% 
                                	for(Exam exam:tongkao){ 
                                		if(paperDaoImpl.getPaperByExamId(exam.getId()) == null){
                                %>
                                 <tr>
                                    <td><%=exam.getExamName()%></td>
                                	<td><a href="<%=request.getContextPath() %>/UserExamTestServlet?param=join&examId=<%=exam.getId() %>" >参与考试</a></td>
                                 </tr> 
                                 <%}}%>  
                                </tbody>
			                </table>
			            </div>
		            </div>
	                </div>
                
                </div>
			</div>
		</div>
		<!--<div class="bottom">
			<div class="cha">
				<font class="f1">
					版权所有：中国空军飞行基地     版权声明
				</font><br>
				
				<font class="f2">
					中国 河南开封 河南大学   Copyright@2016
				</font>
			</div>
		</div>-->
	</body>
</html>
