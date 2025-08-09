package com.wipro.bhanu.quizmonorepo.service;

import com.wipro.bhanu.quizmonorepo.entity.Quiz;
import com.wipro.bhanu.quizmonorepo.entity.Question;
import com.wipro.bhanu.quizmonorepo.entity.Response;
import com.wipro.bhanu.quizmonorepo.exception.ResourceNotFoundException;
import com.wipro.bhanu.quizmonorepo.repository.QuizRepository;
import com.wipro.bhanu.quizmonorepo.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Quiz createQuiz(String title, String category, String difficulty) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Quiz title cannot be empty");
        }
        List<Question> questions = questionRepository.findRandomQuestionsByCategoryAndDifficulty(category, difficulty);
        if (questions.isEmpty()) {
            throw new ResourceNotFoundException("No questions found for category: " + category + " and difficulty: " + difficulty);
        }
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        return quizRepository.save(quiz);
    }

    @Override
    public Quiz getQuizById(Integer id) {
        return quizRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz not found with id: " + id));
    }

    @Override
    public int submitQuiz(Integer quizId, List<Response> responses) {
        if (responses == null || responses.isEmpty()) {
            throw new IllegalArgumentException("Responses cannot be empty");
        }
        Quiz quiz = getQuizById(quizId);
        int score = 0;
        Map<Long, String> answerMap = quiz.getQuestions().stream()
                .collect(Collectors.toMap(Question::getId, Question::getCorrectAnswer));
        for (Response response : responses) {
            if (response.getId() == null || response.getResponse() == null) {
                continue; // Skip invalid responses
            }
            Long questionId = response.getId();
            String userAnswer = response.getResponse();
            String correctAnswer = answerMap.get(questionId);
            if (correctAnswer != null && correctAnswer.equals(userAnswer)) {
                score++;
            }
        }
        return score;
    }
}

