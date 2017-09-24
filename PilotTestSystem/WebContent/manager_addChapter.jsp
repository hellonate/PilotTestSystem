<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
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
			width: 600px;
			height:250px;
			background-color: white;
			top: 100px;
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
			width:580px;
			height: 30%;
			/*background-color: #269ABC;*/
			top: auto;
			left: 10px;
			z-index: 10;	
		}
		
		.middle .create .body{
			text-align: center;
			position: absolute;
			width: 580px;
			height: 40%;
			/*background-color: #31B0D5;*/
			top: 30%;
			left: 10px;
			z-index: 10;
		}
		
		.middle .create .foot{
			text-align: center;
			position: absolute;
			width: 580px;
			height: 30%;
			/*background-color: #AC2925;*/
			top:70%;
			left: 10px;
			z-index: 10;
		}
	</style>

<div class="middle">
<form action="DealChapterServlet?param=insert" method="post">
	        <div class="create">
	    	    <div class="head">
                    <h3>添加章节</h3>
	    	    </div>
	    	    <div class="body">
                <table class="table table-striped" >
                	<thead>
                		<tr>
			                
			                <th>章节名称</th>
			                <th>章节介绍</th>
		                </tr>
                	</thead>
                	<tbody>
                		<tr>
                			
                			<td><input type="text" name="chapterName" /></td>
                			<td><input type="text" name="chapterIntro" /></td>
                		</tr>
                	</tbody>
                </table>
	    	</div>
	    	<div class="foot">
	    		 <button  type="submit" class="btn btn-primary" style="text-shadow: black 5px 3px 3px;" value="submit">提交</button>
	    	</div>
	        </div>
	        </form>
	    </div>	
	</body>
</html>






