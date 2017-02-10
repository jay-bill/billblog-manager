	/**
	 * 点击“编辑”，显示编辑页
	 */
 	$("#content-outer button").click(function(){
 		$("#main-div").css("display","none");
 		$("#main-display-div").css("display","block");
 	});
 	
 	$("#saveInfo").click(function(){
 		alert("已保存");
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
	 			$("#userNickname").text(
	 					$("#content-display-outer input[name='userNickname']").val()
	 			);
	 			//所在地
	 			$("#userAddress").text(
	 					$("#content-display-outer input[name='userAddress']").val()
	 			);
	 			//性别
	 			if($("#content-display-outer input[name='userSex']:checked").val()=="1"||
	 			   $("#content-display-outer input[name='userSex']:checked").val()==1)
	 			{
	 				$("#userSex").text("女");
	 			}
	 			if($("#content-display-outer input[name='userSex']:checked").val()=="0"||
	 	 			   $("#content-display-outer input[name='userSex']:checked").val()==0)
	 	 			{
	 	 				$("#userSex").text("男");
	 	 			}
	 			//性取向
	 			if($("#content-display-outer select[name='userTropism'] option:selected").val()=="0"||
	 			   $("#content-display-outer select[name='userTropism'] option:selected").val()==0){
		 			$("#userTropism").text("异性恋");
 				}
	 			if($("#content-display-outer select[name='userTropism'] option:selected").val()=="1"||
	 	 		    $("#content-display-outer select[name='userTropism'] option:selected").val()==1){
 		 			$("#userTropism").text("双性恋");
  				}
	 			if($("#content-display-outer select[name='userTropism'] option:selected").val()=="2"||
	 	 		    $("#content-display-outer select[name='userTropism'] option:selected").val()==2){
 		 			$("#userTropism").text("同性恋");
  				}
	 			
	 			//情感状况
	 			if($("#content-display-outer select[name='userLovestate'] option:selected").val()=="0"||
	 				$("#content-display-outer select[name='userLovestate'] option:selected").val()==0){
	 				$("#userLovestate").text("单身");
	 			}
	 			if($("#content-display-outer select[name='userLovestate'] option:selected").val()=="1"||
	 				$("#content-display-outer select[name='userLovestate'] option:selected").val()==1){
	 				$("#userLovestate").text("恋爱中");
	 			}
	 			if($("#content-display-outer select[name='userLovestate'] option:selected").val()=="2"||
	 				$("#content-display-outer select[name='userLovestate'] option:selected").val()==2){
	 				$("#userLovestate").text("已婚");
	 			}
	 			if($("#content-display-outer select[name='userLovestate'] option:selected").val()=="3"||
	 				$("#content-display-outer select[name='userLovestate'] option:selected").val()==3){
	 				$("#userLovestate").text("离异");
	 			}
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
	 			$("#main-div").css("display","block");
	 	 		$("#main-display-div").css("display","none");
	 		}
 		});
 	});