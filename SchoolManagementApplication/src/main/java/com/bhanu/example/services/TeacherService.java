package com.bhanu.example.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhanu.example.entities.Teacher;
import com.bhanu.example.repositories.TeacherRepository;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    // Get all teachers
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    // Get teacher by ID
    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    // Create new teacher
    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    // Update teacher
    public Teacher updateTeacher(Long id, Teacher updatedTeacher) {
        Teacher existing = teacherRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setTeacherName(updatedTeacher.getTeacherName());
            existing.setTeacherAdress(updatedTeacher.getTeacherAdress());
            existing.setQualification(updatedTeacher.getQualification());
            existing.setAge(updatedTeacher.getAge());
            existing.setDob(updatedTeacher.getDob());
            existing.setExperience(updatedTeacher.getExperience());
            return teacherRepository.save(existing);
        }
        return null;
    }

    // Delete teacher
    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }

    // Custom method: Find teachers by qualification
    public List<Teacher> getTeachersByQualification(String qualification) {
        return teacherRepository.findByQualification(qualification);
    }

    // Custom method: Find teachers above given age
    public List<Teacher> getTeachersAboveAge(int age) {
        return teacherRepository.findByAgeGreaterThan(age);
    }
}
