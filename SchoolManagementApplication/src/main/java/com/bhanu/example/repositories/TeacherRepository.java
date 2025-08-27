package com.bhanu.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhanu.example.entities.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    // Custom method: Find teachers by qualification
    List<Teacher> findByQualification(String qualification);

    // Custom method: Find teachers above a certain age
    List<Teacher> findByAgeGreaterThan(int age);
}
