package com.bhanu.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhanu.example.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
}