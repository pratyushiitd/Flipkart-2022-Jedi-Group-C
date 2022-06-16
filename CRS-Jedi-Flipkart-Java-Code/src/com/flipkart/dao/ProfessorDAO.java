package com.flipkart.dao;

public interface ProfessorDAO {
    public  void viewProfessorDetails(String professorID) ;
    public  void viewStudentsList(String courseId,int sem);
    public  void submitGrades(String studentId,int gpa,String courseId);

}
