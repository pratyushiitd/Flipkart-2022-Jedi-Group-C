package com.flipkart.service;


public interface UserInterface {
    boolean resetPassword(String userID, String newPassword);
    public boolean login(String userID,String password);
    public boolean register(String name, int role, String userID, String password, String email_id);
    public boolean setname(String userId, String name);
    public boolean setrole(String userId, int role);
    // public boolean setmobile(String userId, long mobile);
    public boolean setemail(String userId, String email_id);
    public boolean setpassword(String userId, String password);
    public int getRole(String userID);
}
