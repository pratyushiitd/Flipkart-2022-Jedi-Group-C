package com.flipkart.bean;

public class Payment{
    public String rollNo;
    public int amount;
    public boolean status;
    public String payment_id;
    public String transaction_id;

    public Payment(String rollNo, int amount, boolean status, String payment_id) {
        this.rollNo = rollNo;
        this.amount = amount;
        this.status = status;
        this.payment_id = payment_id;
    }

    public Payment() {
    }

    public String getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(String payment_id) {
        this.payment_id = payment_id;
    }

    public boolean isStatus() {
        return status;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public String setTransaction_id(String transaction_id) {
        return this.transaction_id = transaction_id;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }
}
