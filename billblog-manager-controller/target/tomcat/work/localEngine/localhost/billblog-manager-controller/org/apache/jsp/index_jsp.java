package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no\"/>\r\n");
      out.write("<link rel=\"SHORTCUT ICON\" href=\"resource/image/s_blog.ico\">\r\n");
      out.write("<link rel=\"BOOKMARK\" href=\"resource/image/s_blog.ico\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"resource/css/bootstrap.min.css\" />\r\n");
      out.write("<title>微博-随时随地发现新鲜事儿</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"resource/css/common/common.css\"></link>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"resource/css/index/index.css\"></link>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!-- 导航栏 -->\r\n");
      out.write("\t<div class=\"row navbar-fixed-top\" id=\"nav\"> \r\n");
      out.write("\t\t<div class=\"container\" id=\"nav-con\">\r\n");
      out.write("\t\t\t<!-- logo -->\r\n");
      out.write("\t\t\t<div class=\"col-md-2 col-xs-9\" id=\"logo\">\r\n");
      out.write("\t\t\t\t<a href=\"/billblog-manager-controller/weibocontroller/tomainpage.do\">\r\n");
      out.write("\t\t\t\t\t<img alt=\"\" src=\"/billblog-manager-controller/resource/image/s_weibo.png\">\r\n");
      out.write("\t\t\t\t</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- 输入栏 -->\r\n");
      out.write("\t\t\t<form id=\"searchForm\" class=\"col-md-5 hidden-sm hidden-xs\" action=\"/billblog-manager-controller/searchcontroller/searchUser.do\">\r\n");
      out.write("\t\t\t\t<div id=\"search-div\">\r\n");
      out.write("\t\t\t\t\t<input name=\"userNickname\">\r\n");
      out.write("\t\t\t\t\t<img id=\"searchImg\" alt=\"\" src=\"/billblog-manager-controller/resource/image/search.png\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t<!-- 右边的菜单,中等屏幕时显示 -->\r\n");
      out.write("\t\t\t<div class=\"col-md-5 hidden-sm hidden-xs\">\r\n");
      out.write("\t\t\t\t<div class=\"container-fluid\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-md-2 nav-right\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"/billblog-manager-controller/weibocontroller/tomainpage.do\" class=\"dropdown-toggle\">\r\n");
      out.write("\t\t\t\t          <span class=\"glyphicon glyphicon-home\"></span>&nbsp;首页\r\n");
      out.write("\t               \t\t</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-md-2 nav-right\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"#\" class=\"dropdown-toggle\">\r\n");
      out.write("\t\t\t\t          <span class=\"\tglyphicon glyphicon-facetime-video\"></span>&nbsp;视频\r\n");
      out.write("\t                \t</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-md-2 nav-right\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"#\" class=\"dropdown-toggle\">\r\n");
      out.write("\t\t\t\t          <span class=\"\tglyphicon glyphicon-eye-open\"></span>&nbsp;发现\r\n");
      out.write("\t                \t</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-md-2 nav-right\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"#\" class=\"dropdown-toggle\">\r\n");
      out.write("\t\t\t\t          <span class=\"\tglyphicon glyphicon-gift\"></span>&nbsp;游戏\r\n");
      out.write("\t                \t</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-md-2 nav-right spe-nav-right\">\r\n");
      out.write("\t\t\t\t\t\t<span><a href=\"#\" class=\"dropdown-toggle\">昵称</a></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-md-2 nav-right\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"/billblog-manager-controller/logincontroller/loginout\" class=\"dropdown-toggle\">注销</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- 右边菜单，小屏幕时显示 -->\r\n");
      out.write("\t\t\t<div class=\"col-xs-3 hidden-md hidden-lg nav-right dropdown\">\r\n");
      out.write("\t\t\t\t<a class=\"btn btn-info btn-sm dropdown-toggle\" data-toggle=\"dropdown\">\r\n");
      out.write("\t\t\t\t\t<span class=\"glyphicon glyphicon-align-justify\"></span>&nbsp;菜单\r\n");
      out.write("\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t<ul class=\"dropdown-menu dropdown-menu-right \" role=\"menu\" aria-labelledby=\"dropdownMenu1\">\r\n");
      out.write("\t\t\t\t\t<li role=\"presentation\">\r\n");
      out.write("\t\t\t\t\t\t<a role=\"menuitem\" tabindex=\"-1\" href=\"#\">\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"glyphicon glyphicon-home\"></span>&nbsp;首页\r\n");
      out.write("\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li role=\"presentation\">\r\n");
      out.write("\t\t\t\t\t\t<a role=\"menuitem\" tabindex=\"-1\" href=\"#\">\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"\tglyphicon glyphicon-facetime-video\"></span>&nbsp;视频\r\n");
      out.write("\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li role=\"presentation\">\r\n");
      out.write("\t\t\t\t\t\t<a role=\"menuitem\" tabindex=\"-1\" href=\"#\">\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"\tglyphicon glyphicon-eye-open\"></span>&nbsp;发现\r\n");
      out.write("\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li role=\"presentation\">\r\n");
      out.write("\t\t\t\t\t\t<a role=\"menuitem\" tabindex=\"-1\" href=\"#\">\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"\tglyphicon glyphicon-gift\"></span>&nbsp;游戏\r\n");
      out.write("\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li role=\"presentation\" class=\"divider\"></li>\r\n");
      out.write("\t\t\t\t\t<li role=\"presentation\">\r\n");
      out.write("\t\t\t\t\t\t<a role=\"menuitem\" tabindex=\"-1\" href=\"#\">登录</a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li role=\"presentation\">\r\n");
      out.write("\t\t\t\t\t\t<a role=\"menuitem\" tabindex=\"-1\" href=\"#\">注册</a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t<!-- 主题内容 -->\r\n");
      out.write("\t<div class=\"container\" id=\"main-outer\">\r\n");
      out.write("\t\t<div class=\"container-fluid\">\r\n");
      out.write("\t\t\t<div class=\"container-fluid\" id=\"main-con\">\r\n");
      out.write("\t\t\t\t<div class=\"col-md-2 hidden-xs hidden-sm\">\r\n");
      out.write("\t\t\t\t\t<ul id=\"left-ul\">\r\n");
      out.write("\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t<a role=\"menuitem\" tabindex=\"-1\" href=\"#\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"\tglyphicon glyphicon-eye-open\"></span>&nbsp;热门\r\n");
      out.write("\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t<a role=\"menuitem\" tabindex=\"-1\" href=\"#\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"\tglyphicon glyphicon-eye-open\"></span>&nbsp;热门\r\n");
      out.write("\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t<a role=\"menuitem\" tabindex=\"-1\" href=\"#\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"\tglyphicon glyphicon-eye-open\"></span>&nbsp;热门\r\n");
      out.write("\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t<a role=\"menuitem\" tabindex=\"-1\" href=\"#\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"\tglyphicon glyphicon-eye-open\"></span>&nbsp;热门\r\n");
      out.write("\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"col-md-7 hidden-xs hidden-sm\" id=\"center-div\">\r\n");
      out.write("\t\t\t\t\t<div class=\"content\">\r\n");
      out.write("\t\t\t\t\t\t老司机...老司机...为了江苏台跨年晚会的收视率，SNH48的妹子们也是把偶像包袱都丢光了吧\r\n");
      out.write("\t\t\t\t\t\t昨晚，TFBOYS参加了#湖南卫视跨年# 演唱会，不仅带来《是你》和新歌《萤火》首唱，三人也\r\n");
      out.write("\t\t\t\t\t\t分别献唱个人单曲；还与现场前辈及观众共同迎接零点[羞嗒嗒]今晚七点半锁定湖南卫\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"col-md-3 col-sm-12 col-xs-12\">\r\n");
      out.write("\t\t\t\t\t<div id=\"right-div\">\r\n");
      out.write("\t\t\t\t\t\t<span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${login_error}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t\t<form class=\"form-horizontal\" role=\"form\" action=\"logincontroller/login\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t  <div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t    <div class=\"col-md-6 col-sm-6 col-xs-12\">\r\n");
      out.write("\t\t\t\t\t\t      \t<div  style=\"border-bottom:3px solid #fa7d3c;text-align:center;\">\r\n");
      out.write("\t\t\t\t\t\t      \t\t账号登录\r\n");
      out.write("\t\t\t\t\t\t      \t</div>\r\n");
      out.write("\t\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t\t    <div class=\"col-md-6 col-sm-6 hidden-xs\">\r\n");
      out.write("\t\t\t\t\t\t      \t<div  style=\"text-align:center;\">\r\n");
      out.write("\t\t\t\t\t\t      \t\t安全登录\r\n");
      out.write("\t\t\t\t\t\t      \t</div>\r\n");
      out.write("\t\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t\t  </div>\r\n");
      out.write("\t\t\t\t\t\t  <div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t    <div class=\"col-sm-12\">\r\n");
      out.write("\t\t\t\t\t\t      <input type=\"text\" class=\"form-control\" name=\"userAccount\" placeholder=\"请输入账号\">\r\n");
      out.write("\t\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t\t  </div>\r\n");
      out.write("\t\t\t\t\t\t  <div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t    <div class=\"col-sm-12\">\r\n");
      out.write("\t\t\t\t\t\t      <input type=\"password\" class=\"form-control\" name=\"userPassword\" placeholder=\"请输入密码\">\r\n");
      out.write("\t\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t\t  </div>\r\n");
      out.write("\t\t\t\t\t\t  <div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t    <div class=\"col-sm-12\">\r\n");
      out.write("\t\t\t\t\t\t      <input type=\"submit\" class=\"btn btn-primary btn-warning btn-block\"/>\r\n");
      out.write("\t\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t\t  </div>\r\n");
      out.write("\t\t\t\t\t\t  <div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t    <div class=\"col-sm-12\">\r\n");
      out.write("\t\t\t\t\t\t    \t<p>还没有微博？<a href=\"regist.jsp\">立即注册！</a></p>\r\n");
      out.write("\t\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t\t  </div>\r\n");
      out.write("\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 页尾 -->\r\n");
      out.write("\t<footer class=\"hidden-xs hidden-sm\">\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<span>微博客服</span>\r\n");
      out.write("\t\t\t<span>意见反馈</span>\r\n");
      out.write("\t\t\t<span>舞弊举报</span>\r\n");
      out.write("\t\t\t<span>开方平台</span>\r\n");
      out.write("\t\t\t<span>微博招聘</span>\r\n");
      out.write("\t\t\t<span>服务大厅</span>\r\n");
      out.write("\t\t\t<p>\r\n");
      out.write("\t\t\t\t<span>粤ICP证100780号</span>\r\n");
      out.write("\t\t\t\t<span>大粤网201430260259号</span>\r\n");
      out.write("\t\t\t\t<span>Copyright © 2017-2018 WEIBO 广州标新科技网络技术有限公司</span>\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</footer>\r\n");
      out.write("</body>\r\n");
      out.write("\t <script type=\"text/javascript\" src=\"/billblog-manager-controller/resource/js/jquery.min.js\" ></script>\r\n");
      out.write("\t <script type=\"text/javascript\" src=\"/billblog-manager-controller/resource/js/bootstrap.min.js\" ></script>\r\n");
      out.write("\t <script type=\"text/javascript\">\r\n");
      out.write("\t    $(window).scroll(function(){\r\n");
      out.write("\t    \tvar h = $(window).scrollTop();\r\n");
      out.write("\t    \tif(parseInt(h)>340){\r\n");
      out.write("\t    \t\t$(\"#right-div\").css(\"position\",\"relative\");\r\n");
      out.write("\t    \t\t$(\"#right-div\").css(\"top\",parseInt(h));\r\n");
      out.write("\t    \t\t$(\"#left-ul\").css(\"position\",\"relative\");\r\n");
      out.write("\t    \t\t$(\"#left-ul\").css(\"top\",parseInt(h));\r\n");
      out.write("\t    \t\t\r\n");
      out.write("\t    \t}else{\r\n");
      out.write("\t    \t\t$(\"#right-div\").css(\"position\",\"static\");\r\n");
      out.write("\t    \t\t$(\"#left-ul\").css(\"position\",\"static\");\r\n");
      out.write("\t    \t}\r\n");
      out.write("\t    });\r\n");
      out.write("\t </script>\r\n");
      out.write("\t <script type=\"text/javascript\">\r\n");
      out.write("\t\t$(\"#searchImg\").click(function(){\r\n");
      out.write("\t\t\t$(\"#searchForm\").submit();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t</script>\r\n");
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
