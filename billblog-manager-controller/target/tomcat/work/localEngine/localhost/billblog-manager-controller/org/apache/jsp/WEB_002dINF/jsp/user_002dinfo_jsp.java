package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class user_002dinfo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
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
      out.write("<link rel=\"stylesheet\" href=\"/billblog-manager-controller/resource/css/common/main-common.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/billblog-manager-controller/resource/css/home/home.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/billblog-manager-controller/resource/css/common/home-common.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/billblog-manager-controller/resource/css/user-info/user-info.css\">\r\n");
      out.write("<title>孙悟空的微博</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<!-- 导航栏 -->\r\n");
      out.write("\t<div class=\"row navbar-fixed-top\" id=\"nav\"> \r\n");
      out.write("\t\t<div class=\"container\" id=\"nav-con\">\r\n");
      out.write("\t\t\t<!-- logo -->\r\n");
      out.write("\t\t\t<div class=\"col-md-2 col-xs-9\" id=\"logo\">\r\n");
      out.write("\t\t\t\t<img alt=\"\" src=\"/billblog-manager-controller/resource/image/s_weibo.png\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- 输入栏 -->\r\n");
      out.write("\t\t\t<div class=\"col-md-5 hidden-sm hidden-xs\">\r\n");
      out.write("\t\t\t\t<div id=\"search-div\">\r\n");
      out.write("\t\t\t\t\t<input>\r\n");
      out.write("\t\t\t\t\t<img alt=\"\" src=\"/billblog-manager-controller/resource/image/search.png\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- 右边的菜单,中等屏幕时显示 -->\r\n");
      out.write("\t\t\t<div class=\"col-md-5 hidden-sm hidden-xs\">\r\n");
      out.write("\t\t\t\t<div class=\"container-fluid\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-md-2 nav-right\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"main.jsp\" class=\"dropdown-toggle\">\r\n");
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
      out.write("\t\t\t\t\t\t<span><a href=\"#\" class=\"dropdown-toggle\">昵称到今年考九年级看你空间</a></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-md-2 nav-right\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"#\" class=\"dropdown-toggle\">设置</a>\r\n");
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
      out.write("\t\r\n");
      out.write("\t<!-- 顶部背景 -->\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<!-- 第一行 -->\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<div class=\"col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1\" id=\"top-bg-div\">\r\n");
      out.write("\t\t\t\t<!-- 头像 -->\r\n");
      out.write("\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_base_info.userHeadimage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!-- 昵称 -->\r\n");
      out.write("\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t<h3>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_base_info.userNickname}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</h3>\r\n");
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
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- 第二行 -->\r\n");
      out.write("\t\t<!-- 功能选项 -->\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<div class=\"col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1 func-select-div\">\r\n");
      out.write("\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-xs-4\"><a href=\"home.jsp\">我的微博</a></div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-xs-4\"><a href=\"photo.jsp\">我的相册</a></div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-xs-4\">管理中心</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- 第三行 -->\r\n");
      out.write("\t\t<div class=\"row\" style=\"margin-top:20px;\">\r\n");
      out.write("\t\t\t<div class=\"col-md-offset-1 col-md-3 col-sm-offset-1 col-sm-3\" id=\"left-div\">\r\n");
      out.write("\t\t\t\t<!-- 微博、粉丝、关注、 -->\r\n");
      out.write("\t\t\t\t<div class=\"container-fluid\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-xs-4\">\r\n");
      out.write("\t\t\t\t\t\t<div>粉丝</div>\r\n");
      out.write("\t\t\t\t\t\t<div>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_fans_sum}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-xs-4\">\r\n");
      out.write("\t\t\t\t\t\t<div>关注</div>\r\n");
      out.write("\t\t\t\t\t\t<div>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_noticed_sum}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-xs-4\">\r\n");
      out.write("\t\t\t\t\t\t<div>微博</div>\r\n");
      out.write("\t\t\t\t\t\t<div>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${weibo_sum}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</div>\r\n");
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
      out.write("\t\t\t\t<!-- 个人信息部分 -->\r\n");
      out.write("\t\t\t\t<div id=\"content-outer\">\r\n");
      out.write("\t\t\t\t\t<!-- 基本信息 -->\r\n");
      out.write("\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t<span>基本信息</span>\r\n");
      out.write("\t\t\t\t\t\t\t&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t<button>编辑</button>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>昵称</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span id=\"userNickname\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_base_info.userNickname}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>所在地</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span id=\"userAddress\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_info.userAddress}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>性别</span>\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t<span id=\"userSex\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_info.userSex}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>性取向</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span id=\"userTropism\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_info.userTropism}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>感情状况</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span id=\"userLoveState\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_info.userLovestate}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>生日</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span id=\"userBirthday\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_info.userBirthday}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>注册时间</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_base_info.userDatetime}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>毕业学校</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span id=\"userSchool\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_info.userSchool}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>工作</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span id=\"userPosition\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_info.userPosition}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<!-- 其他信息 -->\r\n");
      out.write("\t\t\t\t</div>\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- 隐藏起来的 -->\r\n");
      out.write("\t\t\t\t\t<div class=\"col-md-7 col-sm-7\" id=\"main-display-div\" style=\"display:none;\">\r\n");
      out.write("\t\t\t\t\t\t<!-- 个人信息部分 -->\r\n");
      out.write("\t\t\t\t\t\t<!-- ajax提交表单 -->\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<!-- 基本信息 -->\r\n");
      out.write("\t\t\t\t\t\t<div id=\"content-display-outer\">\r\n");
      out.write("\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>基本信息</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t\t<button id=\"saveInfo\">保存</button>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<form id=\"userInfoForm\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span>昵称</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input name=\"userNickname\" value=\"2395956@ww.cpm\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span>个性签名</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input name=\"userSignature\" value=\"这是个性签名！\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span>所在地</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input name=\"userAddress\" value=\"广西钦州\">\r\n");
      out.write("\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span>性别</span>\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input name=\"userSex\" type=\"radio\" value=\"0\">男\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input name=\"userSex\" type=\"radio\" value=\"1\">女\r\n");
      out.write("\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span>性取向</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<select name=\"userTropism\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"0\">异性恋</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"1\">双性恋</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"2\">同性恋</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span>感情状况</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<select name=\"userLovestate\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"0\">单身</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"1\">恋爱中</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"2\">已婚</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"3\">离异</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span>生日</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input name=\"userBirthday\" value=\"1995-11-04\">\r\n");
      out.write("\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span>注册时间</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span>2017-01-18</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span>学校</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input name=\"userSchool\" value=\"钦州市第二中学\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span>工作</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input name=\"userPosition\" value=\"软件架构师\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</form>\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<!-- 其他信息 -->\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
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
      out.write("<script type=\"text/javascript\" src=\"/billblog-manager-controller/resource/js/user-info/user-info.js\"></script>\r\n");
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
    // /WEB-INF/jsp/user-info.jsp(116,6) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("flagSignature");
    // /WEB-INF/jsp/user-info.jsp(116,6) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/jsp/user-info.jsp(116,6) '0'",_el_expressionfactory.createValueExpression("0",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
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
    // /WEB-INF/jsp/user-info.jsp(117,6) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
    // /WEB-INF/jsp/user-info.jsp(118,7) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setVar("flagSignature");
    // /WEB-INF/jsp/user-info.jsp(118,7) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/jsp/user-info.jsp(118,7) '1'",_el_expressionfactory.createValueExpression("1",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
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
    // /WEB-INF/jsp/user-info.jsp(121,6) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${flagAddress eq 0}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
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
}
