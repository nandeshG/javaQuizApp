package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Alien;
import com.example.demo.service.AlienService;

@RestController
@RequestMapping("alien")
public class AlienController {
	
	@Autowired
	AlienService alienService;
	
	@GetMapping("/")
	public List<Alien> getAllAlien(){
		List<Alien> a = alienService.getAlien();
		
		return a;
	}

}
