package com.flipkart.service;


import com.flipkart.bean.Student;

public interface StudentInterface {

    // public void addStudent();
    // public void deleteStudent(String studentid);
    // public void updateStudent(String studentid, String name, String password, long mobile, String email_id, char section);
    // public void viewStudent(String studentid);
    // public void viewAllStudents();
    // public void viewCoursesEnrolled(String studentid);
    // public void addCourseEnrolled(String studentid, int courseid);
    // public void dropCourseEnrolled(String studentid, int courseid);
    // public void viewStudentGrade(String studentid);
    // public void payFees(String studentid, int courseid, float fees);
    public void showStudentMenu();
    public void setRegisteredCourse_student(String studentID, String courseID);
    public boolean isCourseforStudent(String studentID, String courseID);
    void addStudent(Student stud);
}
