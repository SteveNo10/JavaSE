package com.ifnoelse.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContext extends HttpServlet {

	private static final long serialVersionUID = -6410987767173338374L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		javax.servlet.ServletContext servletContext = this.getServletContext();
		int count = 1;
		if(servletContext.getAttribute("count") == null) {
			servletContext.setAttribute("count", count);
		}
		else {
			count = Integer.parseInt(servletContext.getAttribute("count").toString());
			++count;
			servletContext.setAttribute("count", count);
		}
		
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.println("<html><head><title>Servlet Context</title></head><body>");
		writer.println("<table width='200' align='center' border='1'>");
		writer.println("<tr><td width='100'>getContextPath</td><td width='100'>" + servletContext.getContextPath() + "</td></tr>");
		writer.println("<tr><td width='100'>count</td><td width='100'>" + count + "</td></tr>");
		writer.println("</table></body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
