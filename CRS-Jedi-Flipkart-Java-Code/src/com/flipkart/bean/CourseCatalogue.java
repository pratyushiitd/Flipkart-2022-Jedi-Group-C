package com.flipkart.bean;

import java.util.ArrayList;
import java.util.List;

public class CourseCatalogue{

    private List<Course> courses;
    private int semester;
    public CourseCatalogue(List<Course> courses, int semester){
        this.courses = courses;
        this.semester = semester;
    }
    public CourseCatalogue(int semester){
        this.semester = semester;
        this.courses = new ArrayList<Course>();
    }
    public CourseCatalogue(){
        this.courses = new ArrayList<Course>();
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void addCourse(Course course){
        this.courses.add(course);
    }

    public void removeCourse(Course course){
        this.courses.remove(course);
    }

    public int getCourseCount(){
        return this.courses.size();
    }

    public void printCourses(){
        for(Course course: this.courses){
            System.out.println(course.getCourseName());
        }
    }
}
