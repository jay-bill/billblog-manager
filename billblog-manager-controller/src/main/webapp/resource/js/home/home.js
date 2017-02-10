/**
 * home页面的js
 */

	function changeImgSize(){
		var big_img_div = $("#left-div>:nth-child(3)>:nth-child(2)>:first-child").width();
		$("#left-div>:nth-child(3)>:nth-child(2)>:first-child img").css("width",big_img_div);
		$("#left-div>:nth-child(3)>:nth-child(2)>:first-child img").css("height",big_img_div);
		var small_img_div = $("#left-div>:nth-child(3)>:nth-child(2)>:nth-child(2)").width();
		$("#left-div>:nth-child(3)>:nth-child(2)>:nth-child(2) img").css("width",small_img_div);
		$("#left-div>:nth-child(3)>:nth-child(2)>:nth-child(2) img").css("height",small_img_div);
		var smalbottom_img_div = $("#left-div>:nth-child(3)>:nth-child(2)").width();
		$("#left-div>:nth-child(3)>:nth-child(2)>:nth-child(3) img").css("width",(smalbottom_img_div/3)-1);
		$("#left-div>:nth-child(3)>:nth-child(2)>:nth-child(3) img").css("height",(smalbottom_img_div/3)-1);
	}
	
	changeImgSize();
	
	//滚动条事件，对左边的信息div重新定位
	$(window).scroll(function(){
		var scrTop = $(window).scrollTop();
		if(parseInt(scrTop)>1025){
			$("#left-div>:nth-child(2)").css("position","relative");
			$("#left-div>:nth-child(2)").css("top",parseInt(scrTop)-430);
		}else{
			$("#left-div>:nth-child(2)").css("position","static");
		}
	});
	  
	/**
	 * 鼠标移入头像时
	 */
	$("#myHeadimage").mouseenter(function(){
		$("#myHeadimage").css({
			"border":"2px solid yellow",
			"box-shadow":"0px 0px 50px yellow"
		});
	});
	/**
	 * 鼠标移出头像时
	 */
	$("#myHeadimage").mouseout(function(){
		$("#myHeadimage").css({
			"border":"0px",
			"box-shadow":"0px 0px 0px #444"
		});
	});
	/**
	 * 点击鼠标时
	 */
	$("#myHeadimage").click(function(){
		$("#myHeadimage").parent().children("input").click();
	});
	/**
	 * 选择图片时
	 */    
	$("#myHeadimage").parent().children("input").change(function(){
		alert();
		$("#myHeadimage").parent().submit();
	});

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
		 if($(".content").length>0){
			 //css
			 $("#searchFormSm").css({
				"position":"fixed",
				"top":"100px",
				"width":$(".content").width()+40,
				"background":"gray",
				"padding":"10px"
			 });
		}else{
			 //css
			 $("#searchFormSm").css({
				"position":"fixed",
				"top":"100px",
				"width":$(window).width()-40,
				"background":"gray",
				"padding":"10px"
			 });
		}
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
		if($(".content").length>0){
			 //设置css属性
			 $("#writeWeiboDiv").css({
				"position":"fixed",
				"top":"100px",
				"width":$(".content").width()+40,
				"background":"gray",
				"padding":"10px"
			 });
		}else{
			 //设置css属性
			 $("#writeWeiboDiv").css({
				"position":"fixed",
				"top":"100px",
				"width":$(window).width()-40,
				"background":"gray",
				"padding":"10px"
			 });
		}
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
	    
	    