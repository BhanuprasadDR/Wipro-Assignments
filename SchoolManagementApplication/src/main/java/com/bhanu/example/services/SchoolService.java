package com.bhanu.example.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhanu.example.entities.School;
import com.bhanu.example.repositories.SchoolRepository;

import java.util.List;

@Service
public class SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    
    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

   
    public School getSchoolById(Long id) {
        return schoolRepository.findById(id).orElse(null);
    }

    
    public School createSchool(School school) {
        return schoolRepository.save(school);
    }

    
    public School updateSchool(Long id, School updatedSchool) {
        School existing = schoolRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setSchoolName(updatedSchool.getSchoolName());
            existing.setSchoolAdress(updatedSchool.getSchoolAdress());
            existing.setTeachers(updatedSchool.getTeachers());
            return schoolRepository.save(existing);
        }
        return null;
    }

    
    public void deleteSchool(Long id) {
        schoolRepository.deleteById(id);
    }

    
    public School patchSchoolName(Long id, String newName) {
        School school = schoolRepository.findById(id).orElse(null);
        if (school != null) {
            school.setSchoolName(newName);
            return schoolRepository.save(school);
        }
        return null;
    }

    // Native SQL: Get schools by name
    public List<School> getSchoolsByName(String name) {
        return schoolRepository.findBySchoolNameNative(name);
    }

    // Native SQL: Get schools with experienced teachers
    public List<School> getSchoolsByTeacherExperience(int exp) {
        return schoolRepository.findExperiencedTeacherSchools(exp);
    }
}
