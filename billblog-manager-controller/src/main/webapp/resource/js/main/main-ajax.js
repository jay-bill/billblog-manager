
	window.onload=function(){		 
		   
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
		
		    //显示用户数据 
		 	//获取微博的ajax	   
		 	function updateWeiboContent(){
	 			$.ajax({
			 		url:"getmineandmynoticeweibo.do",
			 		type:"get",
			 		data:{offset:offset*pageSum},
			 		dataType:"json",
			 		error:function(){alert("出错了");},
			 		success:function(weibos){
			 			//封装成数据包括头像和内容
			 			offset = offset+1;//自增
			 			 for(i=0;i<50;i++){
			 				 var data = "<div class='row content'><div class='content-head'><a href='tohomepage.do?userId="+weibos[i].userId+"'><img width='50px' src='"+weibos[i].userHeadimage+"'></a></div><div class='content-text'><h4><a>"+weibos[i].userNickname+"</a></h4><p style='margin-bottom:10px;color:#808080;'>"+new Date(weibos[i].weiboPublishtime).toLocaleString()+"</p>"+weibos[i].weiboContent+"</div><div class='float'></div><div class='container-fluid text-bottom-div'><div class='col-xs-3'><a>收藏</a></div><div class='col-xs-3'><a>转发</a></div><div class='col-xs-3'><a>评论</a></div><div class='col-xs-3'><a>点赞</a></div></div></div>";				    				   
					    	 $("#content-outer").append(data);		    	
			 			 }			 			
			 		}
			 	});
		 		calTextWidth();
		 	}    		
		 	//将时间戳转换成时间
		    function getDate(tm){ 
				var tt=new Date(parseInt(tm) * 1000).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ") 
				return tt; 
	    	} 
		    //窗口改变时，重新计算content-text即微博文字的宽度
		    $(document).ready(function(){
		    	$(window).resize(function(){
			    	calTextWidth();
			    });
		    });
		 	updateWeiboContent();	//获取数据		
		    setInterval(calTextWidth,80);//强制运行这个函数
	}