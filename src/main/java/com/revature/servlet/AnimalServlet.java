package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.revature.model.Animal;
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
		resp.setContentType("text/xml");
		PrintWriter pw = resp.getWriter();
//		pw.println(aService.getAnimals());
//		pw.close();
		List<Animal> animals = aService.getAnimals();
		
		ObjectMapper om = new XmlMapper();
		String obj = om.writeValueAsString(animals.get(0));
		pw.println(obj);
		pw.close();
	}
}
