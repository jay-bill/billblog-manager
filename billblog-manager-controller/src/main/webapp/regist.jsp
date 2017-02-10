<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"/>
<title>注册</title>
<link rel="SHORTCUT ICON" href="resource/image/s_blog.ico">
<link rel="BOOKMARK" href="resource/image/s_blog.ico">
<link rel="stylesheet" href="resource/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="resource/css/regist/regist.css">
</head>
<body>
	<div id="firstDiv"></div>
	<!--导航栏-->
	<div id="navbar">
	   <div class="col-xs-2">
	      <img src="resource/image/reback.png">
	   </div>
	   <div class="col-xs-8">
	      注册
	   </div>
	   <div class="col-xs-2"></div>
	</div>
	<div class="container model">
		<div class="col-xs-6 model1">邮箱注册</div>
  		<div class="col-xs-6 model2">手机注册</div>
	</div>
	<!-- 邮箱注册 -->
	<div class="container" id="form-div">
		<form role="form">
		  <div id="line1" class="form-group">
		    <label for="name">邮箱：</label>
		    <input type="text" class="form-control" name="email" id="name" placeholder="请输入常用邮箱">
		  </div>
		  <div id="line2" class="form-group">
		    <label for="inputfile">密码：</label>
		    <input type="password" class="form-control" name="pword" id="name" placeholder="6到16位英文数字密码，区分大小写">
		  </div>
		  <div id="line3" class="form-group">
		    <label for="inputfile">验证码：</label><br>
		    <input type="text" id="name" style="width:120px;">
		    <img id='verifyCodeImg' src="">
		    <input type='hidden' style="float:left;">
		  </div>
		  <button id="phone_submit" type="button" name="regist" class="btn btn-primary btn-block">注册</button>
		  <div style="margin-top:20px;">
		     <span>我已阅读标<a href="#">微博协议</a>并同意遵守协议</span><input type="radio" name="select" style="width:13px;height:13px;">
		  </div>
		</form>
	</div>
	<!-- 手机注册 -->
	<div class="container" id="mb-form-div">
		<div class="col-xs-2 mb-prefix1 mb-prefix">0086</div>
		<div class="col-xs-9 mb-prefix2 mb-prefix">中国大陆</div>
		<div class="col-xs-1 mb-prefix3 mb-prefix">></div>
		<form role="form">
		  <div class="form-group">
		    <label for="name">手机号：</label>
		    <input type="text" class="form-control" name="phone" placeholder="请输入手机号码">
		  </div>
		  <div class="form-group">
		    <label for="inputfile">密码：</label>
		    <input type="password" class="form-control" name="pword" placeholder="6到16位英文数字密码，区分大小写">
		  </div>
		  <button type="button" name="getCode" class="btn btn-primary btn-block">获取短信验证码</button>
		  <div style="margin-top:20px;">
		     <span>我已阅读标<a href="#">微博协议</a>并同意遵守协议</span><input type="radio" name="select" style="width:13px;height:13px;">
		  </div>
		</form>
		<!-- 显示其他国家或地区 -->
		<div id="area-div">
			<ul>
				<li><span>中国大陆</span><input type="radio" name="area" checked="checked" value="中国大陆"></li>
				<li><span>香港地区</span><input type="radio" name="area" value="香港地区"></li>
				<li><span>台湾地区</span><input type="radio" name="area" value="台湾地区"></li>
				<li><span>澳门地区</span><input type="radio" name="area" value="澳门地区"></li>
				<li><span>日本</span><input type="radio" name="area" value="日本"></li>
				<li><span>韩国</span><input type="radio" name="area" value="韩国"></li>
				<li><span>新加坡</span><input type="radio" name="area" value="新加坡"></li>
				<li><span>马来西亚</span><input type="radio" name="area" value="马来西亚"></li>
				<li><span>美国</span><input type="radio" name="area" value="美国"></li>
				<li><span>加拿大</span><input type="radio" name="area" value="加拿大"></li>
				<li><span>澳大利亚</span><input type="radio" name="area" value="澳大利亚"></li>
				<li><span>英国</span><input type="radio" name="area" value="英国"></li>
				<li><span>法国</span><input type="radio" name="area" value="法国"></li>
				<li><span>德国</span><input type="radio" name="area" value="德国"></li>
				<li><span>俄罗斯</span><input type="radio" name="area" value="俄罗斯"></li>
				<li><span>印度</span><input type="radio" name="area" value="印度"></li>
				<li><span>泰国</span><input type="radio" name="area" value="泰国"></li>
				<li><span>巴西</span><input type="radio" name="area" value="巴西"></li>
				<li><span>瑞典</span><input type="radio" name="area" value="瑞典"></li>
				<li><span>土耳其</span><input type="radio" name="area" value="土耳其"></li>
			</ul>
			<div>
				<button type="button" class="btn btn-default" name="cancle">取消</button>
				<button type="button" class="btn btn-default" name="sure">确定</button>
			</div>
		</div>
	</div>
	
	<!-- 电脑版 -->
     <div id="mainDiv">
        <div id="mainTop">
           <div class="topCont"><a style="border-bottom:3px solid  #ffa00a">个人注册</a></div>
           <div class="topCont" style="padding-left:20px;color:gray;font-weight:bold;">|</div>
           <div class="topCont" style="padding-left:20px"><a>官方注册</a></div>
        </div>
        <!-- 主题内容左边 -->
        <div id="mainLeft">
           <div id="mainLeftDiv">
             <div id="line1" class="line">
                <div class="tag">邮箱：</div>
                <input name="email" class="pc_email" placeholder="请输入常用邮箱">
             </div>
             <div style="margin:0px 0px 10px 82px;font-size:14px;">
                或使用<a href="#">手机注册</a>
             </div>
             <div id="line2" class="line">
                <div class="tag">密码：</div>
                <input type="password" class="pc_pword" name="pword" placeholder="6到16位英文数字密码，区分大小写">
             </div>
             <div id="line3" class="line">
                <div class="tag">验证码：</div>
                <input type="text" style="width:74px;height:30px;">
                <img src="" id="verifyCodeImg">
                <input type="hidden">
             </div>
             <div id="line4" class="line">
             	<div class="tag"></div>
                <button id="pc_submit" type="button" class="btn btn-warning" style="width:200px;">立即注册</button>
             </div>
             <div class="line4">
             	<div class="tag" style="height:1px;"></div>
             	<div style="display:inline-block">
             		<p><a href="http://weibo.com/signup/v5/protocol" target="_blank">微博服务使用协议</a></p>
             		<p><a href="http://weibo.com/signup/v5/privacy" target="_blank">微博个人信息保护政策</a></p>
             		<p><a href="http://news.sina.com.cn/c/2012-12-29/051425921660.shtml" target="_blank">全国人大常委会关于加强网络信息保护的决定</a></p>
             	</div>
             </div>
           </div>
        </div>
        
         <!-- 电脑页面，主体右边 -->
	     <div id="mainRight">
	     	<div>
	     		<p>已有账号，请<a href="index.jsp">直接登录</a></p>
	     	</div>
	     	<div id="help-div">
	     		<p>微博注册帮助</p>
	     		<p><a href="http://help.weibo.com/faq/q/76/15955#15955" target="_blank">1、微博注册帮助指南</a></p>
	     		<p><a href="http://help.weibo.com/faq/q/200/13091#13091" target="_blank">2、手机注册时提示手机号码已被绑定怎么办</a></p>
	     		<p><a href="http://help.weibo.com/faq/q/200/276#276" target="_blank">3、注册微博时昵称显示“已经被注册”该如何处理</a></p>
	     		<p><a href="http://help.weibo.com/faq/q/200/13043#13043" target="_blank">4、注册时提示你所用的ip异常该怎么办</a></p>
	     		<p><a href="http://help.weibo.com/faq/q/201" target="_blank">更多帮助>></a></p>
	     	</div>
	     </div>
     </div>
    <!-- 电脑页面底部 -->
    <footer>
    	<div style="float:left;">
    		<p>广州标新网络技术有限公司&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    		大粤网[2016]0003-719号&nbsp;粤ICP备201430260259号</p> 		
    	</div>
    	<div style="float:right;">
    		<p>Copyright © 2016-2018 WEIBO</p>
    	</div>
    </footer>
     <script type="text/javascript" src="/billblog-manager-controller/resource/js/jquery.min.js" ></script>
	 <script type="text/javascript" src="/billblog-manager-controller/resource/js/bootstrap.min.js" ></script>
	 <script type="text/javascript" src="/billblog-manager-controller/resource/js/common/common.js"></script>
	 <script type="text/javascript" src="/billblog-manager-controller/resource/js/regist/regist_personal.js"></script>	 
	 <script type="text/javascript">
	 	var wid = parseInt($(window).width());
	 	$("#area-div").css("left",(wid-270)/2);
	 	getVerifyCode();//获取验证码
	 </script>
</body>
</html>