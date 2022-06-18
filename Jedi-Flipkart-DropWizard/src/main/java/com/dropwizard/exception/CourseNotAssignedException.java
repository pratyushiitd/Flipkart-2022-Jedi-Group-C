package com.dropwizard.exception;

public class CourseNotAssignedException extends Exception{
    private String courseID;
    private String userId;

    public CourseNotAssignedException(String courseID, String userId) {
        this.courseID = courseID;
        this.userId = userId;
    }

    public String getCourseID() {
        return courseID;
    }

    public String getUserId() {
        return userId;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    @Override
    public String getMessage() {
        return "course ID: " + courseID + " couldn't be assigned to UserId: " + userId ;
    }
}
