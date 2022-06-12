package com.flipkart.bean;

public class Admin extends User{
    private int adminID;

    public Admin(int adminId){
        this.adminID = adminId;
    }
    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }
}
