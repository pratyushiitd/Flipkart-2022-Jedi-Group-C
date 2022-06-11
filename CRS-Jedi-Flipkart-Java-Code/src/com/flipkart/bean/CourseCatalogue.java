package com.flipkart.bean;

import java.util.List;

public class CourseCatalogue{

    public int semester;
    public int isOffered;

    public List<Course> course;

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

    public int getIsOffered() {
        return isOffered;
    }

    public void setIsOffered(int isOffered) {
        this.isOffered = isOffered;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
}
