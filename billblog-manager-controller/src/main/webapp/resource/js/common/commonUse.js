/**
 *  供各个页面使用
 */

	 //弹出选择图片的文件
	 function openFile(thisS){
		 $(thisS).parent().children("input[type='file']").click();
	 }
	 //删除微博框
	 function closeWriteWeiboDiv(){
		 $("#writeWeiboDiv").fadeOut(500,function(){
			 $("#writeWeiboDiv").remove();//删除 
		 });
	 }
	 //弹出写微博框
	 function showWriteWeiboDiv(){
		 var div = 	"<form id='writeWeiboDiv' method='post' action='/billblog-manager-controller/weibocontroller/broadcastweibo.do' enctype='multipart/form-data'>" +
		 				"<div>" +
		 					"<span onclick='closeWriteWeiboDiv()'>关闭</span>"+
		 				"</div>"+
		 				"<textarea name='weiboContent'></textarea>"+
		 				"<div>" +
		 					"<span onclick='openFile(this)'>图片</span>"+
		 					"<span style='visibility:hidden;'>空</span>"+
		 					"<span>表情</span>"+
		 					"<input type='file' name='weiboImages' style='display:none;'/>"+
		 					"<input type='submit' value='发表' class='btn btn-warning btn-sm'>"
		 				"</div>"+
		 			"</form>";
		 $("#content-outer").append(div);
		 //设置css属性
		 if($(".content").length>0){
			 //设置css属性
			 $("#writeWeiboDiv").css({
				"position":"fixed",
				"top":"100px",
				"width":$(".content").width()+40,
				"background":"gray",
				"padding":"10px"
			 });
		}else{
			 //设置css属性
			 $("#writeWeiboDiv").css({
				"position":"fixed",
				"top":"100px",
				"width":$(window).width()-40,
				"background":"gray",
				"padding":"10px"
			 });
		}
		 $("#writeWeiboDiv>:first-child").css({
			 "padding":"0px 0px 10px 0px",
			 "text-align":"right",
		});
		 $("#writeWeiboDiv>:nth-child(2)").css({
			 "resize":"none",
			 "width":"100%",
			 "height":"80px"
		});
		 $("#writeWeiboDiv>:last-child input").css({
			 "float":"right",
		});
		 $("#writeWeiboDiv>:last-child span").css({
			 "float":"left",
		});
	 }
	 
	 /**
	  * 关闭搜索栏
	  */
	 function closeSearchDiv(){
		 $("#searchFormSm").fadeOut(500,function(){
			$("#searchFormSm").remove(); 
		 });
	 }
	 /**
	  * 显示搜索栏
	  */
	 function showSearchDiv(){
		 var data = "<form id='searchFormSm' action='/billblog-manager-controller/searchcontroller/searchUser.do'>" +
		 				"<div>" +
		 					"<span onclick='closeSearchDiv()'>关闭</span>"+
		 				"</div>"+
		 				"<input name='userNickname' style='width:100%;margin:10px 0px;'>"+
		 				"<input type='submit' value='搜索' class='btn btn-warning btn-sm'/>"+
		 			"</form>";
		 $("#content-outer").append(data);
		if($(".content").length>0){
			 //css
			 $("#searchFormSm").css({
				"position":"fixed",
				"top":"100px",
				"width":$(".content").width()+40,
				"background":"gray",
				"padding":"10px"
			 });
		}else{
			 //css
			 $("#searchFormSm").css({
				"position":"fixed",
				"top":"100px",
				"width":$(window).width()-10,
				"background":"gray",
				"padding":"10px"
			 });
		}
	 }
	 
	 //上传图片
	 $("#input-text-under>:first-child>:nth-child(2)").click(function(){	
		 $("#previewDiv").children().remove();
		 $("#uploadImages").click();
	 });
	 
	//下面用于图片上传预览功能
	 function setImagePreview(file){
	    if (file.files && file.files[0]) {
	        for(i=0;i<file.files.length;i++){
	        	var div = document.getElementById('previewDiv');
		        var reader = new FileReader();
		        reader.onload = function (evt) { 
		        	var img = new Image();
		        	img.src= evt.target.result;
		        	img.width=80;
		        	img.height=80;
		        	div.append(img); 
		        }
		        reader.readAsDataURL(file.files[i]);
	        }
	      } else {
	          //兼容IE
	          file.select();
	          var src = document.selection.createRange().text;
	          var img = document.getElementById('preview');
	          img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
	      }
	 }