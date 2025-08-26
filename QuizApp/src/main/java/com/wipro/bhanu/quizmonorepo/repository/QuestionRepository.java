package com.wipro.bhanu.quizmonorepo.repository;

import com.wipro.bhanu.quizmonorepo.entity.Question;
import com.wipro.bhanu.quizmonorepo.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByCategory(Category category);

    @Query(value = "SELECT * FROM question WHERE category = :category AND difficulty_level = :difficulty ORDER BY RAND() LIMIT 3", nativeQuery = true)
    List<Question> findRandomQuestionsByCategoryAndDifficulty(@Param("category") String category, @Param("difficulty") String difficulty);

    @Query(value = "SELECT id FROM question WHERE category = :category AND difficulty_level = :difficulty ORDER BY RAND() LIMIT 3", nativeQuery = true)
    List<Long> findRandomQuestionIdsByCategoryAndDifficulty(@Param("category") String category, @Param("difficulty") String difficulty);
}