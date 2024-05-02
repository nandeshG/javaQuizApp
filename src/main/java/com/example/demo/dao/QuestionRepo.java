package com.example.demo.dao;



import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {

	public List<Question> findByCategory(String category);

	@Query(value = "SELECT * FROM questions q where q.category=:category ORDER BY RANDOM() LIMIT :qNum",nativeQuery = true)
	public List<Question> findRandomByCategory(String category, int qNum);
}
