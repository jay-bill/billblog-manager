package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class regist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no\"/>\r\n");
      out.write("<title>注册</title>\r\n");
      out.write("<link rel=\"SHORTCUT ICON\" href=\"resource/image/s_blog.ico\">\r\n");
      out.write("<link rel=\"BOOKMARK\" href=\"resource/image/s_blog.ico\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"resource/css/bootstrap.min.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"resource/css/regist/regist.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"firstDiv\"></div>\r\n");
      out.write("\t<!--导航栏-->\r\n");
      out.write("\t<div id=\"navbar\">\r\n");
      out.write("\t   <div class=\"col-xs-2\">\r\n");
      out.write("\t      <img src=\"resource/image/reback.png\">\r\n");
      out.write("\t   </div>\r\n");
      out.write("\t   <div class=\"col-xs-8\">\r\n");
      out.write("\t      注册\r\n");
      out.write("\t   </div>\r\n");
      out.write("\t   <div class=\"col-xs-2\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"container model\">\r\n");
      out.write("\t\t<div class=\"col-xs-6 model1\">邮箱注册</div>\r\n");
      out.write("  \t\t<div class=\"col-xs-6 model2\">手机注册</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- 邮箱注册 -->\r\n");
      out.write("\t<div class=\"container\" id=\"form-div\">\r\n");
      out.write("\t\t<form role=\"form\">\r\n");
      out.write("\t\t  <div class=\"form-group\">\r\n");
      out.write("\t\t    <label for=\"name\">邮箱：</label>\r\n");
      out.write("\t\t    <input type=\"text\" class=\"form-control\" name=\"email\" id=\"name\" placeholder=\"请输入常用邮箱\">\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t  <div class=\"form-group\">\r\n");
      out.write("\t\t    <label for=\"inputfile\">密码：</label>\r\n");
      out.write("\t\t    <input type=\"password\" class=\"form-control\" name=\"pword\" id=\"name\" placeholder=\"6到16位英文数字密码，区分大小写\">\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t  <div class=\"form-group\">\r\n");
      out.write("\t\t    <label for=\"inputfile\">验证码：</label>\r\n");
      out.write("\t\t    <input type=\"text\" class=\"form-control\" id=\"name\" style=\"width:120px;\">\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t  <button type=\"button\" name=\"regist\" class=\"btn btn-primary btn-block\">注册</button>\r\n");
      out.write("\t\t  <div style=\"margin-top:20px;\">\r\n");
      out.write("\t\t     <span>我已阅读标<a href=\"#\">微博协议</a>并同意遵守协议</span><input type=\"radio\" name=\"select\" style=\"width:13px;height:13px;\">\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- 手机注册 -->\r\n");
      out.write("\t<div class=\"container\" id=\"mb-form-div\">\r\n");
      out.write("\t\t<div class=\"col-xs-2 mb-prefix1 mb-prefix\">0086</div>\r\n");
      out.write("\t\t<div class=\"col-xs-9 mb-prefix2 mb-prefix\">中国大陆</div>\r\n");
      out.write("\t\t<div class=\"col-xs-1 mb-prefix3 mb-prefix\">></div>\r\n");
      out.write("\t\t<form role=\"form\">\r\n");
      out.write("\t\t  <div class=\"form-group\">\r\n");
      out.write("\t\t    <label for=\"name\">手机号：</label>\r\n");
      out.write("\t\t    <input type=\"text\" class=\"form-control\" name=\"phone\" placeholder=\"请输入手机号码\">\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t  <div class=\"form-group\">\r\n");
      out.write("\t\t    <label for=\"inputfile\">密码：</label>\r\n");
      out.write("\t\t    <input type=\"password\" class=\"form-control\" name=\"pword\" placeholder=\"6到16位英文数字密码，区分大小写\">\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t  <button type=\"button\" name=\"getCode\" class=\"btn btn-primary btn-block\">获取短信验证码</button>\r\n");
      out.write("\t\t  <div style=\"margin-top:20px;\">\r\n");
      out.write("\t\t     <span>我已阅读标<a href=\"#\">微博协议</a>并同意遵守协议</span><input type=\"radio\" name=\"select\" style=\"width:13px;height:13px;\">\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t<!-- 显示其他国家或地区 -->\r\n");
      out.write("\t\t<div id=\"area-div\">\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li><span>中国大陆</span><input type=\"radio\" name=\"area\" checked=\"checked\" value=\"中国大陆\"></li>\r\n");
      out.write("\t\t\t\t<li><span>香港地区</span><input type=\"radio\" name=\"area\" value=\"香港地区\"></li>\r\n");
      out.write("\t\t\t\t<li><span>台湾地区</span><input type=\"radio\" name=\"area\" value=\"台湾地区\"></li>\r\n");
      out.write("\t\t\t\t<li><span>澳门地区</span><input type=\"radio\" name=\"area\" value=\"澳门地区\"></li>\r\n");
      out.write("\t\t\t\t<li><span>日本</span><input type=\"radio\" name=\"area\" value=\"日本\"></li>\r\n");
      out.write("\t\t\t\t<li><span>韩国</span><input type=\"radio\" name=\"area\" value=\"韩国\"></li>\r\n");
      out.write("\t\t\t\t<li><span>新加坡</span><input type=\"radio\" name=\"area\" value=\"新加坡\"></li>\r\n");
      out.write("\t\t\t\t<li><span>马来西亚</span><input type=\"radio\" name=\"area\" value=\"马来西亚\"></li>\r\n");
      out.write("\t\t\t\t<li><span>美国</span><input type=\"radio\" name=\"area\" value=\"美国\"></li>\r\n");
      out.write("\t\t\t\t<li><span>加拿大</span><input type=\"radio\" name=\"area\" value=\"加拿大\"></li>\r\n");
      out.write("\t\t\t\t<li><span>澳大利亚</span><input type=\"radio\" name=\"area\" value=\"澳大利亚\"></li>\r\n");
      out.write("\t\t\t\t<li><span>英国</span><input type=\"radio\" name=\"area\" value=\"英国\"></li>\r\n");
      out.write("\t\t\t\t<li><span>法国</span><input type=\"radio\" name=\"area\" value=\"法国\"></li>\r\n");
      out.write("\t\t\t\t<li><span>德国</span><input type=\"radio\" name=\"area\" value=\"德国\"></li>\r\n");
      out.write("\t\t\t\t<li><span>俄罗斯</span><input type=\"radio\" name=\"area\" value=\"俄罗斯\"></li>\r\n");
      out.write("\t\t\t\t<li><span>印度</span><input type=\"radio\" name=\"area\" value=\"印度\"></li>\r\n");
      out.write("\t\t\t\t<li><span>泰国</span><input type=\"radio\" name=\"area\" value=\"泰国\"></li>\r\n");
      out.write("\t\t\t\t<li><span>巴西</span><input type=\"radio\" name=\"area\" value=\"巴西\"></li>\r\n");
      out.write("\t\t\t\t<li><span>瑞典</span><input type=\"radio\" name=\"area\" value=\"瑞典\"></li>\r\n");
      out.write("\t\t\t\t<li><span>土耳其</span><input type=\"radio\" name=\"area\" value=\"土耳其\"></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn btn-default\" name=\"cancle\">取消</button>\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn btn-default\" name=\"sure\">确定</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 电脑版 -->\r\n");
      out.write("     <div id=\"mainDiv\">\r\n");
      out.write("        <div id=\"mainTop\">\r\n");
      out.write("           <div class=\"topCont\"><a style=\"border-bottom:3px solid  #ffa00a\">个人注册</a></div>\r\n");
      out.write("           <div class=\"topCont\" style=\"padding-left:20px;color:gray;font-weight:bold;\">|</div>\r\n");
      out.write("           <div class=\"topCont\" style=\"padding-left:20px\"><a>官方注册</a></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- 主题内容左边 -->\r\n");
      out.write("        <div id=\"mainLeft\">\r\n");
      out.write("           <div id=\"mainLeftDiv\">\r\n");
      out.write("             <div id=\"line1\" class=\"line\">\r\n");
      out.write("                <div class=\"tag\">邮箱：</div>\r\n");
      out.write("                <input name=\"email\" class=\"pc_email\" placeholder=\"请输入常用邮箱\">\r\n");
      out.write("             </div>\r\n");
      out.write("             <div style=\"margin:0px 0px 10px 82px;font-size:14px;\">\r\n");
      out.write("                或使用<a href=\"#\">手机注册</a>\r\n");
      out.write("             </div>\r\n");
      out.write("             <div id=\"line2\" class=\"line\">\r\n");
      out.write("                <div class=\"tag\">密码：</div>\r\n");
      out.write("                <input type=\"password\" class=\"pc_pword\" name=\"pword\" placeholder=\"6到16位英文数字密码，区分大小写\">\r\n");
      out.write("             </div>\r\n");
      out.write("             <div id=\"line3\" class=\"line\">\r\n");
      out.write("                <div class=\"tag\">验证码：</div>\r\n");
      out.write("                <input type=\"text\" style=\"width:74px;height:30px;\">\r\n");
      out.write("                <img src=\"\" id=\"verifyCodeImg\">\r\n");
      out.write("                <input type=\"hidden\">\r\n");
      out.write("             </div>\r\n");
      out.write("             <div id=\"line4\" class=\"line\">\r\n");
      out.write("             \t<div class=\"tag\"></div>\r\n");
      out.write("                <button id=\"pc_submit\" type=\"button\" class=\"btn btn-warning\" style=\"width:200px;\">立即注册</button>\r\n");
      out.write("             </div>\r\n");
      out.write("             <div class=\"line4\">\r\n");
      out.write("             \t<div class=\"tag\" style=\"height:1px;\"></div>\r\n");
      out.write("             \t<div style=\"display:inline-block\">\r\n");
      out.write("             \t\t<p><a href=\"http://weibo.com/signup/v5/protocol\" target=\"_blank\">微博服务使用协议</a></p>\r\n");
      out.write("             \t\t<p><a href=\"http://weibo.com/signup/v5/privacy\" target=\"_blank\">微博个人信息保护政策</a></p>\r\n");
      out.write("             \t\t<p><a href=\"http://news.sina.com.cn/c/2012-12-29/051425921660.shtml\" target=\"_blank\">全国人大常委会关于加强网络信息保护的决定</a></p>\r\n");
      out.write("             \t</div>\r\n");
      out.write("             </div>\r\n");
      out.write("           </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("         <!-- 电脑页面，主体右边 -->\r\n");
      out.write("\t     <div id=\"mainRight\">\r\n");
      out.write("\t     \t<div>\r\n");
      out.write("\t     \t\t<p>已有账号，请<a href=\"index.jsp\">直接登录</a></p>\r\n");
      out.write("\t     \t</div>\r\n");
      out.write("\t     \t<div id=\"help-div\">\r\n");
      out.write("\t     \t\t<p>微博注册帮助</p>\r\n");
      out.write("\t     \t\t<p><a href=\"http://help.weibo.com/faq/q/76/15955#15955\" target=\"_blank\">1、微博注册帮助指南</a></p>\r\n");
      out.write("\t     \t\t<p><a href=\"http://help.weibo.com/faq/q/200/13091#13091\" target=\"_blank\">2、手机注册时提示手机号码已被绑定怎么办</a></p>\r\n");
      out.write("\t     \t\t<p><a href=\"http://help.weibo.com/faq/q/200/276#276\" target=\"_blank\">3、注册微博时昵称显示“已经被注册”该如何处理</a></p>\r\n");
      out.write("\t     \t\t<p><a href=\"http://help.weibo.com/faq/q/200/13043#13043\" target=\"_blank\">4、注册时提示你所用的ip异常该怎么办</a></p>\r\n");
      out.write("\t     \t\t<p><a href=\"http://help.weibo.com/faq/q/201\" target=\"_blank\">更多帮助>></a></p>\r\n");
      out.write("\t     \t</div>\r\n");
      out.write("\t     </div>\r\n");
      out.write("     </div>\r\n");
      out.write("    <!-- 电脑页面底部 -->\r\n");
      out.write("    <footer>\r\n");
      out.write("    \t<div style=\"float:left;\">\r\n");
      out.write("    \t\t<p>广州标新网络技术有限公司&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("    \t\t大粤网[2016]0003-719号&nbsp;粤ICP备201430260259号</p> \t\t\r\n");
      out.write("    \t</div>\r\n");
      out.write("    \t<div style=\"float:right;\">\r\n");
      out.write("    \t\t<p>Copyright © 2016-2018 WEIBO</p>\r\n");
      out.write("    \t</div>\r\n");
      out.write("    </footer>\r\n");
      out.write("     <script type=\"text/javascript\" src=\"/billblog-manager-controller/resource/js/jquery.min.js\" ></script>\r\n");
      out.write("\t <script type=\"text/javascript\" src=\"/billblog-manager-controller/resource/js/bootstrap.min.js\" ></script>\r\n");
      out.write("\t <script type=\"text/javascript\" src=\"/billblog-manager-controller/resource/js/common/common.js\"></script>\r\n");
      out.write("\t <script type=\"text/javascript\" src=\"/billblog-manager-controller/resource/js/regist/regist_personal.js\"></script>\t \r\n");
      out.write("\t <script type=\"text/javascript\">\r\n");
      out.write("\t \tvar wid = parseInt($(window).width());\r\n");
      out.write("\t \t$(\"#area-div\").css(\"left\",(wid-270)/2);\r\n");
      out.write("\t \tgetVerifyCode();//获取验证码\r\n");
      out.write("\t </script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
