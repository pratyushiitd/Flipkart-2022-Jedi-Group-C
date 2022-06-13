package com.flipkart.bean;

import java.util.List;

public class Professor extends User{



    public String professorId;
    public String department;
    public String designation;
    public String office;
    public List<Course> coursesTeaching;

    public Professor(
        String name, 
        String role,
        String userID,
        String password,
        long mobile,
        String email_id,
        String professorId,
        String department,
        String designation,
        String office,
        List<Course> coursesTeaching){

        super(name, role, userID, password, mobile, email_id);
        this.professorId = professorId;
        this.department = department;
        this.designation = designation;
        this.office = office;
        this.coursesTeaching = coursesTeaching;
    }

    public Professor(){

    }

    
    public String getProfessorId() {
        return professorId;
    }

    public void setProfessorId(String professorId) {
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
}

