package com.flipkart.dao;

public class Notification {

    public void sendNotification(String name, String paymentID){
        System.out.println("Payment successful!\nStudent name:"+name+"\nPayment ID is "+paymentID);
    }
}
