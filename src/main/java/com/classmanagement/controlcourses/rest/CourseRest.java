package com.classmanagement.controlcourses.rest;

import java.util.List;

import com.classmanagement.controlcourses.dao.CourseDAO;
import com.classmanagement.controlcourses.model.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("courses")
public class CourseRest {

    @Autowired
    private CourseDAO courseDAO;

    @PostMapping("/guardar")
    public void guardar(@RequestBody Course course){
        courseDAO.save(course);
    }
    @GetMapping("/get")
    public List<Course> get(){
        return courseDAO.findAll();
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        courseDAO.deleteById(id);
    }
    @PutMapping("/put")
    public void put(@RequestBody Course course){
        courseDAO.save(course);
    }
}
