	var wid = parseInt($(window).width());
	
	$(window).scroll(function(){
		if(wid>450){
			var h = parseInt($(window).scrollTop());//滚动到图片导航栏不见时，重新将其定位，使其显示
			if(h>422){
				$("#photo-nav").css("position","relative");
				$("#photo-nav").css("top",h-352);
			}else{
				$("#photo-nav").css("position","static");
			}
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
		$("#myHeadimage").parent().submit();
	});
	
	/**
	 * 弹出上传图片的div
	 */
	function showUploadImageDiv(thisA){
		//获取相册名称
		$.ajax({
			url:"/billblog-manager-controller/imagecontroller/getimagealbum.do",
			type:"get",
			dataType:"json",
			error:function(){},
			success:function(names){
				var data = 	"<form id='uploadImagesForm' action='/billblog-manager-controller/imagecontroller/uploadimages.do' method='post' enctype='multipart/form-data'>" +
								"<div style='text-align:right'>" +
									"<a href='javascript:void(0)' onclick='closeUploadImageDiv()'>关闭</a>"+
								"</div>"+
								"<div>" +
								"<select id='selectImageAlbum' name='imageAlbum' value='选择相册'>";
				var suffix = "</select>"+
							"<a class='btn btn-warning btn-xs' onclick='createNewPhoto()'>新建相册</a>"+ 
							"<input type='file' multiple name='images'>"+
							"<input type='submit' value='上传'>"+
							"</div>"+
						"</form>";	
				for(i=0;i<names.length;i++){
					var op = "<option value='"+names[i]+"'>" +
								names[i]+
					 		"</option>";
					data= data + op;
				}
				data = data+suffix;
				$("#photo-main-div>:first-child").append(data);
				$("#uploadImagesForm").css({
					"width":$("#top-bg-div").width()+30,
					"position":"fixed",
					"top":"100px",
					"height":"100px",
					"background":"#c7c7c7",
					"padding":"10px 20px"
				});
				$("#uploadImagesForm input[name='images']").css({
					"display":"inline"
				});
				$("#selectImageAlbum>:first-child").attr("selected","selected");
			}
		});				
	}
	
	/**
	 * 关闭上传的div
	 */
	function closeUploadImageDiv(){
		$("#uploadImagesForm").fadeOut(500,function(){
			$("#uploadImagesForm").remove();
			if($("#newAlbumDiv").length>0){
				$("#newAlbumDiv").remove();
			}
		});
	}
	
	/**
	 * 新建相册
	 */
	function createNewPhoto(){
		var data = 	"<div id='newAlbumDiv'>" +
						"<div>新建相册名：</div>" +
						"<input/>"+
						"<button class='btn btn-info btn-xs' onclick='create()'>确认</button>"+
						"<button class='btn btn-info btn-xs' onclick='avoid()'>取消</button>"+
					"</div>";
		$("#photo-main-div>:first-child").append(data);
		$("#newAlbumDiv").css({
			"width":$("#top-bg-div").width()+30,
			"position":"fixed",
			"top":"200px",
			"background":"#c7c7c7",
			"padding":"10px 20px"
		});

	}
	
	/**
	 * 新建相册
	 */
	function create(){
		var val=$("#newAlbumDiv input").val();
		if(val.length==0){
			alert("相册名称不能为空");
			return;
		}
			
		var data = "<option value='"+val+
						"'>" +
						val+
					"</option>";
		$("#selectImageAlbum").append(data);
		$("#newAlbumDiv").fadeOut(500,function(){
			$("#newAlbumDiv").remove();
		});
	}
	
	/**
	 * 取消新建
	 */
	function avoid(){
		$("#newAlbumDiv").remove();
	}
	
	/**
	 * 显示相册名
	 */
	function showImageAlbumDiv(){
		$("#photo-main-div>:first-child").html("");
		$(".dividePage").remove();
		$("#albumA").css("color","red");
		$("#photosWallA").css("color","gray");
		var data = 	"<div id='showimageAlbumDiv'>" +
						"<div id='breadNav'>" +
							"<a href='javascript:void(0)' onclick='showImageAlbumDiv()'>相册专辑</a>"+
						"</div>"+
						"<div id='albumsDiv'>";
						
		var	suffix=		"</div>"+
					"</div>";
		var userId = $("#nicknameA").attr("href").split("?userId=")[1];
		$.ajax({
			url:"/billblog-manager-controller/imagecontroller/selectfirstimgbygroup.do",
			type:"get",
			data:{userId:userId},
			dataType:"json",
			error:function(){},
			success:function(names){
				for(i=0;i<names.length;i++){
					data = data + "<div onclick='getImageByAlbum(this)' class='imageAlbumDivFirstImg' style='background:url("+names[i].imagePath+")'>"+"<a href='javascript:void(0)'>"+names[i].imageAlbum+"</a>"+"</div>";
				}
				data = data + suffix;
				$("#photo-main-div>:first-child").append(data);
				$("#showimageAlbumDiv").css({
					"width":$("#top-bg-div").width()+30,
					"top":"50px",
					"border-radius":"8px",
				});
				$(".imageAlbumDivFirstImg").css({
					"display":"inline-block",
					"width":"150px",
					"height":"150px",
					"text-align":"center",
					"line-height":"150px",
					"margin":"15px 0px 20px 20px",
					"border-radius":"10px",
					"background-size":"cover"
				});
			}
		});
	}
	
	/**
	 * 根据相册获取图片
	 */
	function getImageByAlbum(thisA){
		var userId=$("#nicknameA").attr("href").split("?userId=")[1];
		//获取当前class的下标
		var index = $(thisA).index();
		$("#albumsDiv").html("");
		var bread = "<a href='javascript:void(0)'>-->"+$(thisA).text()+"</a>";
		$("#breadNav").append(bread);
		$.ajax({
			url:"/billblog-manager-controller/imagecontroller/getimagesbyalbum.do",
			type:"get",
			data:{userId:userId,index:index,imgBegin:0,pageBegin:0},
			dataType:"json",
			error:function(){
				alert("根据相册获取图片失败！");
			},
			success:function(list){
				for(i=0;i<list[0].length;i++){
					var data ="<div class='container-fluid photo-list-div'>" +
								 "<p>"+new Date(list[0][i][0].imageDatetime).toLocaleString()+"&nbsp;&nbsp;&nbsp;来自《"+
								 	"<a href='#'>"+list[0][i][0].imageAlbum+"</a>》"
								 +"</p>" +
								 "<div>" ;
					var suffix=  "</div>" +
				    			"</div>";
					for(j=0;j<list[0][i].length;j++){						
						data = data+
						"<img class='photoImage' onclick='showBigImageCanScroll(this)' src='"+list[0][i][j].imagePath+"'>"
						+"<a href='javascript:void(0)' onclick='deleteImage("+list[0][i][j].imageId+",this)' style='display:none;'>删除</a>";
					}
					$("#photo-main-div>:first-child").append(data+suffix);					
				}
				var page = "<div class='pageDiv'>";
				for(i=0;i<list[1].length;i++){
					var tmp = i+1;
					page = page + "<a class='ajaxPageA' href='javascript:void(0)' onclick='getImageByAlbum2("+index+","+i*5+","+list[1][i]+")'>"+tmp+"</a>";					
				}
				page = page + "</div>";
				$("#photo-main-div>:first-child").append(page);
				
				/***********css样式****************/
				//相片翻转
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
	
	function getImageByAlbum2(index,pageBegin,imgBegin){
		var userId=$("#nicknameA").attr("href").split("?userId=")[1];
		$(".photo-list-div").remove();
		$(".pageDiv").remove();
		//获取当前class的下标
		$.ajax({
			url:"/billblog-manager-controller/imagecontroller/getimagesbyalbum.do",
			type:"get",
			data:{userId:userId,index:index,imgBegin:imgBegin,pageBegin:pageBegin},
			dataType:"json",
			error:function(){
				alert("根据相册获取图片失败！");
			},
			success:function(list){
				for(i=0;i<list[0].length;i++){
					var data ="<div class='container-fluid photo-list-div'>" +
								 "<p>"+new Date(list[0][i][0].imageDatetime).toLocaleString()+"&nbsp;&nbsp;&nbsp;来自《"+
								 	"<a href='#'>"+list[0][i][0].imageAlbum+"</a>》"
								 +"</p>" +
								 "<div>" ;
					var suffix=  "</div>" +
				    			"</div>";
					for(j=0;j<list[0][i].length;j++){						
						data = data+
						"<img class='photoImage' onclick='showBigImageCanScroll(this)' src='"+list[0][i][j].imagePath+"'>"
						+"<a href='javascript:void(0)' onclick='deleteImage("+list[0][i][j].imageId+",this)' style='display:none;'>删除</a>";
					}
					$("#photo-main-div>:first-child").append(data+suffix);					
				}
				var page = "<div class='pageDiv'>";
				for(i=0;i<list[1].length;i++){
					var tmp = i+1;
					page = page + "<a class='ajaxPageA' href='javascript:void(0)' onclick='getImageByAlbum2("+index+","+i*5+","+list[1][i]+")'>"+tmp+"</a>";					
				}
				page = page + "</div>";
				$("#photo-main-div>:first-child").append(page);
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
    				 "<div style='text-align:right;padding-top:10px;'><a href='javascript:void(0)' onclick='removeBigImgLunbo()'><span class='glyphicon glyphicon-remove' style='width:30px;height:30px;'></span></a></div>"+
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
    	var index =  $(thisA).index();//获取当前class的索引
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