package com.flipkart.exception;

public class CourseNotAvailableException extends Exception{
    private String courseID;


    public CourseNotAvailableException(String courseID)
    {
        this.courseID = courseID;
    }



    @Override
    public String getMessage() {
        return  "Seats are not available in : " + courseID;
    }
}
