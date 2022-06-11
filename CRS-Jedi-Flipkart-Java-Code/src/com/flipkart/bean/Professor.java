package com.flipkart.bean;

import java.util.List;

public class Professor extends Admin{

    public int professorId;
    public String department;
    public String designation;
    public String office;
    public List<Course> coursesTeaching;

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public List<Course> getList() {
        return coursesTeaching;
    }

    public String getDepartment() {
        return department;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setList(List<Course> coursesTeaching) {
        this.coursesTeaching = coursesTeaching;
    }

