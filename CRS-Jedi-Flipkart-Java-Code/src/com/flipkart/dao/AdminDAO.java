package com.flipkart.dao;

import java.sql.SQLException;
import java.util.List;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.exception.*;
import com.flipkart.bean.Course;


public interface AdminDAO {

    public String getDepartmentCourse(String courseId) throws CourseNotFoundException;
    public int professorSize();
    public  void addProfessor(String professorId,String name,String password,String mail,String department) throws UserNotAddedException, UserIDAlreadyInUseException, ProfessorNotAddedException;
    public  void getCourseDetails(String courseId) throws CourseNotFoundException;
    public  void getStudentDetails(String studentId) throws UserNotFoundException;

    void approveCourse();

    public  void addCourse();
    public  void addStudent() throws UserNotAddedException;
    public void viewAllStudents();
}