	/**
	 * 点击“编辑”，显示编辑页
	 */
 	$("#content-outer button").click(function(){
 		$("#main-div").css("display","none");
 		$("#main-display-div").css("display","block");
 	});
 	
 	$("#saveInfo").click(function(){
 		alert("保存");
 		$.ajax({
	 		url:"saveuserinfo.do",
	 		type:"post",
	 		data:$("#userInfoForm").serialize(),
	 		error:function(){
	 			alert("出错了");//如果接受到的值为null的话，执行error
	 			//如果有值就会成功！！！
	 		},
	 		success:function(d){
	 			//更新之前的信息
	 			//昵称
	 			alert("开始");
	 			alert($("#content-display-outer input[name='userNickname']").val());
	 			$("#userNickname").text(
	 					$("#content-display-outer input[name='userNickname']").val()
	 			);
	 			//所在地
	 			$("#userAddress").text(
	 					$("#content-display-outer input[name='userAddress']").val()
	 			);
	 			//性别
	 			$("#userSex").text(
	 					$("#content-display-outer radio[name='userSex']").val()
	 			);
	 			//性取向
	 			$("#userTropism").text(
	 					$("#content-display-outer radio[name='userTropism']").val()
	 			);
	 			//情感状况
	 			$("#userLoveState").text(
	 					$("#content-display-outer radio[name='userLoveState']").val()
	 			);
	 			//生日
	 			$("#userBirthday").text(
	 					$("#content-display-outer input[name='userBirthday']").val()
	 			);
	 			//毕业学校
	 			$("#userSchool").text(
	 					$("#content-display-outer input[name='userSchool']").val()
	 			);
	 			//工作
	 			$("#userPosition").text(
	 					$("#content-display-outer input[name='userPosition']").val()
	 			);
	 			alert("最后");
	 			$("#main-div").css("display","block");
	 	 		$("#main-display-div").css("display","none");
	 		}
 		});
 	});