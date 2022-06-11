package com.flipkart.bean;

import java.util.HashMap;
import java.util.List;

public class CourseCatalogue{
    public int isOffered;
    public HashMap<Integer,List<Course>> semCourses;

    public List<Course> getCourse(int semester) {
        return semCourses.get(semester);
    }

    public void setCourse(List<Course> course,int semester) {
        semCourses.put(semester,course);

    }

    public int getIsOffered() {
        return isOffered;
    }

    public void setIsOffered(int isOffered) {
        this.isOffered = isOffered;
    }
}
