package com.flipkart.service;
import java.util.*;

public interface UserInterface {
    boolean resetPassword(String userID, String newPassword);
    public boolean login(String userID,String password);
    public boolean register(String name, String role, int userID, String password, long mobile, String email_id);
    public boolean setname(int userID);
    public boolean setrole(int userID);
    public boolean setmobile(int userID);
    public boolean setemail(int userID);
    public boolean setpassword(int userID);
}
