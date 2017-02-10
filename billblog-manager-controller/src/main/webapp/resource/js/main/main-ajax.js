
			//计算content-text的宽度
		    function calTextWidth(){
		    	console.info("进来了！");
	 		    //先获取class=row、content的宽度。不包括padding
		    	var content_div_wid = parseInt($(".content").width());
		    	//再获取头像的宽度
		    	var content_head_wid = parseInt($(".content-head").width());
		    	//设置文字，即content-text的宽度
		    	$(".content-text").css("width",content_div_wid-content_head_wid-10);//减去10px的误差
		    	//设置content-text的样式
		    	$(".content-text").css("padding-left",10);
		    	$(".content-text").css("padding-right",10);
		    }
		
		    //关闭转发框
		    function closeForwardForm(){
		    	$("#forwardForm").remove();
		    }
		    //转发时弹出的面板
		    function forwardWeiboDiv(beForwardWeiboId,thisA){
		    	if($("#forwardForm").length>0){
		    		$("#forwardForm").remove();
		    	}		    	
		    	var data =  "<form action='/billblog-manager-controller/weibocontroller/forwardweibo.do' method='post' id='forwardForm'>" +
		    					"<div>" +		    						
		    						"<a href='javascript:void(0)' onclick='closeForwardForm()' style='color:red;float:right;'>关闭</a>" +
		    						"<div style='clear:both'></div>"+
		    					"</div>"+
		    					"<div>" +
		    						"转发：@"+$(thisA).parent().parent().parent().children(".content-text").text()+
		    					"</div>"+
		    					"<div>" +
			    					"<textarea name='myContent'></textarea><br>"+
			    					"<input type='submit' value='转发' class='btn btn-warning btn-sm'>"+
		    					"</div>"+
		    					"<input type='hidden' name='beForwardWeiboId' value='"+beForwardWeiboId+"'>"+
		    			   	"</form>";		    	
		    	var w = $(".content").width();	
		    	var h = $(".content").height();
		    	var left = $(".content").left;
		    	//根据屏幕的宽高，对转发div重新定位
		    	$("#center-div").append(data);
		    	$("#forwardForm").css({
		    		"background":"#F7F7F7",
		    		"border-radius":"4px",
		    		"position":"fixed",
		    		"left":left,
		    		"top":"100px",
		    		"width":w+20,
		    		"padding":"10px",
		    		"overflow":"auto",
		    		"margin-bottom":10
		    	});
		    	$("#forwardForm textarea").css({
		    		"resize":"none",
		    		"width":"100%",
		    		"height":70,	    		
		    	});
		    	$("#forwardForm input[type='submit']").css({
		    		"float":"right",
		    	});
		    }
		    
		    //显示用户数据 
		 	//获取微博的ajax	   
		 	function updateWeiboContent(value){
	 			$.ajax({	 				
			 		url:"getmineandmynoticeweibo.do",
			 		type:"get",
			 		data:{offset:value},
			 		dataType:"json",
			 		error:function(){alert("出错了");},
			 		success:function(weibos){			 			
			 			 if($("#loadmore").length>0){
			 				$("#loadmore").remove();//先删除
			 			 }
			 			 
			 			 for(i=0;i<weibos[0].length;i++){
			 				//默认状态时
			 				if(weibos[0][i].weiboState==0){
			 					 var suffix1 = "</div><div class='float'></div><div class='container-fluid text-bottom-div'><div class='col-xs-3'><a>收藏</a></div><div class='col-xs-3'><a href='javascript:void(0)' onclick='forwardWeiboDiv("+weibos[0][i].weiboId+",this)'>转发</a></div><div class='col-xs-3'><a href='javascript:void(0)' onclick='getComments("+weibos[0][i].weiboId+",this,0)'>评论"+weibos[3][i]+"</a></div><div class='col-xs-3'><a href='javascript:void(0)' onclick='likeweibo("+weibos[0][i].weiboId+",this)'>点赞</a>"+"&nbsp;<a target='_blank' href='/billblog-manager-controller/likecontroller/showlikepeople.do?belikeId="+weibos[0][i].weiboId+"&offset=0'>"+weibos[1][i]+"</a></div></div></div>";
				 				 var suffix2 = "</div><div class='float'></div><div class='container-fluid text-bottom-div'><div class='col-xs-3'><a>收藏</a></div><div class='col-xs-3'><a href='javascript:void(0)' onclick='forwardWeiboDiv("+weibos[0][i].weiboId+",this)'>转发</a></div><div class='col-xs-3'><a href='javascript:void(0)' onclick='getComments("+weibos[0][i].weiboId+",this,0)'>评论"+weibos[3][i]+"</a></div><div class='col-xs-3'><a href='javascript:void(0)' onclick='avoidLike("+weibos[0][i].weiboId+",this)'>已赞</a>"+"&nbsp;<a target='_blank' href='/billblog-manager-controller/likecontroller/showlikepeople.do?belikeId="+weibos[0][i].weiboId+"&offset=0'>"+weibos[1][i]+"</a></div></div></div>";
				 				 var data = "<div class='row content'><div class='content-head'><a href='tohomepage.do?userId="+weibos[0][i].userId+"'><img width='50px' height='50px' src='"+weibos[0][i].userHeadimage+"'></a></div><div class='content-text' id='tempId'><h4><a>"+weibos[0][i].userNickname+"</a></h4><p style='margin-bottom:10px;color:#808080;'>"+
					 						new Date(weibos[0][i].weiboPublishtime).toLocaleString()+"</p>"+weibos[0][i].weiboContent+"<br>";			 				 
				 				 if(weibos[0][i].userId==$("#hiddenId").val()){
				 					data = "<div class='row content'><div class='content-head'><a href='tohomepage.do?userId="+weibos[0][i].userId+"'><img width='50px' height='50px' src='"+weibos[0][i].userHeadimage+"'></a></div><div class='content-text' id='tempId'><h4><a>"+weibos[0][i].userNickname+"</a></h4><p style='margin-bottom:10px;color:#808080;'>"+
		 				 			new Date(weibos[0][i].weiboPublishtime).toLocaleString()+"&nbsp;"+"<a href='javascript:void(0)' onclick='deleteWeibo("+weibos[0][i].weiboId+",this)'>删除</a>"+"</p>"+weibos[0][i].weiboContent+"<br>";	

				 				 }
				 				 //装配图片
				 				 if(weibos[0][i].weiboImage!=null){
				 					 //以%%为分界分隔图片
				 					 var arr = new Array();
				 					 arr = weibos[0][i].weiboImage.split("%%");
				 					 for(j=0;j<arr.length;j++){
				 						 if(arr[j]!=""){//如果不是空格的话，追加
				 							 data=data+"<img class='weiboImage' onclick='showBigImage(this)' style='padding:2px;' width='100px' height='100px' src='"+arr[j]+"'/>";
				 						 }
				 					 }
				 				 }
			 					 if(weibos[2][i]==0){
			 						 data=data+suffix1;//组装
			 					 }else{
			 						data=data+suffix2;//组装
			 					 }
				 				 $("#content-outer").append(data);
			 				}else if(weibos[0][i].weiboState==2){//转发
			 					 var suffix1 = "</div>" +
			 					 					"<div class='float'></div>" +
			 					 					"<div class='container-fluid text-bottom-div'>" +
			 					 						"<div class='col-xs-3'>" +
			 					 							"<a>收藏</a>" +
			 					 						"</div>" +
			 					 						"<div class='col-xs-3'>" +
			 					 							"<a href='javascript:void(0)' onclick='forwardWeiboDiv("+weibos[0][i].weiboId+",this)'>转发</a>" +
			 					 						"</div>" +
			 					 						"<div class='col-xs-3'>" +
		 					 								"<a href='javascript:void(0)' onclick='getComments("+weibos[0][i].weiboId+",this,0)'>评论"+weibos[3][i]+"</a>" +
		 					 							"</div>" +
		 					 							"<div class='col-xs-3'>" +
		 					 								"<a href='javascript:void(0)' onclick='likeweibo("+weibos[0][i].weiboId+",this)'>点赞</a>"+
		 					 								"&nbsp;" +
		 					 								"<a target='_blank' href='/billblog-manager-controller/likecontroller/showlikepeople.do?belikeId="+weibos[0][i].weiboId+"&offset=0'>"+weibos[1][i]+"</a>" +
		 					 							"</div>" +
		 											"</div>" +
		 									   "</div>";
				 				 var suffix2 = "</div>" +
					 				 			   "<div class='float'></div>" +
					 				 			   "<div class='container-fluid text-bottom-div'>" +
					 				 			   		"<div class='col-xs-3'><a>收藏</a></div>" +
					 				 			   		"<div class='col-xs-3'><a href='javascript:void(0)' onclick='forwardWeiboDiv("+weibos[0][i].weiboId+",this)'>转发</a></div>" +
					 				 			   		"<div class='col-xs-3'><a href='javascript:void(0)' onclick='getComments("+weibos[0][i].weiboId+",this,0)'>评论"+weibos[3][i]+"</a></div>" +
			 				 			   				"<div class='col-xs-3'>" +
			 				 			   					"<a href='javascript:void(0)' onclick='avoidLike("+weibos[0][i].weiboId+",this)'>已赞</a>"+"&nbsp;" +
					 			   							"<a target='_blank' href='/billblog-manager-controller/likecontroller/showlikepeople.do?belikeId="+weibos[0][i].weiboId+"&offset=0'>"+weibos[1][i]+"</a>" +
		 			   									"</div>" +
				   									"</div>" +
 			   									"</div>";
				 				 var  weiboContents= weibos[0][i].weiboContent.split("@_@");
				 				 var data1 = "<div class='row content'>" +
				 				 				"<div class='content-head'>" +
				 				 					"<a href='tohomepage.do?userId="+weibos[0][i].userId+"'>" +
				 				 						"<img width='50px' height='50px' src='"+weibos[0][i].userHeadimage+"'>" +
	 				 								"</a>" +
 				 								"</div>" +
 				 								"<div class='content-text' id='tempId'>" +
 				 									"<h4><a>"+weibos[0][i].userNickname+"</a></h4>" +
		 											"<p style='margin-bottom:10px;color:#808080;'>"+
		 												new Date(weibos[0][i].weiboPublishtime).toLocaleString()+
		 												"&nbsp;"+
	 												"</p>"+weiboContents[0]+
	 												"<div class='row' style='background:rgb(247, 247, 247);padding:10px;'>" +
	 													"<h5>" +
	 														"<a href='/billblog-manager-controller/weibocontroller/tohomepage.do?userId="+
	 															weiboContents[6]+"'>"+weiboContents[2]+
	 														"</a>"+
	 													"</h5>"+
	 													"<div class='content-text'>" +
	 														"<p>"+
	 															weiboContents[3]+
	 														"</p>"+
	 														weiboContents[4]+
	 													"</div>"+
	 													"<div>" +
		 													"<div  class='innerForwardBottomDiv'>"+"<a>收藏</a>&nbsp;"+"</div>"+
															"<div  class='innerForwardBottomDiv'>"+"<a href='javascript:void(0)' onclick='forwardWeiboDiv("+weiboContents[7]+",this)'>转发</a>"+"</div>"+
															"<div  class='innerForwardBottomDiv'>"+"<a>评论"+weiboContents[10]+"</a>"+"</div>"+
															"<div  class='innerForwardBottomDiv'>"+"<a href='javascript:void(0)' onclick='likeweibo("+weiboContents[7]+",this)'>点赞"+weiboContents[8]+"</a>"+"</div>"+
	 													"</div>"+
	 												"</div>";
				 				 var data2 = "<div class='row content'>" +
				 				 				"<div class='content-head'>" +
				 				 					"<a href='tohomepage.do?userId="+weibos[0][i].userId+"'>" +
				 				 						"<img width='50px' height='50px' height='50px' src='"+weibos[0][i].userHeadimage+"'>" +
					 								"</a>" +
				 								"</div>" +
				 								"<div class='content-text' id='tempId'>" +
				 									"<h4><a>"+weibos[0][i].userNickname+"</a></h4>" +
													"<p style='margin-bottom:10px;color:#808080;'>"+
														new Date(weibos[0][i].weiboPublishtime).toLocaleString()+
														"&nbsp;"+
													"</p>"+weiboContents[0]+
													"<div class='row' style='background:rgb(247, 247, 247);padding:10px;'>" +
														"<h5>" +
															"<a href='/billblog-manager-controller/weibocontroller/tohomepage.do?userId="+
																weiboContents[6]+"'>"+weiboContents[2]+
															"</a>"+
														"</h5>"+
														"<div class='content-text'>" +
															"<p>"+
																weiboContents[3]+
															"</p>"+
															weiboContents[4]+
														"</div>"+
														"<div>" +
															"<div  class='innerForwardBottomDiv'>"+"<a>收藏</a>&nbsp;"+"</div>"+
															"<div  class='innerForwardBottomDiv'>"+"<a href='javascript:void(0)' onclick='forwardWeiboDiv("+weiboContents[7]+",this)'>转发</a>"+"</div>"+
															"<div  class='innerForwardBottomDiv'>"+"<a>评论"+weiboContents[10]+"</a>"+"</div>"+
															"<div  class='innerForwardBottomDiv'>"+"<a href='javascript:void(0)' onclick='avoidLike("+weiboContents[7]+",this)'>已赞"+weiboContents[8]+"</a>"+"</div>"+
														"</div>"+
													"</div>";
				 				 if(weibos[0][i].userId==$("#mynicknameA").attr("href").split("?userId=")[1]){
				 					 data1 = "<div class='row content'>" +
	 				 				"<div class='content-head'>" +
	 				 					"<a href='tohomepage.do?userId="+weibos[0][i].userId+"'>" +
	 				 						"<img width='50px' height='50px' src='"+weibos[0][i].userHeadimage+"'>" +
			 								"</a>" +
		 								"</div>" +
		 								"<div class='content-text' id='tempId'>" +
		 									"<h4><a>"+weibos[0][i].userNickname+"</a></h4>" +
											"<p style='margin-bottom:10px;color:#808080;'>"+
												new Date(weibos[0][i].weiboPublishtime).toLocaleString()+
												"&nbsp;"+"<a href='javascript:void(0)' onclick='deleteWeibo("+weibos[0][i].weiboId+",this)'>删除</a>"+
											"</p>"+weiboContents[0]+
											"<div class='row' style='background:rgb(247, 247, 247);padding:10px;'>" +
												"<h5>" +
													"<a href='/billblog-manager-controller/weibocontroller/tohomepage.do?userId="+
														weiboContents[6]+"'>"+weiboContents[2]+
													"</a>"+
												"</h5>"+
												"<div class='content-text'>" +
													"<p>"+
														weiboContents[3]+
													"</p>"+
													weiboContents[4]+
												"</div>"+
												"<div>" +
													"<div  class='innerForwardBottomDiv'>"+"<a>收藏</a>&nbsp;"+"</div>"+
												"<div  class='innerForwardBottomDiv'>"+"<a href='javascript:void(0)' onclick='forwardWeiboDiv("+weiboContents[7]+",this)'>转发</a>"+"</div>"+
												"<div  class='innerForwardBottomDiv'>"+"<a>评论"+weiboContents[10]+"</a>"+"</div>"+
												"<div  class='innerForwardBottomDiv'>"+"<a href='javascript:void(0)' onclick='likeweibo("+weiboContents[7]+",this)'>点赞"+weiboContents[8]+"</a>"+"</div>"+
												"</div>"+
											"</div>";
				 				data2 = "<div class='row content'>" +
	 				 				"<div class='content-head'>" +
	 				 					"<a href='tohomepage.do?userId="+weibos[0][i].userId+"'>" +
	 				 						"<img width='50px' height='50px' src='"+weibos[0][i].userHeadimage+"'>" +
		 								"</a>" +
	 								"</div>" +
	 								"<div class='content-text' id='tempId'>" +
	 									"<h4><a>"+weibos[0][i].userNickname+"</a></h4>" +
										"<p style='margin-bottom:10px;color:#808080;'>"+
											new Date(weibos[0][i].weiboPublishtime).toLocaleString()+
											"&nbsp;"+"<a href='javascript:void(0)' onclick='deleteWeibo("+weibos[0][i].weiboId+",this)'>删除</a>"+
										"</p>"+weiboContents[0]+
										"<div class='row' style='background:rgb(247, 247, 247);padding:10px;'>" +
											"<h5>" +
												"<a href='/billblog-manager-controller/weibocontroller/tohomepage.do?userId="+
													weiboContents[6]+"'>"+weiboContents[2]+
												"</a>"+
											"</h5>"+
											"<div class='content-text'>" +
												"<p>"+
													weiboContents[3]+
												"</p>"+
												weiboContents[4]+
											"</div>"+
											"<div>" +
												"<div  class='innerForwardBottomDiv'>"+"<a>收藏</a>&nbsp;"+"</div>"+
												"<div  class='innerForwardBottomDiv'>"+"<a href='javascript:void(0)' onclick='forwardWeiboDiv("+weiboContents[7]+",this)'>转发</a>"+"</div>"+
												"<div  class='innerForwardBottomDiv'>"+"<a>评论"+weiboContents[10]+"</a>"+"</div>"+
												"<div  class='innerForwardBottomDiv'>"+"<a href='javascript:void(0)' onclick='avoidLike("+weiboContents[7]+",this)'>已赞"+weiboContents[8]+"</a>"+"</div>"+
											"</div>"+
										"</div>";
				 				 }
				 				 //装配图片
//				 				 if(weiboContents[5]!=null||weiboContents[5].length>0){
//				 					 //以%%为分界分隔图片
//				 					 var arr = new Array();
//				 					 arr = weibos[0][i].weiboImage.split("%%");
//				 					 for(j=0;j<arr.length;j++){
//				 						 if(arr[j]!=""){//如果不是空格的话，追加
////				 							 data=data+"<img style='padding:2px;' width='100px' height='100px' src='"+arr[j]+"'/>";
//				 						 }
//				 					 }
//				 				 }
				 				 var data;
			 					 if(weibos[2][i]==0&&(weiboContents[9]=="0"||weiboContents[9]==0)){
			 						 data=data1+suffix1;//组装
			 					 }else if(weibos[2][i]==0&&(weiboContents[9]=="1"||weiboContents[9]==1)){
			 						data=data2+suffix1;//组装
			 					 }else if(weibos[2][i]==1&&(weiboContents[9]=="1"||weiboContents[9]==1)){
			 						data=data2+suffix2;//组装
			 					 }
			 					 else if(weibos[2][i]==1&&(weiboContents[9]=="0"||weiboContents[9]==0)){
			 						data=data1+suffix2;//组装
			 					 }
				 				 $("#content-outer").append(data);
			 				}
			 			 }
			 			 if(weibos[0].length<10){
					 			$("#content-outer").append("<div style='text-align:center;'>已加载全部</div>");
			 			 }else{
					 			$("#content-outer").append("<div style='text-align:center;'><button id='loadmore' onclick='updateWeiboContent("+$(".content").length+")'>点击加载更多</button></div>");
			 			 }
			 			 var counter1 = setInterval(calTextWidth,80);//强制运行这个函数
					     setTimeout(function(){
					    	clearInterval(counter1);//2s后停止运行
					     },2000);
			 		}
			 	});
		 		calTextWidth();
		 	}   
		 	
		 	/**
		 	 * 删除微博
		 	 * @param weiboId
		 	 */
		 	function deleteWeibo(weiboId,thisA){
		 		$.ajax({
		 			url:"/billblog-manager-controller/weibocontroller/deleteweibo.do",
		 			type:"get",
		 			data:{weiboId:weiboId},
		 			dataType:"json",
		 			error:function(){
		 				alert("暂时无法删除微博！请重试");
		 			},
		 			success:function(data){
		 				$(thisA).parent().parent().parent().fadeOut('1000');
		 				setTimeout(function(){
		 					$(thisA).parent().parent().parent().remove();
		 					//点击加载更多
			 				$("#loadmore").attr("onclick","updateWeiboContent("+$(".content").length+")");
		 				},1000);		 				
		 			}
		 		});
		 	}
		 	
		 	//将时间戳转换成时间
		    function getDate(tm){ 
				var tt=new Date(parseInt(tm) * 1000).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ") 
				return tt; 
	    	} 
		    //窗口改变时，重新计算content-text即微博文字的宽度
		    $(document).ready(function(){
		    	$(window).resize(function(){
			    	calTextWidth();
			    });
		    });
		    
		 	updateWeiboContent(0);	//获取数据		
		    
		 	var counter = setInterval(calTextWidth,80);//强制运行这个函数
		    setTimeout(function(){
		    	clearInterval(counter);//2s后停止运行
		    },2000);
		    
		    /**
		     * 查看大图
		     * @param thisA
		     */
		    function showBigImage(thisA){
			 var data = "<div id='bigImageBlackDiv' onclick='removeBigImage()'>" +
 							"<img id='currentBigImage' src='"+$(thisA).attr("src")+"'>"+
		 				"</div>";
				 //获取原图的Size
				 var oriImg = new Image();
				 oriImg.src = $(thisA).attr("src");//原图路径
				//先判断原图的宽/高关系
				 var rat = oriImg.width/oriImg.height;
				 var top;
				 var height;
				 var width;
				 var left;
				 //如果是平板或手机之类的屏幕
				 if($(window).width()<700){	
					 //追加节点
					 $('body').append(data);
					 $("#bigImageBlackDiv").css({
						"height":$(window).height() 
					 });
					 if(rat>=1){//如果宽大于等于高
						//如果宽大于屏幕宽
						 if(oriImg.width>parseInt($(window).width())){
							 width=parseInt($(window).width());//令大图宽等于屏幕宽
							 height = width/rat;//高按比例缩放
						 }else{//如果宽度小于屏幕宽
							 width = oriImg.width;
							 height = oriImg.height;
							 left = (parseInt($(window).width())-width)/2;
						 }
						 top = (parseInt($(window).height())-height)/2;
					 }else{//如果高大于宽
						 //如果原图高度大于屏幕高度
						 if(oriImg.height>parseInt($(window).height())){//如果原图的高度大于屏幕高度
							 width=parseInt($(window).width());//令大图宽等于屏幕宽
							 height = width/rat;//高按比例缩放
						 }else{//如果原图高度小于屏幕高度
							 height = oriImg.height;//高等于原图
							 //如果高乘以比例后，仍然大于屏幕宽
							 if(oriImg.height*rat>parseInt($(window).width())){
								width = parseInt($(window).width());
								height = width/rat;//高按比例缩放
							 }else{//如果原图高度*rat小于屏幕宽度
								 width = height*rat;
								 left = (parseInt($(window).width())-width)/2;
							 }							 
						 }
						 top = (parseInt($(window).height())-height)/2;
					 }
					 $("#bigImageBlackDiv img").css({
						"width":width,
						"padding":"0px 10px",
						"position":"absolute",
						"height":height,
						"top":top,
						"left":left
					 });
					 $("#bigImageBlackDiv").css({
						 "overflow":"auto",
						 "position":"fixed",
					 });
					 $("body").css("overflow","hidden");
				 }else{//电脑屏幕
					 if($("#currentBigImage").length>0){
						 $("#bigImageBlackDiv").remove();
					 }
					 width = parseInt($(".content-text").width());//宽度
					 $(thisA).parent().append(data);//必须要先添加元素
					 /*
					  * 先让其他相同class图片的onclick为显示大图，
					  * 再让自己的onclick变成显示隐藏大图
					  */
					 $(".weiboImage").attr("onclick","showBigImage(this)");
					 $(thisA).attr("onclick","removeBigImage()");
					 height = width/rat;
					 $("#bigImageBlackDiv img").css({
						"width":width,
						"position":"relative",
						"height":height,						
					 });
					 $("#bigImageBlackDiv").css({
						 "position":"relative",
						 "z-index":9
					 });
					 $(thisA).css({
						 "color":"#f7f7f7", 
					 });
				 }		 				
		    }
		    function removeBigImage(){
		    	$("#bigImageBlackDiv").remove();
		    	$("body").css("overflow","auto");
		    	$(".weiboImage").attr("onclick","showBigImage(this)");
		    }