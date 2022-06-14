package com.flipkart.service;

import java.util.HashMap;
import java.util.List;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;;
public interface ProfessorInterface {

    public void viewResults(String courseid);
    public void viewProfile(String professorid,List<Professor> prof_list);
    public List<Student> getStudentsList(String courseID, HashMap<String,List<Student>> course_student_list) ;
    public void submitGrades(String courseID, String studentID, String grade) ;
    public void selectCoursestoTeach(String professorID, String courseID) ;
    public void dropCoursestoTeach(String professorID, String courseID) ;
    public void viewCourses(String professorID) ;
    }
