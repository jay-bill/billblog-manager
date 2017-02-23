/**
 * 首页的js
 */
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

	 /**
	  * 显示表情
	  */
	function showEmoji(thisA){
		$("#emojiDiv").css("display","block");
		$(thisA).attr("onclick","closeEmojiDiv(this)");
		if($("#emojiDiv ul li").length>0)
			return;
		for(i=1;i<61;i++){
			$("#emojiDiv ul").append("<li><img src='/billblog-manager-controller/resource/plug-res/images/face/"+i+".gif' onclick='imgToCode(this)' face='<emj>"+i+"</emj>'/><li>");
		}
	}
	/**
	 * 隐藏表情
	 */
	function closeEmojiDiv(thisA){
		$("#emojiDiv").css("display","none");
		$(thisA).attr("onclick","showEmoji(this)");
	}
	
	function imgToCode(thisA){
		 var myValue = $(thisA).attr("face");
		 $("#weiboTextarea").focus();
		 var myField = document.getElementById("weiboTextarea");
		//IE support
		 if (document.selection) {
			 myField.focus();
			 sel = document.selection.createRange();
			 sel.text = myValue;
			 sel.select();
		 }
			 //MOZILLA/NETSCAPE support 
		 else if (myField.selectionStart || myField.selectionStart == '0') {
			 var startPos = myField.selectionStart;
			 var endPos = myField.selectionEnd;
			 // save scrollTop before insert www.keleyi.com
			 var restoreTop = myField.scrollTop;
			 myField.value = myField.value.substring(0, startPos) + myValue + myField.value.substring(endPos, myField.value.length);
			 if (restoreTop > 0) {
			 myField.scrollTop = restoreTop;
			 }
			 myField.focus();
			 myField.selectionStart = startPos + myValue.length;
			 myField.selectionEnd = startPos + myValue.length;
			 } else {
			 myField.value += myValue;
			 myField.focus();
		 }
	}