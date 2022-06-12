package com.flipkart.service;

import java.util.List;
import com.flipkart.bean.Student;;
public interface ProfessorInterface {
    
    public List<Student> getStudentsList(int courseID);
    public void submitGrades(int courseID, int studentID, int grade);
    
}
