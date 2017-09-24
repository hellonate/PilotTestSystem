<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "com.utils.DbUtil
    "%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%//变量声明   
    java.sql.ResultSet sqlRst; //结果集对象   
    java.lang.String strSQL; //SQL语句   
    int intPageSize; //一页显示的记录数   
    int intRowCount; //记录总数   
    int intPageCount; //总页数   
    int intPage; //待显示页码   
    java.lang.String strPage;   
    int i;   
    //设置一页显示的记录数   
    intPageSize = 2;   
    //取得待显示页码   
    strPage = request.getParameter("page");   
      
    if(strPage==null)  
    {//表明在QueryString中没有page这一个参数，此时显示第一页数据   
        intPage = 1;   
    }   
    else{//将字符串转换成整型   
        intPage = java.lang.Integer.parseInt(strPage);   
        if(intPage<1) intPage = 1;   
    }   
    strSQL = "SELECT fd_username,fd_usertype FROM tb_users";
     sqlRst = DbUtil.executeQuery(strSQL);   
    //获取记录总数   
    sqlRst.last();//光标在最后一行   
    intRowCount = sqlRst.getRow();//获得当前行号   
    //记算总页数   
    intPageCount = (intRowCount+intPageSize-1) / intPageSize;   
    //调整待显示的页码,超过总页数则显示最后一页  
    if(intPage>intPageCount) intPage = intPageCount;   
%>
    <form method="POST" action="paging.jsp">   
        第<%=intPage%>页 共<%=intPageCount%>页   
          
       
        <% if(intPage>1)//当前在第一页之后需要有上一页  
            {  
        %>  
          
        <a href="paging.jsp?page=<%=intPage-1%>">上一页</a>  
        <%  
            }  
        %>   
          <% if(intPage<intPageCount)//总页数大于当前页说明还有下一页  
            {  
        %>  
          
        <a href="paging.jsp?page=<%=intPage+1%>">下一页 </a>  
          
        <%  
            }  
        %>   
          
        转到第:<input type="text" name="page" size="8"> 页   
        <span>  
            <input class=buttonface type="submit" value="GO"></span>   
</form> 
  
      
    <!--   
    这是用表格显示，咱们不要表格 
    <table border="1" cellspacing="0" cellpadding="0">   
        <tr>   
        <th>ID</th>   
        <th>用户名</th>   
        </tr>   
        <%   
            if(intPageCount>0){   
            //将记录指针定位到待显示页的第一条记录上   
            sqlRst.absolute((intPage-1) * intPageSize + 1);   
            //显示数据   
            i = 0;   
            String username,usertype;   
            while(i<intPageSize && !sqlRst.isAfterLast()){   
            username=sqlRst.getString(1);   
            usertype=sqlRst.getString(2);   
        %>   
            <tr>   
            <td><%=username%></td>   
            <td><%=usertype%></td>   
              
            </tr>   
        <%   
                sqlRst.next();   
                i++;   
                }   
            }   
        %>   
    </table> 
    --> 
    <%   
            if(intPageCount>0){   
            //将记录指针定位到待显示页的第一条记录上   
            sqlRst.absolute((intPage-1) * intPageSize + 1);   
            //显示数据   
            i = 0;   
           int j=0;
            String [] username = new String[2];
            String [] usertype = new String[2];
            while(i<intPageSize && !sqlRst.isAfterLast()){   
            username[j]=sqlRst.getString(1);   
            usertype[j]=sqlRst.getString(2); 
            j++;
            sqlRst.next();   
            i++;   
            }  
	%> 
          <!-- 新建div用于显示查询的记录，每次现实的div都是新建的，样式可以在css里边根据class更改 -->
        <% if(username[0]!=null){%>
			<div class="page1" style="position: absolute;width: 200px;height: 50px;left: 10%;top: 50px; background-color:#999999; text-align:center;border-radius: 5px;"> <%=username[0]%> <br/> 
            <%=usertype[0]%></div>
		<%} %>
		<% if(username[1]!=null){%>
			<div class="page2"style="position: absolute;width: 200px;height: 50px;left: 50%;top: 50px;background-color:#999999 ; text-align:center;border-radius: 5px;"> <%=username[1]%>  <br/>
            <%=usertype[1]%></div>
		<%} %>
	<% }%>   
      
    <%   
        //关闭结果集   
        sqlRst.close(); 
    %>  
</body>
</html>