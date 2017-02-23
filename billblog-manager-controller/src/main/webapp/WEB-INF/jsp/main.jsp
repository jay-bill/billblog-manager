<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"/>
<link rel="SHORTCUT ICON" href="/billblog-manager-controller/resource/image/s_blog.ico">
<link rel="BOOKMARK" href="/billblog-manager-controller/resource/image/s_blog.ico">
<link rel="stylesheet" href="/billblog-manager-controller/resource/css/bootstrap.min.css" />
<link rel="stylesheet" href="/billblog-manager-controller/resource/css/common/common.css"></link>
<link rel="stylesheet" href="/billblog-manager-controller/resource/plug-res/css/lunbo.css">

<link rel="stylesheet" href="/billblog-manager-controller/resource/css/main/main.css">
<link rel="stylesheet" href="/billblog-manager-controller/resource/css/common/main-common.css">

<title>微博-随时随地发现新鲜事儿</title>
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
						<a role="menuitem" tabindex="-1" href="/billblog-manager-controller/imagecontroller/tophotopage.do?userId=${user_id}">
							<span class="glyphicon glyphicon-eye-open"></span>&nbsp;相册
						</a>
					</li>
					<li role="presentation">
						<a role="menuitem" tabindex="-1" href="/billblog-manager-controller/weibocontroller/toreadinfo.do" class="dropdown-toggle">
				          @我
				          <c:if test="${no_read_sum > 0}">
				          	<span style="font-weight:bold;color:red;font-family:'微软雅黑'">${no_read_sum}</span>
				          </c:if>				          
	                	</a>
					</li>
					<li role="presentation">
						<a role="menuitem" tabindex="-1" href="/billblog-manager-controller/writeWeibo.jsp">
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
							<span style="color:blue;">粉丝${user_fans_sum}</span>
						</a>						
					</li>
					<li role="presentation">						
						<a href="/billblog-manager-controller/attentioncontroller/tonoticelistpage.do?userId=${user_id}">							
							<span style="color:blue;">关注${user_noticed_sum}</span>
						</a>						
					</li>
					<li role="presentation">						
						<a href="/billblog-manager-controller/weibocontroller/tohomepage.do?userId=${user_id}">							
							<span style="color:blue;">微博${weibo_sum}</span>
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
								<span class="glyphicon glyphicon-home"></span>&nbsp;我的主页
							</a>
						</li>
						<li>
							<a role="menuitem" tabindex="-1" href="/billblog-manager-controller/imagecontroller/tophotopage.do?userId=${user_id}">
								<span class="glyphicon glyphicon-camera"></span>&nbsp;我的相册
							</a>
						</li>
						<!-- <li>
							<a role="menuitem" tabindex="-1" href="#">
								<span class="glyphicon glyphicon-eye-open"></span>&nbsp;热门微博
							</a>
						</li> -->
						<li></li>
					</ul>
				</div>
				<div class="col-md-7 col-sm-10 col-xs-12" id="center-div">
					
					<!-- 微博输入框 -->
					<form class="hidden-xs" id="input-text-div" action="broadcastweibo.do" method="post" enctype="multipart/form-data">
						<p>有什么新鲜事儿想告诉大家</p>
						<div>
							<textarea id="weiboTextarea" name="weiboContent" style="border:1px solid gray;"></textarea>
						</div>
						<div class="container-fluid" id="input-text-under">
							<div class="col-sm-10">
								<a href="javascript:void(0)" onclick="showEmoji(this)">
									 <span class="glyphicon glyphicon-magnet"></span>
								</a>
								&nbsp;
								<a href="javascript:void(0)">
									<span class="glyphicon glyphicon-picture"></span>
								</a>
<!-- 								<a>视频</a>
								<a>话题</a> -->
								<input name="weiboImages" type="file" multiple  id="uploadImages" accept="image/*" onchange="setImagePreview(this)" style="display:none;"/>
							</div>
							<div class="col-sm-2">
								<input id="broadcast" type="submit" class="btn btn-sm btn-warning" style="float:right;" value="发布 ">								
							</div>
						</div>						
						<!-- 预览栏 -->
						<div id="previewDiv">
							<img id="previewImg" src="">
						</div>
						<!-- 表情栏 -->
						<div id="emojiDiv">
							<ul>
							
							</ul>
						</div>
					</form>
					
					<!-- 微博正文部分 -->
					<div id="content-outer">
						<input type="hidden" value="${user_id}" id="hiddenId">
						<input type="hidden" id="hidden-user-headimg" value="${user_base_info.userHeadimage}"/>
						<!-- 待填充 -->
					</div>			
				</div>
				<div class="col-md-3 hidden-sm hidden-xs" id="right-div">
					<!-- 用户信息 -->
					<div id="user-info-div">
						<div></div>
						<!-- 用户头像 -->
						<div>
							<a href="tohomepage.do?userId=${user_base_info.userId}"><img id="myHeadimage" title="我的主页" src="${user_base_info.userHeadimage}"></a>
						</div>
						
						<div style="margin-top:-30px;text-align:center;">
							<p><a id="nicknameA" href="tohomepage.do?userId=${user_base_info.userId}">${user_base_info.userNickname}</a></p>
							<div class="container-fluid">
								<div class="col-xs-4 nums-div">
									<div>
										<a href="/billblog-manager-controller/attentioncontroller/tonoticelistpage.do?userId=${user_id}">${user_noticed_sum}</a>
									</div>
									<div>
										<a href="/billblog-manager-controller/attentioncontroller/tonoticelistpage.do?userId=${user_id}">关注</a>
									</div>
								</div>
								<div class="col-xs-4 nums-div">
									<div>
										<a href="/billblog-manager-controller/attentioncontroller/tofanslistpage.do?userId=${user_id}">${user_fans_sum}</a>
									</div>
									<div>
										<a href="/billblog-manager-controller/attentioncontroller/tofanslistpage.do?userId=${user_id}">粉丝</a>
									</div>
								</div>
								<div class="col-xs-4 nums-div">
									<div>
										<a href="tohomepage.do?userId=${user_base_info.userId}">${weibo_sum}</a>									
									</div>
									<div>
										<a href="tohomepage.do?userId=${user_base_info.userId}">微博</a>
									</div>
								</div>
							</div>
						</div>
					</div>
					
					<!-- 热门话题 -->
					<div id="hot-topic-div">
						<div>热门话题<a style="float:right;">换一换</a></div>
						<ul>
							<li><a>#电视剧漂亮的李慧珍#</a></li>
							<li><a>#低调组合起点终点#</a></li>
							<li><a>#图书馆派对堪比春运#</a></li>
							<li><a>#言情小说吸粉套路#</a></li>
							<li><a>#电视剧漂亮的李慧珍#</a></li>
							<li><a>#低调组合起点终点#</a></li>
							<li><a>#图书馆派对堪比春运#</a></li>
							<li><a>#言情小说吸粉套路#</a></li>
						</ul>
						<p style="text-align:center;">
							<a>查看更多></a>
						</p>
					</div>
					
					<!-- 广告位 -->
					<div id="advertise-div">
						<div>热门商品推荐</div>
						<div>
							<img alt="" src="/billblog-manager-controller/resource/image/adv.jpg">
						</div>
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
			<p>
				联系QQ:2399599130，
				电话：18813296645
			</p>
		</div>
	</footer>
</body>
<script type="text/javascript" src="/billblog-manager-controller/resource/js/jquery.min.js" ></script>
<script type="text/javascript" src="/billblog-manager-controller/resource/js/bootstrap.min.js" ></script>
<script type="text/javascript" src="/billblog-manager-controller/resource/js/main/main.js"></script>
<script type="text/javascript" src="/billblog-manager-controller/resource/js/common/commonUse.js"></script>
<script type="text/javascript" src="/billblog-manager-controller/resource/js/common/image.js"></script>

<script type="text/javascript" src="/billblog-manager-controller/resource/js/like/like-weibo.js"></script>
<script type="text/javascript" src="/billblog-manager-controller/resource/js/comments/comments-ajax.js"></script>
<script type="text/javascript" src="/billblog-manager-controller/resource/js/common/main-home.js"></script>

<script type="text/javascript" src="/billblog-manager-controller/resource/js/main/main-ajax.js"></script>
<script type="text/javascript" src="/billblog-manager-controller/resource/plug-res/js/jquery.event.drag.js" ></script>
<script type="text/javascript" src="/billblog-manager-controller/resource/plug-res/js/jquery.touchSlider.js" ></script>
<script type="text/javascript" src="/billblog-manager-controller/resource/plug-res/js/smohan.face.js" ></script>

<script type="text/javascript">
	$("#searchImg").click(function(){
		$("#searchForm").submit();
	});
	
	//头像旋转
	$("#myHeadimage").mouseenter(function(){
		$(this).addClass("headRotate");
	});
	$("#myHeadimage").mouseleave(function(){
		$(this).addClass("headLeaveRotate");
		$(this).removeClass("headRotate");
		var tmp = $(this);
		setTimeout(function(){
			tmp.removeClass("headLeaveRotate");
		},150);
	});
	
	//logo翻转
	$("#logo img").mouseenter(function(){
		$(this).addClass("rotateYLogo");
	});
	$("#logo img").mouseleave(function(){
		$(this).addClass("rotatoYLogoLeave");
		$(this).removeClass("rotateYLogo");
		var tmp = $(this);
		setTimeout(function(){
			tmp.removeClass("rotatoYLogoLeave");
		},600); 
	});

</script>
</html>