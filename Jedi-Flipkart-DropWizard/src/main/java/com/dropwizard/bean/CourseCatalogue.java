package com.flipkart.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
public class CourseCatalogue{

    
    public HashMap<Integer,List<Course>> semCourses;

    public CourseCatalogue() {

        this.semCourses = new HashMap<Integer,List<Course>>();
        for(int i = 1; i <= 8; i++){
            this.semCourses.put(i, new ArrayList<Course>());
        }
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
        System.out.println("Course Catalogue:\n");
        for(int semester = 1; semester <= 8; semester++) {
            if (semCourses.get(semester).size() == 0)continue;
            System.out.println("Semester " + semester);
            for(Course course : semCourses.get(semester)) {
                course.printCourseDetails();
                System.out.println("-----");
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
