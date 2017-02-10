/**
 * 
 */
			//计算content-text的宽度
		    function calTextWidth(){
		    	console.info("进来了！");
	 		    //先获取class=row、content的宽度。不包括padding
		    	var content_div_wid = parseInt($(".content").width());
		    	$(".content-head").css({
		    		"width":"50px",
		    		"height":"50px",
		    		"float":"left"
		    	});
		    	//再获取头像的宽度
		    	var content_head_wid = parseInt($(".content-head").width());
		    	//设置文字，即content-text的宽度
		    	$(".content-text").css("width",content_div_wid-content_head_wid-30);//减去10px的误差
		    	//设置content-text的样式
		    	$(".content-text").css("padding-left",10);
		    	$(".content-text").css("padding-right",10);
		    	$(".content-text").css("float","left");
		    	$(".text-bottom-div").css("padding","10px 0px");
		    	$(".text-bottom-div div").css("padding","0px");
		    }
			
		 	//获取微博的ajax	   
		 	function updateWeiboContent(){
		 		var val = $("#hidden-weibo-id").val();
	 			$.ajax({	 				
			 		url:"/billblog-manager-controller/weibocontroller/getoneweibo.do",
			 		type:"get",
			 		data:{weiboId:val},
			 		dataType:"json",
			 		error:function(){alert("出错了");},
			 		success:function(weibos){			 			
			 			 if($("#loadmore").length>0){
			 				$("#loadmore").remove();//先删除
			 			 }
			 			 
		 				//默认状态时
	 					 var suffix1 = "</div><div class='float'></div><div class='container-fluid text-bottom-div'><div class='col-xs-3'><a>收藏</a></div><div class='col-xs-3'><a href='javascript:void(0)' onclick='forwardWeiboDiv("+weibos[0].weiboId+",this)'>转发</a></div><div class='col-xs-3'><a href='javascript:void(0)' onclick='getComments("+weibos[0].weiboId+",this,0)'>评论"+weibos[3]+"</a></div><div class='col-xs-3'><a href='javascript:void(0)' onclick='likeweibo("+weibos[0].weiboId+",this)'>点赞</a>"+"&nbsp;<a target='_blank' href='/billblog-manager-controller/likecontroller/showlikepeople.do?belikeId="+weibos[0].weiboId+"&offset=0'>"+weibos[1]+"</a></div></div></div>";
		 				 var suffix2 = "</div><div class='float'></div><div class='container-fluid text-bottom-div'><div class='col-xs-3'><a>收藏</a></div><div class='col-xs-3'><a href='javascript:void(0)' onclick='forwardWeiboDiv("+weibos[0].weiboId+",this)'>转发</a></div><div class='col-xs-3'><a href='javascript:void(0)' onclick='getComments("+weibos[0].weiboId+",this,0)'>评论"+weibos[3]+"</a></div><div class='col-xs-3'><a href='javascript:void(0)' onclick='avoidLike("+weibos[0].weiboId+",this)'>已赞</a>"+"&nbsp;<a target='_blank' href='/billblog-manager-controller/likecontroller/showlikepeople.do?belikeId="+weibos[0].weiboId+"&offset=0'>"+weibos[1]+"</a></div></div></div>";
		 				 var data = "<div class='row content'><div class='content-head'><a href='tohomepage.do?userId="+weibos[0].userId+"'><img width='50px' height='50px' id='myHeadimage' src='"+weibos[0].userHeadimage+"'></a></div><div class='content-text' id='tempId'><h4><a>"+weibos[0].userNickname+"</a></h4><p style='margin-bottom:10px;color:#808080;'>"+
			 						new Date(weibos[0].weiboPublishtime).toLocaleString()+"</p>"+weibos[0].weiboContent+"<br>";			 				 
		 				 if(weibos[0].userId==$("#hiddenId").val()){
		 					data = "<div class='row content'><div class='content-head'><a href='tohomepage.do?userId="+weibos[0][i].userId+"'><img id='myHeadimage' width='50px' height='50px' src='"+weibos[0][i].userHeadimage+"'></a></div><div class='content-text' id='tempId'><h4><a>"+weibos[0][i].userNickname+"</a></h4><p style='margin-bottom:10px;color:#808080;'>"+
 				 			new Date(weibos[0].weiboPublishtime).toLocaleString()+"&nbsp;"+"<a href='javascript:void(0)' onclick='deleteWeibo("+weibos[0].weiboId+",this)'>删除</a>"+"</p>"+weibos[0].weiboContent+"<br>";	

		 				 }
		 				 //装配图片
		 				 if(weibos[0].weiboImage!=null){
		 					 //以%%为分界分隔图片
		 					 var arr = new Array();
		 					 arr = weibos[0].weiboImage.split("%%");
		 					 for(j=0;j<arr.length;j++){
		 						 if(arr[j]!=""){//如果不是空格的话，追加
		 							 data=data+"<img class='weiboImage' onclick='showBigImage(this)' style='padding:2px;' width='100px' height='100px' src='"+arr[j]+"'/>";
		 						 }
		 					 }
		 				 }
	 					 if(weibos[2]==0){
	 						 data=data+suffix1;//组装
	 					 }else{
	 						data=data+suffix2;//组装
	 					 }
		 				 $("#main-div").append(data);
		 				 var counter1 = setInterval(calTextWidth,80);//强制运行这个函数
					     setTimeout(function(){
					    	clearInterval(counter1);//2s后停止运行
					     },2000);
			 		}
			 	});
		 		calTextWidth();
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
		    	$("#main-div").append(data);
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
		 	
		 	updateWeiboContent();