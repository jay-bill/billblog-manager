	/**
	 * 图片的查看，特效等
	 */
		    
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
    	//鼠标移到图片上，出现上一张下一张的箭头提示
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
    		 $dragBln=false;
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
    		 $dragBln=true;
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