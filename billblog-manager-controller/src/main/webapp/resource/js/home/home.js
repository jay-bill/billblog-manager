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