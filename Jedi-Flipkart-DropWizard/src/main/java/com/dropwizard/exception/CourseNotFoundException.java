package com.dropwizard.exception;
public class CourseNotFoundException extends Exception{
    private String courseID;

    public CourseNotFoundException(String courseID)
    {
        this.courseID = courseID;
    }

    public String getCourseID()
    {
        return courseID;
    }

    @Override
    public String getMessage()
    {
        return "Course with course ID: " + courseID + " not found.";
    }
}
