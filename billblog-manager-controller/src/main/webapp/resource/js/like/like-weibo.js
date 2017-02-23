	 
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

	/****************************弹出登录层****************************************/
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
	  /*****************************************************************************/
	  
	    
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
				/**
				 * 对弹出层的操作
				 */
				$("body").append(dataDiv);
				getSrceenWH();		
				openLoginDiv(thisA);
			 },
			 success:function(like){
				alert("点赞成功！"); 
				$(thisA).children().css("color","red");
				if($(thisA).next().text()==''){
					$(thisA).next().text(1);
				}else{
					$(thisA).next().text(parseInt($(thisA).next().text())+1);
				}
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
				$(thisA).children().css("color","gray");
				if(parseInt($(thisA).next().text())==1){
					$(thisA).next().text('');
				}else{
					$(thisA).next().text(parseInt($(thisA).next().text())-1);
				}
				thisA.setAttribute("onclick","likeweibo("+belikeId+",this)");
			 }
		  });
	  }