/**
 * 首页的js
 */
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
	    
	    //显示用户数据的ajax	    
		$(document).ready(function(){
//			//封装成数据包括头像和内容
//		    var data = "<div class='row content'><div class='content-head'><img src='resource/image/头像.jpg'></div><div class='content-text'><h4><a>孙悟空</a></h4><p style='margin-bottom:10px;color:#808080;'>今天 21:54</p>老司机...老司机...为了江苏台跨年晚会的收视率，SNH48的妹子们也是把偶像包袱都丢光了吧昨晚，TFBOYS参加了#湖南卫视跨年# 演唱会，不仅带来《是你》和新歌《萤火》首唱，三人分别献唱个人单曲；还与现场前辈及观众共同迎接零点[羞嗒嗒]今晚七点半锁定湖南卫</div><div class='float'></div><div class='container-fluid text-bottom-div'><div class='col-xs-3'><a>收藏</a></div><div class='col-xs-3'><a>转发</a></div><div class='col-xs-3'><a>评论</a></div><div class='col-xs-3'><a>点赞</a></div></div></div>";
//		    
//		    for(i=0;i<50;i++){
//		    	$("#content-outer").append(data);		    	
//		    }
		    calTextWidth();
		});
	    
	    //计算content-text的宽度
	    function calTextWidth(){
	    	//先获取class=row、content的宽度。不包括padding
	    	var content_div_wid = parseInt($(".content").width());
	    	//再获取头像的宽度
	    	var content_head_wid = parseInt($(".content-head").width());
	    	//设置文字，即content-text的宽度
	    	$(".content-text").css("width",content_div_wid-content_head_wid-2);//减去2px的误差
	    	//设置content-text的样式
	    	$(".content-text").css("padding-left",10);
	    }
	    
	    //窗口改变时，重新计算content-text即微博文字的宽度
	    $(document).ready(function(){
	    	$(window).resize(function(){
		    	calTextWidth();
		    });
	    });
}