package com.flipkart.bean;

import java.util.List;

public class Student extends User{

    private int semester;
    private char section;
    private String department;
    private float cg;
    private char gender;

    private boolean isRegistered;

    public Student(
        String name, 
        String role, 
        String userID,
        String password, 
        String email_id,
        int semester,
        char section,
        String department,
        float cg,
        char gender){

        super(name, role, userID, password, email_id);
        this.semester = semester;
        this.section = section;
        this.department = department;
        this.cg = cg;
        this.gender = gender;
    }

    public Student(){

    }
    
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public float getCg() {
        return cg;
    }

    public void setCg(float cg) {
        this.cg = cg;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean registered) {
        this.isRegistered = registered;
    }


    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public char getSection() {
        return section;
    }

    public void setSection(char section) {
        this.section = section;
    }

    public void viewStudent() {

    }
}