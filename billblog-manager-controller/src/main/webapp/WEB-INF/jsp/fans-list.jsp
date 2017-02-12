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
<link rel="stylesheet" href="/billblog-manager-controller/resource/plug-res/css/common.css">
<link rel="stylesheet" href="/billblog-manager-controller/resource/css/common/common.css"></link>
<link rel="stylesheet" href="/billblog-manager-controller/resource/css/common/main-common.css">
<link rel="stylesheet" href="/billblog-manager-controller/resource/css/home/home.css">
<link rel="stylesheet" href="/billblog-manager-controller/resource/css/common/home-common.css">
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
				<input id="hiddenId" type="hidden" value="${other_user_id}">
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
						<span><a id="mynicknameA" href="/billblog-manager-controller/weibocontroller/tohomepage.do?userId=${user_id}" class="dropdown-toggle">${user_base_info.userNickname}</a></span>
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
				<div>
					<a href="/billblog-manager-controller/weibocontroller/tohomepage.do?userId=${user_info.userId}">
						<img src="${other_user_base_info.userHeadimage}">
					</a>			
				</div>
				<!-- 昵称 -->
				<div>
					<h3>
						<a id="nicknameA" 
						href="/billblog-manager-controller/weibocontroller/tohomepage.do?userId=${other_user_base_info.userId}">
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
		
		<!-- 第三行 -->
		<div class="row" style="margin-top:20px;">
			<div class="col-md-offset-1 col-md-3 col-sm-offset-1 col-sm-3" id="left-div">
				<!-- 微博、粉丝、关注、 -->
				<div class="container-fluid">
					<div class="col-xs-4">
						<div><a style="color:red;" href="/billblog-manager-controller/attentioncontroller/tofanslistpage.do?userId=${other_user_base_info.userId}">粉丝</a></div>
						<div>
							<a style="color:red;" href="/billblog-manager-controller/attentioncontroller/tofanslistpage.do?userId=${other_user_base_info.userId}">
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
				<!-- 粉丝列表 -->
				<div id="content-outer">
					<!-- 具体信息 -->						
			</div>
			<!--分页-->
			<div>
				<a href="javascript:void(0)" onclick="getFansListByPre()">上一页</a>												
				<c:if test="${user_fans_sum%5 eq 0}">
					<c:set var="pageNum" value="${user_fans_sum/5}"></c:set>
				</c:if>
				<c:if test="${user_fans_sum%5 ne 0}">
					<c:set var="pageNum" value="${1+user_fans_sum/5}"></c:set>
				</c:if>
				<c:forEach varStatus="number" begin="1"  end="${pageNum}">
					<a href="javascript:void(0)" onclick="getFansListDataByNum('${number.index}')">${number.index}</a>
				</c:forEach>
				<a href="javascript:void(0)" onclick="getFansListByAfter()">下一页</a>
			</div>
			<!-- 隐藏起来的 -->			
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
<script type="text/javascript" src="/billblog-manager-controller/resource/js/relative/relative.js"></script>
<script type="text/javascript" src="/billblog-manager-controller/resource/js/relative/fans-list.js"></script>
<script type="text/javascript">
	$("#searchImg").click(function(){
		$("#searchForm").submit();
	});
</script>
</html>