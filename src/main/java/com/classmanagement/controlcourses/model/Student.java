package com.classmanagement.controlcourses.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

//table structures in this case is for Student table (Entity)

@Entity
public class Student {
    @Id
    private Integer idStudent;

    @Column
    private String rut;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private Integer age;

    @Column
    private Integer course;

    public Integer getIdStudent() {
        return idStudent;
    }
    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }
    public String getRut() {
        return rut;
    }
    public void setRut(String rut) {
        this.rut = rut;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public Integer getCourse() {
        return course;
    }
    public void setCourse(Integer course) {
        this.course = course;
    }
}
