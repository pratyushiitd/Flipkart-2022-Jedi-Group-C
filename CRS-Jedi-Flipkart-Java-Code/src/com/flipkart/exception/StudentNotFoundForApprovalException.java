package com.flipkart.exception;

public class StudentNotFoundForApprovalException extends Exception{
    private String studentID;

    public StudentNotFoundForApprovalException(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentID() {
        return studentID;
    }

    @Override
    public String getMessage() {
        return "Student ID: " + studentID + " not registered!";
    }
}
