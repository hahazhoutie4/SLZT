package com.zhoutong.interceptors;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.zhoutong.service.XiangmuTemplate;
import com.zhoutong.util.Encrypt;

public class Login extends HandlerInterceptorAdapter{
	
	@Resource(name="xiangmuService")
	private XiangmuTemplate xiangmuTemplate;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("Login Interceptors");
		boolean s=false;
		if(request.getRequestURI().contains("index")||request.getRequestURI().contains("validate")) {
			System.out.println("index page or validate page!!");
			return true;
		}
		Cookie[] cookie=request.getCookies();
		if(cookie==null) {
			System.out.println("no cookie , redirect to login page.");
			response.sendRedirect(request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/"+"index");
			return false;
			}
		for(Cookie c:cookie) {
			if("up##".equals(c.getName())) {
				s=!s;
				System.out.println("login validate pass!!");
				break;
		}
		}
		if(!s) {
			System.out.println("redirect to login page!!!");
			response.sendRedirect(request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/"+"index");
		}
		return s;
	}
}