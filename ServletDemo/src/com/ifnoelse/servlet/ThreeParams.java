package com.ifnoelse.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThreeParams extends HttpServlet {
	private static final long serialVersionUID = -3311040306819461830L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.println("<html><body>");
		pw.println(req.getParameter("param1"));
		pw.println("<br/>");
		pw.println(req.getParameter("param2"));
		pw.println("<br/>");
		pw.println(req.getParameter("param3"));
		System.out.println("GetParams");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
