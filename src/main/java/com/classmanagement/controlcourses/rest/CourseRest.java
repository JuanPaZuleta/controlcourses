package com.classmanagement.controlcourses.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.classmanagement.controlcourses.dao.CourseDAO;
import com.classmanagement.controlcourses.model.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @Autowired //injected CourseDAO dependency
    private CourseDAO courseDAO;


    @PostMapping("/POST")
    public ResponseEntity<Course> save(@Valid @RequestBody Course course) {
        if(course.getCode().length()>4){
            return new ResponseEntity<Course>(HttpStatus.NOT_ACCEPTABLE);
        }else{
            Course obj = courseDAO.save(course);
            return new ResponseEntity<Course>(obj, HttpStatus.CREATED);
        }
        
    }

    @GetMapping("/GET")//It's a get metod, with this you can get all Courses.
    public List<Course> get(){
        return courseDAO.findAll();
    }


    @GetMapping("/GET/{id}")//It's a get metod, with this you can get all Courses.
    public ResponseEntity<Course> get(@PathVariable Integer id){
        Optional<Course> stud = courseDAO.findById(id);
        Course course = courseDAO.getOne(id);
        if(stud.isPresent()){
            return new ResponseEntity<Course>(course,HttpStatus.OK);
        }else{
            return new ResponseEntity<Course>(course,HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/DELETE/{id}")
    public ResponseEntity<Course> delete(@PathVariable Integer id){
        Optional<Course> cours = courseDAO.findById(id);
        Course course = courseDAO.getOne(id);
        if(cours.isPresent()){
            courseDAO.deleteById(id);
            return new ResponseEntity<Course>(course,HttpStatus.OK);
        }else{
            return new ResponseEntity<Course>(course,HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/PUT")
    public void put(@RequestBody Course course){
        courseDAO.save(course);
    }
}
