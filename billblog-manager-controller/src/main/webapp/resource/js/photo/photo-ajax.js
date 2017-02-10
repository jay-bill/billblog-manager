
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
								 	"<a href='#'>"+list[i][0].imageAlbum+"</a>》"
								 +"</p>" +
								 "<div>" ;
					var suffix=  "</div>" +
				    			"</div>";
					for(j=0;j<list[i].length;j++){						
						data = data+
						"<img class='photoImage' onclick='showBigImage(this)' src='"+list[i][j].imagePath+"'>";
					}
					$("#photo-main-div>:first-child").append(data+suffix);
				}				
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
	//关注
	function notice(beNoticedId){
		$.ajax({
			url:"/billblog-manager-controller/attentioncontroller/addattention.do",
			type:"post",
			data:{beNoticedId:beNoticedId},
			dataType:"json",
			error:function(){alert("关注失败！");},
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
	isNoticed();