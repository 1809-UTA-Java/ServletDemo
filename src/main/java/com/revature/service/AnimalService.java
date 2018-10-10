package com.revature.service;

import java.util.List;

import com.revature.model.Animal;
import com.revature.repository.AnimalDao;

public class AnimalService {
	AnimalDao dao;
	
	public AnimalService(AnimalDao dao) {
		this.dao = dao;
	}
	
	public List<Animal> getAnimals() {
		return dao.getAnimals();
	}

}
