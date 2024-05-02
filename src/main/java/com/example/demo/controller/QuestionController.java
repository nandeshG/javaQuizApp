package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Question;
import com.example.demo.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	QuestionService service;
	
	@GetMapping("allQuestions")
	public ResponseEntity<List<Question>> getAllQuestions() {
		return service.getAllQuestions();
	}
	
	@PostMapping("add")
	public ResponseEntity<Question> addQuestion(@RequestBody Question q) {
		return service.addQuestion(q);
		
	}
	
	@GetMapping("category/{category}")
	public ResponseEntity<List<Question>> getquestionByCategory(@PathVariable String category){
		return service.getQuestionByCategory(category);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Question> getQuestionById(@PathVariable int id){
		return service.getQuestionById(id);
	}
	

}
