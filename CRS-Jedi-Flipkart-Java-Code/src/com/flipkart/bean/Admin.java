package com.flipkart.bean;

public class Admin extends User{

    private String adminID;

    public Admin(String name, String role, String userID, String password, String email_id) {
        super(name, role, userID, password, email_id);
    }
    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }
}
