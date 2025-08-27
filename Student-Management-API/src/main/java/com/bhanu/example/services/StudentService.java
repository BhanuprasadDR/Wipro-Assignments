package com.bhanu.example.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhanu.example.entities.Student;
import com.bhanu.example.repositories.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public List<Student> getAll() {
        return repo.findAll();
    }

    public Optional<Student> getById(Long id) {
        return repo.findById(id);
    }

    public Student save(Student student) {
        return repo.save(student);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
