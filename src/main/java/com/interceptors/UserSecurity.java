package com.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class UserSecurity extends HandlerInterceptorAdapter{

	final static Logger logger=Logger.getLogger("UserSecurity.class");
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession httpsession=request.getSession();
		String email = (String) httpsession.getAttribute("email");
		if(email==null || email.isEmpty()) {
			ModelAndView mv = new ModelAndView("login");
			
			logger.error(" please login first");
			mv.addObject("msg", "please login first");
			throw new ModelAndViewDefiningException(mv);
			
		}else {
			
			return true;
		}
	}
}
