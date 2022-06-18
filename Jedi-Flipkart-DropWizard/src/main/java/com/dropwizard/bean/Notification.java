package com.dropwizard.bean;


public class Notification {
    public void isPaymentDone() {
        Payment ob = new Payment();
        if(ob.isStatus()){
            System.out.println("Payment Successful!");
            System.out.println("Payment ID: "+ob.getPayment_id()+"\nTransaction ID: "+ob.getTransaction_id()+"\nRoll No. :"+ob.getRollNo()+"\nAmount paid: "+ob.getAmount());
        }
        else{
            System.out.println("Payment Failed!");
        }
    }

}