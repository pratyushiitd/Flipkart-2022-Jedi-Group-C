package com.flipkart.bean;

import java.util.List;
import java.util.ArrayList;
public class Professor extends User{

    public String department;
    public List<Course> coursesTeaching;

    public Professor(
        String name, 
        String role,
        String userID,
        String password,
        String email_id,
        String department
        ){

        super(name, role, userID, password, email_id);
        this.department = department;
        this.coursesTeaching = new ArrayList<Course>();
    }

    public Professor(){
        this.coursesTeaching = new ArrayList<Course>();
    }

    public String getProfessorId() {
        return getUserID();
    }

    public void setProfessorId(String professorId) {
        setUserID(professorId);
    }

    public List<Course> getList() {
        return coursesTeaching;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // add course to the list
    public void addCourse(Course course){
        coursesTeaching.add(course);
    }

    public void showProfessorDetails() {
        System.out.println("Professor Details");
        System.out.println("Name: " + getName());
        System.out.println("Role: " + getRole());
        System.out.println("UserID: " + getUserID());
        System.out.println("Password: " + getPassword());
        System.out.println("Email: " + getEmail_id());
        System.out.println("Department: " + getDepartment());
        System.out.println("Courses: ");
        for(Course course : coursesTeaching){
            System.out.println(course.getCourseID() + ": " + course.getCourseName());
        }
    }
}

