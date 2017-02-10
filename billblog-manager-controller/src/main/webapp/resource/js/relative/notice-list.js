
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
	/**
	 * 判断是否被关注
	 */
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
	
	/**
	 * 关注
	 * @param beNoticedId
	 */
	function notice(beNoticedId,thisA){
		$.ajax({
			url:"/billblog-manager-controller/attentioncontroller/addattention.do",
			type:"post",
			data:{beNoticedId:beNoticedId},
			dataType:"json",
			error:function(){alert("关注失败！");},
			success:function(num){
				alert("关注成功");
				$.ajax({
					url:"/billblog-manager-controller/attentioncontroller/judgeattention.do",
					type:"get",
					data:{beNoticedId:beNoticedId,method:0},
					dataType:"json",
					success:function(num){
						if(num[0]==1){//表示已关注
							$(thisA).attr("onclick","avoidNotice("+beNoticedId+",this)");
							$(thisA).text("已关注");		
							$(thisA).attr("class","btn btn-success");
						}else if(num[0]==3){//表示互相关注
							$(thisA).attr("onclick","avoidNotice("+beNoticedId+",this)");
							$(thisA).text("互相关注");		
							$(thisA).attr("class","btn btn-default");
						}
					}
				});
			}
		});
	}
	
	/**
	 * 取消关注
	 * @param beNoticedId
	 */
	function avoidNotice(beNoticedId,thisA){
		$.ajax({
			url:"/billblog-manager-controller/attentioncontroller/avoidattention.do",
			type:"get",
			data:{beNoticedId:beNoticedId},
			dataType:"json",
			error:function(){alert("取消关注失败！");},
			success:function(num){
				alert("已取消关注");
				$(thisA).text("关注");
				$(thisA).attr("onclick","notice("+beNoticedId+",this)");
				$(thisA).attr("class","btn btn-info");
			}
		});
	}
	currentPage=1;//用于表明当前在第几页
	fansNum = 5;//每页5个
	//刷新页面即可获取
	function getNoticeListData(){
		var userId = $("#hiddenId").val();
		$.ajax({
			url:"/billblog-manager-controller/attentioncontroller/getnoticeuserlist.do",
			type:"get",
			data:{userId:userId,offset:0},
			dataType:"json",
			error:function(){
				alert("获取粉丝或关注的人失败！");
			},
			success:function(list){
				$("#content-outer").html("");//清空
				for(i=0;i<list[0].length;i++){
					//关注关系
					var rel = list[4][i][0];
					var cont;
					if(rel==0){
						cont = "<a href='javascript:void(0)' onclick='notice("+list[0][i].userId+",this)'>关注</a>";
					}else if(rel==1){
						cont = "<a href='javascript:void(0)' onclick='avoidNotice("+list[0][i].userId+",this)'>已关注</a>";
					}else if(rel==3){
						cont = "<a href='javascript:void(0)' onclick='avoidNotice("+list[0][i].userId+",this)'>互相关注</a>";
					}else if(rel==2){
						cont="";
					}
					var d = "<div class='content row'>" +
								"<div class='content-head'>" +
									"<a target='_blank' href='/billblog-manager-controller/weibocontroller/tohomepage.do?userId="+list[0][i].userId+"'>" +
										"<img src='"+list[0][i].userHeadimage+"' style='border-radius:50px;width:50px;height:50px;'>" +
									"</a>" +
								"</div>" +
								"<div class='content-text'>" +
									"<div>" +
										"<span>"+list[0][i].userNickname+"</span>" +
										"<span id='relativeSpan"+i+"' style='float:right;'>"+cont+"</span>" +
									"</div>" +
									"<div>" +
										"<a target='_blank' " +
										"href='/billblog-manager-controller/attentioncontroller/tonoticelistpage.do?userId="+list[0][i].userId+"'>关注</a>"+list[2][i]+
										"&nbsp;" +
										"<a target='_blank' " +
										"href='/billblog-manager-controller/attentioncontroller/tofanslistpage.do?userId="+list[0][i].userId+"'>粉丝</a>"
										+list[1][i]+
										"&nbsp;" +
										"<a target='_blank' href='/billblog-manager-controller/weibocontroller/tohomepage.do?userId="+list[0][i].userId+"'>微博</a>"
										+list[3][i]+
									"</div>" +
									"<div>地址：" +
									list[5][i].userAddress+
									"</div>"+
									"<div>签名：" +
									list[5][i].userSignature+
									"</div>"+
								"</div>" +
							"</div>";
					$("#content-outer").append(d);
				}
			}
		});
	}
	
	/**
	 * 直接点击页数
	 */
	function getNoticeListDataByNum(number){
		var userId = $("#hiddenId").val();
		$.ajax({
			url:"/billblog-manager-controller/attentioncontroller/getnoticeuserlist.do",
			type:"get",
			data:{userId:userId,offset:(number-1)*fansNum},
			dataType:"json",
			error:function(){
				alert("直接点击页面获取粉丝或关注的人失败！");
			},
			success:function(list){
				currentPage=number;//更新当前页数
				$("#content-outer").html("");//清空
				func(list);
				//校准定位
				var c1 = setInterval(calTextWidth,80);
			    setTimeout(function(){
			    	clearInterval(c1);
			    },2000);
			}
		});
	}
	
	/**
	 * 点击“上一页”获取时
	 */
	function getFansListByPre(){
		var userId = $("#hiddenId").val();
		if(currentPage>1){//只有页数大于1的时候，才有“上一页”这个功能
			$.ajax({
				url:"/billblog-manager-controller/attentioncontroller/getnoticeuserlist.do",
				type:"get",
				data:{userId:userId,offset:(currentPage-2)*5},
				dataType:"json",
				error:function(){
					alert("获取粉丝或关注的人失败！");
				},
				success:function(list){
					currentPage--;//当前页数-1
					$("#content-outer").html("");//清空
					func(list);					
				}
			});
		}
	}
	
	/**
	 * 点击“下一页”获取
	 */
	function getNoticeListByAfter(){
		var userId = $("#hiddenId").val();
		$.ajax({
			url:"/billblog-manager-controller/attentioncontroller/getnoticeuserlist.do",
			type:"get",
			data:{userId:userId,offset:(currentPage)*5},
			dataType:"json",
			error:function(){
				alert("没有更多！");
			},
			success:function(list){
				currentPage++;//当前页数+1
				$("#content-outer").html("");//清空
				func(list);
			}
		});
	}	
    
	getNoticeListData();
	isNoticed();
    var c = setInterval(calTextWidth,80);
    setTimeout(function(){
    	clearInterval(c);
    },2000);