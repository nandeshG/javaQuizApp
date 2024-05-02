package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Question;
import com.example.demo.dao.QuestionRepo;

@Service
public class QuestionService {
	
	@Autowired
	QuestionRepo repo;
	
	public ResponseEntity<List<Question>> getAllQuestions() {
			try {
				return new ResponseEntity<List<Question>>(repo.findAll(), HttpStatus.OK);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return new ResponseEntity<List<Question>>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}
	
	
	public ResponseEntity<Question>	addQuestion(Question q){
		
		try {
			return new ResponseEntity<>(repo.save(q),HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Question>(new Question(),HttpStatus.BAD_REQUEST);
	}
	

	public ResponseEntity<List<Question>> getQuestionByCategory(String category){		
		try {
			return new ResponseEntity<List<Question>>(repo.findByCategory(category), HttpStatus.OK);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<List<Question>>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}
	
	
	public ResponseEntity<Question> getQuestionById(int id){		
		try {
			return new ResponseEntity<>(repo.findById(id).orElse(new Question()),HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Question>(new Question(),HttpStatus.BAD_REQUEST);
	}
	
}


