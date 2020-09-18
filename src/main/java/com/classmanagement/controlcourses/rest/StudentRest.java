package com.classmanagement.controlcourses.rest;

import java.util.List;

import com.classmanagement.controlcourses.dao.StudentDAO;
import com.classmanagement.controlcourses.model.Student;

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
@RequestMapping("students")
public class StudentRest {
    
    @Autowired //injected StudentDAO dependency
    private StudentDAO studentDAO;


    @PostMapping("/post") //this is a create url example //localhost:8080/Students/post
    public void post(@RequestBody Student student){
        studentDAO.save(student);
    }
    @GetMapping("/get")
    public List<Student> get(){
        return studentDAO.findAll();
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        studentDAO.deleteById(id);
    }
    @PutMapping("/put")
    public void put(@RequestBody Student student){  
        studentDAO.save(student);
    }

}
