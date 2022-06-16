package com.flipkart.dao;

public interface StudentDAO {
    public  void viewStudentDetails(String studentID);
    public  void viewStudentsList(String courseId,int sem);
    public void addStudent(String name,int role,String userId,String password,String emailId ,
                             int semester,int section,String department,float cg,String gender,String paymentId);

    public void addStudentRegistration(String courseId,String studentId,String student_name);
    public int studentSize();
}
