package com.ifnoelse.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SetSession extends HttpServlet {

	private static final long serialVersionUID = -2336136634124604022L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession(true);
		int count = 0;
		String title = "Welcome First Time!";
		if(httpSession.getAttribute("count") == null) {
			httpSession.setAttribute("count", count);
		}
		else {
			count = Integer.parseInt(httpSession.getAttribute("count").toString());
			count++;
			httpSession.setAttribute("count", count);
			title = "Welcome Back!";
		}
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.println("<html><head><title>Session Test</title></head><body><table align='center' border='1' width='200'>");
		pw.println("<tr><td width='100'>" + title + "</td><td width='100'>" + count + "</td></tr>");
		pw.println("<tr><td width='100'>session.getId</td><td width='100'>" + httpSession.getId() + "</td></tr>");
		pw.println("<tr><td width='100'>getRequestedSessionId</td><td width='100'>" + req.getRequestedSessionId() + "</td></tr>");
		pw.println("<tr><td width='100'>session.getCreationTime</td><td width='100'>" + new Date(httpSession.getCreationTime()) + "</td></tr>");
		pw.println("<tr><td width='100'>session.getLastAccessedTime</td><td width='100'>" + new Date(httpSession.getLastAccessedTime()) + "</td></tr>");
		pw.println("<tr><td width='100'>isRequestedSessionIdFromCookie</td><td width='100'>" + req.isRequestedSessionIdFromCookie() + "</td></tr>");
		pw.println("<tr><td width='100'>isRequestedSessionIdFromURL</td><td width='100'>" + req.isRequestedSessionIdFromURL() + "</td></tr>");
		pw.println("<tr><td width='100'>isRequestedSessionIdValid</td><td width='100'>" + req.isRequestedSessionIdValid() + "</td></tr>");
		pw.println("</body></html>");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
