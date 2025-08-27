package com.bhanu.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.bhanu.example.entities.Student;
import com.bhanu.example.services.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    // 1. List all students
    @GetMapping
    public String listStudents(Model model) {
        model.addAttribute("students", service.getAll());
        return "students"; // students.html should exist in templates
    }

    // 2. Show create form
    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("student", new Student());
        return "create"; // create.html
    }

    // 3. Handle form submission
    @PostMapping
    public String save(@ModelAttribute Student student) {
        service.save(student);
        return "redirect:/students"; // ✅ REDIRECT to prevent circular path error
    }

    // 4. Show edit form
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Student student = service.getById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student ID: " + id));
        model.addAttribute("student", student);
        return "edit"; // edit.html
    }

    // 5. Update the student
    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Student student) {
        student.setRollNo(id);
        service.save(student);
        return "redirect:/students";
    }

    // 6. Delete a student
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/students";
    }
}
