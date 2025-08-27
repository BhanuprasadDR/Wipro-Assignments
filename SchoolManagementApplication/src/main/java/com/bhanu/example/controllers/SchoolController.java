package com.bhanu.example.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bhanu.example.entities.School;
import com.bhanu.example.services.SchoolService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    
    @GetMapping
    public List<School> getAllSchools() {
        return schoolService.getAllSchools();
    }

    
    @GetMapping("/{id}")
    public School getSchoolById(@PathVariable Long id) {
        return schoolService.getSchoolById(id);
    }

    
    @PostMapping
    public School createSchool(@RequestBody School school) {
        return schoolService.createSchool(school);
    }

    
    @PutMapping("/{id}")
    public School updateSchool(@PathVariable Long id, @RequestBody School school) {
        return schoolService.updateSchool(id, school);
    }

    
    @DeleteMapping("/{id}")
    public String deleteSchool(@PathVariable Long id) {
        schoolService.deleteSchool(id);
        return "School with ID " + id + " deleted successfully.";
    }

   
    @PatchMapping("/{id}")
    public School patchSchoolName(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        String name = (String) updates.get("schoolName");
        return schoolService.patchSchoolName(id, name);
    }

    
    @GetMapping("/name/{name}")
    public List<School> getSchoolsByName(@PathVariable String name) {
        return schoolService.getSchoolsByName(name);
    }

    
    @GetMapping("/experienced/{experience}")
    public List<School> getSchoolsWithExperiencedTeachers(@PathVariable int experience) {
        return schoolService.getSchoolsByTeacherExperience(experience);
    }
}
