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
<link rel="stylesheet" href="resource/css/common/main-common.css">
<link rel="stylesheet" href="resource/css/home/home.css">
<link rel="stylesheet" href="resource/css/common/home-common.css">
<title>孙悟空的微博</title>
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
		
		<!-- 第三行 -->
		<div class="row" style="margin-top:20px;">
			<div class="col-md-offset-1 col-md-3 col-sm-offset-1 col-sm-3" id="left-div">
				<!-- 微博、粉丝、关注、 -->
				<div class="container-fluid">
					<div class="col-xs-4">
						<div>粉丝</div>
						<div>888</div>
					</div>
					<div class="col-xs-4">
						<div>关注</div>
						<div>212</div>
					</div>
					<div class="col-xs-4">
						<div>微博</div>
						<div>869</div>
					</div>
				</div>
				<!-- 个人信息 -->
				<div class="container-fluid">
					<div>
						<a>申请认证</a>
						<span>等级9</span>
					</div>
					<div class="info-div">
						广西钦州
					</div>
					<div class="info-div">
						毕业于钦州市第二中学
					</div>
					<div class="info-div">
						异性恋
					</div>
					<div class="info-div">
						没脸中
					</div>
					<div class="info-div">
						生日1995年12月25
					</div>
					<div class="info-div">
						<a>编辑个人资料</a>
					</div>
				</div>
				
				<!-- 部分相片展示 -->
				<div class="container-fluid">
					<div>
						相册
					</div>
					<div class="row">
						<!-- 放一张大图 -->
						<div class="col-xs-8"><img src="resource/test/20140622214745_tNe8v.thumb.700_0.jpeg"></div>
						<!-- 放小图 -->
						<div class="col-xs-4">
							<img src="resource/test/318768-15032013295555.jpg"></img>
							<img src="resource/test/aec379310a55b3196238c7f441a98226cefc1769.jpg"></img>
						</div>
						<!-- 放小图 -->
						<div class="col-xs-12" style="font-size:0px;">
							<img src="resource/test/318768-15032013295555.jpg"></img>
							<img src="resource/test/aec379310a55b3196238c7f441a98226cefc1769.jpg"></img>
							<img alt="" src="resource/test/90.jpg">
						</div>
					</div>
				</div>
			</div>
			
			<!-- 主体内容 -->
			<div class="col-md-7 col-sm-7" id="main-div">
				<!-- 微博正文部分 -->
				<div id="content-outer">
					<!-- 待填充 -->
				</div>		
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="/billblog/resource/js/jquery.min.js" ></script>
<script type="text/javascript" src="/billblog/resource/js/bootstrap.min.js" ></script>
<script type="text/javascript" src="/billblog/resource/js/main/main.js"></script>
<script type="text/javascript" src="/billblog/resource/js/home/home.js"></script>
</html>