package com.flipkart.exception;

public class GradeCardNotGeneratedException extends Exception{
    private String studentID;

    public GradeCardNotGeneratedException(String studentId)
    {
       studentID = studentId;
    }

    @Override
    public String getMessage() {
        return  "Grade card not generated for student : " + studentID;
    }
}
