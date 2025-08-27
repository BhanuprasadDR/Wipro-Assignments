package com.bhanu.example.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bhanu.example.entities.Teacher;
import com.bhanu.example.services.TeacherService;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    
    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    
    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable Long id) {
        return teacherService.getTeacherById(id);
    }

    
    @PostMapping
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return teacherService.createTeacher(teacher);
    }

    
    @PutMapping("/{id}")
    public Teacher updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher) {
        return teacherService.updateTeacher(id, teacher);
    }

    
    @DeleteMapping("/{id}")
    public String deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
        return "Teacher with ID " + id + " deleted successfully.";
    }

  
    @GetMapping("/qualification/{qualification}")
    public List<Teacher> getTeachersByQualification(@PathVariable String qualification) {
        return teacherService.getTeachersByQualification(qualification);
    }

    
    @GetMapping("/age-above/{age}")
    public List<Teacher> getTeachersAboveAge(@PathVariable int age) {
        return teacherService.getTeachersAboveAge(age);
    }
}
