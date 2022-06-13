package com.flipkart.bean;

public class Admin extends User{

    private String adminID;

    public Admin(String name, String role, String userID, String password, long mobile, String email_id, String adminID) {
        super(name, role, userID, password, mobile, email_id);
        this.adminID = adminID;
    }
    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }
}
