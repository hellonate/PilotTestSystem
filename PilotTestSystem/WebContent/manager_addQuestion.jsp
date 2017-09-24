<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
			width: 660px;
			height:520px;
			background-color: white;
			top: 60px;
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
			width:640px;
			height: 75px;
			/*background-color: #269ABC;*/
			top: auto;
			left: 10px;
			z-index: 10;	
		}
		
		.middle .create .body{
			text-align: center;
			position: absolute;
			width: 640px;
			height: 450px;
			/*background-color: #31B0D5;*/
			top: 75px;
			left: 10px;
			z-index: 10;
		}
		
		.middle .create .foot{
			text-align: center;
			position: absolute;
			width: 440px;
			/*background-color: #AC2925;*/
			top:320px;
			left: 100px;
			z-index: 10;
		}
	</style>

<body>
<div class="middle">
		
	  <div class="create">
	        	<form action="DealQuestionServlet?param=insert" method="post">
	    	    <div class="head">
                    <h3>单个试题添加</h3>
	    	    </div>
	    	    <div class="body">
                <table class="table table-striped" >
                	<thead>
                		<tr>
			                
			                <th>题目问题</th>
			                <th>试题答案</th>
			                <th>题目类型</th>
			                <th>题目分值</th>
			                <th>chapterID</th>  
		                </tr>
                	</thead>
                	<tbody>
                		<tr>
                			<td><input type="text" name="question" style="width: 90px;"/></td>
                			<td><input type="text" name="answer" style="width: 90px;"/></td>
                			<td><input type="text" name="type" style="width: 90px;"/></td>
                			<td><input type="text" name="score" style="width: 90px;"/></td>
                			<td><input type="text" name="chapterId" style="width: 90px;"/></td>
                			
                		</tr>
                	</tbody>
                </table>
                <table class="table table-striped" >
                	<thead>
                		<tr>
                		    <th>chapterName</th>
			                <th>sectionName</th>
			                <th>optionA</th>
			                <th>optionB</th>
			                <th>optionC</th>
			                <th>optionD</th>
		                </tr>
                	</thead>
                	<tbody>
                		<tr>
                			<td><input type="text" name="chapterName" style="width: 90px;"/></td>
                			<td><input type="text" name="sectionName" style="width: 90px;"/></td>
                			<td><input type="text" name="optionA" style="width: 90px;"/></td>
                			<td><input type="text" name="optionB" style="width: 90px;"/></td>
                			<td><input type="text" name="optionC" style="width: 90px;"/></td>
                			<td><input type="text" name="optionD" style="width: 90px;"/></td>
                		</tr>
                	</tbody>
                </table>
                <button  type="reset" class="btn btn-primary" style="text-shadow: black 5px 3px 3px;">清空信息</button>
                <button  type="submit" class="btn btn-primary" style="text-shadow: black 5px 3px 3px;" value="submit">提交单个试题</button>
	    	</div>
	    	</form>
	    	
	    	<div class="foot">
	    		 <h3>批量添加   </h3>
                <form action="FileUploadServlet" method="post" ENCTYPE="multipart/form-data">
                    
                    <input type="FILE" name="fileName" />
	                    <br>
	                        <input type="radio" name="isCover" value="true">覆盖现有题目
	                        <input type="radio" name="isCover" value="false" checked="true">追加题目
	                    
	                        <input type="submit" name="upload" value="上传"/> 
	                    <br>
                 </form>
	    	
	    	</div><!-- end foot -->
	    	
	  </div> <!-- end create -->
	        
	    
	        
	        
	        
	    </div> <!-- end middle -->
</body>
</html>