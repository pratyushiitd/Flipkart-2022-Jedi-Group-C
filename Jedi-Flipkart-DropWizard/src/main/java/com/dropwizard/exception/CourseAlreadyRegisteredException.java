package com.dropwizard.exception;

public class CourseAlreadyRegisteredException extends Exception {

    private String courseID;

    public CourseAlreadyRegisteredException(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseID()
    {
        return courseID;
    }

    @Override
    public String getMessage() {
        return "You have already registered for " + courseID;
    }
}
