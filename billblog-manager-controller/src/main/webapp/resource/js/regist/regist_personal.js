/**
 *regist相关页面的js函数 
 */
   window.onload=function(){
	   //标志，用于判断是否第一次按下“注册”按键
	   var flag=0;
	   //标志，当点击“手机注册“的时候置为1，否则为0.
	   var mod=0;
	   //匹配表达式，验证
	   var reg1 = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
	   var reg2 = /^[a-zA-Z0-9]{6,16}$/;
	   //改变“手机注册”和“邮箱注册”这两个按钮的颜色
	   $('.model>div:first').click(function(){
		   mod=0;
		   $('.model>div:last').css("background","white");
		   $('.model>div:last').css("color","black");
		   $('.model>div:first').css("background","gray");
		   $('.model>div:first').css("color","white");
		   $('#mb-form-div').hide();
		   $('#form-div').show();
	   });
	   $('.model>div:last').click(function(){
		   mod=1;
		   $('.model>div:first').css("background","white");
		   $('.model>div:first').css("color","black");
		   $('.model>div:last').css("background","gray");
		   $('.model>div:last').css("color","white");
		   $('#mb-form-div').show();
		   $('#form-div').hide();
	   });
	   
	   //确定和取消单选框
	   $("input[name='select']").bind("click",function(){
		 	var $radio = $(this);
		    // if this was previously checked
		    if ($radio.data('waschecked') == true)
		    {
		        $radio.prop('checked', false);
		        $radio.data('waschecked', false);
		    }
		    else
		    {
		         $radio.prop('checked', true);
		         $radio.data('waschecked', true);
		    }
		    // remove was checked from other radios
		    $radio.siblings('input[type="radio"]').data('waschecked', false);
		});
	   
	   //判断邮箱格式是否正确（手机版）
	   function phoneEmailIsTure(){
		    
		   if(!reg1.test($("input[name='email']").val())){
			   if($('#app-email').length>0)
				   return;//如果提示已经存在，则返回
			   $('form>div:first').append("<p id='app-email' class='form-group' style='color:red;margin-bottom:15px'>你输入的邮箱格式有误，请重新输入！</p>");
		   	    return;
		   }
	   }
	   //判断密码格式是否正确
	   function phonePwordIsTure(){
		 //判断密码格式是否正确
		   if(!reg2.test($("input[name='pword']").val())){
			   if($('#app-pword').length>0) //如果提示已经存在，则返回
				   return true;
			   $('form').find('div').eq(1).append("<p id='app-pword' class='form-group' style='color:red;margin-bottom:15px'>你输入的密码格式不符合要求！</p>");
			   return true;
		   }
	   }
//	   //点击注册(手机版)
//	   $("button[name='regist']").click(function(){
//		   //将flag置为1
//		   flag = 1;
//		 //首先判断邮箱格式是否正确		
//		   phoneEmailIsTure();
//		   //判断密码格式是否正确
//		   phonePwordIsTure();
//	   });
	   
	 //电脑版判断邮箱是否正确
	   function pcEmailIsTure(){
		   //电脑版判断邮箱是否正确
		  if(!reg1.test($(".pc_email").val())){
			  if($("#pc_em_span").length>0)
				  return true;
			  $(".pc_line1").append("<span id='pc_em_span' style='color:red;'>输入的邮箱格式有误</span>");
			  return true;
		  } 
	   }
	   //电脑版判断密码格式是否正确
	   function pcPwordIsTure(){
		 //电脑版判断密码格式是否正确
		  if(!reg2.test($(".pc_pword").val())){
			  if($("#pc_pw_span").length>0)
				  return true;
			  $(".pc_line2").append("<span id='pc_pw_span' style='color:red;'>输入的密码格式有误</span>");
			  return true;
		  } 
	   }
	   
	   //文本框或密码框输入格式符合要求时，清除提示，或者自动提示不正确
	   function clearText(){
		   if(flag==1){
			 //首先判断邮箱格式是否正确
			 if($('#app-email').length>0&&reg1.test($("input[name='email']").val())){
				 $('#app-email').remove();
			 }else{
				//判断邮箱格式是否正确		
				phoneEmailIsTure();
			 }
			 
			//判断密码格式是否正确
			 if($('#app-pword').length>0&&reg2.test($("input[name='pword']").val())){
				 $('#app-pword').remove();
			 }else{
				//判断手机格式是否正确		
				phonePwordIsTure();
			 }
		   }
		   if(flag==2){
			 //判断电脑版邮箱格式是否正确
			 if($('#pc_em_span').length>0&&reg1.test($(".pc_email").val())){
				 $("#pc_em_span").remove();
			 }else{
				 pcEmailIsTure();
			 }
			 
			 //判断电脑版密码格式是否正确
			 if($('#pc_pw_span').length>0&&reg2.test($(".pc_pword").val())){
				 $("#pc_pw_span").remove();
			 }else{
				 pcPwordIsTure();
			 }
		   }
	   }
	   $(document).ready(function(){  
		   setInterval(clearText, 1000);  
		});
	   

	   //点击“中国大陆”时，弹出可以选择其他国家或地区的div
	   $(".mb-prefix").click(function(){
		  $("#area-div").fadeIn();
	   });
	   
	   //点击“取消”时，面板消失
	   $("button[name='cancle']").click(function(){
		  $("#area-div").fadeOut();
	   });
	   //选择国家或地区,即按下“确定”时
	   var areas = ["中国大陆","香港地区","台湾地区","澳门地区","日本","韩国","新加坡","马来西亚","美国",
	                "加拿大","澳大利亚","俄罗斯","印度","泰国","巴西","土耳其","瑞典"]; 
	   var nums=["8806","00852","00886","00853","0081","0082","0065","0060","001","001","0061","0044",
	             "0033","0049","007","0091","0066","0055","90","0046"];
	   $("button[name='sure']").click(function(){
		   var country = $("input[name='area']:checked").val();
		   for(i=0;i<areas.length;i++){
			   if(country==areas[i]){//找到国家名
				   //改变显示的国家名
				   $(".mb-prefix2").text(areas[i]);
			   	   //改变代号
				   $(".mb-prefix1").text(nums[i]);
			   	   //退出选项框
			   	   $("#area-div").fadeOut();
			   	   //将代号显示到input里面去
				   $("input[name='phone']").val(nums[i]);				   
			   }
		   }
	   });
	   
	   //点击li选定radio
	   $("#area-div ul li").click(function(){
		  $(this).children("input").attr("checked","checked"); 
	   });
	   
	   //电脑版判断格式是否正确
	   $("#pc_submit").click(function(){
		   flag=2;		  
		   if(pcEmailIsTure())
			   return;
		   if(pcPwordIsTure())
			   return;
		   
		   //判断验证码填写是否正确，区分大小写
		   if($("#tmpVal").val()!=$("#inpVal").val().toUpperCase()){
			   alert("验证码有误！请重新输入");
			   $("#inpVal").val("");//清空输入
			   getVerifyCode();//更新验证码
			   return;
		   }else{//如果验证码填写正确,跳转到后台,后台发送邮件（短信）			      
			   var email = $(".pc_email").val();
			   var password = $("#pc_password").val();
			   var grayDiv = "<div id='pc_grayDiv'>" +
			   					"<div>"+
			   						"<img src='/billblog-manager-controller/resource/image/loading.gif' style='width:100px;border-radius:100px;'>"+
			   						"<p>邮件发送中，请稍后......</p>"+
			   					"</div>"+
			   				"</div>";
			   $("body").append(grayDiv);
			   $.ajax({
				  url:"registcontroller/submitemail",
				  type:"get",
				  data:{userAccount:email,userPassword:password},//传递账户密码给控制器
				  dataType:"json",
				  success:function(info){
					  if(info[0]=="0"){
						  //错误页面			
						  var errpage = " http://jaybill.tunnel.qydev.com/billblog-manager-controller/error-user.jsp?errinfo="+info[1];
						  window.location.href=errpage;
					  }else if(info[0]=="1"){
						  //邮件已发送
						  $("#pc_grayDiv").fadeOut(1000,function(){
							  $("#pc_grayDiv").remove(); 
						  });
						  $("#mainDiv").html("<p>请到您的邮箱获取验证码<<</p>");					  
						  $("#mainDiv").append("<form id='form' action='registcontroller/makesureregist'></form>")
						  $("#form").append("<input id='makeSureText' name='inputCode' type='text'/>");
						  $("#mainDiv").append("<button id='makeSureBtn' class='btn btn-info' onclick='makeSureRegist()'>确认注册</button>");
						  $("#mainDiv").append("<a href='javascript:void(0)' onclick=getCodeAgain('"+info[1]+"',this)>重新获取验证码</a>");
						  $("#mainDiv").css("text-align","center");
						  $("#mainDiv p").css("margin-top","30px");						 
					  }				 
				  }
			   });
		   }
	   });
	   
	  
	   
	   //当改变浏览器窗口时
	   $(window).resize(function(){
		    var wid=parseInt($(window).width());
			if(wid>=450){
				$('#mb-form-div').hide();
				$('#form-div').hide();
			}else{
				if(mod==0){
					$('#mb-form-div').hide();
					$('#form-div').show();
					$('.model>div:last').css("background","white");
				    $('.model>div:last').css("color","black");
				    $('.model>div:first').css("background","gray");
				    $('.model>div:first').css("color","white");
				}else{
					$('#mb-form-div').show();
					$('#form-div').hide();
					$('.model>div:first').css("background","white");
				    $('.model>div:first').css("color","black");
				    $('.model>div:last').css("background","gray");
				    $('.model>div:last').css("color","white");
				}
			}
		});
	   
	 //手机版判断格式是否正确
	   $("#phone_submit").click(function(){
		   flag=1;		  
		   if(phoneEmailIsTure())
			   return;
		   if(phonePwordIsTure())
			   return;
		 //判断验证码填写是否正确，区分大小写
		   if($("#line3 input[type='hidden']").val()!=$("#line3 input[type='text']").val().toUpperCase()){
			   alert("验证码有误！请重新输入");
			   $("#line3 input[type='text']").val("");//清空输入
			   getVerifyCode();//更新验证码
			   return;
		   }else{//如果验证码填写正确,跳转到后台,后台发送邮件（短信）			      
			   var email = $("#line1 input[name='email']").val();
			   var password = $("#line2 input[type='password']").val();
			   var grayDiv = "<div id='mb_grayDiv'>" +
								"<div>"+
									"<img src='/billblog-manager-controller/resource/image/loading.gif' style='width:100px;border-radius:50px;'>"+
									"<p>邮件发送中，请稍后......</p>"+
								"</div>"+
							"</div>";
			   	$("body").append(grayDiv);
			   $.ajax({
				  url:"registcontroller/submitemail",
				  type:"get",
				  data:{userAccount:email,userPassword:password},//传递账户密码给控制器
				  dataType:"json",
				  success:function(info){
					  if(info[0]=="0"){
						  //错误页面			
						  var errpage = " http://jaybill.tunnel.qydev.com/billblog-manager-controller/error-user.jsp?errinfo="+info[1];
						  window.location.href=errpage;
					  }else if(info[0]=="1"){
						  //邮件已发送
						  $("#mb_grayDiv").fadeOut(1000,function(){
							  $("#mb_grayDiv").remove(); 
						  });
						  $("#form-div").html("<p>请到您的邮箱获取验证码<<</p>");					  
						  $("#form-div").append("<form id='form' action='registcontroller/makesureregist'></form>")
						  $("#form").append("<input id='makeSureText' name='inputCode' type='text'/>");
						  $("#form-div").append("<button id='makeSureBtn' class='btn btn-info' onclick='makeSureRegist()'>确认注册</button>");
						  $("#form-div").append("<a href='javascript:void(0)' onclick=getCodeAgain('"+info[1]+"',this)>重新获取验证码</a>");
						  $("#mainDiv").css("text-align","center");
						  $("#mainDiv p").css("margin-top","30px");						 
					  }				 
				  }
			   });
		   }
	   });
   }
   function alreadyGetCode_PC(){
	  //电脑
	  $("#mainDiv").html("<p>请到您的邮箱获取验证码</p>");	
	  $("#mainDiv").append("<a href='regist.jsp'>返回注册页面</a>");
	  $("#mainDiv").append("<form id='form' action='registcontroller/makesureregist'></form>")
	  $("#form").append("<input id='makeSureText' name='inputCode' type='text'/>");
	  $("#mainDiv").append("<button id='makeSureBtn' class='btn btn-info' onclick='makeSureRegist()'>确认注册</button>");
	  $("#mainDiv").css("text-align","center");
	  $("#mainDiv p").css("margin-top","30px");	
   }
   function alreadyGetCode_MB(){
	   $("#form-div").html("<p>请到您的邮箱获取验证码</p>");	
	   $("#form-div").append("<a href='regist.jsp'>返回注册页面</a>")
		  $("#form-div").append("<form id='form' action='registcontroller/makesureregist'></form>")
		  $("#form").append("<input id='makeSureText' name='inputCode' type='text'/>");
		  $("#form-div").append("<button id='makeSureBtn' class='btn btn-info' onclick='makeSureRegist()'>确认注册</button>");
		  $("#mainDiv").css("text-align","center");
		  $("#mainDiv p").css("margin-top","30px");			
   }