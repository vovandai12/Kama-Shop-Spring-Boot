package com.example.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.model.User;
import com.example.service.SessionService;

@Service
public class AuthInterceptor implements HandlerInterceptor {

	@Autowired
	SessionService session;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		User user = session.get("user");
		String error = "";
		if (user == null)
			error = "Please login!";
		else if (!user.isRole())
			error = "Access denied!";
		if (error.length() > 0) {
			session.set("security-uri", uri);
			response.sendRedirect("/auth/admin/login?error=" + error);
			return false;
		}
		return true;
	}
}
