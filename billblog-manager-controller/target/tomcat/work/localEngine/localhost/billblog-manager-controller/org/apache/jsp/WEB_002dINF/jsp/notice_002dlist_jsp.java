package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class notice_002dlist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fend_005fbegin;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fend_005fbegin = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fend_005fbegin.release();
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
      out.write("<link rel=\"stylesheet\" href=\"/billblog-manager-controller/resource/css/common/main-common.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/billblog-manager-controller/resource/css/home/home.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/billblog-manager-controller/resource/css/common/home-common.css\">\r\n");
      out.write("<title>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${other_user_base_info.userNickname}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("的微博</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!-- 导航栏 -->\r\n");
      out.write("\t<!-- 导航栏 -->\r\n");
      out.write("\t<div class=\"row navbar-fixed-top\" id=\"nav\"> \r\n");
      out.write("\t\t<div class=\"container\" id=\"nav-con\">\r\n");
      out.write("\t\t\t<!-- logo -->\r\n");
      out.write("\t\t\t<div class=\"col-md-2 col-xs-9\" id=\"logo\">\r\n");
      out.write("\t\t\t\t<a href=\"/billblog-manager-controller/weibocontroller/tomainpage.do\">\r\n");
      out.write("\t\t\t\t\t<img alt=\"\" src=\"/billblog-manager-controller/resource/image/s_weibo.png\">\r\n");
      out.write("\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t<input id=\"hiddenId\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${other_user_base_info.userId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
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
      out.write("\t\t\t\t\t\t<span>\r\n");
      out.write("\t\t\t\t\t\t\t<a id=\"mynicknameA\"\r\n");
      out.write("\t\t\t\t\t\t\thref=\"/billblog-manager-controller/weibocontroller/tohomepage.do?userId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" \r\n");
      out.write("\t\t\t\t\t\t\tclass=\"dropdown-toggle\">\r\n");
      out.write("\t\t\t\t\t\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_base_info.userNickname}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t</span>\r\n");
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
      out.write("\t\t\t\t\t\t<a role=\"menuitem\" tabindex=\"-1\" href=\"javascript:void(0)\" onclick=\"showWriteWeiboDiv()\">\r\n");
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
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${other_user_base_info.userId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<span style=\"color:blue;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${other_user_base_info.userNickname}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write('粉');
      out.write('丝');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_fans_sum}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t\t</a>\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li role=\"presentation\">\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<a href=\"/billblog-manager-controller/attentioncontroller/tonoticelistpage.do?userId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${other_user_base_info.userId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<span style=\"color:blue;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${other_user_base_info.userNickname}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write('关');
      out.write('注');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_noticed_sum}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t\t</a>\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li role=\"presentation\">\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<a href=\"/billblog-manager-controller/weibocontroller/tohomepage.do?userId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${other_user_base_info.userId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<span style=\"color:blue;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${other_user_base_info.userNickname}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write('微');
      out.write('博');
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
      out.write("\t<!-- 顶部背景 -->\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<!-- 第一行 -->\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<div class=\"col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1\" id=\"top-bg-div\">\r\n");
      out.write("\t\t\t\t<!-- 头像 -->\r\n");
      out.write("\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t<a href=\"/billblog-manager-controller/weibocontroller/tohomepage.do?userId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_info.userId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${other_user_base_info.userHeadimage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t</a>\t\t\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!-- 昵称 -->\r\n");
      out.write("\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t<h3><a id=\"nicknameA\" href=\"/billblog-manager-controller/weibocontroller/tohomepage.do?userId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${other_user_base_info.userId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write('"');
      out.write('>');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${other_user_base_info.userNickname}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</a></h3>\r\n");
      out.write("\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_c_005fif_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- 第三行 -->\r\n");
      out.write("\t\t<div class=\"row\" style=\"margin-top:20px;\">\r\n");
      out.write("\t\t\t<div class=\"col-md-offset-1 col-md-3 col-sm-offset-1 col-sm-3\" id=\"left-div\">\r\n");
      out.write("\t\t\t\t<!-- 微博、粉丝、关注、 -->\r\n");
      out.write("\t\t\t\t<div class=\"container-fluid\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-xs-4\">\r\n");
      out.write("\t\t\t\t\t\t<div><a href=\"/billblog-manager-controller/attentioncontroller/tofanslistpage.do?userId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${other_user_base_info.userId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">粉丝</a></div>\r\n");
      out.write("\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"/billblog-manager-controller/attentioncontroller/tofanslistpage.do?userId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${other_user_base_info.userId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_fans_sum}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-xs-4\">\r\n");
      out.write("\t\t\t\t\t\t<div><a style=\"color:red;\" href=\"/billblog-manager-controller/attentioncontroller/tonoticelistpage.do?userId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${other_user_base_info.userId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">关注</a></div>\r\n");
      out.write("\t\t\t\t\t\t<div><a style=\"color:red;\" href=\"/billblog-manager-controller/attentioncontroller/tonoticelistpage.do?userId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${other_user_base_info.userId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write('"');
      out.write('>');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_noticed_sum}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</a></div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-xs-4\">\r\n");
      out.write("\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"tohomepage.do?userId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${other_user_base_info.userId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">微博</a>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"tohomepage.do?userId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${other_user_base_info.userId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write('"');
      out.write('>');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${weibo_sum}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</a>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!-- 等级信息 -->\r\n");
      out.write("\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t<h4>等级信息</h4>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t<p style=\"margin-top:20px;\">当前等级：Lv ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_base_info.userLevel}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\t\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- 主体内容 -->\r\n");
      out.write("\t\t\t<div class=\"col-md-7 col-sm-7\" id=\"main-div\">\r\n");
      out.write("\t\t\t\t<!-- 粉丝列表 -->\r\n");
      out.write("\t\t\t\t<div id=\"content-outer\">\r\n");
      out.write("\t\t\t\t\t<!-- 具体信息 -->\t\t\t\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!--分页-->\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<a href=\"javascript:void(0)\" onclick=\"getNoticeListByPre()\">上一页</a>\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fif_005f3(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fif_005f4(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t<a href=\"javascript:void(0)\" onclick=\"getNoticeListByAfter()\">下一页</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
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
      out.write("<script type=\"text/javascript\" src=\"/billblog-manager-controller/resource/js/jquery.min.js\" ></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/billblog-manager-controller/resource/js/bootstrap.min.js\" ></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/billblog-manager-controller/resource/js/main/main.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/billblog-manager-controller/resource/js/home/home.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/billblog-manager-controller/resource/js/relative/relative.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/billblog-manager-controller/resource/js/relative/notice-list.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(\"#searchImg\").click(function(){\r\n");
      out.write("\t\t$(\"#searchForm\").submit();\r\n");
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

  private boolean _jspx_meth_c_005fset_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent(null);
    // /WEB-INF/jsp/notice-list.jsp(146,6) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("flagSignature");
    // /WEB-INF/jsp/notice-list.jsp(146,6) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/jsp/notice-list.jsp(146,6) '0'",_el_expressionfactory.createValueExpression("0",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /WEB-INF/jsp/notice-list.jsp(147,6) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_info.userSignature eq null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t");
        if (_jspx_meth_c_005fset_005f1(_jspx_th_c_005fif_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t编辑您的个性签名\r\n");
        out.write("\t\t\t\t\t\t");
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

  private boolean _jspx_meth_c_005fset_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f0);
    // /WEB-INF/jsp/notice-list.jsp(148,7) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setVar("flagSignature");
    // /WEB-INF/jsp/notice-list.jsp(148,7) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/jsp/notice-list.jsp(148,7) '1'",_el_expressionfactory.createValueExpression("1",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f1 = _jspx_th_c_005fset_005f1.doStartTag();
    if (_jspx_th_c_005fset_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f1);
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
    // /WEB-INF/jsp/notice-list.jsp(151,6) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${flagSignature eq 0}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_info.userSignature}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\r\n");
        out.write("\t\t\t\t\t\t");
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

  private boolean _jspx_meth_c_005fif_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f2.setParent(null);
    // /WEB-INF/jsp/notice-list.jsp(155,5) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${other_user_base_info.userId ne user_id}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
    if (_jspx_eval_c_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t<div>\r\n");
        out.write("\t\t\t\t\t\t\t<button id=\"noticeAId\" onclick=\"notice(");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${other_user_base_info.userId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write(",this)\" class=\"btn btn-info\" style=\"display:none;\">关注</button>\r\n");
        out.write("\t\t\t\t\t\t\t<button id=\"avoidNoticeAId\" onclick=\"avoidNotice(");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${other_user_base_info.userId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write(",this)\" class=\"btn btn-success\" style=\"display:none;\">已关注</button>\r\n");
        out.write("\t\t\t\t\t\t\t<button id=\"avoidNoticeAIdEach\" onclick=\"avoidNotice(");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${other_user_base_info.userId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write(",this)\" class=\"btn btn-default\" style=\"display:none;\">互相关注</button>\r\n");
        out.write("\t\t\t\t\t\t</div>\r\n");
        out.write("\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f3.setParent(null);
    // /WEB-INF/jsp/notice-list.jsp(212,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_noticed_sum%5 eq 0}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f3 = _jspx_th_c_005fif_005f3.doStartTag();
    if (_jspx_eval_c_005fif_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t");
        if (_jspx_meth_c_005fset_005f2(_jspx_th_c_005fif_005f3, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f2 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f3);
    // /WEB-INF/jsp/notice-list.jsp(213,5) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f2.setVar("pageNum");
    // /WEB-INF/jsp/notice-list.jsp(213,5) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f2.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/jsp/notice-list.jsp(213,5) '${user_noticed_sum/5}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${user_noticed_sum/5}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f2 = _jspx_th_c_005fset_005f2.doStartTag();
    if (_jspx_th_c_005fset_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f4 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f4.setParent(null);
    // /WEB-INF/jsp/notice-list.jsp(215,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f4.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_noticed_sum%5 ne 0}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f4 = _jspx_th_c_005fif_005f4.doStartTag();
    if (_jspx_eval_c_005fif_005f4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t");
        if (_jspx_meth_c_005fset_005f3(_jspx_th_c_005fif_005f4, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f4);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f4, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f3 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f4);
    // /WEB-INF/jsp/notice-list.jsp(216,5) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f3.setVar("pageNum");
    // /WEB-INF/jsp/notice-list.jsp(216,5) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f3.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/jsp/notice-list.jsp(216,5) '${1+user_noticed_sum/5}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${1+user_noticed_sum/5}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f3 = _jspx_th_c_005fset_005f3.doStartTag();
    if (_jspx_th_c_005fset_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fend_005fbegin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/jsp/notice-list.jsp(218,4) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVarStatus("number");
    // /WEB-INF/jsp/notice-list.jsp(218,4) name = begin type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setBegin(1);
    // /WEB-INF/jsp/notice-list.jsp(218,4) name = end type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setEnd(((java.lang.Integer) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageNum}", java.lang.Integer.class, (PageContext)_jspx_page_context, null, false)).intValue());
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t<a href=\"javascript:void(0)\" onclick=\"getNoticeListDataByNum('");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${number.index}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("')\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${number.index}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</a>\r\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fend_005fbegin.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}
