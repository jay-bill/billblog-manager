<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="SHORTCUT ICON" href="/billblog-manager-controller/resource/image/s_blog.ico">
	<link rel="BOOKMARK" href="/billblog-manager-controller/resource/image/s_blog.ico">
    <title>发微博</title>

    <style>
         * {
            margin: 0;
            padding: 0;
        }
        /*图片上传*/       
        body {
            background:#f6f6f6;
        }
        
        .container1 {
            width: 100%;
            height: 100%;
            overflow: auto;
            clear: both;
        }
        
        .z_photo {
            width: 5rem;
            height: 5rem;
            overflow: auto;
            clear: both;
            margin: 0px auto;
            padding-top:15px;
        }
        
        .z_photo img {
            width: 1rem;
            height: 1rem;
        }
        
        .z_addImg {
            float: left;
            margin-right: 0.2rem;
        }
        
        .z_file {
            width: 1rem;
            height: 1rem;
            background: url(/billblog-manager-controller/resource/image/z_add.png) no-repeat;
            background-size: 100% 100%;
            float: left;
            margin-right: 0.2rem;
        }
        
        .z_file input::-webkit-file-upload-button {
            width: 1rem;
            height: 1rem;
            border: none;
            position: absolute;
            outline: 0;
            opacity: 0;
        }
        
        .z_file input#file {
            display: block;
            width: auto;
            border: 0;
            vertical-align: middle;
        }
        /*遮罩层*/
        
        .z_mask {
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, .5);
            position: fixed;
            top: 0;
            left: 0;
            z-index: 999;
            display: none;
        }
        
        .z_alert {
            width: 3rem;
            height: 2rem;
            border-radius: .2rem;
            background: #fff;
            font-size: .24rem;
            text-align: center;
            position: absolute;
            left: 50%;
            top: 50%;
            margin-left: -1.5rem;
            margin-top: -2rem;
        }
        
        .z_alert p:nth-child(1) {
            line-height: 1.5rem;
        }
        
        .z_alert p:nth-child(2) span {
            display: inline-block;
            width: 49%;
            height: .5rem;
            line-height: .5rem;
            float: left;
            border-top: 1px solid #ddd;
        }
        
        .z_cancel {
            border-right: 1px solid #ddd;
        }
        .text-div{
        	width: 5rem;
            height: 80px;
            border: 1px solid #555;
        	margin:0px auto;
        }
		textarea{
			width:100%;
			height:100%;			
			resize:none;
			border:0px;			
		}
		.top{
			width: 5rem;
			margin:0px auto;
			font-size:15px;
			padding:10px 0px;
		}
		.top a{
			line-height:30px;
			color:#00ae9d;
		}
		.top input{
			background:#00ae9d;
			display:inline-block;
			height:30px;
			width:60px;
			float:right;
			color:white;
		}
		.text-next-div{
			width: 5rem;
			margin:0px auto;
			padding:0px;
		}
		#emojiDiv{
			display:none;
			width: 5rem;
			margin:0px auto;
			padding:0px;
		}
		#emojiDiv ul{
			list-style:none;
		}
		#emojiDiv ul li{
			display:inline-block;
			padding:3px;
			height:20px;
		}
    </style>
</head>

<body>

    <form class="container1"  action="/billblog-manager-controller/weibocontroller/broadcastweibo.do" method="post" enctype="multipart/form-data">
    	
    	<div class="top">
    		<a href="/billblog-manager-controller/weibocontroller/tomainpage.do">取消</a>
    		<a href="javascript:void(0)" onclick="showEmoji(this)" style="font-size:13px;">
				表情
			</a>
    		<input type="submit" value="发表">
    		<div style="clear:both;"></div>
    	</div>
    	
    	<!-- 写微博 -->
    	<div class="text-div">    		
    		<textarea id="weiboTextarea" name="weiboContent" placeholder="有什么想说的分享给大家吧..."></textarea> 	  
    	</div>
    	<div class="text-next-div">    		
    				
    	</div>
    	<!-- 表情栏 -->
		<div id="emojiDiv">
			<ul>
			
			</ul>
		</div>
        <!--    照片添加    -->
        <div class="z_photo">
            <div class="z_file">
                <input type="file" name="weiboImages" id="file" value="" accept="image/*" multiple onchange="imgChange('z_photo','z_file');" />
            </div>
        </div>

        <!--遮罩层-->
        <div class="z_mask">
            <!--弹出框-->
            <div class="z_alert">
                <p>确定要删除这张图片吗？</p>
                <p>
                    <span class="z_cancel">取消</span>
                    <span class="z_sure">确定</span>
                </p>
            </div>
        </div>
    </form>
</body>
<script type="text/javascript" src="/billblog-manager-controller/resource/js/jquery.min.js" ></script>
<script type="text/javascript" src="/billblog-manager-controller/resource/js/bootstrap.min.js" ></script>
<script type="text/javascript" src="/billblog-manager-controller/resource/js/main/main.js"></script>
    <script type="text/javascript">
        //px转换为rem
        (function(doc, win) {
            var docEl = doc.documentElement,
                resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize',
                recalc = function() {
                    var clientWidth = docEl.clientWidth;
                    if (!clientWidth) return;
                    if (clientWidth >= 640) {
                        docEl.style.fontSize = '100px';
                    } else {
                        docEl.style.fontSize = 100 * (clientWidth / 640) + 'px';
                    }
                };

            if (!doc.addEventListener) return;
            win.addEventListener(resizeEvt, recalc, false);
            doc.addEventListener('DOMContentLoaded', recalc, false);
        })(document, window);

        function imgChange(obj1, obj2) {
            //获取点击的文本框
            var file = document.getElementById("file");
            //存放图片的父级元素
            var imgContainer = document.getElementsByClassName(obj1)[0];
            //获取的图片文件
            var fileList = file.files;
            //文本框的父级元素
            var input = document.getElementsByClassName(obj2)[0];
            var imgArr = [];
            //遍历获取到得图片文件
            for (var i = 0; i < fileList.length; i++) {
                var imgUrl = window.URL.createObjectURL(file.files[i]);
                imgArr.push(imgUrl);
                var img = document.createElement("img");
                img.setAttribute("src", imgArr[i]);
                var imgAdd = document.createElement("div");
                imgAdd.setAttribute("class", "z_addImg");
                imgAdd.appendChild(img);
                imgContainer.appendChild(imgAdd);
            };
            imgRemove();
        };

        function imgRemove() {
            var imgList = document.getElementsByClassName("z_addImg");
            var mask = document.getElementsByClassName("z_mask")[0];
            var cancel = document.getElementsByClassName("z_cancel")[0];
            var sure = document.getElementsByClassName("z_sure")[0];
            for (var j = 0; j < imgList.length; j++) {
                imgList[j].index = j;
                imgList[j].onclick = function() {
                    var t = this;
                    mask.style.display = "block";
                    cancel.onclick = function() {
                        mask.style.display = "none";
                    };
                    sure.onclick = function() {
                        mask.style.display = "none";
                        t.style.display = "none";
                    };

                }
            };
        };

    </script>
</html>
