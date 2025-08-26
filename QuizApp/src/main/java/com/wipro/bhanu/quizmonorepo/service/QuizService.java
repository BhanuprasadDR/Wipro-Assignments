package com.wipro.bhanu.quizmonorepo.service;

import java.util.List;

import com.wipro.bhanu.quizmonorepo.entity.Quiz;
import com.wipro.bhanu.quizmonorepo.entity.Response;

public interface QuizService {
    Quiz createQuiz(String title, String category, String difficulty);
    Quiz getQuizById(Integer id);
    int submitQuiz(Integer quizId, List<Response> responses);
}