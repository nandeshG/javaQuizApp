package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Alien;
import com.example.demo.dao.AlienRepo;

@Service
public class AlienService {
	
	@Autowired
	AlienRepo alienRepo;
	
	public List<Alien> getAlien() {
		return 	alienRepo.findAll();
	}

}
