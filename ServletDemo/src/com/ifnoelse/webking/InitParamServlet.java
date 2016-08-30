package com.ifnoelse.webking;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitParamServlet extends HttpServlet {

	private static final long serialVersionUID = 1284818043964212426L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		resp.setContentType("text/html");
		
		PrintWriter pw = resp.getWriter();
		pw.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		pw.println("<HTML>");
		pw.println("<HEAD><TITLE>Please Check Notice File</TITLE></HEAD>");
		pw.println("<style>body,td,div{font-size:12px;}</style>");
		pw.println("<BODY>");
		pw.println("<form action='" + req.getRequestURL() + "' method='post'>");
		pw.println("ACCOUNT:<input type='text' name='username' style='width:200px;'><br/>");
		pw.println("PASSWORD:<input type='text' name='password' stype='width:200px;'><br/><br/>");
		pw.println("<input type='submit' value=' LogIn '>");
		pw.println("</form>");
		pw.println("</BODY>");
		pw.println("</HTML>");
		
		pw.flush();
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		Enumeration<String> params = this.getInitParameterNames();
		
		while(params.hasMoreElements()) {
			String usernameParam = (String)params.nextElement();
			String passwordParam = this.getInitParameter(usernameParam);
			
			if(usernameParam.equalsIgnoreCase(username) && passwordParam.equals(password)) {
				req.getRequestDispatcher("/WEB-INF/notice.html").forward(req, resp);
				return;
			}
		}
	}

	
}
