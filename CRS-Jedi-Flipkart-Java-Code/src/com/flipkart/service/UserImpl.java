package com.flipkart.service;


public class UserImpl implements UserInterface{


    @Override
    public boolean resetPassword(String userID, String newPassword) {
        return false;
    }

    @Override
    public boolean login(String userID, String password) {
        return false;
    }

    @Override
    public boolean register(String name, String role, int userID, String password, long mobile, String email_id) {
        return false;
    }

    @Override
    public boolean setname(int userID) {
        return false;
    }

    @Override
    public boolean setrole(int userID) {
        return false;
    }

    @Override
    public boolean setmobile(int userID) {
        return false;
    }

    @Override
    public boolean setemail(int userID) {
        return false;
    }

    @Override
    public boolean setpassword(int userID) {
        return false;
    }
}
