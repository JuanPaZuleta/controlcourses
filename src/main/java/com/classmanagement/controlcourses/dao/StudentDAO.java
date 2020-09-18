package com.classmanagement.controlcourses.dao;

import com.classmanagement.controlcourses.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDAO extends JpaRepository<Student, Integer> {
    //is the logical configuration of the atributs for the Student class
}
