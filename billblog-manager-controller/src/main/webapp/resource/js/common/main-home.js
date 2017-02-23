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
	    	$("#forwardDiv").fadeOut(200,function(){
	    		$("#forwardDiv").remove();
	    	});
	    	$("#forwardForm").addClass("exitForward");
	    	setTimeout(function(){
	    		$("#forwardForm").remove();
	    		$("#forwardForm").removeClass("exitForward");
	    	},200);
	    }
	    //转发时弹出的面板
	    function forwardWeiboDiv(beForwardWeiboId,thisA){
	    	if($("#forwardForm").length>0){
	    		$("#forwardForm").remove();
	    	}		    	
	    	var data =  "<div id='forwardDiv' style='display:none;'>" +
	    				  "<style id=tmpFallStyle></style>"+	    				  
	    			   "</div>";
	    	var form =   "<form action='/billblog-manager-controller/weibocontroller/forwardweibo.do' method='post' id='forwardForm'>" +
							"<div>" +		    						
								"<a href='javascript:void(0)' onclick='closeForwardForm()' style='color:red;float:right;'>关闭</a>" +
								"<div style='clear:both'></div>"+
							"</div>"+
							"<div>" +
								"转发：@"+$(thisA).parent().parent().children(".content-text").text()+
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
	    	$("body").append(data);
	    	$("body").append(form);
	    	$("#forwardDiv").fadeIn(500,function(){
	    		$("#forwardDiv").css("display","block");
	    	});
	    	$("#forwardDiv").css({
	    		"position":"fixed",
	    		"background":"black",
	    		"width":$(window).width(),
	    		"height":$(window).height(),
	    		"z-index":999,
	    		"top":0,
	    		"left":0,	    		
	    	});
	    	$("#forwardForm").css({
	    		"background":"powderblue",
	    		"border-radius":"4px",
	    		"width":w+40,
	    		"padding":"10px",
	    		"overflow":"auto",
	    		"margin-bottom":10,	 
	    		"margin":"0px auto",
	    		"position":"fixed",
	    		"z-index":1000
	    	});
	    	$("#forwardForm textarea").css({
	    		"resize":"none",
	    		"width":"100%",
	    		"height":70,	    		
	    	});
	    	$("#forwardForm input[type='submit']").css({
	    		"float":"right",
	    	});
	    	//转发框的特效
	    	//先用屏幕宽度减去转发框的宽度除以二，得到距离左边的距离	    	
	    	var left = ($(window).width()-$("#forwardForm").width())/2-10;
	    	$("#forwardForm").css({
	    		"left":left,
	    		"top":10+'px'
	    	});
	    	var bottom = $(window).height()+$("#forwardForm").height();
	    	//动画
	    	document.getElementById("tmpFallStyle").innerHTML=  "@keyframes fall{" +
	    														"0% {top:"+bottom+"px;}" +
	    														"25%{top:"+bottom/2+"px;}" +
	    														"50%{top:"+0+"px;}" +
	    														"75%{top:"+bottom*1/5+"px;}" +
	    														"100%{top:"+0+"px;}}"+
	    														"@-webkit-keyframes fall{" +
	    														"0% {top:"+bottom+"px;}" +
	    														"25%{top:"+bottom/2+"px;}" +
	    														"50%{top:"+0+"px;}" +
	    														"75%{top:"+bottom*1/5+"px;}" +
	    														"100%{top:"+0+"px;}}"+
	    														"@-moz-keyframes fall{" +
	    														"0% {top:"+bottom+"px;}" +
	    														"25%{top:"+bottom/2+"px;}" +
	    														"50%{top:"+0+"px;}" +
	    														"75%{top:"+bottom*1/5+"px;}" +
	    														"100%{top:"+0+"px;}}"+
	    														"@-o-keyframes fall{" +
	    														"0% {top:"+bottom+"px;}" +
	    														"25%{top:"+bottom/2+"px;}" +
	    														"50%{top:"+0+"px;}" +
	    														"75%{top:"+bottom*1/5+"px;}" +
	    														"100%{top:"+0+"px;}}"+
	    														"@keyframes rotateForward{" +
	    														"0% {transform: rotate(0deg)}" +
	    														"10%{transform: rotate(36deg)}" +
	    														"20%{transform: rotate(72deg)}" +
	    														"30%{transform: rotate(108deg)}" +
	    														"40%{transform: rotate(144deg)}}"+
	    														"50% {transform: rotate(180deg)}" +
	    														"60%{transform: rotate(216deg)}" +
	    														"70%{transform: rotate(252deg)}" +
	    														"80%{transform: rotate(288deg)}" +
	    														"90%{transform: rotate(324deg)}}"+
	    														"100%{transform: rotate(360deg)}}"+
	    														"@-webkit-keyframes rotateForward{" +
	    														"0% {-webkit-transform: rotate(0deg)}" +
	    														"10%{-webkit-transform: rotate(36deg)}" +
	    														"20%{-webkit-transform: rotate(72deg)}" +
	    														"30%{-webkit-transform: rotate(108deg)}" +
	    														"40%{-webkit-transform: rotate(144deg)}}"+
	    														"50% {-webkit-transform: rotate(180deg)}" +
	    														"60%{-webkit-transform: rotate(216deg)}" +
	    														"70%{-webkit-transform: rotate(252deg)}" +
	    														"80%{-webkit-transform: rotate(288deg)}" +
	    														"90%{-webkit-transform: rotate(324deg)}}"+
	    														"100%{-webkit-transform: rotate(360deg)}}"+
	    														"@-moz-keyframes rotateForward{" +
	    														"0% {-moz-transform: rotate(0deg)}" +
	    														"10%{-moz-transform: rotate(36deg)}" +
	    														"20%{-moz-transform: rotate(72deg)}" +
	    														"30%{-moz-transform: rotate(108deg)}" +
	    														"40%{-moz-transform: rotate(144deg)}}"+
	    														"50% {-moz-transform: rotate(180deg)}" +
	    														"60%{-moz-transform: rotate(216deg)}" +
	    														"70%{-moz-transform: rotate(252deg)}" +
	    														"80%{-moz-transform: rotate(288deg)}" +
	    														"90%{-moz-transform: rotate(324deg)}}"+
	    														"100%{-moz-transform: rotate(360deg)}}"+
	    														"@-o-keyframes rotateForward{" +
	    														"0% {-o-transform: rotate(0deg)}" +
	    														"10%{-o-transform: rotate(36deg)}" +
	    														"20%{-o-transform: rotate(72deg)}" +
	    														"30%{-o-transform: rotate(108deg)}" +
	    														"40%{-o-transform: rotate(144deg)}}"+
	    														"50% {-o-transform: rotate(180deg)}" +
	    														"60%{-o-transform: rotate(216deg)}" +
	    														"70%{-o-transform: rotate(252deg)}" +
	    														"80%{-o-transform: rotate(288deg)}" +
	    														"90%{-o-transform: rotate(324deg)}}"+
	    														"100%{-o-transform: rotate(360deg)}}";
	    	$("#forwardForm").addClass("fallForward");
	    	//动画播放完成后，自动除移
	    	setTimeout(function(){
	    		$("#forwardForm").removeClass("fallForward");
	    		//转发页面可拖拽
	    		//拖拽事件
		    	$('#forwardForm').css("cursor","move ");
		    	$("#forwardForm").mousedown(function(e){
		    		//获取当前鼠标位置和当前div的位置差
		    		var distanceY = e.pageY-parseInt($("#forwardForm").css('top'));
		    		//移动
		    		$(window).mousemove(function(e){
		    			//鼠标移动到的坐标减去坐标相对于div边缘的位置
		    			var y = e.pageY-distanceY;
		    			 $("#forwardForm").css({
		    		         'top':y+'px',
	    		        });
		    		});
		    		 //鼠标释放
	    		    $(window).mouseup(function(){
	    		        $(window).off('mousemove');
	    		    });
		    	});	    
	    	},550);	    		
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
	    
	    
	 /**
	  * 把微博数据填充到页面
	  */
	 function useWeiboDataToPage(weibos){
		 for(i=0;i<weibos[0].length;i++){
			 	 //如果点赞数、评论数分别为0，则都赋予空字符串处理
			 	 if(weibos[1][i]==0){
			 		weibos[1][i]='';
			 	 }
			 	 if(weibos[3][i]==0){
			 		weibos[3][i]='';
			 	 }
			 	 if(weibos[4][i]==0){
			 		weibos[4][i]='';
			 	 }
				//默认状态时 
				if(weibos[0][i].weiboState==0){
					 //未点赞
					 var suffix = "</div><div class='float'></div><div class='container-fluid text-bottom-div'><div class='col-xs-3'><a><span class='glyphicon glyphicon-star-empty content-span'></span></a></div><div class='col-xs-3' onclick='forwardWeiboDiv("+weibos[0][i].weiboId+",this)'><a href='javascript:void(0)'> <span class='glyphicon glyphicon-share-alt content-span'></span>"+weibos[4][i]+"</a></div><div class='col-xs-3'><a href='javascript:void(0)' class='rollIn' onclick='getComments("+weibos[0][i].weiboId+",this,0)'><span class='glyphicon glyphicon-comment content-span'></span>&nbsp;"+weibos[3][i]+"</a></div><div class='col-xs-3'><a class='tmpLikeA rollIn' id='tmpLikeA"+i+"' href='javascript:void(0)' onclick='likeweibo("+weibos[0][i].weiboId+",this)'><span class='glyphicon glyphicon-thumbs-up content-span'></span></a>"+"&nbsp;<a target='_blank' href='/billblog-manager-controller/likecontroller/showlikepeople.do?belikeId="+weibos[0][i].weiboId+"&offset=0'>"+weibos[1][i]+"</a></div></div></div>";
	 				 //微博正文
					 var data = "<div class='row content'><div class='content-head'><a href='tohomepage.do?userId="+weibos[0][i].userId+"'><img width='50px' height='50px' src='"+weibos[0][i].userHeadimage+"'></a></div><div class='content-text content-text-tmp' id='content-text-tmp"+i+"'><h4><a>"+weibos[0][i].userNickname+"</a></h4><p style='margin-bottom:10px;color:#808080;'>"+
		 						new Date(weibos[0][i].weiboPublishtime).toLocaleString()+"</p>"+"<p>"+weibos[0][i].weiboContent+"</p>";			 				 
	 				 if(weibos[0][i].userId==$("#mynicknameA").attr("href").split("?userId=")[1]){
	 					data = "<div class='row content'><div class='content-head'><a href='tohomepage.do?userId="+weibos[0][i].userId+"'><img width='50px' height='50px' src='"+weibos[0][i].userHeadimage+"'></a></div><div class='content-text content-text-tmp' id='content-text-tmp"+i+"'><h4><a>"+weibos[0][i].userNickname+"</a></h4><p style='margin-bottom:10px;color:#808080;'>"+
			 			new Date(weibos[0][i].weiboPublishtime).toLocaleString()+"&nbsp;"+"<a href='javascript:void(0)' onclick='deleteWeibo("+weibos[0][i].weiboId+",this)'>删除</a>"+"</p>"+"<p>"+weibos[0][i].weiboContent+"</p>";	
	 				 }
	 				 //添加到页面
	 				$("#content-outer").append(data+suffix);
	 				//如果我已经点了赞weiboContents[5]==$("#mynicknameA").attr("href").split("?userId=")[1]
	 				if(weibos[2][i]==1){
	 					$("#tmpLikeA"+i).children("span").css("color","red");
	 					$("#tmpLikeA"+i).attr("onclick","avoidLike("+$("#tmpLikeA"+i).attr("onclick").split("(")[1]);
	 				}
	 				//解析表情
	 				var oriHtml = $(".content-text:last>:nth-child(3)").html();
	 				while(oriHtml.indexOf("<emj>")>=0){
	 					for(m=1;m<61;m++){
		 					oriHtml = oriHtml.replace("<emj>"+m+"</emj>","<img src='/billblog-manager-controller/resource/plug-res/images/face/"+m+".gif'/>");
		 				}
	 				}
	 				$(".content-text:last>:nth-child(3)").html(oriHtml);
	 				 //装配图片				 				 
	 				 if(weibos[0][i].weiboImage!=null){
	 					var dataImgs = '';
	 					 //以%%为分界分隔图片			 					 
	 					 var arr = new Array();
	 					 arr = weibos[0][i].weiboImage.split("%%");
	 					 for(j=0;j<arr.length;j++){
	 						 if(arr[j]!=""){//如果不是空格的话，追加
	 							dataImgs=dataImgs+"<img class='weiboImage' onclick='showBigImageCanScroll(this)' style='padding:2px;' width='100px' height='100px' src='"+arr[j]+"'/>";
	 						 }
	 					 }
	 					$("#content-text-tmp"+i).append("<div>"+dataImgs+"</div>");
	 				 }					 				
				}else if(weibos[0][i].weiboState==2){//转发
					 var suffix = "</div>" +
					 					"<div class='float'></div>" +
					 					"<div class='container-fluid text-bottom-div'>" +
					 						"<div class='col-xs-3'>" +
					 							"<a><span class='glyphicon glyphicon-star-empty content-span'></span></a>" +
					 						"</div>" +
					 						"<div class='col-xs-3' onclick='forwardWeiboDiv("+weibos[0][i].weiboId+",this)'>" +
					 							"<a href='javascript:void(0)'><span class='glyphicon glyphicon-share-alt content-span'></span>"+weibos[4][i]+"</a>" +
					 						"</div>" +
					 						"<div class='col-xs-3'>" +
				 								"<a href='javascript:void(0)' onclick='getComments("+weibos[0][i].weiboId+",this,0)'><span class='glyphicon glyphicon-comment content-span'></span>&nbsp;"+weibos[3][i]+"</a>" +
				 							"</div>" +
				 							"<div class='col-xs-3'>" +
				 								"<a href='javascript:void(0)' class='tmpLikeFA' id='tmpLikeFA"+i+"' onclick='likeweibo("+weibos[0][i].weiboId+",this)'><span class='glyphicon glyphicon-thumbs-up content-span'></span></a>"+
				 								"&nbsp;" +
				 								"<a target='_blank' href='/billblog-manager-controller/likecontroller/showlikepeople.do?belikeId="+weibos[0][i].weiboId+"&offset=0'>"+weibos[1][i]+"</a>" +
				 							"</div>" +
										"</div>" +
								   "</div>";
	 				 var  weiboContents= weibos[0][i].weiboContent.split("@_@");
	 				 //如果转发链中有微博被删除
	 				 if(weiboContents.length<3){
	 					 var myWeibo = weibos[0][i].weiboContent.split("<br>原微博已")[0];
	 					 var delContent = "<div class='row content'>" +
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
											"</p>"+myWeibo+
											"<div class='row' style='background:rgb(247, 247, 247);padding:10px;'>" +
												"<div class='content-text content-text-tmp' id='content-text-tmp"+i+"'>" +
													"原微博已删除"+"<br>"+
												"</div>"+
											"</div>";
	 					$("#content-outer").append(delContent+suffix);
	 					//如果是当前用户的微博，则提供删除功能
		 				if(weibos[0][i].userId==$("#mynicknameA").attr("href").split("?userId=")[1]){
		 					$("#content-text-tmp"+i).parent().parent().children("p").append("<a href='javascript:;' onclick='deleteWeibo("+weibos[0][i].weiboId+",this)'>删除</a>");
		 				}
	 					continue;
	 				 }
	 				 //
					 if(weiboContents[10]==0){
						weiboContents[10]='';
					 }
					 if(weiboContents[8]==0){
						weiboContents[8]='';
					 }
	 				 //微博内容
	 				 var data = "<div class='row content'>" +
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
										"</p>"+"<p>"+weiboContents[0]+"</p>"+
										"<div class='row' style='background:rgb(247, 247, 247);padding:10px;'>" +
											"<h5>" +
												"<a href='/billblog-manager-controller/weibocontroller/tohomepage.do?userId="+
													weiboContents[6]+"'>"+weiboContents[2]+
												"</a>"+
											"</h5>"+
											"<div class='content-text content-text-tmp' id='content-text-tmp"+i+"'>" +
												"<p>"+
													weiboContents[3]+
												"</p>"+
												"<p>"+weiboContents[4]+"</p>"+
											"</div>"+
											"<div>" +
												"<div  class='innerForwardBottomDiv'>"+"<a><span class='glyphicon glyphicon-star-empty content-span'></span></a>&nbsp;"+"</div>"+
												"<div  class='innerForwardBottomDiv' onclick='forwardWeiboDiv("+weiboContents[7]+",this)'>"+"<a href='javascript:void(0)'><span class='glyphicon glyphicon-share-alt content-span'></span>"+weiboContents[11]+"</a>"+"</div>"+
												"<div  class='innerForwardBottomDiv'>"+"<a href='javascript:;'  onclick='getOneWeibo("+weiboContents[7]+")'><span class='glyphicon glyphicon-comment content-span'></span>&nbsp;"+weiboContents[10]+"</a>"+"</div>"+
												"<div  class='innerForwardBottomDiv'>"+"<a href='javascript:void(0)' class='tmpLikeA' id='tmpLikeA"+i+"' onclick='likeweibo("+weiboContents[7]+",this)'><span class='glyphicon glyphicon-thumbs-up' style='color:gray;'></span>"+weiboContents[8]+"</a>"+"&nbsp;<a></a>"+"</div>"+
											"</div>"+
										"</div>";
	 				//拼装
	 				data = data  + suffix;
	 				//追加到id为content-outer的div后面 
	 				$("#content-outer").append(data);
	 				//如果我已经点了赞weiboContents[5]==$("#mynicknameA").attr("href").split("?userId=")[1]
	 				if(weiboContents[9]==1){
	 					$("#tmpLikeA"+i).children("span").css("color","red");
	 					$("#tmpLikeA"+i).attr("onclick","avoidLike("+$("#tmpLikeA"+i).attr("onclick").split("(")[1]);
	 				}
	 				//如果我已经点赞了当前的微博(不是转发的原微博)
	 				if(weibos[2][i]==1){	 					
	 					$("#tmpLikeFA"+i).children("span").css("color","red");
	 					$("#tmpLikeFA"+i).attr("onclick","avoidLike("+$("#tmpLikeFA"+i).attr("onclick").split("(")[1]);
	 				}
	 				//如果转发的原微博属于当前用户的，则提供删除功能
	 				if(weiboContents[6]==$("#mynicknameA").attr("href").split("?userId=")[1]){
	 					$("#content-text-tmp"+i+">:first-child").append("<a href='javascript:;' onclick='deleteWeibo("+weiboContents[7]+",this)'>删除</a>");
	 				}
	 				//如果是当前用户的微博，则提供删除功能
	 				if(weibos[0][i].userId==$("#mynicknameA").attr("href").split("?userId=")[1]){
	 					$("#content-text-tmp"+i).parent().parent().children("p").first().append("<a href='javascript:;' onclick='deleteWeibo("+weibos[0][i].weiboId+",this)'>删除</a>");
	 				}
	 				//解析表情:待重构
	 				var oriHtml = $(".content-text:last>:nth-child(2)").html();
	 				console.log(oriHtml);
	 				while(oriHtml.indexOf("<emj>")>=0){
	 					for(m=1;m<61;m++){
		 					oriHtml = oriHtml.replace("<emj>"+m+"</emj>","<img src='/billblog-manager-controller/resource/plug-res/images/face/"+m+".gif'/>");
		 				}
	 				}
	 				$(".content-text:last>:nth-child(2)").html(oriHtml);
	 				//加载转发时原微博的图片:类content-text-tmp，id为content-text-tmp+i
	 				var forwardImgs="";
	 				var forwardImgsStr=weiboContents[5];
//	 				alert(weiboContents[5]==null);
//	 				alert(weiboContents[5]=='null');
	 				if(forwardImgsStr!="null"){
	 					var forwardImgsArr = forwardImgsStr.split("%%");
		 				for(k=0;k<forwardImgsArr.length;k++){
		 					if(forwardImgsArr[k]==''||forwardImgsArr[k]==null||forwardImgsArr[k].length<=0){
		 						continue;
		 					}
		 					forwardImgs = forwardImgs+"<img class='weiboImage' onclick='showBigImageCanScroll(this)' style='padding:2px;width:100px;height:100px;' src='"+forwardImgsArr[k]+"'/>";
		 				}
		 				$("#content-text-tmp"+i).append("<div>"+forwardImgs+"</div>");
	 				}	 				
				}//转发结束			 				
			 }
			//为了防止后面点击加载更多时候出现干扰，每个页面加载到最后一个的时候，把点赞处的id和class=tmpLikeA全都除移
			 $(".tmpLikeA").removeAttr("id");
			 $(".tmpLikeA").removeClass("tmpLikeA");
			//为了防止后面点击加载更多时候出现干扰，每个页面加载到最后一个的时候，把点赞处的id和class=tmpLikeA全都除移
			 $(".tmpLikeFA").removeAttr("id");
			 $(".tmpLikeFA").removeClass("tmpLikeFA");
			//为了防止后面点击加载更多时候出现干扰，每个页面加载到最后一个的时候，把转发的图片临时设置的id和class=content-text-tmp全都除移
			 $(".content-text-tmp").removeAttr("id");
			 $(".content-text-tmp").removeClass("content-text-tmp");
			 //加载更多
			 if(weibos[0].length<10){
		 			$("#content-outer").append("<div style='text-align:center;'>已加载全部</div>");
			 }else{
		 			$("#content-outer").append("<div style='text-align:center;'><button id='loadmore' onclick='updateWeiboContent("+$(".content").length+")'>点击加载更多</button></div>");
			 }
			 
			 //删除加载中的图片
			 $("#tmpLoading").fadeOut(100,function(){
				$("#tmpLoading").remove();
			 });
			 
			 //css定位
			 var counter1 = setInterval(calTextWidth,80);//强制运行这个函数
		     setTimeout(function(){
		    	clearInterval(counter1);//2s后停止运行
		     },2000);
		     //图片特效
		     imageCss();
	 }
	 
	 /**
	  * 把某条微博数据填充到页面
	  */
	 function useOneWeiboDataToPage(weibos){
			 	 //如果点赞数、评论数分别为0，则都赋予空字符串处理
			 	 if(weibos[1]==0){
			 		weibos[1]='';
			 	 }
			 	 if(weibos[3]==0){
			 		weibos[3]='';
			 	 }
				 if(weibos[4]==0){
					 weibos[4]='';
				 }
				if(weibos[0].weiboState==0){//默认状态时 
					 //未点赞
					 var suffix = "</div><div class='float'></div><div class='container-fluid text-bottom-div'><div class='col-xs-3'><a><span class='glyphicon glyphicon-star-empty content-span'></span></a></div><div class='col-xs-3' onclick='forwardWeiboDiv("+weibos[0].weiboId+",this)'><a href='javascript:void(0)'> <span class='glyphicon glyphicon-share-alt content-span'></span>"+weibos[4]+"</a></div><div class='col-xs-3'><a href='javascript:void(0)' class='rollIn' onclick='getComments("+weibos[0].weiboId+",this,0)'><span class='glyphicon glyphicon-comment content-span'></span>&nbsp;"+weibos[3]+"</a></div><div class='col-xs-3'><a class='tmpLikeA rollIn' id='tmpLikeA' href='javascript:void(0)' onclick='likeweibo("+weibos[0].weiboId+",this)'><span class='glyphicon glyphicon-thumbs-up content-span'></span></a>"+"&nbsp;<a target='_blank' href='/billblog-manager-controller/likecontroller/showlikepeople.do?belikeId="+weibos[0].weiboId+"&offset=0'>"+weibos[1]+"</a></div></div></div>";
	 				 //微博正文
					 var data = "<div class='row content'><div class='content-head'><a href='tohomepage.do?userId="+weibos[0].userId+"'><img width='50px' height='50px' src='"+weibos[0].userHeadimage+"'></a></div><div class='content-text content-text-tmp' id='content-text-tmp'><h4><a>"+weibos[0].userNickname+"</a></h4><p style='margin-bottom:10px;color:#808080;'>"+
		 						new Date(weibos[0].weiboPublishtime).toLocaleString()+"</p>"+"<p>"+weibos[0].weiboContent+"</p>"+"<br>";			 				 
	 				 if(weibos[0].userId==$("#mynicknameA").attr("href").split("?userId=")[1]){
	 					data = "<div class='row content'><div class='content-head'><a href='tohomepage.do?userId="+weibos[0].userId+"'><img width='50px' height='50px' src='"+weibos[0].userHeadimage+"'></a></div><div class='content-text content-text-tmp' id='content-text-tmp'><h4><a>"+weibos[0].userNickname+"</a></h4><p style='margin-bottom:10px;color:#808080;'>"+
			 			new Date(weibos[0].weiboPublishtime).toLocaleString()+"&nbsp;"+"<a href='javascript:void(0)' onclick='deleteWeibo("+weibos[0].weiboId+",this)'>删除</a>"+"</p>"+"<p>"+weibos[0].weiboContent+"</p>";	
	 				 }
	 				 //添加到页面
	 				$("#content-outer").append(data+suffix);
	 				//如果我已经点了赞weiboContents[5]==$("#mynicknameA").attr("href").split("?userId=")[1]
	 				if(weibos[2]==1){
	 					$("#tmpLikeA").children("span").css("color","red");
	 					$("#tmpLikeA").attr("onclick","avoidLike("+$("#tmpLikeA").attr("onclick").split("(")[1]);
	 				}
	 				//解析表情
	 				var oriHtml = $(".content-text:last>:nth-child(3)").html();
	 				for(m=1;m<61;m++){
	 					oriHtml = oriHtml.replace("<emj>"+m+"</emj>","<img src='/billblog-manager-controller/resource/plug-res/images/face/"+m+".gif'/>");
	 				}
	 				$(".content-text:last>:nth-child(3)").html(oriHtml);
	 				 //装配图片				 				 
	 				 if(weibos[0].weiboImage!=null){
	 					var dataImgs = '';
	 					 //以%%为分界分隔图片			 					 
	 					 var arr = new Array();
	 					 arr = weibos[0].weiboImage.split("%%");
	 					 for(j=0;j<arr.length;j++){
	 						 if(arr[j]!=""){//如果不是空格的话，追加
	 							dataImgs=dataImgs+"<img class='weiboImage' onclick='showBigImageCanScroll(this)' style='padding:2px;' width='100px' height='100px' src='"+arr[j]+"'/>";
	 						 }
	 					 }
	 					$("#content-text-tmp").append("<div>"+dataImgs+"</div>");
	 				 }				 				
				}else if(weibos[0].weiboState==2){//转发
					 var suffix = "</div>" +
					 					"<div class='float'></div>" +
					 					"<div class='container-fluid text-bottom-div'>" +
					 						"<div class='col-xs-3'>" +
					 							"<a><span class='glyphicon glyphicon-star-empty content-span'></span></a>" +
					 						"</div>" +
					 						"<div class='col-xs-3' onclick='forwardWeiboDiv("+weibos[0].weiboId+",this)'>" +
					 							"<a href='javascript:void(0)'><span class='glyphicon glyphicon-share-alt content-span'></span>"+weibos[4]+"</a>" +
					 						"</div>" +
					 						"<div class='col-xs-3'>" +
				 								"<a href='javascript:void(0)' onclick='getComments("+weibos[0].weiboId+",this,0)'><span class='glyphicon glyphicon-comment content-span'></span>&nbsp;"+weibos[3]+"</a>" +
				 							"</div>" +
				 							"<div class='col-xs-3'>" +
				 								"<a href='javascript:void(0)' class='tmpLikeFA' id='tmpLikeFA' onclick='likeweibo("+weibos[0].weiboId+",this)'><span class='glyphicon glyphicon-thumbs-up content-span'></span></a>"+
				 								"&nbsp;" +
				 								"<a target='_blank' href='/billblog-manager-controller/likecontroller/showlikepeople.do?belikeId="+weibos[0].weiboId+"&offset=0'>"+weibos[1]+"</a>" +
				 							"</div>" +
										"</div>" +
								   "</div>";
	 				 var  weiboContents= weibos[0].weiboContent.split("@_@");
	 				 //如果转发链中有微博被删除
	 				 if(weiboContents.length<3){
	 					 var myWeibo = weibos[0].weiboContent.split("<br>原微博已")[0];
	 					 var delContent = "<div class='row content'>" +
							 				"<div class='content-head'>" +
							 					"<a href='tohomepage.do?userId="+weibos[0].userId+"'>" +
							 						"<img width='50px' height='50px' src='"+weibos[0].userHeadimage+"'>" +
												"</a>" +
											"</div>" +
											"<div class='content-text' id='tempId'>" +
												"<h4><a>"+weibos[0].userNickname+"</a></h4>" +
											"<p style='margin-bottom:10px;color:#808080;'>"+
												new Date(weibos[0].weiboPublishtime).toLocaleString()+
												"&nbsp;"+
											"</p>"+myWeibo+
											"<div class='row' style='background:rgb(247, 247, 247);padding:10px;'>" +
												"<div class='content-text content-text-tmp' id='content-text-tmp'>" +
													"原微博已删除"+"<br>"+
												"</div>"+
											"</div>";
	 					 //删除加载中的图片
	 					 $("#tmpLoading").fadeOut(100,function(){
	 						$("#tmpLoading").remove();
	 					 });
	 					$("#content-outer").append(delContent+suffix);
	 					return;
	 				 }
	 				 //
					 if(weiboContents[8]==0){
						weiboContents[8]='';
					 }
					 if(weiboContents[7]==0){
						weiboContents[7]='';
					 }
					 if(weiboContents[11]==0){
						weiboContents[11]='';
					 }
	 				 //微博内容
	 				 var data = "<div class='row content'>" +
	 				 				"<div class='content-head'>" +
	 				 					"<a href='tohomepage.do?userId="+weibos[0].userId+"'>" +
	 				 						"<img width='50px' height='50px' src='"+weibos[0].userHeadimage+"'>" +
		 								"</a>" +
	 								"</div>" +
	 								"<div class='content-text' id='tempId'>" +
	 									"<h4><a>"+weibos[0].userNickname+"</a></h4>" +
										"<p style='margin-bottom:10px;color:#808080;'>"+
											new Date(weibos[0].weiboPublishtime).toLocaleString()+
											"&nbsp;"+
										"</p>"+weiboContents[0]+
										"<div class='row' style='background:rgb(247, 247, 247);padding:10px;'>" +
											"<h5>" +
												"<a href='/billblog-manager-controller/weibocontroller/tohomepage.do?userId="+
													weiboContents[6]+"'>"+weiboContents[2]+
												"</a>"+
											"</h5>"+
											"<div class='content-text content-text-tmp' id='content-text-tmp'>" +
												"<p>"+
													weiboContents[3]+
												"</p>"+
												weiboContents[4]+"<br>"+
											"</div>"+
											"<div>" +
												"<div  class='innerForwardBottomDiv'>"+"<a><span class='glyphicon glyphicon-star-empty content-span'></span></a>&nbsp;"+"</div>"+
												"<div  class='innerForwardBottomDiv' onclick='forwardWeiboDiv("+weiboContents[7]+",this)'>"+"<a href='javascript:void(0)'><span class='glyphicon glyphicon-share-alt content-span'></span>"+weiboContents[11]+"</a>"+"</div>"+
												"<div  class='innerForwardBottomDiv'>"+"<a onclick='getOneWeibo("+weiboContents[7]+")'><span class='glyphicon glyphicon-comment content-span'></span>&nbsp;"+weiboContents[10]+"</a>"+"</div>"+
												"<div  class='innerForwardBottomDiv'>"+"<a href='javascript:void(0)' class='tmpLikeA' id='tmpLikeA' onclick='likeweibo("+weiboContents[7]+",this)'><span class='glyphicon glyphicon-thumbs-up' style='color:gray;'></span>"+weiboContents[8]+"</a>"+"</div>"+
											"</div>"+
										"</div>";
	 				//拼装
	 				data = data  + suffix;
	 				//追加到id为content-outer的div后面 
	 				$("#content-outer").append(data);
	 				//如果我已经点了赞weiboContents[5]==$("#mynicknameA").attr("href").split("?userId=")[1]
	 				if(weiboContents[9]==1){
	 					$("#tmpLikeA").children("span").css("color","red");
	 					$("#tmpLikeA").attr("onclick","avoidLike("+$("#tmpLikeA").attr("onclick").split("(")[1]);
	 				}
	 				//如果我已经点赞了当前的微博(不是转发的原微博)
	 				if(weibos[2]==1){	 					
	 					$("#tmpLikeFA").children("span").css("color","red");
	 					$("#tmpLikeFA").attr("onclick","avoidLike("+$("#tmpLikeFA").attr("onclick").split("(")[1]);
	 				}
	 				//如果转发的原微博属于当前用户的，则提供删除功能
	 				if(weiboContents[6]==$("#mynicknameA").attr("href").split("?userId=")[1]){
	 					$("#content-text-tmp"+" p").append("<a href='javascript:;' onclick='deleteWeibo("+weiboContents[7]+",this)'>删除</a>");
	 				}
	 				//如果是当前用户的微博，则提供删除功能
	 				if(weibos[0].userId==$("#mynicknameA").attr("href").split("?userId=")[1]){
	 					$("#content-text-tmp").parent().parent().children("p").append("<a href='javascript:;' onclick='deleteWeibo("+weibos[0].weiboId+",this)'>删除</a>");
	 				}
	 				
	 				//加载转发时原微博的图片:类content-text-tmp，id为content-text-tmp+i
	 				var forwardImgs="";
	 				var forwardImgsStr=weiboContents[5];
	 				var forwardImgsArr = forwardImgsStr.split("%%");
	 				for(k=0;k<forwardImgsArr.length;k++){
	 					if(forwardImgsArr[k]==''||forwardImgsArr[k]==null||forwardImgsArr[k].length<=0){
	 						continue;
	 					}
	 					forwardImgs = forwardImgs+"<img class='weiboImage' onclick='showBigImageCanScroll(this)' style='padding:2px;width:100px;height:100px;' src='"+forwardImgsArr[k]+"'/>";
	 				}
	 				$("#content-text-tmp").append("<div>"+forwardImgs+"</div>");
				}//转发结束			 				
			 
			//为了防止后面点击加载更多时候出现干扰，每个页面加载到最后一个的时候，把点赞处的id和class=tmpLikeA全都除移
			 $(".tmpLikeA").removeAttr("id");
			 $(".tmpLikeA").removeClass("tmpLikeA");
			//为了防止后面点击加载更多时候出现干扰，每个页面加载到最后一个的时候，把点赞处的id和class=tmpLikeA全都除移
			 $(".tmpLikeFA").removeAttr("id");
			 $(".tmpLikeFA").removeClass("tmpLikeFA");
			//为了防止后面点击加载更多时候出现干扰，每个页面加载到最后一个的时候，把转发的图片临时设置的id和class=content-text-tmp全都除移
			 $(".content-text-tmp").removeAttr("id");
			 $(".content-text-tmp").removeClass("content-text-tmp");
			 //加载更多
			 if(weibos[0].length<10){
		 			$("#content-outer").append("<div style='text-align:center;'>已加载全部</div>");
			 }else{
		 			$("#content-outer").append("<div style='text-align:center;'><button id='loadmore' onclick='updateWeiboContent("+$(".content").length+")'>点击加载更多</button></div>");
			 }
			 
			 //删除加载中的图片
			 $("#tmpLoading").fadeOut(100,function(){
				$("#tmpLoading").remove();
			 });
			 
			 //css定位
			 var counter1 = setInterval(calTextWidth,100);//强制运行这个函数
		     setTimeout(function(){
		    	clearInterval(counter1);//2s后停止运行
		     },2000);
		     //图片特效
		     imageCss();
	 }
	 
	 function imageCss(){
		 /*******************css样式************************************/					     
		   //头像翻转
		 	$(".content-head img").mouseenter(function(){
		 		$(this).addClass("headRotate");
		 	});
		 	$(".content-head img").mouseleave(function(){
		 		$(this).addClass("headLeaveRotate");
		 		$(this).removeClass("headRotate");
		 		var tmp = $(this);
		 		setTimeout(function(){
		 			tmp.removeClass("headLeaveRotate");
		 		},150);
		 	});
		 	
		 	//相片翻转
		 	$(".weiboImage").mouseenter(function(){
		 		$(this).addClass("headRotate");
		 	});
		 	$(".weiboImage").mouseleave(function(){
		 		$(this).addClass("headLeaveRotate");
		 		$(this).removeClass("headRotate");
		 		var tmp = $(this);
		 		setTimeout(function(){
		 			tmp.removeClass("headLeaveRotate");
		 		},150);
		 	});
		 	/*******************************************************/
	 }
	 /**
	  * 获取一条微博的具体内容
	  * @param weiboId
	  */
	 function getOneWeibo(weiboId){
		 var t = "<a href='/billblog-manager-controller/weibocontroller/tooneweibopage.do?weiboId="+weiboId+"' target='_blank'><span id='tmpWeiboA' >666</span></a>";
		 $("body").append(t);
		 $(document).ready(function(){
			$("#tmpWeiboA").click(); 
			$("#tmpWeiboA").parent().remove();
		 });
	 }