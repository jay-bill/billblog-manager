/**
 * 
 */
	//获取验证码
	function getVerifyCode(){
		var val = $("#line3 input[type='hidden']").val();
		if(val!=null){
			$.ajax({
				url:"registcontroller/getverifycode",
				type:"get",
				data:{beforeImg:val},//每次刷新验证码，把之前的验证码删除
				dataType:"json",
				success:function(d){
					//改变页面中的验证码					 
					$("#verifyCodeImg").attr("src",d[0]);					
					$("#verifyCodeImgPc").attr("src",d[0]);					
					$("#line3 input[type='hidden']").attr("value",d[1]);
					$("#tmpVal").attr("value",d[1]);
				}
			});
		}
		else{
			$.ajax({
				url:"registcontroller/getverifcode",
				type:"get",
				dataType:"json",
				success:function(d){
					//改变页面中的验证码
					$("#verifyCodeImg").attr("src",d[0]);
					$("#verifyCodeImgPc").attr("src",d[0]);
					$("#line3 input[type='hidden']").attr("value",d[1]);
				}
			});
		}
	}
	
	 //点击验证码刷新
	   $("#verifyCodeImg").click(function(){
		   $("#verifyCodeImg").attr("src","/billblog-manager-controller/resource/image/loading.gif");						
		   getVerifyCode();
	   });
	   //点击验证码刷新
	   $("#verifyCodeImgPc").click(function(){
		   $("#verifyCodeImgPc").attr("src","/billblog-manager-controller/resource/image/loading.gif");	
		   getVerifyCode();
	   });
	   