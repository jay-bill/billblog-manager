			//获取微博的ajax	   
		 	function updateWeiboContent(id){
		 		var val=-1;
		 		if($("#hidden-weibo-id").length>0)
		 			val = $("#hidden-weibo-id").val();
		 		else
		 			val = id;
		 		//先删除“点击加载更多”
		 		 if($("#loadmore").length>0){
	 				$("#loadmore").remove();//先删除
	 			 }	
		 		 //正在加载的提示动态图
		 		var imgLoad="<div id='tmpLoading' style='text-align:center;'><img src='/billblog-manager-controller/resource/image/loading.gif' style='width:50px;border-radius:50px;'/></div>";
		 		$("#content-outer").append(imgLoad);
	 			$.ajax({	 				
			 		url:"/billblog-manager-controller/weibocontroller/getoneweibo.do",
			 		type:"get",
			 		data:{weiboId:val},
			 		dataType:"json",
			 		error:function(){alert("出错了");},
			 		success:function(weibos){			 						 			
			 			useOneWeiboDataToPage(weibos);
			 			 if($("#loadmore").length>0){
			 				$("#loadmore").remove();//先删除
			 			 }
			 			 //打开评论
			 			 $(".text-bottom-div>:nth-child(3) a").click();
			 		}
			 	});
	 			calTextWidth();
		 	}   		 	
		 	updateWeiboContent();