/**
 * 查询用户页面的js
 */
	//改变头像大小
	function calTextWidth(){
    	//先获取宽度。不包括padding
    	var contentdivwid = parseInt($(".person-id").width());
    	//再获取头像的宽度
    	var contentheadwid = parseInt($("#head-div").width());
    	//设置文字，即content-text的宽度
    	$("#content-div").css("width",contentdivwid-contentheadwid-10);//减去10px的误差
    	//设置content-text的样式
    	$("#content-div").css("padding-left",10);
    	$("#content-div").css("padding-right",10);
    }
	var counter = setInterval(calTextWidth,100);
	setTimeout(function(){
		clearInterval(counter)
	},5000);
	
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
					$("#noticeAId").css("display","inline-block");//关注
				}else
				if(num[0]==1){
					$("#avoidNoticeAId").css("display","inline-block");//已关注
				}else
				if(num[0]==3){
					$("#avoidNoticeAIdEach").css("display","inline-block");//互相关注
				}
			}
		});
	}isNoticed();
	
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
	 /**
	  * 关闭搜索栏
	  */
	 function closeSearchDiv(){
		 $("#searchFormSm").fadeOut(500,function(){
			$("#searchFormSm").remove(); 
		 });
	 }
	 /**
	  * 显示搜索栏
	  */
	 function showSearchDiv(){
		 var data = "<form id='searchFormSm' action='/billblog-manager-controller/searchcontroller/searchUser.do'>" +
		 				"<div>" +
		 					"<span onclick='closeSearchDiv()'>关闭</span>"+
		 				"</div>"+
		 				"<input name='userNickname' style='width:100%;margin:10px 0px;'>"+
		 				"<input type='submit' value='搜索' class='btn btn-warning btn-sm'/>"+
		 			"</form>";
		 $("#content-outer").append(data);
		 //css
		 $("#searchFormSm").css({
			"position":"fixed",
			"top":"100px",
			"width":$(".content").width()+40,
			"background":"gray",
			"padding":"10px"
		 });
	 }
	 
	 //弹出选择图片的文件
	 function openFile(thisS){
		 $(thisS).parent().children("input[type='file']").click();
	 }
	 //删除微博框
	 function closeWriteWeiboDiv(){
		 $("#writeWeiboDiv").fadeOut(500,function(){
			 $("#writeWeiboDiv").remove();//删除 
		 });
	 }
	 //弹出写微博框
	 function showWriteWeiboDiv(){
		 var div = 	"<form id='writeWeiboDiv' method='post' action='/billblog-manager-controller/weibocontroller/broadcastweibo.do' enctype='multipart/form-data'>" +
		 				"<div>" +
		 					"<span onclick='closeWriteWeiboDiv()'>关闭</span>"+
		 				"</div>"+
		 				"<textarea name='weiboContent'></textarea>"+
		 				"<div>" +
		 					"<span onclick='openFile(this)'>图片</span>"+
		 					"<span style='visibility:hidden;'>空</span>"+
		 					"<span>表情</span>"+
		 					"<input type='file' name='weiboImages' style='display:none;'/>"+
		 					"<input type='submit' value='发表' class='btn btn-warning btn-sm'>"
		 				"</div>"+
		 			"</form>";
		 $("#content-outer").append(div);
		 //设置css属性
		 $("#writeWeiboDiv").css({
			"position":"fixed",
			"top":"100px",
			"width":$(".content").width()+40,
			"background":"gray",
			"padding":"10px"
		 });
		 $("#writeWeiboDiv>:first-child").css({
			 "padding":"0px 0px 10px 0px",
			 "text-align":"right",
		});
		 $("#writeWeiboDiv>:nth-child(2)").css({
			 "resize":"none",
			 "width":"100%",
			 "height":"80px"
		});
		 $("#writeWeiboDiv>:last-child input").css({
			 "float":"right",
		});
		 $("#writeWeiboDiv>:last-child span").css({
			 "float":"left",
		});
	 }