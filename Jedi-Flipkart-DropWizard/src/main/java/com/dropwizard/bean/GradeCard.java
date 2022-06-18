package com.dropwizard.bean;

import java.util.HashMap;

public class GradeCard {

    Student student;
    public HashMap<Course, Integer> grades;
    public GradeCard(Student student){
        this.student = student;
        this.grades = new HashMap<Course, Integer>();
    }
    public GradeCard(){
        this.grades = new HashMap<Course, Integer>();
    }
    public void addGrade(Course course, int grade){
        this.grades.put(course, grade);
    }
    public void removeGrade(Course course){
        this.grades.remove(course);
    }
    public int getGrade(Course course){
        return this.grades.get(course);
    }
    public void printGrades(){
        for(Course course: this.grades.keySet()){
            System.out.println(course.getCourseName() + ": " + this.grades.get(course));
        }
    }
    // GET STUDENT
    public Student getStudent(){
        return this.student;
    }
    public HashMap<Course, Integer> getGrades() {
        return grades;
    }

}
