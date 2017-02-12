
/**
 * 确认注册
 */
function makeSureRegist(){
	$.ajax({
		url:"/billblog-manager-controller/registcontroller/makesureregist",
		data:$("#form").serialize(),
		dataType:"json",
		error:function(){
			if($("#error-p").length>0)
				return;
			$("#form-div").append("<p id='error-p' style='margin-top:15px;font-size:13px;color:red;'>验证码输入有误！</p>");
			$("#mainDiv").append("<p id='error-p' style='margin-top:15px;text-align:center;font-size:13px;color:red;'>验证码输入有误！</p>");
		},
		success:function(website){//得到注册后转向的网址名
			window.location.href=website[0];
		}
	});
}

/**
 * 重新获取验证码
 * @param account
 */
function getCodeAgain(account,thisA){
	$.ajax({
		url:"/billblog-manager-controller/registcontroller/submitemailagain",
		data:{userAccount:account},
		dataType:"json",
		error:function(){
			alert("获取验证码 失败");
		},
		success:function(website){
		}
	});
	//先删除点击事件
	$(thisA).removeAttr("onclick");
	//获取“确认提交的”按钮点击事件
	var submitOnclick = $("#makeSureBtn").attr("onclick");
	$("#makeSureBtn").removeAttr("onclick");
	//定时器
	var count = 20;
	var counter = setInterval(function(){
		$(thisA).text(count+"s后获取验证码");
		count--;
	},1000);
	setTimeout(function(){
		clearInterval(counter);
		$(thisA).attr("onclick","getCodeAgain('"+account+"',this)");
		$(thisA).text("重新获取验证码");
		count=10;
		$("#makeSureBtn").attr("onclick",submitOnclick);
	},22000)
}