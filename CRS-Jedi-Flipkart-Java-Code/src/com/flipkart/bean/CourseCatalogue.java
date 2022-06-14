package com.flipkart.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
public class CourseCatalogue{

    
    public HashMap<Integer,List<Integer>> semCourses;

    public CourseCatalogue() {
        this.semCourses = new HashMap<Integer,List<Integer>>();
    }
    public List<Integer> getCourses(int semester) {
        return semCourses.get(semester);
    }
    public void addCourse(int semester, int courseID) {
        if(semCourses.containsKey(semester)){
            semCourses.get(semester).add(courseID);
        }
        else{
            List<Integer> courses = new ArrayList<Integer>();
            courses.add(courseID);
            semCourses.put(semester,courses);
        }
    }

    public int getCourseCount(int semester) {
        return semCourses.get(semester).size();
    }

    public void removeCourse(int semester, int courseID) {
        if(semCourses.containsKey(semester)){
            semCourses.get(semester).remove(courseID);
        }
        else{
            List<Integer> courses = new ArrayList<Integer>();
            courses.add(courseID);
        }
    }
}
