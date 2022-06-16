package com.flipkart.exception;

public class ProfessorIDAlreadyInUseException extends Exception{
    private String professorID;

    public ProfessorIDAlreadyInUseException(String professorID) {
        this.professorID = professorID;
    }

    public String getUserId() {
        return professorID;
    }

    @Override
    public String getMessage() {
        return "user ID: " + professorID + " is already in use.";
    }
}
