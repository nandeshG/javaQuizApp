package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Question;
import com.example.demo.QuestionWrapper;
import com.example.demo.Quiz;
import com.example.demo.UserResponse;
import com.example.demo.dao.QuestionRepo;
import com.example.demo.dao.QuizRepo;

@Service
public class QuizService {
	
	@Autowired
	QuizRepo quizRepo;
	
	@Autowired
	QuestionRepo qRepo;

	public ResponseEntity<String> createQuiz(String category, int qNum, String title) {
		// TODO Auto-generated method stub
		Quiz q =new Quiz();
		q.setTitle(title);
		List<Question> questions= qRepo.findRandomByCategory(category,qNum);
		q.setQuestion(questions);
		quizRepo.save(q);
		return new ResponseEntity<>("created",HttpStatus.CREATED);		
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		// TODO Auto-generated method stub
		Optional<Quiz> q = quizRepo.findById(id);
		List<Question> questionFromDB = q.get().getQuestion();
		List<QuestionWrapper> qw = new ArrayList<>();
		for(Question wr:questionFromDB) {
			QuestionWrapper wrap = new QuestionWrapper(wr.getId(), wr.getQuestionTitle(), wr.getOption1(), wr.getOption2(), wr.getOption3(), wr.getOption4());
			qw.add(wrap);
		}
		return new ResponseEntity<List<QuestionWrapper>>(qw,HttpStatus.OK);
	}

	public ResponseEntity<Integer> calcScore(Integer id, List<UserResponse> response) {
		// TODO Auto-generated method stub
		Quiz quiz = quizRepo.findById(id).get();
		List<Question> q = quiz.getQuestion();
		int right = 0;
		int i=0;
		for(UserResponse r:response) {
				if(r.getResponse().equals(q.get(i).getRightAnswer()))
					right++;
				i++;
			
		
		}
		return new ResponseEntity<>(right,HttpStatus.OK);
	}
	
	

}
