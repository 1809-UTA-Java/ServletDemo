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
@WebServlet("/animals/*")
public class AnimalServlet extends HttpServlet {
	
	AnimalDao dao = new AnimalDao();
	AnimalService aService = new AnimalService(dao);
	
	// For GET /animals/
	// GET /animals/123
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String path = req.getPathInfo();
		
		resp.setContentType("text/xml");
		PrintWriter pw = resp.getWriter();
		
		List<Animal> animals = aService.getAnimals();
		ObjectMapper om = new XmlMapper();
		
		if(path == null || path.equals("/")) {
			String obj = om.writeValueAsString(animals);
			pw.println(obj);
			return;
		}
		
		String[] pathSplits = path.split("/");
		
		if(pathSplits.length != 2) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		int animalId = Integer.parseInt(pathSplits[1]);
		Animal found = null;
		for (Animal a : animals) {
			if (a.getId() == animalId) {
				found = a;
			}
		}
		
		if(found != null) {
			String obj = om.writeValueAsString(found);
			pw.println(obj);
		}
		
		pw.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		Animal input = new Animal(0, "T", 5, 5);
		
		aService.createAnimal(input);
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String path = req.getPathInfo();
		
		resp.setContentType("text/xml");
		
		List<Animal> animals = aService.getAnimals();
		
		String[] pathSplits = path.split("/");
		
		if(pathSplits.length != 2) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		int animalId = Integer.parseInt(pathSplits[1]);
		Animal found = null;
		for (Animal a : animals) {
			if (a.getId() == animalId) {
				found = a;
			}
		}
		
		if(found != null) {
			aService.deleteAnimal(found);
		}
	}
}
