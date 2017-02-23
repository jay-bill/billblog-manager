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
<link rel="stylesheet" href="/billblog-manager-controller/resource/plug-res/css/lunbo.css">

<link rel="stylesheet" href="/billblog-manager-controller/resource/plug-res/css/common.css">
<link rel="stylesheet" href="/billblog-manager-controller/resource/css/common/common.css"></link>
<link rel="stylesheet" href="/billblog-manager-controller/resource/css/common/main-common.css">
<link rel="stylesheet" href="/billblog-manager-controller/resource/css/home/home.css">
<link rel="stylesheet" href="/billblog-manager-controller/resource/css/common/home-common.css">
<style>
	.text-bottom-div div{
		padding:0px;
	}
</style>
<title>${other_user_base_info.userNickname}的微博</title>
</head>
<body>
<!-- 导航栏 -->
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
					<c:if test="${user_id>0}">
						<li role="presentation">
							<a role="menuitem" tabindex="-1" href="/billblog-manager-controller/weibocontroller/tohomepage.do?userId=${user_id}">
								<span class="	glyphicon glyphicon-facetime-video"></span>&nbsp;主页
							</a>
						</li>
					</c:if>
					<c:if test="${user_id>0}">
						<li role="presentation">
							<a role="menuitem" tabindex="-1" href="javascript:void(0)" onclick="showWriteWeiboDiv()">
								<span class="glyphicon glyphicon-eye-open"></span>&nbsp;写微博
							</a>
						</li>
					</c:if>
					<li role="presentation">
						<a role="menuitem" tabindex="-1" href="javascript:void(0)" onclick="showSearchDiv()">
							<span class="glyphicon glyphicon-eye-open"></span>&nbsp;搜索
						</a>
					</li>
					<c:if test="${user_id>0}">
						<li role="presentation">						
							<a id="mynicknameA" role="menuitem" tabindex="-1" 
							href="/billblog-manager-controller/weibocontroller/tohomepage.do?userId=${user_id}">
								<span style="color:blue;">${user_base_info.userNickname}</span>
							</a>						
						</li>
					</c:if>
					<c:if test="${user_id eq other_user_base_info.userId}">
						<li role="presentation">						
							<a role="menuitem" tabindex="-1" 
							href="/billblog-manager-controller/userinfocontroller/touserinfo.do?userId=${user_id}">
								<span style="color:blue;">编辑信息</span>
							</a>						
						</li>
					</c:if>
					<li role="presentation">						
						<a role="menuitem" tabindex="-1" 
						href="/billblog-manager-controller/userinfocontroller/touserinfo.do?userId=${other_user_base_info.userId}">
							<span style="color:blue;">查看信息</span>
						</a>						
					</li>
					<li role="presentation" class="divider"></li>
					<li role="presentation">						
						<a href="/billblog-manager-controller/attentioncontroller/tofanslistpage.do?userId=${other_user_base_info.userId}">							
							<span style="color:blue;">${other_user_base_info.userNickname}粉丝${user_fans_sum}</span>
						</a>						
					</li>
					<li role="presentation">						
						<a href="/billblog-manager-controller/attentioncontroller/tonoticelistpage.do?userId=${other_user_base_info.userId}">							
							<span style="color:blue;">${other_user_base_info.userNickname}关注${user_noticed_sum}</span>
						</a>						
					</li>
					<li role="presentation">						
						<a href="/billblog-manager-controller/weibocontroller/tohomepage.do?userId=${other_user_base_info.userId}">							
							<span style="color:blue;">${other_user_base_info.userNickname}微博${weibo_sum}</span>
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
	
	<!-- 顶部背景 -->
	<div class="container">
		<!-- 第一行 -->
		<div class="row">
			<div class="col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1" id="top-bg-div">
				<!-- 头像 -->
				<form action="/billblog-manager-controller/imagecontroller/updateheadimage.do"
				 	method="post" enctype="multipart/form-data">
					<input type="file" name="headImage" style="display:none;">
					<img title="更换头像" id="myHeadimage" src="${other_user_base_info.userHeadimage}">
				</form>
				<!-- 昵称 -->
				<div>
					<h3>
						<a id="nicknameA" href="/billblog-manager-controller/weibocontroller/tohomepage.do?userId=${other_user_base_info.userId}">
						${other_user_base_info.userNickname}
						</a>
					</h3>
					<p>
						<c:set var="flagSignature" value="0"></c:set>
						<c:if test="${user_info.userSignature eq null}">
							<c:set var="flagSignature" value="1"></c:set>
							编辑您的个性签名
						</c:if>
						<c:if test="${flagSignature eq 0}">
							${user_info.userSignature}
						</c:if>							
					</p>
					<c:if test="${other_user_base_info.userId ne user_id}">
						<div>
							<button id="noticeAId" onclick="notice(${other_user_base_info.userId},this)" class="btn btn-info" style="display:none;">关注</button>
							<button id="avoidNoticeAId" onclick="avoidNotice(${other_user_base_info.userId},this)" class="btn btn-success" style="display:none;">已关注</button>
							<button id="avoidNoticeAIdEach" onclick="avoidNotice(${other_user_base_info.userId},this)" class="btn btn-default" style="display:none;">互相关注</button>
						</div>
					</c:if>
				</div>
			</div>
		</div>
		<!-- 第二行 -->
		<!-- 功能选项 -->
		<div class="row">
			<div class="col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1 func-select-div">
				<div class="row">
					<div class="col-xs-4"><a href="tohomepage.do?userId=${other_user_base_info.userId}">微博</a></div>
					<div class="col-xs-4"><a href="/billblog-manager-controller/imagecontroller/tophotopage.do?userId=${other_user_base_info.userId }">相册</a></div>
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
						<div><a href="/billblog-manager-controller/attentioncontroller/tofanslistpage.do?userId=${other_user_base_info.userId}">粉丝</a></div>
						<div>
							<a href="/billblog-manager-controller/attentioncontroller/tofanslistpage.do?userId=${other_user_base_info.userId}">
						${user_fans_sum}
							</a>
						</div>
					</div>
					<div class="col-xs-4">
						<div><a href="/billblog-manager-controller/attentioncontroller/tonoticelistpage.do?userId=${other_user_base_info.userId}">关注</a></div>
						<div><a href="/billblog-manager-controller/attentioncontroller/tonoticelistpage.do?userId=${other_user_base_info.userId}">${user_noticed_sum}</a></div>
					</div>
					<div class="col-xs-4">
						<div>
							<a href="tohomepage.do?userId=${other_user_base_info.userId}">微博</a>
						</div>
						<div>
							<a href="tohomepage.do?userId=${other_user_base_info.userId}">${weibo_sum}</a>
						</div>
					</div>
				</div>
				<!-- 个人信息 -->
				<div class="container-fluid">
					<div>
						<a>申请认证</a>
						<span>等级${other_user_base_info.userLevel}</span>
					</div>
					<div class="info-div">
						<c:set var="flagSex" value="0"></c:set>
						<c:if test="${user_info.userSex eq null}">
							<c:set var="flagSex" value="1"></c:set>
							您的性别是？
						</c:if>
						<c:if test="${flagSex eq 0}">
							<c:if test="${user_info.userSex eq 0}">
								男
							</c:if>
							<c:if test="${user_info.userSex eq 1}">
								女
							</c:if>
						</c:if>						
					</div>
					<div class="info-div">
						<c:set var="flagAddress" value="0"></c:set>
						<c:if test="${user_info.userAddress eq null}">
							<c:set var="flagAddress" value="1"></c:set>
							您的住址是？
						</c:if>
						<c:if test="${flagAddress eq 0}">
							${user_info.userAddress}
						</c:if>						
					</div>
					<div class="info-div">
						<c:set var="flagSchool" value="0"></c:set>
						<c:if test="${user_info.userSchool eq null}">
							<c:set var="flagSchool" value="1"></c:set>
							您毕业学校是？
						</c:if>
						<c:if test="${flagSchool eq 0}">
							${user_info.userSchool}
						</c:if>
					</div>
					<div class="info-div">
						<c:set var="flagLovestate" value="0"></c:set>
						<c:if test="${user_info.userLovestate eq null}">
							<c:set var="flagLovestate" value="1"></c:set>
							您的恋爱状态是？
						</c:if>
						<c:if test="${flagLovestate eq 0}">
							<c:if test="${user_info.userLovestate eq 0}">
								单身
							</c:if>
							<c:if test="${user_info.userLovestate eq 1}">
								恋爱中
							</c:if>
							<c:if test="${user_info.userLovestate eq 2}">
								已婚
							</c:if>
							<c:if test="${user_info.userLovestate eq 3}">
								离异
							</c:if>
						</c:if>						
					</div>
					<div class="info-div">
						<c:set var="flagTropism" value="0"></c:set>
						<c:if test="${user_info.userTropism eq null}">
							<c:set var="flagTropism" value="1"></c:set>
							您的性取向是？
						</c:if>
						<c:if test="${flagTropism eq 0}">
							<c:if test="${user_info.userTropism eq 0}">
								异性恋
							</c:if>
							<c:if test="${user_info.userTropism eq 1}">
								双性恋
							</c:if>
							<c:if test="${user_info.userTropism eq 2}">
								同性恋
							</c:if>
						</c:if>		
					</div>
					<div class="info-div">
						<c:set var="flagBirthday" value="0"></c:set>
						<c:if test="${user_info.userLovestate eq null}">
							<c:set var="flagBirthday" value="1"></c:set>
							您的生日是？
						</c:if>
						<c:if test="${flagBirthday eq 0}">
							${user_info.userBirthday}
						</c:if>	
					</div>
					<div class="info-div">
						<a href="/billblog-manager-controller/userinfocontroller/touserinfo.do?userId=${user_base_info.userId}">编辑个人资料</a>
					</div>
				</div>
				
				<!-- 部分相片展示 -->
				<div class="container-fluid">
					<div>
						相册
					</div>
					<div class="row">
						<!-- 放一张大图 -->
						<div class="col-xs-8"><img src="${img_list[0].imagePath}"class='weiboImage'  onclick="showBigImageCanScroll(this)"></div>
						<!-- 放小图 -->
						<div class="col-xs-4">
							<img src="${img_list[1].imagePath}" class='weiboImage' onclick="showBigImageCanScroll(this)"></img>
							<img src="${img_list[2].imagePath}" class='weiboImage' onclick="showBigImageCanScroll(this)"></img>
						</div>
						<!-- 放小图 -->
						<div class="col-xs-12" style="font-size:0px;">
							<img src="${img_list[3].imagePath}" class='weiboImage'  onclick="showBigImageCanScroll(this)"></img>
							<img src="${img_list[4].imagePath}" class='weiboImage'  onclick="showBigImageCanScroll(this)"></img>
							<img src="${img_list[5].imagePath}" class='weiboImage'  onclick="showBigImageCanScroll(this)">
						</div>						
					</div>
					<!-- 查看大图 -->
					<div style="text-align:center;">
						<a href="/billblog-manager-controller/imagecontroller/tophotopage.do?userId=${other_user_base_info.userId }">查看更多</a>
					</div>
				</div>
			</div>
			
			<!-- 主体内容 -->
			<div class="col-md-7 col-sm-7" id="center-div">
				<!-- 微博正文部分 -->
				<div id="content-outer">
					<!-- 待填充 -->
					<input type="hidden" id="hidden-user-headimg" value="${user_base_info.userHeadimage}"/>
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
<script type="text/javascript" src="/billblog-manager-controller/resource/js/common/commonUse.js"></script>
<script type="text/javascript" src="/billblog-manager-controller/resource/js/common/image.js"></script>

<script type="text/javascript" src="/billblog-manager-controller/resource/js/home/home.js"></script>
<script type="text/javascript" src="/billblog-manager-controller/resource/js/like/like-weibo.js"></script>
<script type="text/javascript" src="/billblog-manager-controller/resource/js/comments/comments-ajax.js"></script>
<script type="text/javascript" src="/billblog-manager-controller/resource/js/common/main-home.js"></script>

<script type="text/javascript" src="/billblog-manager-controller/resource/js/home/home-ajax.js"></script>
<script type="text/javascript" src="/billblog-manager-controller/resource/plug-res/js/jquery.event.drag.js" ></script>
<script type="text/javascript" src="/billblog-manager-controller/resource/plug-res/js/jquery.touchSlider.js" ></script>

<script type="text/javascript">
	$("#searchImg").click(function(){
		$("#searchForm").submit();
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