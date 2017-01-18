<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"/>
<link rel="SHORTCUT ICON" href="resource/image/s_blog.ico">
<link rel="BOOKMARK" href="resource/image/s_blog.ico">
<link rel="stylesheet" href="resource/css/bootstrap.min.css" />
<link rel="stylesheet" href="resource/css/common/common.css"></link>
<link rel="stylesheet" href="resource/css/common/home-common.css">
<link rel="stylesheet" href="resource/css/common/main-common.css">
<link rel="stylesheet" href="resource/css/photo/photo.css">
<title>我的相册</title>
</head>
<body>
	<!-- 导航栏 -->
	<div class="row navbar-fixed-top" id="nav"> 
		<div class="container" id="nav-con">
			<!-- logo -->
			<div class="col-md-2 col-xs-9" id="logo">
				<img alt="" src="resource/image/s_weibo.png">
			</div>
			<!-- 输入栏 -->
			<div class="col-md-5 hidden-sm hidden-xs">
				<div id="search-div">
					<input>
					<img alt="" src="resource/image/搜索.png">
				</div>
			</div>
			<!-- 右边的菜单,中等屏幕时显示 -->
			<div class="col-md-5 hidden-sm hidden-xs">
				<div class="container-fluid">
					<div class="col-md-2 nav-right">
						<a href="main.jsp" class="dropdown-toggle">
				          <span class="glyphicon glyphicon-home"></span>&nbsp;首页
	               		</a>
					</div>
					<div class="col-md-2 nav-right">
						<a href="#" class="dropdown-toggle">
				          <span class="	glyphicon glyphicon-facetime-video"></span>&nbsp;视频
	                	</a>
					</div>
					<div class="col-md-2 nav-right">
						<a href="#" class="dropdown-toggle">
				          <span class="	glyphicon glyphicon-eye-open"></span>&nbsp;发现
	                	</a>
					</div>
					<div class="col-md-2 nav-right">
						<a href="#" class="dropdown-toggle">
				          <span class="	glyphicon glyphicon-gift"></span>&nbsp;游戏
	                	</a>
					</div>
					<div class="col-md-2 nav-right spe-nav-right">
						<span><a href="#" class="dropdown-toggle">昵称到今年考九年级看你空间</a></span>
					</div>
					<div class="col-md-2 nav-right">
						<a href="#" class="dropdown-toggle">设置</a>
					</div>
				</div>
			</div>
			<!-- 右边菜单，小屏幕时显示 -->
			<div class="col-xs-3 hidden-md hidden-lg nav-right dropdown">
				<a class="btn btn-info btn-sm dropdown-toggle" data-toggle="dropdown">
					<span class="glyphicon glyphicon-align-justify"></span>&nbsp;菜单
				</a>
				<ul class="dropdown-menu dropdown-menu-right " role="menu" aria-labelledby="dropdownMenu1">
					<li role="presentation">
						<a role="menuitem" tabindex="-1" href="#">
							<span class="glyphicon glyphicon-home"></span>&nbsp;首页
						</a>
					</li>
					<li role="presentation">
						<a role="menuitem" tabindex="-1" href="#">
							<span class="	glyphicon glyphicon-facetime-video"></span>&nbsp;视频
						</a>
					</li>
					<li role="presentation">
						<a role="menuitem" tabindex="-1" href="#">
							<span class="	glyphicon glyphicon-eye-open"></span>&nbsp;发现
						</a>
					</li>
					<li role="presentation">
						<a role="menuitem" tabindex="-1" href="#">
							<span class="	glyphicon glyphicon-gift"></span>&nbsp;游戏
						</a>
					</li>
					<li role="presentation" class="divider"></li>
					<li role="presentation">
						<a role="menuitem" tabindex="-1" href="#">登录</a>
					</li>
					<li role="presentation">
						<a role="menuitem" tabindex="-1" href="#">注册</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
	
	<!-- 顶部背景 -->
	<div class="container">
		<!-- 第一行 -->
		<div class="row">
			<div class="col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1" id="top-bg-div">
				<!-- 头像 -->
				<div>
					<img src="resource/image/头像.jpg">
				</div>
				<!-- 昵称 -->
				<div>
					<h3>孙悟空</h3>
					<p>长生不老与天同寿非我愿</p>
				</div>
			</div>
		</div>
		<!-- 第二行 -->
		<!-- 功能选项 -->
		<div class="row">
			<div class="col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1 func-select-div">
				<div class="row">
					<div class="col-xs-4"><a href="home.jsp">我的微博</a></div>
					<div class="col-xs-4"><a href="photo.jsp">我的相册</a></div>
					<div class="col-xs-4">管理中心</div>
				</div>
			</div>
		</div>
		
		<!-- 第三行，导航栏 -->
		<div class="row" id="photo-nav">
			<nav class="navbar navbar-default col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1" role="navigation">
			    <div class="container-fluid">
				    <div class="navbar-header">
				        <a class="navbar-brand" href="#">照片墙</a>
				    </div>
				    <div>
				        <!--向左对齐-->
				        <ul class="nav navbar-nav navbar-left">
				            <li class="dropdown">
				                <a href="#" class="dropdown-toggle">
				                <span class="glyphicon glyphicon-film"></span>&nbsp;
				                   	 视频
				                </a>
				            </li>
				            <li class="dropdown">
				                <a href="#" class="dropdown-toggle">
				                 <span class="glyphicon glyphicon-thumbs-up"></span>&nbsp;
				                   	 我赞过的
				                </a>
				            </li>
				             <li class="dropdown">
				                <a href="#" class="dropdown-toggle">
				                   	 相册专辑
				                </a>
				            </li>
				        </ul>
				        <!--向右对齐-->
				        <ul class="nav navbar-nav navbar-right">
				            <li class="dropdown">
				                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
				                   <span class="glyphicon glyphicon-picture"></span>&nbsp;上传相片
				                </a>	
				            </li>
				            <li class="dropdown">
				                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
				                	<span class="glyphicon glyphicon-facetime-video"></span>&nbsp;
				                    	上传视频
				                </a>	
				            </li>
				        </ul>			       
				    </div>
		    	</div>
			</nav>
		</div>
		
		<!-- 第四行，相片 -->
		<div class="row" id="photo-main-div">
			<div class="col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1">
				<!-- 待填充 -->
				
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="/billblog/resource/js/jquery.min.js" ></script>
<script type="text/javascript" src="/billblog/resource/js/bootstrap.min.js" ></script>
<script type="text/javascript">

	var wid = parseInt($(window).width());
	
	$(window).scroll(function(){
		if(wid>450){
			var h = parseInt($(window).scrollTop());//滚动到图片导航栏不见时，重新将其定位，使其显示
			if(h>422){
				$("#photo-nav").css("position","relative");
				$("#photo-nav").css("top",h-352);
			}else{
				$("#photo-nav").css("position","static");
			}
		}
	});
	
	//填充图片
	$(document).ready(function(){
		var data ="<div class='container-fluid photo-list-div'><p>今天 12:00</p><div><img src='resource/test/318768-15032013295555.jpg'></img><img src='resource/test/318768-15032013295555.jpg'></img><img src='resource/test/318768-15032013295555.jpg'></img><img src='resource/test/318768-15032013295555.jpg'></img><img src='resource/test/318768-15032013295555.jpg'></img><img src='resource/test/318768-15032013295555.jpg'></img><img src='resource/test/318768-15032013295555.jpg'></img></div></div>";
		for(i=0;i<10;i++){
			$("#photo-main-div>:first-child").append(data);
		}
	});
</script>
</html>