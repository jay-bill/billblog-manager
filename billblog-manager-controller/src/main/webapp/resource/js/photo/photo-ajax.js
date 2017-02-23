
	/**
	 * 填充图片,每次获取前5组图片。根据时间是否相同来分组
	 */
	function getImages(offset,imgsSum,thisA){
		offset = offset*5;
		$.ajax({
			url:"/billblog-manager-controller/imagecontroller/getdefaultimagesgroupbytime.do",
			type:"get",
			data:{userId:$("#nicknameA").attr("href").split("?userId=")[1],offset:offset,offsetImage:imgsSum},
			dataType:"json",
			error:function(){
				alert("获取相片失败！");
			},
			success:function(list){
				$("#photo-main-div>:first-child").html("");
				$(".pageA").css("color","blue");
				$(".pageA").removeAttr("id");
				//标记当前处于第几页：红色、有id。
				if(thisA!=null){
					$(thisA).css({
						"color":"red"
					});
					$(thisA).attr("id","currentPageA");
				}else{
					$(".pageA").eq(0).css("color","red");
					$(".pageA").eq(0).attr("id","currentPageA");
				}
				for(i=0;i<list.length;i++){
					var data ="<div class='container-fluid photo-list-div'>" +
								 "<p>"+new Date(list[i][0].imageDatetime).toLocaleString()+"&nbsp;&nbsp;&nbsp;来自《"+
								 	"<a href='#'>"+list[i][0].imageAlbum+"</a>》"+
								 "</p>" +
							  "<div>" ;
					var suffix=  "</div>" +
				    			"</div>";
					for(j=0;j<list[i].length;j++){						
						data = data+
						"<img class='photoImage'value='"+list[i][j].imageId+"' onclick='showBigImageCanScroll(this)' src='"+list[i][j].imagePath+"'>"
						+"<a href='javascript:void(0)' onclick='deleteImage("+list[i][j].imageId+",this)' style='display:none;'>删除</a>";
					}
					$("#photo-main-div>:first-child").append(data+suffix);
				}
				/***********css样式****************/
				$(".photoImage").hover(				   				    	
						function(){
						  if($("#nicknameA").attr("href").split("?userId=")[1]==$("#mynicknameA").attr("href").split("?userId=")[1]){
							  $(this).next().css({
						 			"display":"inline",
						 			"position":"relative",
						 			"top":-$(this).height()/2+10,
						 			"left":"-40px"
			 					});
						  }						
						}
					);	
			}	
		});
	}
	function nextPage(){		
		$("#currentPageA").next().click();
	}
	function prePage(){		
		$("#currentPageA").prev().click();
	}
	/**
	 * /默认获取前5组
	 */
	getImages(0,0,null);//默认获取前5组
	
	
	/**
     * 手机显示的大图片
     */
    function showPhoneBigImage(oriImg){
    		 
		 //先判断原图的宽/高关系
		 var rat = oriImg.width/oriImg.height;
		 var top;
		 var height;
		 var width;
		 var left;
		 
		 if(rat>=1){//如果宽大于等于高
			//如果宽大于屏幕宽
			 if(oriImg.width>parseInt($(window).width())){
				 width=parseInt($(window).width());//令大图宽等于屏幕宽
				 height = width/rat;//高按比例缩放
			 }else{//如果宽度小于屏幕宽
				 width = oriImg.width;
				 height = oriImg.height;
				 left = (parseInt($(window).width())-width)/2;
			 }
			 top = (parseInt($(window).height())-height)/2-40;
		 }else{//如果高大于宽
			 //如果原图高度大于屏幕高度
			 if(oriImg.height>parseInt($(window).height())){//如果原图的高度大于屏幕高度
				 width=parseInt($(window).width());//令大图宽等于屏幕宽
				 height = width/rat;//高按比例缩放
				 top = 0;
			 }else{//如果原图高度小于屏幕高度
				 height = oriImg.height;//高等于原图
				 //如果高乘以比例后，仍然大于屏幕宽
				 if(oriImg.height*rat>parseInt($(window).width())){
					width = parseInt($(window).width());
					height = width/rat;//高按比例缩放
				 }else{//如果原图高度*rat小于屏幕宽度
					 width = height*rat;
					 left = (parseInt($(window).width())-width)/2;
				 }							 
				 top = (parseInt($(window).height())-height)/2-40;
			 }				 
		 }
		 $("#"+oriImg.id).css({
			 "position":"absolute",
			"top":top,
			"left":left,
			"height":height,
			"width":width
		 });
    }
    
    /**
     * 电脑的图片样式
     * @param oriImg
     */
    function showPCBigImage(oriImg){
    	//先判断原图的宽/高关系
		 var rat = oriImg.width/oriImg.height;
		 var ratWin = parseInt($(window).width())/parseInt($(window).height());
		 var top;
		 var height;
		 var width;
		 var left;
		 
		 if(rat>=1){//如果宽大于等于高
			//如果宽大于屏幕宽
			 if(oriImg.width>parseInt($(window).width())){
				 //如果屏幕宽高比小于图片宽高比
				 if(rat>ratWin){
					 width=parseInt($(window).width())-20;//令大图宽等于屏幕宽
					 height = width/rat;//高按比例缩放
				 }else{
					 height=parseInt($(window).height())-20;//令大图宽等于屏幕高
					 width = height*rat;
				 }
			 }else{//如果宽度小于屏幕宽
				 //如果图片高度大于屏幕高度的话
				 if(oriImg.height>parseInt($(window).height())){
					 height=parseInt($(window).height())-20;//令大图宽等于屏幕高
					 width = height*rat;
				 }else{
					 width = oriImg.width;
					 height = oriImg.height;
				 }				 				 
			 }
			 //定位
			 left = (parseInt($(window).width())-width)/2;
			 top = (parseInt($(window).height())-height)/2-40;
		 }else{//如果高大于宽
			 //如果原图高度大于屏幕高度
			 if(oriImg.height>parseInt($(window).height())){//如果原图的高度大于屏幕高度
				 //原图宽度大于屏幕宽度
				 if(oriImg.width>parseInt($(window).width())){
					 width=parseInt($(window).width())-20;
					 height=width/rat;
					 if(height>parseInt($(window).height())){
						 top=0;
					 }else{
						 top = (parseInt($(window).height())-height)/2;
					 }
				 }else{
					 width=oriImg.width;
					 height=oriImg.height;
					 top=0;
				 }
				 left = (parseInt($(window).width())-width)/2;
			 }else{//如果原图高度小于屏幕高度
				 height = oriImg.height;//高等于原图
				 width = oriImg.width;				
				 left = (parseInt($(window).width())-width)/2;						 
				 top = (parseInt($(window).height())-height)/2-40;
			 }				 
		 }
		 $("#"+oriImg.id).css({
			"position":"absolute",
			"top":top,
			"left":left,
			"height":height,
			"width":width
		 });
    }
    /**
     * 可切换图片，可滑动
     */
    function showBigImageCanScroll(thisA){
    	var data = "<div class='img_gallery'>"+
    				 "<div style='text-align:right;padding-top:10px;padding-right:30px;'><a href='javascript:void(0)' onclick='removeBigImgLunbo()'><span class='glyphicon glyphicon-remove' style='width:30px;height:30px;'></span></a></div>"+
					 "<div class='point'>"+		    		
					 "</div>"+
					 "<div class='main_img'>"+
						"<ul>"+		    			
						"</ul>"+
						"<a href='javascript:;' id='btn_prev'></a>"+
						"<a href='javascript:;' id='btn_next'></a>"+
					"</div>"+
				"</div>";
    	//把画廊添加到文档
    	$("body").append(data);
    	//设置外层css
    	$(".img_gallery").css({
    		"width":$(window).width(),
    		"height":$(window).height()
    	});
    	//获取在同一div所有图片
    	var imgArr = $(thisA).parent().children("img");
    	var index =  $(thisA).index()/2;//获取当前class的索引
    	//添加标签0
    	for(i=0;i<imgArr.length;i++){
    		var j = i+1;
    		$(".point").append("<a href='#'>"+j+"</a>");
    		$(".main_img ul").append("<li><img class=img_"+j+" id='imgId_"+j+"' onclick='clickEnlarge(this)'></img></li>");
    		$(".main_img ul li").css("width",$(".img_gallery").width());
    		var src = imgArr[i].src;
    		var newStr;
    		if(src.charAt(src.length-4)=="."){
    			newStr=src.substring(0,src.length-4)+"big"+src.substring(src.length-4,src.length);    			
    		}else{
    			newStr=src.substring(0,src.length-5)+"big"+src.substring(src.length-5,src.length);
    		}   			
    		//添加路径
			$(".img_"+j).attr("src",newStr);
			//判断图片是否加载完成
			//平板或手机
			if(parseInt($(window).width())<700){
				var f=0;
				 document.getElementById("imgId_"+j).onload=function(){
					 if(f==0){
						 for(k=1;k<=imgArr.length;k++){
							 showPhoneBigImage(document.getElementById("imgId_"+k));//手机端的图片
						 }
						 f=1;
					 }
				 }
			}else{
				 var f=0;
				 document.getElementById("imgId_"+j).onload=function(){
					 if(f==0){
						 for(k=1;k<=imgArr.length;k++){
							 showPCBigImage(document.getElementById("imgId_"+k));//手机端的图片
						 }
						 f=1;
					 }
				 }
			}
    	}    	
    	if(parseInt($(window).width())>480){
    		$(".img_gallery").hover(function(){
	    		$("#btn_prev,#btn_next").fadeIn()
	    	},function(){
	    		$("#btn_prev,#btn_next").fadeOut()
	    	});
    	}
    	
    	$dragBln = false;
    	
    	$(".main_img").touchSlider({
    		flexible : true,
    		begin:index,
    		speed : 200,
    		btn_prev : $("#btn_prev"),
    		btn_next : $("#btn_next"),
    		paging : $(".point a"),
    		counter : function (e){
    			$(".point a").removeClass("on").eq(e.current-1).addClass("on");//图片顺序点切换
    		}
    	});
    	
    	$(".main_img").bind("mousedown", function() {
    		$dragBln = false;
    	});
    	
    	$(".main_img").bind("dragstart", function() {
    		$dragBln = true;
    	});
    	
    	$(".main_img a").click(function(){
    		if($dragBln) {
    			return false;
    		}
    	});    	
    	//定位到当前点击的图片
    	$(".point a").removeClass("on").eq(index).click();
    	$(".point a").removeClass("on").eq(index).addClass("on");//图片顺序点切换
    }
    function removeBigImgLunbo(){
    	$(".img_gallery").remove();
    }
    
    /**
     * 模拟双击放大图片
     */
    var clickCount = 0;
    function clickEnlarge(thisA){
   	 if(clickCount==0){
   		//第一次点击
   		 clickCount=1;
   		 //如果0.8s内没有点击第二次，重置为0
   		 setTimeout(function(){
   			 clickCount=0;
   		 },800);
   	 }else{
			 //第二次点击
			 $(thisA).addClass("enlarge");
	    	 //拖拽事件
	    	 $(thisA).css("cursor","move ");
	    	 //首先鼠标按下时，获取当前鼠标的坐标和图片的坐标
	    	 $(thisA).mousedown(function(e){	
   		    var left = parseInt($(thisA).css('left'));
	    	    var top = parseInt($(thisA).css('top'));
	    	    //获取，鼠标刚按下时，鼠标相对于图片边缘的距离
   		    var distenceX = e.pageX - left;
   		    var distenceY = e.pageY - top;
   		    //鼠标移动时，移动到哪个位置，图片停在哪个位置
   		    $(document).mousemove(function(e){
   		    	var x = e.pageX - distenceX;
   		        var y = e.pageY - distenceY;	
   		        $(thisA).css({
   		    	 'position':'absolute',
   		         'left':x+'px',
   		         'top':y+'px'
   		        });
   		    });	    	
   		    //鼠标释放
   		    $(document).mouseup(function(){
   		        $(document).off('mousemove');
   		    });
   		  //双击缩小
  			  $(thisA).attr("onclick","clickCutdown(this)");
		      });	    		   
   		  clickCount=0;
   	 }
    }
    
    //双击缩小
    function clickCutdown( thisA ){
   	 if( clickCount==0 ){
   		 //第一次点击
   		 clickCount=1;
   		//如果0.8s内没有点击第二次，重置为0
   		 setTimeout(function(){
   			 clickCount=0;
   		 },800);
   	 }else{ //第二次点击    	
			$(thisA).removeClass("enlarge");
	    	//旋转退出
	    	$(thisA).addClass("recoverSize");
	    	//0.5s后除移这个class
	    	var tmp = $(thisA);
	    	setTimeout(function(){
	    		tmp.removeClass("recoverSize");
	    	},500);
	    	$(thisA).unbind("mousedown");
	    	$(thisA).css("cursor","default ");
	    	showPCBigImage($(thisA)[0]);
	    	//双击放大
			$(thisA).attr("onclick","clickEnlarge(this)");
			clickCount=0;
   	 }
    }
	
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
    
    //删除
    function deleteImage(id,thisA){
    	$.ajax({
    		url:"/billblog-manager-controller/imagecontroller/deleteimage.do",
    		type:"post",
    		data:{imageId:id},
    		dataType:"json",
    		error:function(){},
    		success:function(){
    			alert("删除成功");
    			$(thisA).prev().fadeOut(500,function(){
    				$(thisA).prev().remove();
    				$(thisA).remove();
    			})
    		}
    	});
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
	isNoticed();