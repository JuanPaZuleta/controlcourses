package com.classmanagement.controlcourses.dao;

import com.classmanagement.controlcourses.model.Course;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDAO extends JpaRepository<Course, Integer> {
     //is the logical configuration of the atributs for the Course class
}
