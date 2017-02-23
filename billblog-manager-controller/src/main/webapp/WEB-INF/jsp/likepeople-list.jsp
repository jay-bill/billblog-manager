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
<link rel="stylesheet" href="/billblog-manager-controller/resource/css/search/search-user.css"></link>
<link rel="stylesheet" href="/billblog-manager-controller/resource/css/like/like.css"></link>
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
	
	<div class="container" id="main-div">
	<!-- 第二行 -->
		<div class="row">
			<div class="col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1">
				<h1>点赞的人</h1>	
				<p>分页功能尚未实现</p>			
				<c:forEach var="other_user_base_info" items="${other_user_base_info_list}" varStatus="VS">
					<div class="col-md-8 col-sm-9 person-id">
						<div class="head-div">
							<a href="/billblog-manager-controller/weibocontroller/tohomepage.do?userId=${other_user_base_info.userId}">
								<img alt="" src="${other_user_base_info.userHeadimage}" class="head-img-id">
							</a>
						</div>
						<div class="content-div">
							<p>
								<a href="/billblog-manager-controller/weibocontroller/tohomepage.do?userId=${other_user_base_info.userId}">${other_user_base_info.userNickname}</a>
								<span style="width:10px;display:inline-block;"></span>
							</p>
							<p>
								<span>点赞时间：</span>
								<span>${like_time_list[VS.index]}</span>							
							</p>
						</div>
					</div>
				</c:forEach>
			</div>	
			<!--分页-->
			<div class="col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1">
				<a href="javascript:void(0)" onclick="getNoticeListByPre()">上一页</a>												
				<c:if test="${like_sum%10 eq 0}">
					<c:set var="pageNum" value="${like_sum/10}"></c:set>
				</c:if>
				<c:if test="${like_sum%10 ne 0}">
					<c:set var="pageNum" value="${1+like_sum/10}"></c:set>
				</c:if>
				<c:forEach varStatus="number" begin="1"  end="${pageNum}">
					<a href="javascript:void(0)" onclick="getNoticeListDataByNum('${number.index}')">${number.index}</a>
				</c:forEach>
				<a href="javascript:void(0)" onclick="getNoticeListByAfter()">下一页</a>
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
	<input id="hiddenId" type="hidden" value="${user_info.userId }">
</body>
<script type="text/javascript" src="/billblog-manager-controller/resource/js/jquery.min.js" ></script>
<script type="text/javascript" src="/billblog-manager-controller/resource/js/bootstrap.min.js" ></script>
<script type="text/javascript" src="/billblog-manager-controller/resource/js/main/main.js"></script>
<script type="text/javascript" src="/billblog-manager-controller/resource/js/like/like-weibo.js" ></script>
<script type="text/javascript">
	$("#searchImg").click(function(){
		$("#searchForm").submit();
	});
</script>
</html>