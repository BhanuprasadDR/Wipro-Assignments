package com.wipro.bhanu.quizmonorepo.entity;

import com.wipro.bhanu.quizmonorepo.enums.Category;
import com.wipro.bhanu.quizmonorepo.enums.Difficulty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String questionTitle;
    @NotBlank
    private String option1;
    @NotBlank
    private String option2;
    @NotBlank
    private String option3;
    @NotBlank
    private String option4;
    @NotBlank
    private String correctAnswer;

    @Enumerated(EnumType.STRING)
    private Difficulty difficultyLevel;

    @Enumerated(EnumType.STRING)
    private Category category;
}