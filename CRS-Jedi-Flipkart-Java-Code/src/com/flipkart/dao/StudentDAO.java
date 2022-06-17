package com.flipkart.dao;

import com.flipkart.bean.GradeCard;
import com.flipkart.bean.Payment;
import com.flipkart.exception.GradeCardNotGeneratedException;

public interface StudentDAO {

    boolean isApproved(String studentId);

    boolean submittedCourses(String studentId);
    boolean getFeeStatus(String studentId);
    String makePayment(Payment payment);
    void generatePaymentNotification(Payment payment);

    GradeCard viewGradeCard(String studentId) throws GradeCardNotGeneratedException;
    public  void viewStudentDetails(String studentID);
    public  void viewStudentsList(String courseId,int sem);
    public void addStudent(String name,int role,String userId,String password,String emailId ,
                             int semester,int section,String department,float cg,String gender,String paymentId);

    public void addStudentRegistration(String courseId,String studentId,String student_name);
    public int studentSize();
}
