<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"/>
<link rel="SHORTCUT ICON" href="resource/image/s_blog.ico">
<link rel="BOOKMARK" href="/billblog-manager-controller/resource/image/s_blog.ico">
<link rel="stylesheet" href="/billblog-manager-controller/resource/css/bootstrap.min.css" />
<link rel="stylesheet" href="/billblog-manager-controller/resource/plug-res/css/common.css">

<link rel="stylesheet" href="/billblog-manager-controller/resource/css/common/common.css"></link>
<link rel="stylesheet" href="/billblog-manager-controller/resource/css/common/home-common.css">
<link rel="stylesheet" href="/billblog-manager-controller/resource/css/common/main-common.css">
<link rel="stylesheet" href="/billblog-manager-controller/resource/css/photo/photo.css">
<title>相册</title>
</head>
<body>
	<!-- 导航栏 -->
	<div class="row navbar-fixed-top" id="nav"> 
		<div class="container" id="nav-con">
			<!-- logo -->
			<div class="col-md-2 col-xs-9" id="logo">
				<a href="/billblog-manager-controller/weibocontroller/tomainpage.do">
					<img src="/billblog-manager-controller/resource/image/s_weibo.png">
				</a>
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
						<a href="/billblog-manager-controller/weibocontroller/tomainpage.do" class="dropdown-toggle">
				          <span class="glyphicon glyphicon-home"></span>&nbsp;首页
	               		</a>
					</div>
					<div class="col-md-2 nav-right">
						<a href="/billblog-manager-controller/weibocontroller/tohomepage.do?userId=${user_id}" class="dropdown-toggle">
				          <span class="	glyphicon glyphicon-facetime-video"></span>&nbsp;主页
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
						<span>
							<a href="/billblog-manager-controller/weibocontroller/tohomepage.do?userId=${other_user_base_info.userId }" class="dropdown-toggle">
								${other_user_base_info.userNickname}
							</a>
						</span>
					</div>
					<div class="col-md-2 nav-right">
						<a href="/billblog-manager-controller/logincontroller/loginout" class="dropdown-toggle">登出</a>
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
						<a role="menuitem" tabindex="-1" 
						href="/billblog-manager-controller/weibocontroller/tohomepage.do?userId=${user_id}">
							<span class="	glyphicon glyphicon-facetime-video"></span>&nbsp;主页
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
						<a href="/billblog-manager-controller/attentioncontroller/tohomepage.do?userId=${user_id}">							
							<span style="color:blue;">微博${weibo_sum}</span>
						</a>						
					</li>
					<li role="presentation" class="divider"></li>
					<li role="presentation">
						<a role="menuitem" tabindex="-1" 
						href="/billblog-manager-controller/logincontroller/loginout">
							登出
						</a>
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
					<img title="更换头像" id="myHeadimage" src="${other_user_base_info.userHeadimage }" style="width:100px;height:100px;">
				</form>
				<!-- 昵称 -->
				<div>
					<h3>
						<a id='nicknameA' href="/billblog-manager-controller/weibocontroller/tohomepage.do?userId=${other_user_base_info.userId }">
						${other_user_base_info.userNickname}
						</a>
					</h3>
					<p>${user_info.userSignature }</p>
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
					<div class="col-xs-4"><a href="/billblog-manager-controller/weibocontroller/tohomepage.do?userId=${other_user_base_info.userId }">微博</a></div>
					<div class="col-xs-4"><a href="/billblog-manager-controller/imagecontroller/tophotopage.do?userId=${other_user_base_info.userId }">相册</a></div>
					<div class="col-xs-4">管理中心</div>
				</div>
			</div>
		</div>
		
		<!-- 第三行，导航栏 -->
		<div class="row" id="photo-nav">
			<nav class="navbar navbar-default col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1" role="navigation">
			    <div class="container-fluid">
				    <div class="navbar-header">
				        <a id="photosWallA" class="navbar-brand"  style="color:red;" href="/billblog-manager-controller/imagecontroller/tophotopage.do?userId=${other_user_base_info.userId}">照片墙</a>
				    </div>
				    <div>
				        <!--向左对齐-->
				        <ul class="nav navbar-nav navbar-left">
				            <!-- <li class="dropdown">
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
				            </li> -->
				             <li class="dropdown">
				                <a id="albumA" href="javascript:void(0)" onclick="showImageAlbumDiv()" class="dropdown-toggle">
				                   	 相册专辑
				                </a>
				            </li>
				        </ul>
				        <!--向右对齐-->
				        <ul class="nav navbar-nav navbar-right">
				            <li class="dropdown">
				                <a href="javascript:void(0)" onclick="showUploadImageDiv(this)"  class="dropdown-toggle" data-toggle="dropdown">
				                   <span class="glyphicon glyphicon-picture"></span>&nbsp;上传相片
				                </a>	
				            </li>
				           <!--  <li class="dropdown">
				                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
				                	<span class="glyphicon glyphicon-facetime-video"></span>&nbsp;
				                    	上传视频
				                </a>	
				            </li> -->
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
			<div class="col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1 dividePage">
				
				<c:if test="${defalut_image_sum > 5 }">
					<a href="javascript:void(0)" onclick="prePage()">上一页</a>
					<c:if test="${defalut_image_sum%5 eq 0}">
						<c:set var="pageSum" value="${defalut_image_sum/5}"></c:set>
					</c:if>
					<c:if test="${defalut_image_sum%5 ne 0}">
						<c:set var="pageSum" value="${1+defalut_image_sum/5}"></c:set>
					</c:if>
					<c:forEach varStatus="num" begin="1" end="${pageSum}">
						<a class="pageA" href="javascript:void(0)" onclick="getImages(${num.index-1},${page_imagesum_list[num.index-1]},this)">${num.index}</a>
					</c:forEach>
					<a href="javascript:void(0)" onclick="nextPage()">下一页</a>
				</c:if>
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
<script type="text/javascript" src="/billblog-manager-controller/resource/js/photo/photo.js" ></script>
<script type="text/javascript" src="/billblog-manager-controller/resource/js/photo/photo-ajax.js" ></script>
</html>