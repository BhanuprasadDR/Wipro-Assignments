package com.wipro.bhanu.quizmonorepo.service;

import com.wipro.bhanu.quizmonorepo.entity.Question;
import com.wipro.bhanu.quizmonorepo.enums.Category;
import com.wipro.bhanu.quizmonorepo.exception.ResourceNotFoundException;
import com.wipro.bhanu.quizmonorepo.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Page<Question> getAllQuestions(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }

    @Override
    public Question getQuestionById(Long id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Question not found with id: " + id));
    }

    @Override
    public Question updateQuestion(Long id, Question question) {
        Question existingQuestion = getQuestionById(id);
        existingQuestion.setQuestionTitle(question.getQuestionTitle());
        existingQuestion.setOption1(question.getOption1());
        existingQuestion.setOption2(question.getOption2());
        existingQuestion.setOption3(question.getOption3());
        existingQuestion.setOption4(question.getOption4());
        existingQuestion.setCorrectAnswer(question.getCorrectAnswer());
        existingQuestion.setDifficultyLevel(question.getDifficultyLevel());
        existingQuestion.setCategory(question.getCategory());
        return questionRepository.save(existingQuestion);
    }

    @Override
    public Question partialUpdateQuestion(Long id, Question question) {
        Question existingQuestion = getQuestionById(id);
        if (question.getQuestionTitle() != null) {
            existingQuestion.setQuestionTitle(question.getQuestionTitle());
        }
        if (question.getOption1() != null) {
            existingQuestion.setOption1(question.getOption1());
        }
        if (question.getOption2() != null) {
            existingQuestion.setOption2(question.getOption2());
        }
        if (question.getOption3() != null) {
            existingQuestion.setOption3(question.getOption3());
        }
        if (question.getOption4() != null) {
            existingQuestion.setOption4(question.getOption4());
        }
        if (question.getCorrectAnswer() != null) {
            existingQuestion.setCorrectAnswer(question.getCorrectAnswer());
        }
        if (question.getDifficultyLevel() != null) {
            existingQuestion.setDifficultyLevel(question.getDifficultyLevel());
        }
        if (question.getCategory() != null) {
            existingQuestion.setCategory(question.getCategory());
        }
        return questionRepository.save(existingQuestion);
    }

    @Override
    public void deleteQuestion(Long id) {
        Question question = getQuestionById(id);
        questionRepository.delete(question);
    }

    @Override
    public List<Question> getQuestionsByCategory(Category category) {
        return questionRepository.findByCategory(category);
    }

    @Override
    public List<Long> getQuestionsForQuiz(String category, String difficultyLevel) {
        return questionRepository.findRandomQuestionIdsByCategoryAndDifficulty(category, difficultyLevel);
    }
}

