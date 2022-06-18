package com.flipkart.dao;

import com.flipkart.exception.CourseNotFoundException;

public interface ProfessorDAO {
    public  void viewProfessorDetails(String professorID) ;
    public  void viewStudentsList(String courseId,int sem) throws CourseNotFoundException;
    public  void submitGrades(String studentId, float gpa, String courseId);

}
