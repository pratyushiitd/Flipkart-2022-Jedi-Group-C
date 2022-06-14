package com.flipkart.bean;

import java.util.List;

public class Professor extends User{

    public String department;
    public String designation;
    public String office;
    public List<String> coursesTeaching;

    public Professor(
        String name, 
        String role,
        String userID,
        String password,
        long mobile,
        String email_id,
        String department,
        String designation,
        String office,
        List<String> coursesTeaching){

        super(name, role, userID, password, mobile, email_id);
        this.department = department;
        this.designation = designation;
        this.office = office;
        this.coursesTeaching = coursesTeaching;
    }

    public Professor(){

    }

    
    public String getProfessorId() {
        return getUserID();
    }

    public void setProfessorId(String professorId) {
        setUserID(professorId);
    }

    public List<String> getList() {
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

    public void setList(List<String> coursesTeaching) {
        this.coursesTeaching = coursesTeaching;
    }
}

