<%@page import="com.utils.DbUtil"%>s
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="Convert" class="com.Tool.Convert"></jsp:useBean>
<jsp:useBean id="user" class="com.Bean.User" scope="request"></jsp:useBean>
<jsp:setProperty property="*" name="user"/>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="3 ; url=index.html">
<title>Insert title here</title>
</head>
<body>
<%request.setCharacterEncoding("utf-8");%>
<%		
	try{
		String sql="insert into tb_user (password,name,identity,question,answer) values(?,?,?,?,?)";
		PreparedStatement ps=DbUtil.getConnection().prepareStatement(sql);
		ps.setString(1,user.getPassword() );
		ps.setString(2,user.getName());
		ps.setString(3, user.getIdentity());
		ps.setString(4, user.getQuestion());
		ps.setString(5,user.getAnswer());
		int i=ps.executeUpdate();
		if(i>0){
			//System.out.print("注册成功!!!");
			%>
			<a href="register_success.html">5s后网页未跳转，请点击返回主页</a>
			<!-- <a href="main_right.html" target="mainFrame">5s后网页未跳转，请点击返回主页</a> -->
			<%
		}
		else
		{
			System.out.print("添加失败");
		}
		
	}
	catch(SQLException e){
		e.printStackTrace();
		
	}
%>

</body>
</html>