package com.flipkart.service;

import java.util.HashMap;
import java.util.List;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;;
public interface ProfessorInterface {
    
    public List<Student> getStudentsList(String courseID, HashMap<String,List<Student>> course_student_list);
    public void submitGrades(String courseID, String studentID, String grade);
    public void selectCoursestoTeach(String professorID, String courseID);
    public void dropCoursestoTeach(String professorID, String courseID);
    public void viewCourses(String professorID);
    public void viewResults(String courseID);
    //public void viewSchedule(int professorID);
    public void viewProfile(String professorID,List<Professor> prof_list);

}
