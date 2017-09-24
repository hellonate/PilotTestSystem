<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
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
	        /* top: 88px; */
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
	        top: 450px;
	        left: 360px;
	        /*background-color: #2F4F4F;*/
	        z-index: 10;
        }
	</style>
	
	<body>

		<div class="middle">
			<div class="welcome">
				<div class="operate">
					<div class="btn-group; btn-block" data-toggle="buttons" style="text-shadow: black 5px 3px 3px;">
	                    <label class="btn btn-success glyphicon glyphicon-plus">
		                    <input type="radio" name="options" id="option1">添加
	                    </label>
	                    <label class="btn btn-danger glyphicon glyphicon-trash">
		                    <input type="radio" name="options" id="option2"> 删除
	                    </label>
	                    <label class="btn btn-warning glyphicon glyphicon-pencil">
		                    <input type="radio" name="options" id="option3"> 修改
	                    </label>
                    </div>	
			    </div>
			    <div class="search">
				    <form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input class="form-control" type="text" />
						</div> 
						<button type="submit" class="btn btn-primary glyphicon glyphicon-search" style="text-shadow: black 5px 3px 3px;">搜索</button>
					</form>
			    </div>
			    <div class="midbgcolor"></div>
			    <div class="table">
			    	<table class="table table-striped">
	                    <thead>
		                    <tr>
			                <th>编号</th>
			                <th>姓名</th>
			                <th>身份证号</th>
			                <th>测试成绩</th>
		                    </tr>
	                    </thead>
	                    <tbody>
		                    <tr>
			                <td>001</td>
			                <td>mlf</td>
			                <td>xxxxxxxxxxxxxxxxxx</td>
			                <td><a href="#">查看详情</a></td>
		                    </tr>
		                    <tr>
			                <td>002</td>
			                <td>hpc</td>
			                <td>xxxxxxxxxxxxxxxxxx</td>
			                <td><a href="#">查看详情</a></td>
		                    </tr>
		                    <tr>
			                <td>003</td>
			                <td>ll</td>
			                <td>xxxxxxxxxxxxxxxxxx</td>
			                <td><a href="#">查看详情</a></td>
		                    </tr>
		                    <tr>
			                <td>004</td>
			                <td>xxq</td>
			                <td>xxxxxxxxxxxxxxxxxx</td>
			                <td><a href="#"></a></td>
		                    </tr>
	                    </tbody>
                    </table>
			    </div>
			    <div class="page">
			        <ul class="pagination">
	                    <li><a href="#">&laquo;</a></li>
	                    <li class="active"><a href="#">1</a></li>
	                    <li><a href="#">2</a></li>
	                    <li><a href="#">3</a></li>
	                    <li><a href="#">4</a></li>
	                    <li><a href="#">5</a></li>
	                    <li><a href="#">&raquo;</a></li>
                   </ul>
			    </div>
			</div>
		</div>
	</body>
</html>




