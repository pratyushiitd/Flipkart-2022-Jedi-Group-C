package com.flipkart.exception;

public class EmailAlreadyInUseException extends  Exception{
    private String emailId;

    public EmailAlreadyInUseException(String id) {
        emailId = id;
    }

    public String getEmailId() {
        return emailId;
    }


    @Override
    public String getMessage() {
        return "EmailId: " + emailId + " is already in use.";
    }
}
