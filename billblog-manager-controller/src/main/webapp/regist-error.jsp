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
	
	<!-- 电脑版 -->
     <div id="error-mainDiv">
        <p>您输入的验证码有误！请重新输入</p>
        <form id='form' action='registcontroller/makesureregist'>
        	<input id='makeSureText' name='inputCode' type='text'/>
        	<input id='makeSureBtn' class="btn btn-warning" type='submit' value='确认注册'>
        </form>
     </div>
     <script type="text/javascript" src="/billblog-manager-controller/resource/js/jquery.min.js" ></script>
	 <script type="text/javascript" src="/billblog-manager-controller/resource/js/bootstrap.min.js" ></script>
	 <script type="text/javascript" src="/billblog-manager-controller/resource/js/common/common.js"></script>
	 <script type="text/javascript" src="/billblog-manager-controller/resource/js/regist/regist_personal.js"></script>	 
	 <script type="text/javascript">
	 	var wid = parseInt($(window).width());
	 	$("#area-div").css("left",(wid-270)/2);
	 	getVerifyCode();//获取验证码
	 	 $("#error-mainDiv").css("text-align","center");
		  $("#error-mainDiv p").css("margin-top","30px");	
	 </script>
</body>
</html>