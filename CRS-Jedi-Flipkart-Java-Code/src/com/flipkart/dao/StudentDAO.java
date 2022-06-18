package com.flipkart.dao;

import com.flipkart.exception.*;

public interface StudentDAO {


public boolean viewStudentsCourses(String studentID);
    /*GradeCard viewGradeCard(String studentId) throws GradeCardNotGeneratedException;*/
    public  void viewStudentDetails(String studentID) throws UserNotFoundException;
    public  void viewStudentsList(String courseId,int sem) throws CourseNotFoundException;
    public void addStudent(String name,int role,String userId,String password,String emailId ,
                             int semester,int section,String department,float cg,String gender,String paymentId) throws UserNotAddedException, EmailAlreadyInUseException;

    public void addStudentRegistration(String courseId,String studentId,String student_name);
    public int studentSize();
    public void addCourse(String studentId,String courseId) throws CourseAlreadyRegisteredException;

    public void dropCourse(String studentId,String courseId);
}
