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
}
