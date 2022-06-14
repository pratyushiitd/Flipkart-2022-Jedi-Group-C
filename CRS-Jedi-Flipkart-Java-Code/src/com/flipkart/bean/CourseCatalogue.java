package com.flipkart.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
public class CourseCatalogue{

    
    public HashMap<Integer,List<Course>> semCourses;

    public CourseCatalogue() {
        this.semCourses = new HashMap<Integer,List<Course>>();
    }
    public List<Course> getCourses(int semester) {
        return semCourses.get(semester);
    }
    public void addCourse(int semester, Course course) {
        if(semCourses.containsKey(semester)){
            semCourses.get(semester).add(course);
        }
        else{
            List<Course> courses = new ArrayList<Course>();
            courses.add(course);
            semCourses.put(semester,courses);
        }
    }
    public int getCourseCount(int semester) {
        return semCourses.get(semester).size();
    }

    // void show course catalogue
    public void showCourseCatalogue() {
        System.out.println("Course Catalogue");
        for(int semester = 1; semester <= 8; semester++) {
            System.out.println("Semester " + semester);
            for(Course course : semCourses.get(semester)) {
                course.printCourseDetails();
            }
        }
    }
    // get course
    public Course getCourse(int semester, String courseID) {
        for(Course course : semCourses.get(semester)) {
            if(course.getCourseID().equals(courseID)) {
                return course;
            }
        }
        return null;
    }
}
