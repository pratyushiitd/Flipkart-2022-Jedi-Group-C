package com.flipkart.bean;

import java.util.List;

public class Student extends User{


    public List<Integer> coursesEnrolled;


    private int rollNo;
    private int semester;
    private char section;
    private String department;
    private float cg;
    private char gender;

    private boolean isRegistered;

    public Student(
        String name, 
        String role, 
        int userID, 
        String password, 
        long mobile, 
        String email_id,
        int rollNo,
        int semester,
        char section,
        String department,
        float cg,
        char gender){

        super(name, role, userID, password, mobile, email_id);
        this.rollNo = rollNo;
        this.semester = semester;
        this.section = section;
        this.department = department;
        this.cg = cg;
        this.gender = gender;
    }

    public Student(){

    }
    
    public List<Integer> getCoursesEnrolled() {
        return coursesEnrolled;
    }

    public void setCoursesEnrolled(List<Integer> coursesEnrolled) {
        this.coursesEnrolled = coursesEnrolled;
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


    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
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

}