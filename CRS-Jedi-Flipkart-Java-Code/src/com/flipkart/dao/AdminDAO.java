package com.flipkart.dao;

import java.sql.SQLException;
import java.util.List;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.exception.*;
import com.flipkart.bean.Course;


public interface AdminDAO {

    List<Course> viewCourses();
    String addCourse(Course newCourse);

    void dropCourse(String courseId) throws CourseNotFoundException;

    List<Student> getPendingStudents();

    String approveStudent(Student newStudent);


    String addProfessor(Professor newProfessor) throws EmailAlreadyInUseException;

    List<Professor> viewProfessorList();

    void dropProfessor(String professorId) throws UserNotFoundException;

    List<Student> getPendingGradeStudents();


    void generateGradeCard(String studentId, String semester) throws GradeNotAllottedException;

}