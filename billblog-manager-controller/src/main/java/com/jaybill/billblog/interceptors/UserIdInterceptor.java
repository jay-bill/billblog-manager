package com.jaybill.billblog.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 除了RegistController、LoginController之外，全部请求都被拦截
 * @author jaybill
 *
 */
public class UserIdInterceptor implements HandlerInterceptor {

	/**
	 * 在方法执行之前拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		//判断是否在浏览器中登录
		HttpSession session = request.getSession();
		if(session==null||session.getAttribute("user_id")==null){
			//重定向到index.jsp
			response.sendRedirect("/billblog-manager-controller/index.jsp");
			return false;
		}
		long userId = (long)session.getAttribute("user_id");
		if(userId<=0){ //如果userId不存在，
			//重定向到index.jsp：使用servlet原生方法时，
			//重定向的根目录是localhost:8080/
			//使用springmvc时，
			//转发和重定向的根目录都是当前工程，如localhost:8080/billblog-manager-controller/
			response.sendRedirect("/billblog-manager-controller/index.jsp");
			return false;
		}
		return true; //执行后续的操作，不仅仅是后面两个方法，还包括被拦截的url对应的方法
	}
	
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}
}
