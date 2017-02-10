	//计算content-text的宽度
    function calTextWidth(){
    	console.info("进来了！");
	    //先获取class=row、content的宽度。不包括padding
    	var content_div_wid = parseInt($(".content").width());
    	//再获取头像的宽度
    	var content_head_wid = parseInt($(".content-head").width());
    	//设置文字，即content-text的宽度
    	$(".content-text").css("width",content_div_wid-content_head_wid-10);//减去10px的误差
    	//设置content-text的样式
    	$(".content-text").css("padding-left",10);
    	$(".content-text").css("padding-right",10);
    }
    calTextWidth();