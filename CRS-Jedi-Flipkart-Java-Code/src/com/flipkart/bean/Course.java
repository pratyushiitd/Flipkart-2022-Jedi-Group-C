package com.flipkart.bean;

import java.util.List;
public class Course{

    public int courseID;
    public String courseName;
    public int professorID;
    public List<Student> studentsEnrolled;
    public int vacancy; 

    public Course(int courseID, String courseName, int professorID, List<Student> studenstEnrolled, int vacancy) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.professorID = professorID;
        this.studentsEnrolled = studenstEnrolled;
        this.vacancy = vacancy;
    }

    public Course() {
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public void setvacancy(int value){
        this.vacancy = value;
    }
    public int getvacancy(){
        return vacancy;
    }

    public int getProfessorID() {
        return professorID;
    }

    public void setProfessorID(int professorID) {
        this.professorID = professorID;
    }

    public int getNoOfStudents() {
        return studentsEnrolled.size();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
