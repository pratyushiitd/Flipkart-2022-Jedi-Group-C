package com.flipkart.exception;

public class CourseNotOptedException extends Exception {
    private String courseId;


    public CourseNotOptedException(String courseId)
    {
        this.courseId = courseId;
    }

    @Override
    public String getMessage() {
        return  "Course " + courseId + " has not been opted by you.";
    }
}
