<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"/>
<link rel="SHORTCUT ICON" href="/billblog-manager-controller/resource/image/s_blog.ico">
<link rel="BOOKMARK" href="/billblog-manager-controller/resource/image/s_blog.ico">
<link rel="stylesheet" href="/billblog-manager-controller/resource/css/bootstrap.min.css" />
<link rel="stylesheet" href="/billblog-manager-controller/resource/css/common/common.css"></link>
<link rel="stylesheet" href="/billblog-manager-controller/resource/css/common/main-common.css">
<link rel="stylesheet" href="/billblog-manager-controller/resource/css/home/home.css">
<link rel="stylesheet" href="/billblog-manager-controller/resource/css/common/home-common.css">
<link rel="stylesheet" href="/billblog-manager-controller/resource/css/user-info/user-info.css">
<title>孙悟空的微博</title>
</head>
<body>
	<!-- 导航栏 -->
	<div class="row navbar-fixed-top" id="nav"> 
		<div class="container" id="nav-con">
			<!-- logo -->
			<div class="col-md-2 col-xs-9" id="logo">
				<img alt="" src="/billblog-manager-controller/resource/image/s_weibo.png">
			</div>
			<!-- 输入栏 -->
			<div class="col-md-5 hidden-sm hidden-xs">
				<div id="search-div">
					<input>
					<img alt="" src="/billblog-manager-controller/resource/image/search.png">
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
					<img src="${user_base_info.userHeadimage}">
				</div>
				<!-- 昵称 -->
				<div>
					<h3>${user_base_info.userNickname}</h3>
					<p>
						<c:set var="flagSignature" value="0"></c:set>
						<c:if test="${user_info.userSignature eq null}">
							<c:set var="flagSignature" value="1"></c:set>
							编辑您的个性签名
						</c:if>
						<c:if test="${flagAddress eq 0}">
							${user_info.userSignature}
						</c:if>							
					</p>
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
						<div>${user_fans_sum}</div>
					</div>
					<div class="col-xs-4">
						<div>关注</div>
						<div>${user_noticed_sum}</div>
					</div>
					<div class="col-xs-4">
						<div>微博</div>
						<div>${weibo_sum}</div>
					</div>
				</div>
				<!-- 等级信息 -->
				<div>
					<div>
						<h4>等级信息</h4>
					</div>
					<div>
						<p style="margin-top:20px;">当前等级：Lv ${user_base_info.userLevel}</p>
					</div>
				</div>				
			</div>
			
			<!-- 主体内容 -->
			<div class="col-md-7 col-sm-7" id="main-div">
				<!-- 个人信息部分 -->
				<div id="content-outer">
					<!-- 基本信息 -->
					<div>
						<div>
							<span>基本信息</span>
							&nbsp;
							<button>编辑</button>
						</div>
						<div>
							<p>
								<span>昵称</span>
								<span id="userNickname">${user_base_info.userNickname}</span>
							</p>
							<p>
								<span>所在地</span>
								<span id="userAddress">${user_info.userAddress}</span>
							</p>
							<p>
								<span>性别</span>								
								<span id="userSex">${user_info.userSex}</span>
							</p>
							<p>
								<span>性取向</span>
								<span id="userTropism">${user_info.userTropism}</span>
							</p>
							<p>
								<span>感情状况</span>
								<span id="userLoveState">${user_info.userLovestate}</span>
							</p>
							<p>
								<span>生日</span>
								<span id="userBirthday">${user_info.userBirthday}</span>
							</p>
							<p>
								<span>注册时间</span>
								<span>${user_base_info.userDatetime}</span>
							</p>
							<p>
								<span>毕业学校</span>
								<span id="userSchool">${user_info.userSchool}</span>
							</p>
							<p>
								<span>工作</span>
								<span id="userPosition">${user_info.userPosition}</span>
							</p>
						</div>
					</div>
					<!-- 其他信息 -->
				</div>		
			</div>
			<!-- 隐藏起来的 -->
					<div class="col-md-7 col-sm-7" id="main-display-div" style="display:none;">
						<!-- 个人信息部分 -->
						<!-- ajax提交表单 -->					
						<!-- 基本信息 -->
						<div id="content-display-outer">
						<div>
							<div>
								<span>基本信息</span>
								&nbsp;
								<button id="saveInfo">保存</button>
							</div>
							<form id="userInfoForm" method="post">
							<div>
								<p>
									<span>昵称</span>
									<input name="userNickname" value="2395956@ww.cpm"/>
								</p>
								<p>
									<span>个性签名</span>
									<input name="userSignature" value="这是个性签名！"/>
								</p>
								<p>
									<span>所在地</span>
									<input name="userAddress" value="广西钦州">
								</p>
								<p>
									<span>性别</span>								
									<input name="userSex" type="radio" value="0">男
									<input name="userSex" type="radio" value="1">女
								</p>
								<p>
									<span>性取向</span>
									<select name="userTropism">
										<option value="0">异性恋</option>
										<option value="1">双性恋</option>
										<option value="2">同性恋</option>
									</select>
								</p>
								<p>
									<span>感情状况</span>
									<select name="userLovestate">
										<option value="0">单身</option>
										<option value="1">恋爱中</option>
										<option value="2">已婚</option>
										<option value="3">离异</option>
									</select>
								</p>
								<p>
									<span>生日</span>
									<input name="userBirthday" value="1995-11-04">
								</p>
								<p>
									<span>注册时间</span>
									<span>2017-01-18</span>
								</p>
								<p>
									<span>学校</span>
									<input name="userSchool" value="钦州市第二中学"/>
								</p>
								<p>
									<span>工作</span>
									<input name="userPosition" value="软件架构师"/>
								</p>
							</div>
						</form>									
						</div>
					<!-- 其他信息 -->
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
<script type="text/javascript" src="/billblog-manager-controller/resource/js/main/main.js"></script>
<script type="text/javascript" src="/billblog-manager-controller/resource/js/home/home.js"></script>
<script type="text/javascript" src="/billblog-manager-controller/resource/js/user-info/user-info.js"></script>
</html>