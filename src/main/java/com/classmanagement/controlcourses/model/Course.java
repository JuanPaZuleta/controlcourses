package com.classmanagement.controlcourses.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

//table structures in this case is for Course table (Entity)

@Entity
public class Course {
    
    @Id
    private Integer idCourse;

    @Column
    private String name;

    @Column
    @Size(max = 4)
    private String code;

    public Integer getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Integer idCourse) {
        this.idCourse = idCourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
}
