package com.wipro.bhanu.quizmonorepo.controller;

import com.wipro.bhanu.quizmonorepo.entity.Question;
import com.wipro.bhanu.quizmonorepo.enums.Category;
import com.wipro.bhanu.quizmonorepo.service.QuestionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping
    public ResponseEntity<Question> addQuestion(@Valid @RequestBody Question question) {
        Question savedQuestion = questionService.addQuestion(question);
        return new ResponseEntity<>(savedQuestion, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<Question>> getAllQuestions(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Question> questions = questionService.getAllQuestions(pageable);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
        Question question = questionService.getQuestionById(id);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Long id, @Valid @RequestBody Question question) {
        Question updatedQuestion = questionService.updateQuestion(id, question);
        return new ResponseEntity<>(updatedQuestion, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Question> partialUpdateQuestion(@PathVariable Long id, @RequestBody Question question) {
        Question updatedQuestion = questionService.partialUpdateQuestion(id, question);
        return new ResponseEntity<>(updatedQuestion, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable Category category) {
        List<Question> questions = questionService.getQuestionsByCategory(category);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @GetMapping("/generateQuestionsForQuiz")
    public ResponseEntity<List<Long>> getQuestionsForQuiz(
            @RequestParam String category,
            @RequestParam String difficultyLevel) {
        List<Long> questionIds = questionService.getQuestionsForQuiz(category, difficultyLevel);
        return new ResponseEntity<>(questionIds, HttpStatus.OK);
    }
}