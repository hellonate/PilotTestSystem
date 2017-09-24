<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="image" class="com.Tool.RandomPasswrod"></jsp:useBean>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%		
	//	String user="abc";
		String str=image.getCertPic(0,0,response.getOutputStream());
		 /**  将认证码存入SESSION **/
		session.setAttribute("certCode", str); 
	//		session.setAttribute("user",user);
		 
		out.clear();
		out = pageContext.pushBody();
%>
</body>
</html>






