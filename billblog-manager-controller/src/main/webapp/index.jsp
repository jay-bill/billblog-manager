<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"/>
<link rel="SHORTCUT ICON" href="resource/image/s_blog.ico">
<link rel="BOOKMARK" href="resource/image/s_blog.ico">
<link rel="stylesheet" href="resource/css/bootstrap.min.css" />
<title>微博-随时随地发现新鲜事儿</title>
<link rel="stylesheet" href="resource/css/common/common.css"></link>
<link rel="stylesheet" href="resource/css/index/index.css"></link>
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
					<img alt="" src="resource/image/search.png">
				</div>
			</div>
			<!-- 右边的菜单,中等屏幕时显示 -->
			<div class="col-md-5 hidden-sm hidden-xs">
				<div class="container-fluid">
					<div class="col-md-2 nav-right">
						<a href="#" class="dropdown-toggle">
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
					<div class="col-md-2 nav-right">
						<a href="regist.jsp" class="dropdown-toggle">注册</a>
					</div>
					<div class="col-md-2 nav-right">
						<a href="index.jsp" class="dropdown-toggle">登录</a>
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
	
	<!-- 主题内容 -->
	<div class="container" id="main-outer">
		<div class="container-fluid">
			<div class="container-fluid" id="main-con">
				<div class="col-md-2 hidden-xs hidden-sm">
					<ul id="left-ul">
						<li>
							<a role="menuitem" tabindex="-1" href="#">
								<span class="	glyphicon glyphicon-eye-open"></span>&nbsp;热门
							</a>
						</li>
						<li>
							<a role="menuitem" tabindex="-1" href="#">
								<span class="	glyphicon glyphicon-eye-open"></span>&nbsp;热门
							</a>
						</li>
						<li>
							<a role="menuitem" tabindex="-1" href="#">
								<span class="	glyphicon glyphicon-eye-open"></span>&nbsp;热门
							</a>
						</li>
						<li>
							<a role="menuitem" tabindex="-1" href="#">
								<span class="	glyphicon glyphicon-eye-open"></span>&nbsp;热门
							</a>
						</li>
						<li></li>
					</ul>
				</div>
				<div class="col-md-7 hidden-xs hidden-sm" id="center-div">
					<div class="content">
						老司机...老司机...为了江苏台跨年晚会的收视率，SNH48的妹子们也是把偶像包袱都丢光了吧
						昨晚，TFBOYS参加了#湖南卫视跨年# 演唱会，不仅带来《是你》和新歌《萤火》首唱，三人也
						分别献唱个人单曲；还与现场前辈及观众共同迎接零点[羞嗒嗒]今晚七点半锁定湖南卫
					</div>
				</div>
				<div class="col-md-3 col-sm-12 col-xs-12">
					<div id="right-div">
						<span>${login_error}</span>
						<form class="form-horizontal" role="form" action="logincontroller/login" method="post">
						  <div class="form-group">
						    <div class="col-md-6 col-sm-6 col-xs-12">
						      	<div  style="border-bottom:3px solid #fa7d3c;text-align:center;">
						      		账号登录
						      	</div>
						    </div>
						    <div class="col-md-6 col-sm-6 hidden-xs">
						      	<div  style="text-align:center;">
						      		安全登录
						      	</div>
						    </div>
						  </div>
						  <div class="form-group">
						    <div class="col-sm-12">
						      <input type="text" class="form-control" name="userAccount" placeholder="请输入账号">
						    </div>
						  </div>
						  <div class="form-group">
						    <div class="col-sm-12">
						      <input type="password" class="form-control" name="userPassword" placeholder="请输入密码">
						    </div>
						  </div>
						  <div class="form-group">
						    <div class="col-sm-12">
						      <input type="submit" class="btn btn-primary btn-warning btn-block"/>
						    </div>
						  </div>
						  <div class="form-group">
						    <div class="col-sm-12">
						    	<p>还没有微博？<a href="regist.jsp">立即注册！</a></p>
						    </div>
						  </div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 页尾 -->
	<footer class="hidden-xs hidden-sm">
		<div>
			<span>微博客服</span>
			<span>意见反馈</span>
			<span>舞弊举报</span>
			<span>开方平台</span>
			<span>微博招聘</span>
			<span>服务大厅</span>
			<p>
				<span>粤ICP证100780号</span>
				<span>大粤网201430260259号</span>
				<span>Copyright © 2017-2018 WEIBO 广州标新科技网络技术有限公司</span>
			</p>
		</div>
	</footer>
</body>
	 <script type="text/javascript" src="/billblog-manager-controller/resource/js/jquery.min.js" ></script>
	 <script type="text/javascript" src="/billblog-manager-controller/resource/js/bootstrap.min.js" ></script>
	 <script type="text/javascript">
	    $(window).scroll(function(){
	    	var h = $(window).scrollTop();
	    	if(parseInt(h)>340){
	    		$("#right-div").css("position","relative");
	    		$("#right-div").css("top",parseInt(h));
	    		$("#left-ul").css("position","relative");
	    		$("#left-ul").css("top",parseInt(h));
	    		
	    	}else{
	    		$("#right-div").css("position","static");
	    		$("#left-ul").css("position","static");
	    	}
	    });
	 </script>
</html>