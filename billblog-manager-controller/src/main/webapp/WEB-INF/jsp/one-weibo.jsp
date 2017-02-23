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
<link rel="stylesheet" href="/billblog-manager-controller/resource/css/common/main-common.css"></link>
<link rel="stylesheet" href="/billblog-manager-controller/resource/plug-res/css/lunbo.css">

<title>孙悟空的微博</title>
</head>
<body>
	<!-- 导航栏 -->
	<div class="row navbar-fixed-top" id="nav"> 
		<div class="container" id="nav-con">
			<!-- logo -->
			<div class="col-md-2 col-xs-9" id="logo">
				<a href="/billblog-manager-controller/weibocontroller/tomainpage.do">
					<img alt="" src="/billblog-manager-controller/resource/image/s_weibo.png">
				</a>
			</div>
			<!-- 输入栏 -->
			<form id="searchForm" class="col-md-5 hidden-sm hidden-xs" action="/billblog-manager-controller/searchcontroller/searchUser.do">
				<div id="search-div">
					<input name="userNickname">
					<img id="searchImg" alt="" src="/billblog-manager-controller/resource/image/search.png">
				</div>
			</form>
			<!-- 右边的菜单,中等屏幕时显示 -->
			<!-- 右边的菜单,中等屏幕时显示 -->
			<div class="col-md-5 hidden-sm hidden-xs">
				<div class="container-fluid">
					<div class="col-md-2 nav-right">
						<a href="/billblog-manager-controller/weibocontroller/tomainpage.do" class="dropdown-toggle">
				          <span class="glyphicon glyphicon-home"></span>&nbsp;首页
	               		</a>
					</div>
					<div class="col-md-2 nav-right">
						<a href="/billblog-manager-controller/weibocontroller/tohomepage.do?userId=${user_id}" class="dropdown-toggle">
				          <span class="	glyphicon glyphicon-home"></span>&nbsp;主页
	                	</a>
					</div>
					<div class="col-md-2 nav-right">
						<a href="/billblog-manager-controller/imagecontroller/tophotopage.do?userId=${user_id}" class="dropdown-toggle">
				          <span class="	glyphicon glyphicon-camera"></span>&nbsp;相册
	                	</a>
					</div>					
					<div class="col-md-2 nav-right spe-nav-right">
						<span>
							<a id="mynicknameA" href="/billblog-manager-controller/weibocontroller/tohomepage.do?userId=${user_id}"
							 class="dropdown-toggle">
							 ${user_base_info.userNickname}
							</a>
						</span>					
					</div>
					<div class="col-md-2 nav-right">
						<a href="/billblog-manager-controller/weibocontroller/toreadinfo.do" class="dropdown-toggle">
				          @我
						  <c:if test="${no_read_sum > 0}">
				          	<span style="font-weight:bold;color:red;font-family:'微软雅黑'">${no_read_sum}</span>
				          </c:if>
	                	</a>
					</div>
					<div class="col-md-2 nav-right">
						<a href="/billblog-manager-controller/logincontroller/loginout" class="dropdown-toggle">注销</a>
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
						<a role="menuitem" tabindex="-1" href="/billblog-manager-controller/weibocontroller/tomainpage.do">
							<span class="glyphicon glyphicon-home"></span>&nbsp;首页
						</a>
					</li>
					<li role="presentation">
						<a role="menuitem" tabindex="-1" href="/billblog-manager-controller/weibocontroller/tohomepage.do?userId=${user_id}">
							<span class="	glyphicon glyphicon-facetime-video"></span>&nbsp;主页
						</a>
					</li>
					<li role="presentation">
						<a role="menuitem" tabindex="-1" href="javascript:void(0)" onclick="showWriteWeiboDiv()">
							<span class="glyphicon glyphicon-eye-open"></span>&nbsp;写微博
						</a>
					</li>
					<li role="presentation">
						<a role="menuitem" tabindex="-1" href="javascript:void(0)" onclick="showSearchDiv()">
							<span class="glyphicon glyphicon-eye-open"></span>&nbsp;搜索
						</a>
					</li>
					<li role="presentation">						
						<a id="mynicknameA" role="menuitem" tabindex="-1" 
						href="/billblog-manager-controller/weibocontroller/tohomepage.do?userId=${user_id}">
							<span style="color:blue;">${user_base_info.userNickname}</span>
						</a>						
					</li>
					<li role="presentation" class="divider"></li>
					<li role="presentation">						
						<a href="/billblog-manager-controller/attentioncontroller/tofanslistpage.do?userId=${user_id}">							
							<span style="color:blue;">${user_base_info.userNickname}粉丝${user_fans_sum}</span>
						</a>						
					</li>
					<li role="presentation">						
						<a href="/billblog-manager-controller/attentioncontroller/tonoticelistpage.do?userId=${user_id}">							
							<span style="color:blue;">${user_base_info.userNickname}关注${user_noticed_sum}</span>
						</a>						
					</li>
					<li role="presentation">						
						<a href="/billblog-manager-controller/weibocontroller/tohomepage.do?userId=${user_id}">							
							<span style="color:blue;">${user_base_info.userNickname}微博${weibo_sum}</span>
						</a>						
					</li>
					<li role="presentation" class="divider"></li>
					<li role="presentation">
						<a role="menuitem" tabindex="-1" href="/billblog-manager-controller/logincontroller/loginout">登出</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
	
			<!-- 主题内容 -->
	<div class="container" id="main-outer">
		<div class="container-fluid">
			<div class="container-fluid" id="main-con">
				<div class="col-md-2 hidden-xs col-sm-2">
					<ul id="left-ul">
						<li>
							<a role="menuitem" tabindex="-1" href="/billblog-manager-controller/weibocontroller/tomainpage.do">
								<span></span>&nbsp;首页
							</a>
						</li>
						<li>
							<a role="menuitem" tabindex="-1" href="/billblog-manager-controller/weibocontroller/tohomepage.do?userId=${user_id}">
								<span class="glyphicon glyphicon-eye-open"></span>&nbsp;我的主页
							</a>
						</li>
						<li>
							<a role="menuitem" tabindex="-1" href="/billblog-manager-controller/imagecontroller/tophotopage.do?userId=${user_id}">
								<span class="glyphicon glyphicon-eye-open"></span>&nbsp;我的相册
							</a>
						</li>
						<li>
							<a role="menuitem" tabindex="-1" href="#">
								<span class="glyphicon glyphicon-eye-open"></span>&nbsp;热门微博
							</a>
						</li>
						<li></li>
					</ul>
				</div>
				<div class="col-md-7 col-sm-10 col-xs-12" id="center-div">	
					<input type="hidden" id="hidden-weibo-id" value="${weibo_id}"/>
					<input type="hidden" id="hidden-user-headimg" value="${user_base_info.userHeadimage}"/>				
					<!-- 微博正文部分 -->
					<div id="content-outer">
						<input id="hiddenId" type="hidden" value="${user_info.userId }">
						<input type="hidden" value="${user_id}" id="hiddenId">
						<!-- 待填充 -->
					</div>			
				</div>		
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="/billblog-manager-controller/resource/js/jquery.min.js" ></script>
<script type="text/javascript" src="/billblog-manager-controller/resource/js/bootstrap.min.js" ></script>
<script type="text/javascript" src="/billblog-manager-controller/resource/js/common/main-home.js"></script>
<script type="text/javascript" src="/billblog-manager-controller/resource/js/common/image.js"></script>
<script type="text/javascript" src="/billblog-manager-controller/resource/js/main/main.js"></script>
<script type="text/javascript" src="/billblog-manager-controller/resource/js/like/like-weibo.js"></script>
<script type="text/javascript" src="/billblog-manager-controller/resource/js/comments/comments-ajax.js"></script>
<script type="text/javascript" src="/billblog-manager-controller/resource/js/one-weibo/one-weibo.js"></script>
<script type="text/javascript" src="/billblog-manager-controller/resource/plug-res/js/jquery.event.drag.js" ></script>
<script type="text/javascript" src="/billblog-manager-controller/resource/plug-res/js/jquery.touchSlider.js" ></script>

<script type="text/javascript">
	$(".comment-text-div").css("width",parseInt($(".comment-show-div").width())-30-30);
</script>
</html>