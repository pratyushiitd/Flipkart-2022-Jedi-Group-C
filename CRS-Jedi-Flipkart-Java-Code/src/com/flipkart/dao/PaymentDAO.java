package com.flipkart.dao;

public interface PaymentDAO {
    public void getDetails(String studentId);
    public int getSize();
    public void makePayment(String studentId, String paymentId);
}
