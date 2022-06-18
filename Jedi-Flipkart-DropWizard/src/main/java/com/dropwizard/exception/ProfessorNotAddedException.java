package com.dropwizard.exception;

public class ProfessorNotAddedException extends Exception{
    private String professorID;

    public ProfessorNotAddedException(String professorID)
    {
        this.professorID=professorID;
    }

    public String getUserID()
    {
        return this.professorID;
    }

    @Override
    public String getMessage() {
        return "professorId: " + professorID + " not added!";
    }
}
