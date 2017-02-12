package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      out.write("<link rel=\"SHORTCUT ICON\" href=\"/billblog-manager-controller/resource/image/s_blog.ico\">\r\n");
      out.write("<link rel=\"BOOKMARK\" href=\"/billblog-manager-controller/resource/image/s_blog.ico\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/billblog-manager-controller/resource/css/bootstrap.min.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/billblog-manager-controller/resource/css/common/common.css\"></link>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/billblog-manager-controller/resource/css/main/main.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/billblog-manager-controller/resource/css/common/main-common.css\">\r\n");
      out.write("<title>微博-随时随地发现新鲜事儿</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<!-- 导航栏 -->\r\n");
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
      out.write("\t\t\t\t\t</div>\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"col-md-2 nav-right spe-nav-right\">\r\n");
      out.write("\t\t\t\t\t\t<span>\r\n");
      out.write("\t\t\t\t\t\t\t<a id=\"mynicknameA\" href=\"/billblog-manager-controller/weibocontroller/tohomepage.do?userId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\t\t class=\"dropdown-toggle\">\r\n");
      out.write("\t\t\t\t\t\t\t ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_base_info.userNickname}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t</span>\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-md-2 nav-right\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"/billblog-manager-controller/weibocontroller/toreadinfo.do\" class=\"dropdown-toggle\">\r\n");
      out.write("\t\t\t\t          @我\r\n");
      out.write("\t\t\t\t\t\t  ");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t                \t</a>\r\n");
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
      out.write("\t\t\t\t\t\t<a role=\"menuitem\" tabindex=\"-1\" href=\"/billblog-manager-controller/weibocontroller/tomainpage.do\">\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"glyphicon glyphicon-home\"></span>&nbsp;首页\r\n");
      out.write("\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li role=\"presentation\">\r\n");
      out.write("\t\t\t\t\t\t<a role=\"menuitem\" tabindex=\"-1\" href=\"/billblog-manager-controller/weibocontroller/tohomepage.do?userId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"\tglyphicon glyphicon-facetime-video\"></span>&nbsp;主页\r\n");
      out.write("\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li role=\"presentation\">\r\n");
      out.write("\t\t\t\t\t\t<a role=\"menuitem\" tabindex=\"-1\" href=\"/billblog-manager-controller/imagecontroller/tophotopage.do?userId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"glyphicon glyphicon-eye-open\"></span>&nbsp;相册\r\n");
      out.write("\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li role=\"presentation\">\r\n");
      out.write("\t\t\t\t\t\t<a role=\"menuitem\" tabindex=\"-1\" href=\"/billblog-manager-controller/weibocontroller/toreadinfo.do\" class=\"dropdown-toggle\">\r\n");
      out.write("\t\t\t\t          @我\r\n");
      out.write("\t\t\t\t          ");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\t\t\t\t          \r\n");
      out.write("\t                \t</a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li role=\"presentation\">\r\n");
      out.write("\t\t\t\t\t\t<a role=\"menuitem\" tabindex=\"-1\" href=\"/billblog-manager-controller/writeWeibo.jsp\">\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"glyphicon glyphicon-eye-open\"></span>&nbsp;写微博\r\n");
      out.write("\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li role=\"presentation\">\r\n");
      out.write("\t\t\t\t\t\t<a role=\"menuitem\" tabindex=\"-1\" href=\"javascript:void(0)\" onclick=\"showSearchDiv()\">\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"glyphicon glyphicon-eye-open\"></span>&nbsp;搜索\r\n");
      out.write("\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li role=\"presentation\">\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<a id=\"mynicknameA\" role=\"menuitem\" tabindex=\"-1\" \r\n");
      out.write("\t\t\t\t\t\thref=\"/billblog-manager-controller/weibocontroller/tohomepage.do?userId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t<span style=\"color:blue;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_base_info.userNickname}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t\t</a>\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li role=\"presentation\" class=\"divider\"></li>\r\n");
      out.write("\t\t\t\t\t<li role=\"presentation\">\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<a href=\"/billblog-manager-controller/attentioncontroller/tofanslistpage.do?userId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<span style=\"color:blue;\">粉丝");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_fans_sum}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t\t</a>\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li role=\"presentation\">\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<a href=\"/billblog-manager-controller/attentioncontroller/tonoticelistpage.do?userId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<span style=\"color:blue;\">关注");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_noticed_sum}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t\t</a>\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li role=\"presentation\">\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<a href=\"/billblog-manager-controller/weibocontroller/tohomepage.do?userId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<span style=\"color:blue;\">微博");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${weibo_sum}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t\t</a>\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li role=\"presentation\" class=\"divider\"></li>\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<li role=\"presentation\">\r\n");
      out.write("\t\t\t\t\t\t<a role=\"menuitem\" tabindex=\"-1\" href=\"/billblog-manager-controller/logincontroller/loginout\">登出</a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\t<!-- 主题内容 -->\r\n");
      out.write("\t<div class=\"container\" id=\"main-outer\">\r\n");
      out.write("\t\t<div class=\"container-fluid\">\r\n");
      out.write("\t\t\t<div class=\"container-fluid\" id=\"main-con\">\r\n");
      out.write("\t\t\t\t<div class=\"col-md-2 hidden-xs col-sm-2\">\r\n");
      out.write("\t\t\t\t\t<ul id=\"left-ul\">\r\n");
      out.write("\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t<a role=\"menuitem\" tabindex=\"-1\" href=\"/billblog-manager-controller/weibocontroller/tomainpage.do\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span></span>&nbsp;首页\r\n");
      out.write("\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t<a role=\"menuitem\" tabindex=\"-1\" href=\"/billblog-manager-controller/weibocontroller/tohomepage.do?userId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"glyphicon glyphicon-eye-open\"></span>&nbsp;我的主页\r\n");
      out.write("\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t<a role=\"menuitem\" tabindex=\"-1\" href=\"/billblog-manager-controller/imagecontroller/tophotopage.do?userId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"glyphicon glyphicon-eye-open\"></span>&nbsp;我的相册\r\n");
      out.write("\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t<a role=\"menuitem\" tabindex=\"-1\" href=\"#\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"glyphicon glyphicon-eye-open\"></span>&nbsp;热门微博\r\n");
      out.write("\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"col-md-7 col-sm-10 col-xs-12\" id=\"center-div\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<!-- 微博输入框 -->\r\n");
      out.write("\t\t\t\t\t<form class=\"hidden-xs\" id=\"input-text-div\" action=\"broadcastweibo.do\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("\t\t\t\t\t\t<p>有什么新鲜事儿想告诉大家</p>\r\n");
      out.write("\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t<textarea name=\"weiboContent\"></textarea>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"container-fluid\" id=\"input-text-under\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-10\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"javascript:void(0)\">表情</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"javascript:void(0)\">图片</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a>视频</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a>话题</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input name=\"weiboImages\" type=\"file\" multiple  id=\"uploadImages\" accept=\"image/*\" onchange=\"setImagePreview(this)\" style=\"display:none;\"/>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input id=\"broadcast\" type=\"submit\" class=\"btn btn-sm btn-warning\" style=\"float:right;\" value=\"发布 \">\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<!-- 预览栏 -->\r\n");
      out.write("\t\t\t\t\t\t<div id=\"previewDiv\">\r\n");
      out.write("\t\t\t\t\t\t\t<img id=\"previewImg\" src=\"\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<!-- 微博正文部分 -->\r\n");
      out.write("\t\t\t\t\t<div id=\"content-outer\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" id=\"hiddenId\">\r\n");
      out.write("\t\t\t\t\t\t<!-- 待填充 -->\r\n");
      out.write("\t\t\t\t\t</div>\t\t\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"col-md-3 hidden-sm hidden-xs\" id=\"right-div\">\r\n");
      out.write("\t\t\t\t\t<!-- 用户信息 -->\r\n");
      out.write("\t\t\t\t\t<div id=\"user-info-div\">\r\n");
      out.write("\t\t\t\t\t\t<div></div>\r\n");
      out.write("\t\t\t\t\t\t<!-- 用户头像 -->\r\n");
      out.write("\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"tohomepage.do?userId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_base_info.userId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"><img id=\"myHeadimage\" title=\"我的主页\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_base_info.userHeadimage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"></a>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<div style=\"margin-top:-30px;text-align:center;\">\r\n");
      out.write("\t\t\t\t\t\t\t<p><a id=\"nicknameA\" href=\"tohomepage.do?userId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_base_info.userId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write('"');
      out.write('>');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_base_info.userNickname}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</a></p>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"container-fluid\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"col-xs-4 nums-div\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"/billblog-manager-controller/attentioncontroller/tonoticelistpage.do?userId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write('"');
      out.write('>');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_noticed_sum}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"/billblog-manager-controller/attentioncontroller/tonoticelistpage.do?userId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">关注</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"col-xs-4 nums-div\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"/billblog-manager-controller/attentioncontroller/tofanslistpage.do?userId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write('"');
      out.write('>');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_fans_sum}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"/billblog-manager-controller/attentioncontroller/tofanslistpage.do?userId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">粉丝</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"col-xs-4 nums-div\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"tohomepage.do?userId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_base_info.userId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write('"');
      out.write('>');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${weibo_sum}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</a>\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"tohomepage.do?userId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_base_info.userId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">微博</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<!-- 热门话题 -->\r\n");
      out.write("\t\t\t\t\t<div id=\"hot-topic-div\">\r\n");
      out.write("\t\t\t\t\t\t<div>热门话题<a style=\"float:right;\">换一换</a></div>\r\n");
      out.write("\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a>#电视剧漂亮的李慧珍#</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a>#低调组合起点终点#</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a>#图书馆派对堪比春运#</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a>#言情小说吸粉套路#</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a>#电视剧漂亮的李慧珍#</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a>#低调组合起点终点#</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a>#图书馆派对堪比春运#</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a>#言情小说吸粉套路#</a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t<p style=\"text-align:center;\">\r\n");
      out.write("\t\t\t\t\t\t\t<a>查看更多></a>\r\n");
      out.write("\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<!-- 广告位 -->\r\n");
      out.write("\t\t\t\t\t<div id=\"advertise-div\">\r\n");
      out.write("\t\t\t\t\t\t<div>热门商品推荐</div>\r\n");
      out.write("\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t<img alt=\"\" src=\"/billblog-manager-controller/resource/image/adv.jpg\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
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
      out.write("\t\t\t<p>\r\n");
      out.write("\t\t\t\t联系QQ:2399599130，\r\n");
      out.write("\t\t\t\t电话：18813296645\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</footer>\r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/billblog-manager-controller/resource/js/jquery.min.js\" ></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/billblog-manager-controller/resource/js/bootstrap.min.js\" ></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/billblog-manager-controller/resource/js/main/main.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/billblog-manager-controller/resource/js/like/like-weibo.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/billblog-manager-controller/resource/js/comments/comments-ajax.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/billblog-manager-controller/resource/js/main/main-ajax.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(\"#searchImg\").click(function(){\r\n");
      out.write("\t\t$(\"#searchForm\").submit();\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t//头像旋转\r\n");
      out.write("\t$(\"#myHeadimage\").mouseenter(function(){\r\n");
      out.write("\t\t$(this).addClass(\"headRotate\");\r\n");
      out.write("\t});\r\n");
      out.write("\t$(\"#myHeadimage\").mouseleave(function(){\r\n");
      out.write("\t\t$(this).addClass(\"headLeaveRotate\");\r\n");
      out.write("\t\t$(this).removeClass(\"headRotate\");\r\n");
      out.write("\t\tvar tmp = $(this);\r\n");
      out.write("\t\tsetTimeout(function(){\r\n");
      out.write("\t\t\ttmp.removeClass(\"headLeaveRotate\");\r\n");
      out.write("\t\t},150);\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t//logo翻转\r\n");
      out.write("\t$(\"#logo img\").mouseenter(function(){\r\n");
      out.write("\t\t$(this).addClass(\"rotateYLogo\");\r\n");
      out.write("\t});\r\n");
      out.write("\t$(\"#logo img\").mouseleave(function(){\r\n");
      out.write("\t\t$(this).addClass(\"rotatoYLogoLeave\");\r\n");
      out.write("\t\t$(this).removeClass(\"rotateYLogo\");\r\n");
      out.write("\t\tvar tmp = $(this);\r\n");
      out.write("\t\tsetTimeout(function(){\r\n");
      out.write("\t\t\ttmp.removeClass(\"rotatoYLogoLeave\");\r\n");
      out.write("\t\t},600); \r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
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

  private boolean _jspx_meth_c_005fif_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /WEB-INF/jsp/main.jsp(63,8) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${no_read_sum > 0}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t          \t<span style=\"font-weight:bold;color:red;font-family:'微软雅黑'\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${no_read_sum}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</span>\r\n");
        out.write("\t\t\t\t          ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent(null);
    // /WEB-INF/jsp/main.jsp(97,14) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${no_read_sum > 0}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t          \t<span style=\"font-weight:bold;color:red;font-family:'微软雅黑'\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${no_read_sum}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</span>\r\n");
        out.write("\t\t\t\t          ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }
}
