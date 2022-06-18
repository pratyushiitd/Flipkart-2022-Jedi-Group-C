package com.dropwizard.dao;

import com.dropwizard.bean.Professor;
import com.dropwizard.bean.Student;
import com.dropwizard.exception.CourseNotFoundException;

import java.util.List;

public interface ProfessorDAO {
    public List<Professor> viewProfessorDetails(String professorID) ;
    public  List<Student> viewStudentsList(String courseId, int sem) throws CourseNotFoundException;
    public  boolean submitGrades(String studentId,int gpa,String courseId);

}
