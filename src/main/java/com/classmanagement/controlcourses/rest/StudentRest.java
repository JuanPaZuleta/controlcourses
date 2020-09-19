package com.classmanagement.controlcourses.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.classmanagement.controlcourses.dao.StudentDAO;
import com.classmanagement.controlcourses.model.Student;

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
@RequestMapping("students")
public class StudentRest {

    @Autowired // injected StudentDAO dependency
    private StudentDAO studentDAO;

    @PostMapping("/post") // this is a create url example //localhost:8080/Students/post
    public ResponseEntity<Student> save(@Valid @RequestBody Student student) {
        Student obj = studentDAO.save(student);
        return new ResponseEntity<Student>(obj, HttpStatus.OK);
    }

    @GetMapping("/get")//It's a get metod, with this you can get all Students.
    public List<Student> get(){
        return studentDAO.findAll();
    }

    @GetMapping("/get/{id}")//It's get by idStudent, with this metod you can find one Student.
    public Student retrieveStudent(@PathVariable Integer id){
        studentDAO.findById(id);
        return studentDAO.getOne(id);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Student> delete(@PathVariable Integer id){
        Optional<Student> stud = studentDAO.findById(id);
        Student student = studentDAO.getOne(id);
        if(stud.isPresent()){
            studentDAO.deleteById(id);
            return new ResponseEntity<Student>(student,HttpStatus.OK);
        }else{
            return new ResponseEntity<Student>(student,HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/put")
    public void put(@RequestBody Student student){  
        studentDAO.save(student);
    }

}
