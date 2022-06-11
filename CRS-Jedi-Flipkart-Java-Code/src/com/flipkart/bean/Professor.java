package com.flipkart.bean;

public class Professor extends Admin{

    public int professorId;
    public String department;
    public String designation;
    public String office;
    public list<courses> coursesTeaching;

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public list<courses> getList() {
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

    public void setList(list<course> coursesTeaching) {
        this.coursesTeaching = coursesTeaching;
    }
}
