package com.flipkart.service;
import java.util.*;

public interface UserInterface {
    boolean resetPassword(String userID, String newPassword);
    public boolean login(String userID,String password);

}
