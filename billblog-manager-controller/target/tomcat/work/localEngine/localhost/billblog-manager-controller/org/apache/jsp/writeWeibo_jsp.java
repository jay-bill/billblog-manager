package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class writeWeibo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\r\n");
      out.write("\t<link rel=\"SHORTCUT ICON\" href=\"/billblog-manager-controller/resource/image/s_blog.ico\">\r\n");
      out.write("\t<link rel=\"BOOKMARK\" href=\"/billblog-manager-controller/resource/image/s_blog.ico\">\r\n");
      out.write("    <title>多图片上传</title>\r\n");
      out.write("\r\n");
      out.write("    <style>\r\n");
      out.write("         * {\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            padding: 0;\r\n");
      out.write("        }\r\n");
      out.write("        /*图片上传*/\r\n");
      out.write("        \r\n");
      out.write("        html,\r\n");
      out.write("        body {\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            height: 100%;\r\n");
      out.write("            background:#f6f6f6;\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        .container1 {\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            height: 100%;\r\n");
      out.write("            overflow: auto;\r\n");
      out.write("            clear: both;\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        .z_photo {\r\n");
      out.write("            width: 5rem;\r\n");
      out.write("            height: 5rem;\r\n");
      out.write("            overflow: auto;\r\n");
      out.write("            clear: both;\r\n");
      out.write("            margin: 0px auto;\r\n");
      out.write("            padding-top:15px;\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        .z_photo img {\r\n");
      out.write("            width: 1rem;\r\n");
      out.write("            height: 1rem;\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        .z_addImg {\r\n");
      out.write("            float: left;\r\n");
      out.write("            margin-right: 0.2rem;\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        .z_file {\r\n");
      out.write("            width: 1rem;\r\n");
      out.write("            height: 1rem;\r\n");
      out.write("            background: url(/billblog-manager-controller/resource/image/z_add.png) no-repeat;\r\n");
      out.write("            background-size: 100% 100%;\r\n");
      out.write("            float: left;\r\n");
      out.write("            margin-right: 0.2rem;\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        .z_file input::-webkit-file-upload-button {\r\n");
      out.write("            width: 1rem;\r\n");
      out.write("            height: 1rem;\r\n");
      out.write("            border: none;\r\n");
      out.write("            position: absolute;\r\n");
      out.write("            outline: 0;\r\n");
      out.write("            opacity: 0;\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        .z_file input#file {\r\n");
      out.write("            display: block;\r\n");
      out.write("            width: auto;\r\n");
      out.write("            border: 0;\r\n");
      out.write("            vertical-align: middle;\r\n");
      out.write("        }\r\n");
      out.write("        /*遮罩层*/\r\n");
      out.write("        \r\n");
      out.write("        .z_mask {\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            height: 100%;\r\n");
      out.write("            background: rgba(0, 0, 0, .5);\r\n");
      out.write("            position: fixed;\r\n");
      out.write("            top: 0;\r\n");
      out.write("            left: 0;\r\n");
      out.write("            z-index: 999;\r\n");
      out.write("            display: none;\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        .z_alert {\r\n");
      out.write("            width: 3rem;\r\n");
      out.write("            height: 2rem;\r\n");
      out.write("            border-radius: .2rem;\r\n");
      out.write("            background: #fff;\r\n");
      out.write("            font-size: .24rem;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            position: absolute;\r\n");
      out.write("            left: 50%;\r\n");
      out.write("            top: 50%;\r\n");
      out.write("            margin-left: -1.5rem;\r\n");
      out.write("            margin-top: -2rem;\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        .z_alert p:nth-child(1) {\r\n");
      out.write("            line-height: 1.5rem;\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        .z_alert p:nth-child(2) span {\r\n");
      out.write("            display: inline-block;\r\n");
      out.write("            width: 49%;\r\n");
      out.write("            height: .5rem;\r\n");
      out.write("            line-height: .5rem;\r\n");
      out.write("            float: left;\r\n");
      out.write("            border-top: 1px solid #ddd;\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        .z_cancel {\r\n");
      out.write("            border-right: 1px solid #ddd;\r\n");
      out.write("        }\r\n");
      out.write("        .text-div{\r\n");
      out.write("        \twidth: 5rem;\r\n");
      out.write("            height: 80px;\r\n");
      out.write("            border: 1px solid #555;\r\n");
      out.write("        \tmargin:0px auto;\r\n");
      out.write("        }\r\n");
      out.write("\t\ttextarea{\r\n");
      out.write("\t\t\twidth:100%;\r\n");
      out.write("\t\t\theight:100%;\t\t\t\r\n");
      out.write("\t\t\tresize:none;\r\n");
      out.write("\t\t\tborder:0px;\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t.top{\r\n");
      out.write("\t\t\twidth: 5rem;\r\n");
      out.write("\t\t\tmargin:0px auto;\r\n");
      out.write("\t\t\tfont-size:15px;\r\n");
      out.write("\t\t\tpadding:10px 0px;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t.top a{\r\n");
      out.write("\t\t\tline-height:30px;\r\n");
      out.write("\t\t\tcolor:#00ae9d;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t.top input{\r\n");
      out.write("\t\t\tbackground:#00ae9d;\r\n");
      out.write("\t\t\tdisplay:inline-block;\r\n");
      out.write("\t\t\theight:30px;\r\n");
      out.write("\t\t\twidth:60px;\r\n");
      out.write("\t\t\tfloat:right;\r\n");
      out.write("\t\t\tcolor:white;\r\n");
      out.write("\t\t}\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("    <form class=\"container1\"  action=\"/billblog-manager-controller/weibocontroller/broadcastweibo.do\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("    \t\r\n");
      out.write("    \t<div class=\"top\">\r\n");
      out.write("    \t\t<a href=\"/billblog-manager-controller/weibocontroller/tomainpage.do\">取消</a>\r\n");
      out.write("    \t\t<input type=\"submit\" value=\"发表\">\r\n");
      out.write("    \t\t<div style=\"clear:both;\"></div>\r\n");
      out.write("    \t</div>\r\n");
      out.write("    \t\r\n");
      out.write("    \t<!-- 写微博 -->\r\n");
      out.write("    \t<div class=\"text-div\">    \t\t\r\n");
      out.write("    \t\t<textarea name=\"weiboContent\" placeholder=\"有什么想说的分享给大家吧...\"></textarea>\r\n");
      out.write("    \t</div>\r\n");
      out.write("        <!--    照片添加    -->\r\n");
      out.write("        <div class=\"z_photo\">\r\n");
      out.write("            <div class=\"z_file\">\r\n");
      out.write("                <input type=\"file\" name=\"weiboImages\" id=\"file\" value=\"\" accept=\"image/*\" multiple onchange=\"imgChange('z_photo','z_file');\" />\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <!--遮罩层-->\r\n");
      out.write("        <div class=\"z_mask\">\r\n");
      out.write("            <!--弹出框-->\r\n");
      out.write("            <div class=\"z_alert\">\r\n");
      out.write("                <p>确定要删除这张图片吗？</p>\r\n");
      out.write("                <p>\r\n");
      out.write("                    <span class=\"z_cancel\">取消</span>\r\n");
      out.write("                    <span class=\"z_sure\">确定</span>\r\n");
      out.write("                </p>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </form>\r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/billblog-manager-controller/resource/js/jquery.min.js\" ></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"/billblog-manager-controller/resource/js/bootstrap.min.js\" ></script>\r\n");
      out.write("\t\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("        //px转换为rem\r\n");
      out.write("        (function(doc, win) {\r\n");
      out.write("            var docEl = doc.documentElement,\r\n");
      out.write("                resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize',\r\n");
      out.write("                recalc = function() {\r\n");
      out.write("                    var clientWidth = docEl.clientWidth;\r\n");
      out.write("                    if (!clientWidth) return;\r\n");
      out.write("                    if (clientWidth >= 640) {\r\n");
      out.write("                        docEl.style.fontSize = '100px';\r\n");
      out.write("                    } else {\r\n");
      out.write("                        docEl.style.fontSize = 100 * (clientWidth / 640) + 'px';\r\n");
      out.write("                    }\r\n");
      out.write("                };\r\n");
      out.write("\r\n");
      out.write("            if (!doc.addEventListener) return;\r\n");
      out.write("            win.addEventListener(resizeEvt, recalc, false);\r\n");
      out.write("            doc.addEventListener('DOMContentLoaded', recalc, false);\r\n");
      out.write("        })(document, window);\r\n");
      out.write("\r\n");
      out.write("        function imgChange(obj1, obj2) {\r\n");
      out.write("            //获取点击的文本框\r\n");
      out.write("            var file = document.getElementById(\"file\");\r\n");
      out.write("            //存放图片的父级元素\r\n");
      out.write("            var imgContainer = document.getElementsByClassName(obj1)[0];\r\n");
      out.write("            //获取的图片文件\r\n");
      out.write("            var fileList = file.files;\r\n");
      out.write("            //文本框的父级元素\r\n");
      out.write("            var input = document.getElementsByClassName(obj2)[0];\r\n");
      out.write("            var imgArr = [];\r\n");
      out.write("            //遍历获取到得图片文件\r\n");
      out.write("            for (var i = 0; i < fileList.length; i++) {\r\n");
      out.write("                var imgUrl = window.URL.createObjectURL(file.files[i]);\r\n");
      out.write("                imgArr.push(imgUrl);\r\n");
      out.write("                var img = document.createElement(\"img\");\r\n");
      out.write("                img.setAttribute(\"src\", imgArr[i]);\r\n");
      out.write("                var imgAdd = document.createElement(\"div\");\r\n");
      out.write("                imgAdd.setAttribute(\"class\", \"z_addImg\");\r\n");
      out.write("                imgAdd.appendChild(img);\r\n");
      out.write("                imgContainer.appendChild(imgAdd);\r\n");
      out.write("            };\r\n");
      out.write("            imgRemove();\r\n");
      out.write("        };\r\n");
      out.write("\r\n");
      out.write("        function imgRemove() {\r\n");
      out.write("            var imgList = document.getElementsByClassName(\"z_addImg\");\r\n");
      out.write("            var mask = document.getElementsByClassName(\"z_mask\")[0];\r\n");
      out.write("            var cancel = document.getElementsByClassName(\"z_cancel\")[0];\r\n");
      out.write("            var sure = document.getElementsByClassName(\"z_sure\")[0];\r\n");
      out.write("            for (var j = 0; j < imgList.length; j++) {\r\n");
      out.write("                imgList[j].index = j;\r\n");
      out.write("                imgList[j].onclick = function() {\r\n");
      out.write("                    var t = this;\r\n");
      out.write("                    mask.style.display = \"block\";\r\n");
      out.write("                    cancel.onclick = function() {\r\n");
      out.write("                        mask.style.display = \"none\";\r\n");
      out.write("                    };\r\n");
      out.write("                    sure.onclick = function() {\r\n");
      out.write("                        mask.style.display = \"none\";\r\n");
      out.write("                        t.style.display = \"none\";\r\n");
      out.write("                    };\r\n");
      out.write("\r\n");
      out.write("                }\r\n");
      out.write("            };\r\n");
      out.write("        };\r\n");
      out.write("\r\n");
      out.write("    </script>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
