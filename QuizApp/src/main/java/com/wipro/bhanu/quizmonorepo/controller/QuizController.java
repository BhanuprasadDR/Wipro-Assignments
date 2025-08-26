package com.wipro.bhanu.quizmonorepo.controller;

import com.wipro.bhanu.quizmonorepo.entity.Quiz;
import com.wipro.bhanu.quizmonorepo.entity.Response;
import com.wipro.bhanu.quizmonorepo.service.QuizService;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping
    public ResponseEntity<Quiz> createQuiz(@RequestBody CreateQuizRequest request) {
        Quiz quiz = quizService.createQuiz(request.getTitle(), request.getCategory(), request.getDifficulty());
        return new ResponseEntity<>(quiz, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable Integer id) {
        Quiz quiz = quizService.getQuizById(id);
        return new ResponseEntity<>(quiz, HttpStatus.OK);
    }

    @PostMapping("/{id}/submit")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses) {
        int score = quizService.submitQuiz(id, responses);
        return new ResponseEntity<>(score, HttpStatus.OK);
    }
}

@Data
class CreateQuizRequest {
    @NotBlank
    private String title;
    private String category;
    private String difficulty;
}