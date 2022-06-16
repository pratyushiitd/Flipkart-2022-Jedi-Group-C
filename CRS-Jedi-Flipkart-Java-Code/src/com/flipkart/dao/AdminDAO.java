package com.flipkart.dao;

import java.sql.SQLException;
import java.util.List;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.exception.*;
import com.flipkart.bean.Course;


public interface AdminDAO {

    public String getDepartmentCourse(String courseId);
    public int professorSize();
    public  void addProfessor(String professorId,String name,String password,String mail,String department);
    public  void approveCourse();
    public  void getCourseDetails(String courseId);
    public  void getStudentDetails(String studentId);
    public  void addCourse() ;
    public  void addStudent();


}