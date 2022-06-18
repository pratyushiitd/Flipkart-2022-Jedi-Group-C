package com.dropwizard.exception;

public class UserNotAddedException extends  Exception {
    private String userID;

    public UserNotAddedException(String userID) {
        this.userID = userID;
    }

    public String getUserID() {
        return userID;
    }


    @Override
    public String getMessage() {
        return "User ID: " + userID + " not added!";
    }
}
