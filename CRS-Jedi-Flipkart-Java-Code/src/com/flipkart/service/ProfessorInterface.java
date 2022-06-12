package com.flipkart.service;

import java.util.List;
import com.flipkart.bean.Student;;
public interface ProfessorInterface {
    
    public List<Student> getStudentsList(int courseID);
    public void submitGrades(int courseID, int studentID, int grade);
    public void selectCoursestoTeach(int professorID, int courseID);
    public void dropCoursestoTeach(int professorID, int courseID);
    public void viewCourses(int professorID);
    public void viewResults(int professorID);
    public void viewSchedule(int professorID);
    public void viewProfile(int professorID);

}
