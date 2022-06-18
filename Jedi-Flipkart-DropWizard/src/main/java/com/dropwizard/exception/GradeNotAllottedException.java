package com.dropwizard.exception;

public class GradeNotAllottedException extends Exception{
    private String userId;

    public GradeNotAllottedException(String userId)
    {
        this.userId =userId;
    }

    public String getUserId()
    {
        return userId;
    }


    public String getMessage()
    {
        return "Student with id: " + userId + "hasn't been allotted a grade yet";
    }
}
