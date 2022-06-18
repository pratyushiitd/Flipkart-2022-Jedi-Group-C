package com.dropwizard.exception;

public class SeatNotAvailableException extends Exception{
    private String courseID;

    public SeatNotAvailableException(String courseID)
    {
        this.courseID = courseID;
    }


    @Override
    public String getMessage() {
        return  "Seats are not available in : " + courseID;
    }
}
