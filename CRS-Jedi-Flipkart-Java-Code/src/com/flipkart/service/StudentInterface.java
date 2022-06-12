package com.flipkart.service;

import java.util.List;
import com.flipkart.bean.Student;

public interface StudentInterface {

    public void addCourse(int studentId, int courseid);

    public void dropCourse(int studentid, int courseid);

    public void viewCourses(int studentid);

    public void viewResults(int studentid);

    public void viewSchedule(int studentid);

    public void viewProfile(int studentid);

    public void submitGrades(int courseID, int studentID, int grade);

    public List<Student> getStudentsList(int courseID);

}
