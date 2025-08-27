package com.bhanu.example.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teacherName;
    private String teacherAdress;
    private String qualification;
    private int age;

    @Temporal(TemporalType.DATE)
    private Date dob;

    private int experience;

    @ManyToOne
    private School school;

    
    public Long getId() {
        return id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherAdress() {
        return teacherAdress;
    }

    public void setTeacherAdress(String teacherAdress) {
        this.teacherAdress = teacherAdress;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    
    public Teacher() {
    	super();
    }

    public Teacher(String teacherName, String teacherAdress, String qualification, int age, Date dob, int experience, School school) {
        this.teacherName = teacherName;
        this.teacherAdress = teacherAdress;
        this.qualification = qualification;
        this.age = age;
        this.dob = dob;
        this.experience = experience;
        this.school = school;
    }
}
