package com.flipkart.bean;
import java.util.List;

public class Grade {

    public int rollNo;
    public int semester;
    private List<Integer> gpa;
    public List<Course> registeredCourses;
    public int cgpa;

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public List<Integer> getGpa() {
        return gpa;
    }

    public void setGpa(List<Integer> gpa) {
        this.gpa = gpa;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void setRegisteredCourses(List<Course> registeredCourses) {
        this.registeredCourses = registeredCourses;
    }

    public int getCgpa() {
        return cgpa;
    }

    public void setCgpa(int cgpa) {
        this.cgpa = cgpa;
    }
}
