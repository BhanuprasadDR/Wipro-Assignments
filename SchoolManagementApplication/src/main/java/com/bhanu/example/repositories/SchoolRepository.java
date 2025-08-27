package com.bhanu.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bhanu.example.entities.School;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
    // Native Queries
    @Query(value = "SELECT * FROM school WHERE school_name = :name", nativeQuery = true)
    List<School> findBySchoolNameNative(@Param("name") String name);

    @Query(value = "SELECT * FROM school WHERE id IN (SELECT id FROM teacher WHERE experience > :exp)", nativeQuery = true)
    List<School> findExperiencedTeacherSchools(@Param("exp") int exp);
}
