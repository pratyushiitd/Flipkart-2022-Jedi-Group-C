package com.flipkart.bean;

public class Course{

    public String courseID;
    public String courseName;
    public String professorID;
    public int vacancy = 10;

    public int strength = 0;
    public Course(String courseID, String courseName, String professorID) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.professorID = professorID;
        this.vacancy = 10;
    }

    public int getVacancy() {
        return vacancy;
    }

    public void setVacancy(int vacancy) {
        this.vacancy = vacancy;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public void increment_strength() {
        this.strength++;
    }
    public int get_strength() {
        return this.strength;
    }
    public String getProfessorID() {
        return professorID;
    }

    public void setProfessorID(String professorID) {
        this.professorID = professorID;
    }
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    // course details
    public void printCourseDetails() {
        System.out.println("Course ID: " + courseID);
        System.out.println("Course Name: " + courseName);
        System.out.println("Professor ID: " + professorID);
        System.out.println("Vacancy: " + vacancy);
    }
}
