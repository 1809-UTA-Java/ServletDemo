package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class DemoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		String arg1 = req.getParameter("name");
		String arg2 = req.getParameter("age");
		if (arg1 == null)
			arg1 = getServletContext().getInitParameter("DefaultName");
		if (arg2 == null)
			arg2 = getServletConfig().getInitParameter("DefaultAge");
		if (req.getAttribute("forred") != null)
			pw.println("This is a forwarded response");
		pw.println("GET " + arg1 + " you are " + arg2);
		pw.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		String arg1 = req.getParameter("name");
		String arg2 = req.getParameter("age");
		pw.println("POST " + arg1 + " you are " + arg2);
		pw.close();
	}
}
