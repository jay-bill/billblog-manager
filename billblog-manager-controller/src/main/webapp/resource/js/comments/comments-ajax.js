		
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
												"<li><label>密码：<input type='text' name='userPassword' required class='ipt'/></label></li>"+
												"<li><a href='/billblog-manager-controller/regist.jsp'>还没账号？立即注册！</a></li>"+
												"<li><input type='submit' value='确认提交' class='submitBtn' /></li>"+
											"</ul>"+
										"</form>"+
									"</div>";
					$("body").append(dataDiv);
					getSrceenWH();		
					openLoginDiv(thisA);
				},
				success:function(list){		
					var href = $("#myHeadimage").attr("src");
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
											"<span style='float:right;'>" +
											new Date(list[0][i].commentDatetime).toLocaleString()+
											"</span>"+
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
										"<span style='float:right;'>" +										
										new Date(list[0][i].commentDatetime).toLocaleString()+
										"</span>"+
										"<a href='javascript:void(0)' onclick='deleteComment("+list[0][i].commentId+",this)' style='float:right;'>删除</a>"+
										"<p style='margin-bottom:10px;color:#808080;'>" +
											list[0][i].commentContent+
										"</p>" +
									"</div>"+
								"</div>";
						}
		 				$(thisA).parent().parent().parent().append(data);
					}
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
			var commentSum = parseInt($(thisA).text().substring(2));
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