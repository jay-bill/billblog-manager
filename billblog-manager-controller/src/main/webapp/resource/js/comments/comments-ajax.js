		
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
	    	
	    var w,h;
		function getSrceenWH(){
			w = $(window).width();
			h = $(window).height();
			$('#dialogBg').width(w).height(h);
		}
		
		window.onresize = function(){  
			getSrceenWH();
		}  
		$(window).resize();  
		
	    function closeLoginDiv(thisA){
	    	openLoginDiv(thisA);
	    	//关闭弹窗
			$('#dialogBg').fadeOut(300,function(){
				$('#dialog').addClass('bounceOutUp').fadeOut();
			});
	    }
	    function openLoginDiv(thisA){
	    	var className = $(thisA).attr('class');
			$('#dialogBg').fadeIn(300);
			$('#dialog').removeAttr('class').addClass('animated '+className+'').fadeIn();
	    }
	    /**
	     * 获取评论
	     */
	   function getCommentsFunction(becommentId,thisA,offset){
		    //显示“加载中”的图片
		    $(thisA).parent().parent().parent().append("<div id='tmpLoading' style='text-align:center;'><img src='/billblog-manager-controller/resource/image/loading.gif' style='width:30px;height:30px;border-radius:30px;'/></div>")
			$.ajax({
				url:"/billblog-manager-controller/commentcontroller/showcomment.do",
				type:"get",
				data:{becommentId:becommentId,offset:offset},
				dataType:"json",
				error:function(){
					var dataDiv =  "<div id='dialogBg'></div>" +
									"<div id='dialog' class='animated'>"+
									"<img class='dialogIco' width='50' height='50' src='/billblog-manager-controller/resource/plug-res/images/ico.png'/>"+
										"<div class='dialogTop'>"+
											"<a href='javascript:;' class='claseDialogBtn' onclick='closeLoginDiv(this)'>关闭</a>"+
										"</div>"+
										"<form action='/billblog-manager-controller/logincontroller/login' method='post' id='editForm'>"+
											"<ul class='editInfos'>"+
												"<li><label>账号：<input type='text' name='userAccount' required class='ipt'/></label></li>"+
												"<li><label>密码：<input type='password' name='userPassword' required class='ipt'/></label></li>"+
												"<li><a href='/billblog-manager-controller/regist.jsp'>还没账号？立即注册！</a></li>"+
												"<li><input type='submit' value='确认提交' class='submitBtn' /></li>"+
											"</ul>"+
										"</form>"+
									"</div>";
					$("body").append(dataDiv);
					getSrceenWH();		
					$("#tmpLoading").remove();//除移“加载中的图片”
					openLoginDiv(thisA);
				},
				success:function(list){						
					var href = $("#hidden-user-headimg").val();
					var beinfoId = $(thisA).parent().parent().parent().children(".content-head").children("a").attr("href").split("?userId=")[1];
					var inputText = "<form class='row inputTextDiv inputText'>"+
										"<div class='content-head'>" +
											"<img src='"+href+"' style='border-radius:0px;width:30px;height:30px;float:right;'>" +
										"</div>"+
										"<div class='content-text'>"+
											"<input name='commentContent' style='width:100%;'>"+
											"<input type='hidden' value='"+becommentId+"' name='becommentId'>"+
											"<input type='hidden' value='"+beinfoId+"' name='beinfoId'>"+
										"</div>"+
									"</form>"+
									"<div class='row inputTextDiv'>" +
										"<div class='content-head' style='height:1px;visibility:hidden;'>" +
										"</div>"+
										"<div class='content-text'>"+
											"<a class='float:left;'>表情</a>"+
											"<button onclick='submitComment(this)' class='btn btn-warning btn-xs' style='float:right;'>评论</button>"+
										"</div>"+
									"</div>";
					if($(thisA).parent().parent().parent().children(".inputTextDiv").length<=0)
						$(thisA).parent().parent().parent().append(inputText);
					//Comments
					for(i=0;i<list[1].length;i++){	
						 if(list[2][i]==0){
							 list[2][i]='';
						 }
		 				 var data = "<div class='row inputTextDiv'>" +
		 				 				"<div class='content-head'>" +
		 				 					"<a href='tohomepage.do?userId="+list[1][i].userId+"'>" +
		 				 						"<img style='border-radius:0px;width:30px;height:30px;float:right;' src='"+list[1][i].userHeadimage+"'>" +
			 								"</a>" +
		 								"</div>" +
		 								"<div class='content-text' id='tempId'>" +
											"<a href='tohomepage.do?userId="+list[1][i].userId+
		 										"'>"
		 										+list[1][i].userNickname+
											"</a>" +
											"<span style='float:right;font-size:10px;'>" +
											new Date(list[0][i].commentDatetime).toLocaleString()+
											"</span>"+
											"<a href='javascript:;' onclick='showReplyDiv("+becommentId+","+list[0][i].commentId+",this)' style='float:right;font-size:10px;'>回复"+list[2][i]+"</a>"+
											"<p style='margin-bottom:10px;color:#808080;'>" +
												list[0][i].commentContent+
											"</p>" +
										"</div>"+
									"</div>";
		 				 //是否显示删除评论
		 				if(($("#mynicknameA").attr("href").split("?userId=")[1]==list[1][i].userId)
	 					|| ($("#mynicknameA").attr("href").split("?userId=")[1]==$(thisA).parent().parent().parent().children(".content-head").
	 					children("a").attr("href").split("?userId=")[1])
		 				){
							data = "<div class='row inputTextDiv'>" +
						 				"<div class='content-head'>" +
						 					"<a href='tohomepage.do?userId="+list[1][i].userId+"'>" +
						 						"<img style='border-radius:0px;width:30px;height:30px;float:right;' src='"+list[1][i].userHeadimage+"'>" +
						 					 "</a>" +
										"</div>" +
										"<div class='content-text' id='tempId'>" +
										"<a href='tohomepage.do?userId="+list[1][i].userId+
												"'>"
												+list[1][i].userNickname+
										"</a>" +					
										"<span style='float:right;font-size:10px;'>" +										
										new Date(list[0][i].commentDatetime).toLocaleString()+
										"</span>"+
										"<a href='javascript:void(0)' onclick='deleteComment("+list[0][i].commentId+",this)' style='float:right;font-size:10px;'>删除</a>"+
										"<a href='javascript:;' onclick='showReplyDiv("+becommentId+","+list[0][i].commentId+",this)' style='float:right;font-size:10px;margin-right:10px;'>回复"+list[2][i]+"</a>"+
										"<p style='margin-bottom:10px;color:#808080;'>" +
											list[0][i].commentContent+
										"</p>" +
									"</div>"+
								"</div>";
						}
		 				$(thisA).parent().parent().parent().append(data);
					}
	 				$("#tmpLoading").remove();//除移“加载中的图片”
					//校准
					var c = setInterval(calTextWidth,10);
					setTimeout(function(){
						clearInterval(c);
					},2000);
				}
			});
	   }
		/**
		 * 评论:显示输入栏，显示评论其他的内容
		 */
		function getComments(becommentId,thisA,offset){
			//判断是否已经显示了评论栏
			if($(thisA).parent().parent().parent().children(".pageNum").length>0||$(thisA).parent().parent().parent().children(".inputTextDiv").length>0){
				$(thisA).parent().parent().parent().children(".inputTextDiv").remove();//删除
				$(thisA).parent().parent().parent().children(".pageNum").remove();//删除
				return;
			}
			//评论总数
			var commentSum = parseInt($(thisA).text());
			//如果评论总数大于10
			if(commentSum>10){
				var page = "<div class='row pageNum' style='text-align:center;background:gainsboro;'>" +
							  "<div>"+
			      				"<a>上一页</a>&nbsp;";
				for(i=0;i<commentSum/10;i++){
					var pageNum = i+1;
					page = page +"<a href='javascript:void(0)' onclick='getCommentsByNum("+becommentId+",this,"+(pageNum-1)*10+")'>"+pageNum+"</a>&nbsp;";
				}
				page = page + "<a>下一页</a>&nbsp;" +
							  "</div>"+
						  "</div>";
				$(thisA).parent().parent().parent().append(page);
			}
			if(offset<0)
				return;
			//获取评论
			getCommentsFunction(becommentId,thisA,offset);
		}		
		/**
		 * 评论，根据选择分页数显示评论
		 */
		function getCommentsByNum(becommentId,thisA,offset){
			if($(thisA).parent().parent().parent().children(".inputTextDiv").length>0){
				$(thisA).parent().parent().parent().children(".inputTextDiv").remove();//删除
			}
			if(offset<0)
				return;
			//获取评论
			getCommentsFunction(becommentId,thisA,offset);
		}
		/**
		 * 发表评论
		 */
		function submitComment(thisBtn){
			$.ajax({
				url:"/billblog-manager-controller/commentcontroller/submitcomment.do",
				type:"post",
				data:$(thisBtn).parent().parent().parent().children("form").serialize(),
				dataType:"json",
				error:function(){
					alert("评论出错了！请稍后重试哦");
				},
				success:function(){
				 var href = $("#myHeadimage").attr("src");
				 var userId = $("#hiddenId").val();
				 var data = "<div class='row inputTextDiv'>" +
				 				"<div class='content-head'>" +
				 					"<a href='tohomepage.do?userId="+userId+"'>" +
				 						"<img style='border-radius:0px;width:30px;float:right;' src='"+href+"'>" +
									"</a>" +
								"</div>" +
								"<div class='content-text' id='tempId'>" +
									"<a href='tohomepage.do?userId="+userId+
										"'>"
										+$("#nicknameA").text()+
									"</a>" +
									"<p style='margin-bottom:10px;color:#808080;'>" +
										$(thisBtn).parent().parent().parent().children("form").find("input[name='commentContent']").val()+
									"</p>" +
								"</div>"+
							"</div>";
				 $(thisBtn).parent().parent().parent().children("form").find("input[name='commentContent']").val("");
				 $(thisBtn).parent().parent().after(data);
				//校准
				var c = setInterval(calTextWidth,10);
				setTimeout(function(){
					clearInterval(c);
				},2000);
				}
			});
		}
		
		/**
		 * 删除评论
		 */
		function deleteComment(commentId,thisA){
			$.ajax({
				url:"/billblog-manager-controller/commentcontroller/deletecomment.do",
				type:"post",
				data:{commentId:commentId},
				dataType:"json",
				error:function(){
					alert("删除失败！请稍后重试");
				},
				success:function(res){
					alert("删除成功！");
					$(thisA).parent().parent().fadeOut(1000,function(){
						$(thisA).parent().parent().remove();
					});
				}
			});
		}
		
		/**
		 * 弹出显示回复的div
		 */
		function showReplyDiv(becommentId,commentId,thisA){			
			var firstDiv = "<div id='replyFirstDiv'></div>";
			$("body").append(firstDiv);
			$("#replyFirstDiv").css({
				"position":"fixed",
				"background":"black",
				"left":0,
				"top":0,
				"width":$(window).width(),
				"height":$(window).height(),
				"filter":"alpha(opacity=80)",
				"-moz-opacity":"0.8",
				"-khtml-opacity":"0.8",
				"opacity":"0.8",
				"z-index":999
			});
			var bereplyId = $(thisA).parent().find("a").first().attr("href").split("?userId=")[1];
			var secondDiv = "<div id='replySecondDiv'>" +
								"<div style='text-align:right;padding:5px 10px 5px 0px;'>" +
									"<a href='javascript:;' onclick='closeReplyDiv()'>关闭</a>" +
								"</div>"+
								"<div>"+
									"<form>" +
										"<textarea name='replyContent' style='resize:none;height:50px;width:100%;border-top:1px solid gray;border-bottom:1px solid gray;'></textarea>"+
										"<input type='hidden' name='weiboId' value='"+becommentId+"'/>"+
										"<input type='hidden' name='commentId' value='"+commentId+"'/>"+
										"<input type='hidden' name='bereplyId' value='"+bereplyId+"'/>"+
									"</form>"+
									"<button class='btn btn-info btn-sm' onclick='submitReply()'>回复</button>"+
								"</div>"+
								"<div style='margin-top:10px;border-top:1px solid gray'>" +
									
								"</div>"+
							"</div>";
			$("body").append(secondDiv);
			$("#replySecondDiv").css({
				"background":"white",
				"position":"fixed",
				"z-index":1000,
				"height":$("#replyFirstDiv").height()*0.9,
				"top":$("#replyFirstDiv").height()*0.1/2,
				"border-radius":"10px",
				"overflow":"auto"
			});
			if($(window).width()<500){
				$("#replySecondDiv").css({
					"width":$("#replyFirstDiv").width()*0.9,
					"left":$("#replyFirstDiv").width()*0.1/2,
				});
			}else{
				$("#replySecondDiv").css({
					"width":$("#replyFirstDiv").width()*0.5,
					"left":$("#replyFirstDiv").width()*0.5/2,
				});
			}
			$("#replySecondDiv textarea").attr("placeholder","回复"+$(thisA).parent().find("a").first().text());
			
			//加载中图片
			$("#replySecondDiv>:last-child").append("<div id='tmpLoading' style='text-align:center;'><img src='/billblog-manager-controller/resource/image/loading.gif' style='width:30px;height:30px;border-radius:30px;'/></div>");
			//获取回复
			$.ajax({
				url:"/billblog-manager-controller/commentcontroller/getreply.do",
				type:"post",
				data:{weiboId:becommentId,commentId:commentId},
				dataType:"json",
				error:function(){
					//如果不加上dataType:"json",服务器返回也null不会进入ajax的error
					$("#replySecondDiv>:last-child").append("<div id='firstTmp' style='text-align:center;'>来成为第一个回复吧:></div>");				
					//除移加载中
					$("#tmpLoading").remove();
				},
				success:function(list){
					//list[0]回复内容；list[1]用户
					for(i=0;i<list[0].length;i++){
						var reply = "<div class='reply'>" +
						 				"<div class='reply-head'>" +
						 					"<a href='/billblog-manager-controller/weibocontroller/tohomepage.do?userId="+list[1][i].replyUserid+"'>" +
						 						"<img style='border-radius:0px;width:30px;float:right;' src='"+list[1][i].userHeadimage+"'>" +
											"</a>" +
										"</div>" +
										"<div class='reply-text'>" +
											"<a href='/billblog-manager-controller/weibocontroller/tohomepage.do?userId="+list[0][i].replyUserid+
												"'>"
												+list[1][i].userNickname+
											"</a>" +"回复"+
											"<a href='/billblog-manager-controller/weibocontroller/tohomepage.do?userId="+list[0][i].bereplyId+"'>" +
												list[2][i].userNickname+
											"</a>"+
											"<span style='float:right;font-size:10px;'>"+new Date(list[0][i].replyTime).toLocaleString()+"</span>"+
											"<a style='float:right;font-size:10px;margin-right:8px;' href='javascript:;' onclick='changeReplyUser(this)'>回复</a>"+
											"<p style='margin-bottom:10px;color:#808080;'>" +
												list[0][i].replyContent+
											"</p>" +
										"</div>"+
										"<div style='clear:both'></div>"+
									"</div>";
						$("#replySecondDiv>:last-child").append(reply);
						//如果这条微博属于当前用户，享有全部删除权力
						if(list[3][i]==$("#mynicknameA").attr("href").split("?userId=")[1]){
							//添加“删除”按钮
							$(".reply-text:last").find("span").first().after("<a style='float:right;font-size:10px;' href='javascript:;' onclick='deleteReply("+list[0][i].replyId+",this)'>删除</a>");
						}else if(list[0][i].replyUserid==$("#mynicknameA").attr("href").split("?userId=")[1]){
							$(".reply-text:last").find("span").first().after("<a style='float:right;font-size:10px;' href='javascript:;' onclick='deleteReply("+list[0][i].replyId+",this)'>删除</a>");
						}
						
						//css渲染
						$(".reply").css({
							"border-bottom":"1px solid #f7f7f7",
							"padding-left":10,
							"margin":"10px 0px 0px 0px"
						});
						$(".reply-head").css({
							"float":"left",						
						});
						$(".reply-head img").css({
							"width":"30px",
							"height":"30px",
							"border-radius":"30px",
						});
						$(".reply-text").css({
							"float":"left",
							"width":$("#replySecondDiv").width()-70,
							"padding-left":10
						});
					}
					//除移加载中
					$("#tmpLoading").remove();
				}				
			});
		}
		/**
		 * 关闭回复框
		 */
		function closeReplyDiv(){
			$("#replyFirstDiv").remove();
			$("#replySecondDiv").remove();
		}
		/**
		 * 提交回复
		 */
		function submitReply(){
			if($("#replySecondDiv form textarea").val().length<=0){
				alert("亲，请输入回复内容喔:>");
				return;
			}
			$.ajax({
				url:"/billblog-manager-controller/commentcontroller/submitreply.do",
				type:"post",
				data:$("#replySecondDiv form").serialize(),
				error:function(){
					
				},
				success:function(result){
					var href = $("#hidden-user-headimg").val();
					//先清空文本框的文字
					$("#replySecondDiv form textarea").val("");
					var reply = "<div class='reply'>" +
					 				"<div class='reply-head'>" +
					 					"<a href='/billblog-manager-controller/weibocontroller/tohomepage.do?userId="+result[0].replyUserid+"'>" +
					 						"<img style='border-radius:0px;width:30px;float:right;' src='"+href+"'>" +
										"</a>" +
									"</div>" +
									"<div class='reply-text'>" +
										"<a href='/billblog-manager-controller/weibocontroller/tohomepage.do?userId="+result[0].replyUserid+
											"'>"
											+$("#nicknameA").text()+
										"</a>" +"回复"+
										"<a href='/billblog-manager-controller/weibocontroller/tohomepage.do?userId="+result[1].userId+"'>" +
									    	result[1].userNickname+
										"</a>"+
										"<span style='float:right;font-size:10px;'>"+new Date(result[0].replyTime).toLocaleString()+"</span>"+
										"<a style='float:right;font-size:10px;' href='javascript:;' onclick='deleteReply("+result[0].replyId+",this)'>删除</a>"+
										"<a style='float:right;font-size:10px;margin-right:8px;' href='javascript:;'>回复</a>"+
										"<p style='margin-bottom:10px;color:#808080;'>" +
											result[0].replyContent+
										"</p>" +
									"</div>"+
									"<div style='clear:both'></div>"+
								"</div>";
					$("#firstTmp").remove();
					$("#replySecondDiv>:last-child").append(reply);
					//css渲染
					$(".reply").css({
						"border-bottom":"1px solid #f7f7f7",
						"padding-left":10
					});
					$(".reply-head").css({
						"float":"left",						
					});
					$(".reply-head img").css({
						"width":"30px",
						"height":"30px",
						"border-radius":"30px",
					});
					$(".reply-text").css({
						"float":"left",
						"width":$("#replySecondDiv").width()-70,
						"padding-left":10
					});
				}
			});
		}
		
		/**
		 * 在回复的div里面，点击回复改变回复的对象
		 * @param thisA
		 */
		function changeReplyUser(thisA){
			var bereplyId = $(thisA).parent().find("a").first().attr("href").split("?userId=")[1];
			var nickname = $(thisA).parent().find("a").first().text();
			$("#replySecondDiv textarea").attr("placeholder","回复"+nickname);
			$("#replySecondDiv form input[name='bereplyId']").val(bereplyId);
			if($("#tmpReplyAvoidA").length<=0){
				$("#replySecondDiv>:nth-child(2)").prepend("<a id='tmpReplyAvoidA' href='javascript:;' onclick='avoidReply()' style='color:white;'>取消</a>")
			}
			$("#replySecondDiv>:nth-child(2)").css({
				"position":"relative",
				"top":$("#replySecondDiv").scrollTop(),
				"background":"gray",
				"border-radius":"6px",
			});
		}
		
		//取消回复
		function avoidReply(){
			$("#tmpReplyAvoidA").remove();
			$("#replySecondDiv>:nth-child(2)").css({
				"position":"static",
				"background":"white",
			});
		}
		
		//删除回复
		function deleteReply(id,thisA){
			$.ajax({
				url:"/billblog-manager-controller/commentcontroller/deletereply.do",
				type:"post",
				data:{replyId:id},
				dataType:"json",
				error:function(){
					alert("亲，删除失败了喔！请稍后再重试");
				},
				success:function(){
					alert("亲，删除成功了哟！");
					$(thisA).parent().parent().fadeOut(500,function(){
						$(thisA).parent().parent().remove();
					});
				}
			});
		}