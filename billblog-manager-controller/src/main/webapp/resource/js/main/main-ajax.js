	
		 	/**
		 	 * ajax获取微博
		 	 */   
		 	function updateWeiboContent(value){
		 		//先删除“点击加载更多”
		 		 if($("#loadmore").length>0){
	 				$("#loadmore").remove();//先删除
	 			 }	
		 		 //正在加载的提示动态图
		 		var imgLoad="<div id='tmpLoading' style='text-align:center;'><img src='/billblog-manager-controller/resource/image/loading.gif' style='width:50px;border-radius:50px;'/></div>";
		 		$("#content-outer").append(imgLoad);		 		
	 			$.ajax({	 				
			 		url:"getmineandmynoticeweibo.do",
			 		type:"get",
			 		data:{offset:value},
			 		dataType:"json",
			 		error:function(){alert("出错了");},
			 		success:function(weibos){			 						 					 			 
			 			useWeiboDataToPage(weibos);
			 		}
			 	});
		 	}   
		 	var counter = setInterval(calTextWidth,80);//强制运行这个函数
		    setTimeout(function(){
		    	clearInterval(counter);//2s后停止运行
		    },2000);
			updateWeiboContent(0);	//获取数据	