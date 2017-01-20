/**
 * 首页的js
 */
offset=0;//分页，从0开始
pageSum=20;//每页20条记录

window.onload=function(){
	 $(window).scroll(function(){
	    	var h = $(window).scrollTop();
	    	//右边div随着滚动条滚动而滚动
	    	if(parseInt(h)>820){
	    		$("#hot-topic-div").css("position","relative");
	    		$("#hot-topic-div").css("top",parseInt(h)-200);//200为头像的div
	    		
	    	}else{
	    		$("#hot-topic-div").css("position","static");
	    		$("#left-ul").css("position","static");
	    	}
	    	
	    	//左边div也是一样
	    	$("#left-ul").css("position","relative");
		 		$("#left-ul").css("top",parseInt(h));
		    });		    
}
