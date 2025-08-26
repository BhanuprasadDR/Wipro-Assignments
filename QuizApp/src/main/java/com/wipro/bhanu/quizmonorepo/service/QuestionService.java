package com.wipro.bhanu.quizmonorepo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wipro.bhanu.quizmonorepo.entity.Question;
import com.wipro.bhanu.quizmonorepo.enums.Category;

public interface QuestionService {
	   Question addQuestion(Question question);
	    Page<Question> getAllQuestions(Pageable pageable);
	    Question getQuestionById(Long id);
	    Question updateQuestion(Long id, Question question);
	    Question partialUpdateQuestion(Long id, Question question);
	    void deleteQuestion(Long id);
	    List<Question> getQuestionsByCategory(Category category);
	    List<Long> getQuestionsForQuiz(String category, String difficultyLevel);
}
