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
						"<img class='photoImage' onclick='showBigImage(this)' src='"+list[0][i][j].imagePath+"'>";
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
						"<img class='photoImage' onclick='showBigImage(this)' src='"+list[0][i][j].imagePath+"'>";
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
			}
		});
	}
	
	 /**
     * 查看大图
     * @param thisA
     */
    function showBigImage(thisA){
	 var data = "<div id='bigImageBlackDiv' onclick='removeBigImage()'>" +
						"<img id='currentBigImage' src='"+$(thisA).attr("src")+"'>"+
 				"</div>";
		 //获取原图的Size
		 var oriImg = new Image();
		 oriImg.src = $(thisA).attr("src");//原图路径
		//先判断原图的宽/高关系
		 var rat = oriImg.width/oriImg.height;
		 var top;
		 var height;
		 var width;
		 var left;
		 if($(window).width()>100){	
			 //追加节点
			 $('body').append(data);
			 $("#bigImageBlackDiv").css({
				"height":$(window).height() 
			 });
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
				 top = (parseInt($(window).height())-height)/2;
			 }else{//如果高大于宽
				 //如果原图高度大于屏幕高度
				 if(oriImg.height>parseInt($(window).height())){//如果原图的高度大于屏幕高度
					 width=parseInt($(window).width());//令大图宽等于屏幕宽
					 height = width/rat;//高按比例缩放
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
				 }
				 top = (parseInt($(window).height())-height)/2;
			 }
			 $("#bigImageBlackDiv img").css({
				"width":width,
				"padding":"0px 10px",
				"position":"absolute",
				"height":height,
				"top":top,
				"left":left
			 });
			 $("#bigImageBlackDiv").css({
				 "overflow":"auto",
				 "position":"fixed",
			 });
			 $("body").css("overflow","hidden");
		 }			
    }
    function removeBigImage(){
    	$("#bigImageBlackDiv").remove();
    	$("body").css("overflow","auto");
    	$(".photoImage").attr("onclick","showBigImage(this)");
    }