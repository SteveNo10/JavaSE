package com.ifnoelse.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetCookies extends HttpServlet {

	private static final long serialVersionUID = 1154684763431958842L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		for(int i=0; i<3; ++i) {
			Cookie cookieShort = new Cookie("Age-short-cookie-key"+i, "Age-short-cookie-value"+i);
			cookieShort.setMaxAge(10);
			resp.addCookie(cookieShort);
			
			Cookie cookieLong = new Cookie("Age-long-cookie-key"+i, "Age-long-cookie-value"+i);
			cookieLong.setMaxAge(10000);
			resp.addCookie(cookieLong);
		}
		
		resp.getWriter().println("add Cookies success!");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
}
