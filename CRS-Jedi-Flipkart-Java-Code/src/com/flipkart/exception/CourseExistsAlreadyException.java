package com.flipkart.exception;

public class CourseExistsAlreadyException extends Exception{

    private String courseID;


    public CourseExistsAlreadyException(String courseID) {
        this.courseID = courseID;
    }


    public String getCourseID() {
        return courseID;
    }


    @Override
    public String getMessage() {
        return "Course: " + courseID + " already exists in catalog.";
    }
}
