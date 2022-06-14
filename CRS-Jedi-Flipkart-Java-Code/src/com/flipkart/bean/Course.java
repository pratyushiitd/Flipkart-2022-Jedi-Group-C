package com.flipkart.bean;

import java.util.List;
public class Course{

    public String courseID;
    public String courseName;
    public String professorID;
    public List<Student> studentsEnrolled;
    public int vacancy;

    public Course(String courseID, String courseName, String professorID, List<Student> studentsEnrolled, int vacancy) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.professorID = professorID;
        this.studentsEnrolled = studentsEnrolled;
        this.vacancy = vacancy;
    }

    public int getVacancy() {
        return vacancy;
    }

    public void setVacancy(int vacancy) {
        this.vacancy = vacancy;
    }

    public List<Student> getStudentsEnrolled(String courseID) {
        return studentsEnrolled;
    }

    public void setStudentsEnrolled(List<Student> studentsEnrolled) {
        this.studentsEnrolled = studentsEnrolled;
    }


    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getProfessorID() {
        return professorID;
    }

    public void setProfessorID(String professorID) {
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

    // course details
    public void printCourseDetails() {
        System.out.println("Course ID: " + courseID);
        System.out.println("Course Name: " + courseName);
        System.out.println("Professor ID: " + professorID);
        System.out.println("No of Students: " + studentsEnrolled.size());
        System.out.println("Vacancy: " + vacancy);
    }
}
