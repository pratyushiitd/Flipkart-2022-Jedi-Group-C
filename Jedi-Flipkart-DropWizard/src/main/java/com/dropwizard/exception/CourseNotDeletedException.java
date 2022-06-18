package com.dropwizard.exception;

public class CourseNotDeletedException extends Exception{
    private String courseID;

    public CourseNotDeletedException(String courseID)
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
        return "Course with course ID: " + courseID + " can't be deleted.";
    }
}
