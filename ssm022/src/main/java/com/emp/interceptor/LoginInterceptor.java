package com.emp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author Administrator
 * 登陆拦截器
 */
public class LoginInterceptor implements HandlerInterceptor{

	/**
	 * 1.preHandle在业务处理器处理请求之前被调用
	 * 2.postHandle在业务处理器处理请求执行完成后,生成视图之前执行
	 * 3.afterCompletion在DispatcherServlet完全处理完请求后被调用,可用于清理资源等 
	 *   afterCompletion()执行完成后开始渲染页面
	 *  
	 * preHandle--->/emp/conditionList--->postHandle--->生成ListEmp.jsp(html)
	 * --->afterCompletion --->向浏览器回传html
	 */
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	/*
	 * return true 不拦截 放行 调用业务组件 比如/emp/condition
	 * return false 拦截 不调用业务组件
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) throws Exception {
		Object user = request.getSession().getAttribute("user");
		if(user!=null){
			return true;
		}
		//转发到Login.jsp
		//绑定错误消息
		request.setAttribute("msg", "请先登陆");
		String appName = request.getServletContext().getContextPath();
		System.out.println("appName=============="+appName);
		request.getRequestDispatcher("/user/toLogin").forward(request, response);
		return false;
	}
	
}
