package com.flipkart.dao;

public interface UserDAO {
    public boolean login(String userId, String password);
    public boolean reset_password(String userId,String old_password,String new_password);
    public void addUser(String userID, String name, String password, int role, String email_id);

    public int getRole(String userId);
}
