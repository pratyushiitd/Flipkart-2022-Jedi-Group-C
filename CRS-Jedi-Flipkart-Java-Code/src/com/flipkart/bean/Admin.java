package com.flipkart.bean;

public class Admin extends User{

    private int adminID;

    public Admin(String name, String role, int userID, String password, long mobile, String email_id, int adminID) {
        super(name, role, userID, password, mobile, email_id);
        this.adminID = adminID;
    }
    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }
}
