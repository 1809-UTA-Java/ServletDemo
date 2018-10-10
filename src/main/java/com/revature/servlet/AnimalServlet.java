package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.repository.AnimalDao;
import com.revature.service.AnimalService;

@SuppressWarnings("serial")
@WebServlet("/animals")
public class AnimalServlet extends HttpServlet {
	
	AnimalDao dao = new AnimalDao();
	AnimalService aService = new AnimalService(dao);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		pw.println(aService.getAnimals());
		pw.close();
	}
}
