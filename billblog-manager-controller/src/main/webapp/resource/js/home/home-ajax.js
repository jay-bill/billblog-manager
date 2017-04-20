
		offset=0;//分页，从0开始
		pageSum=10;//每页20条记录
	    /*************************登录弹出层***********************************************/
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
	    /****************************************************************************/
	    
	    //关注
		function notice(beNoticedId,thisA){
			$.ajax({
				url:"/billblog-manager-controller/attentioncontroller/addattention.do",
				type:"post",
				data:{beNoticedId:beNoticedId},
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
												"<li><label style='color:black;'>账号：<input type='text' name='userAccount' required class='ipt'/></label></li>"+
												"<li><label style='color:black;'>密码：<input type='text' name='userPassword' required class='ipt'/></label></li>"+
												"<li><a href='/billblog-manager-controller/regist.jsp'>还没账号？立即注册！</a></li>"+
												"<li><input type='submit' value='确认提交' class='submitBtn' /></li>"+
											"</ul>"+
										"</form>"+
									"</div>";
					$("body").append(dataDiv);
					getSrceenWH();		
					openLoginDiv(thisA);
				},
				success:function(num){
					alert("关注成功");
					$("#noticeAId").css("display","none");
					isNoticed();
				}
			});
		}
		
		//取消关注
		function avoidNotice(beNoticedId){
			$.ajax({
				url:"/billblog-manager-controller/attentioncontroller/avoidattention.do",
				type:"get",
				data:{beNoticedId:beNoticedId},
				dataType:"json",
				error:function(){alert("取消关注失败！");},
				success:function(num){
					alert("已取消关注");
					$("#fansNum").text(parseInt($("#fansNum").text())-1);
					$("#noticeAId").css("display","inline-block");
					$("#avoidNoticeAId").css("display","none");
					$("#avoidNoticeAIdEach").css("display","none");
				}
			});
		} 
		
	    
		//显示用户数据   
	    function getUrlRequest() {
            var url = location.search; //获取url中"?"符后的字串
            var arr = new Array();
            arr = url.split("=");
            return arr[1];//返回用户id
        }
	 	//获取微博的ajax	   
	 	function updateWeiboContent(offset){
	 		//先删除“点击加载更多”的按钮
	 		if($("#loadmore").length>0){
 				$("#loadmore").remove();//先删除
 			 }
 			//添加“正在加载的功能”
	 		var imgLoad="<div id='tmpLoading' style='text-align:center;'><img src='/billblog-manager-controller/resource/image/loading.gif' style='width:50px;border-radius:50px;'/></div>";
	 		$("#content-outer").append(imgLoad);
	 		var userId = getUrlRequest();
 			$.ajax({
		 		url:"/billblog-manager-controller/weibocontroller/getoneuserweibo.do",
		 		type:"get",
		 		data:{userId:userId,offset:offset},
		 		dataType:"json",
		 		error:function(){alert("出错了");},
		 		success:function(weibos){	
		 			//使用获取的微博，装配到页面去
		 			useWeiboDataToPage(weibos);
		 		}
		 	});
	 	}    	    
	    
	    //搜索页面加载好后，先判断是否被关注
		function isNoticed(){
			var beNoticedId = $("#nicknameA").attr("href").split("?userId=")[1];
			$.ajax({
				url:"/billblog-manager-controller/attentioncontroller/judgeattention.do",
				type:"get",
				data:{beNoticedId:beNoticedId,method:0},
				dataType:"json",
				error:function(){
					
				},
				success:function(num){
					if(num[0]==0){
						$("#noticeAId").css("display","inline-block");
					}else if(num[0]==1){//表示已关注
						$("#avoidNoticeAId").css("display","inline-block");
					}else if(num[0]==3){//表示互相关注
						$("#avoidNoticeAIdEach").css("display","inline-block");
					}
				}
			});
		}
	 	updateWeiboContent(0);	//获取数据
	 	isNoticed();//判断是否关注;
	    var c = setInterval(calTextWidth,80);//强制运行这个函数
	    setTimeout(function(){
	    	clearInterval(c);
	    },2000);