package com.wipro.bhanu.quizmonorepo.repository;

import com.wipro.bhanu.quizmonorepo.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {
}