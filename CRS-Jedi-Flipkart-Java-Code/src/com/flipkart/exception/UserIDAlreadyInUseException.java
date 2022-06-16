package com.flipkart.exception;

public class UserIDAlreadyInUseException extends Exception{
    private String userID;

    public UserIDAlreadyInUseException(String userID) {
        this.userID = userID;
    }

    public String getUserID() {
        return userID;
    }

    @Override
    public String getMessage() {
        return "user ID: " + userID + " is already in use.";
    }
}
