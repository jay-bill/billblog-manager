	 
	//改变头像大小
	function calTextWidth(){
    	//先获取宽度。不包括padding
    	var contentdivwid = parseInt($(".person-id").width());
    	//再获取头像的宽度
    	var contentheadwid = parseInt($(".head-div").width());
    	//设置文字，即content-text的宽度
    	$(".content-div").css("width",contentdivwid-contentheadwid-10);//减去10px的误差
    	//设置content-text的样式
    	$(".content-div").css("padding-left",10);
    	$(".content-div").css("padding-right",10);
    }
	var counter = setInterval(calTextWidth,100);
	setTimeout(function(){
		clearInterval(counter)
	},5000);


	  /**
	  * 点赞
	  */
	  function likeweibo(belikeId,thisA){
		  var beinfoId;
		  if($(thisA).parent().parent().parent().children(".content-head").children("a").length>0){
			  beinfoId = $(thisA).parent().parent().parent().children(".content-head").children("a").attr("href").split("?userId=")[1];
		  }else{
			  beinfoId = $(thisA).parent().parent().parent().children("h5").children("a").attr("href").split("?userId=")[1];
		  }
		  $.ajax({
			 url:"/billblog-manager-controller/likecontroller/makelikeweibo.do",
			 type:"post",
			 data:{belikeId:belikeId,beinfoId:beinfoId},
			 dataType:"json",
			 error:function(){
				 alert("点赞失败，请重试"+" "+thisA.href);
			 },
			 success:function(like){
				alert("点赞成功！"); 
				thisA.innerHTML="已赞";
				thisA.setAttribute("onclick","avoidLike("+belikeId+",this)");
			 }
		  });
	  }
	  
	  /**
	   * 取消点赞
	   * @param belikeId
	   * @param thisA
	   */
	  function avoidLike(belikeId,thisA){
		  var beinfoId;
		  if($(thisA).parent().parent().parent().children(".content-head").children("a").length>0){
			  beinfoId = $(thisA).parent().parent().parent().children(".content-head").children("a").attr("href").split("?userId=")[1];
		  }else{
			  beinfoId = $(thisA).parent().parent().parent().children("h5").children("a").attr("href").split("?userId=")[1];
		  }
		  $.ajax({
			 url:"/billblog-manager-controller/likecontroller/avoidlikeweibo.do",
			 type:"get",
			 data:{belikeId:belikeId,beinfoId:beinfoId},
			 dataType:"json",
			 error:function(){
				 alert("取消点赞失败，请重试"+" "+thisA.href);
			 },
			 success:function(like){
				alert("取消点赞成功！"); 
				thisA.innerHTML="点赞";
				thisA.setAttribute("onclick","likeweibo("+belikeId+",this)");
			 }
		  });
	  }