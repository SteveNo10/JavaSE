package com.ifnoelse.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserMyMathBean extends HttpServlet {

	private static final long serialVersionUID = 3946145456335465989L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int a = Integer.parseInt(req.getParameter("param1"));
		int b = Integer.parseInt(req.getParameter("param2"));
		PrintWriter writer = resp.getWriter();
		resp.setContentType("text/html");
		writer.println("<html><head><title></title></head><body><table width='200' border='1' align='center'>");
		writer.println("<tr><td width='100'>add</td><td width='100'>" + MyMath.Add(a, b) + "</td></tr>");
		writer.println("<tr><td width='100'>Sub</td><td width='100'>" + MyMath.Sub(a, b) + "</td></tr>");
		writer.println("<tr><td width='100'>Mul</td><td width='100'>" + MyMath.Mul(a, b) + "</td></tr>");
		writer.println("</table></body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	
}
