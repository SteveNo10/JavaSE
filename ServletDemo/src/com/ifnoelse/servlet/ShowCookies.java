package com.ifnoelse.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowCookies extends HttpServlet {

	private static final long serialVersionUID = -7657917635709043107L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.println("<html><body><table align='center' border='1' width='200'>");
		for(Cookie cookie : cookies) {
			writer.println("<tr><td width='100'>" + cookie.getName() + "</td><td width='100'>" + cookie.getValue() + "</td></tr>");
		}
		writer.println("</table></body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
