package com.dev.api.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class GlobalInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String contextPath = request.getContextPath();
		if(response.getStatus() == 404) {
			response.sendRedirect(contextPath + "/index");
			return false;
		}
		return true;
	}
	
}
