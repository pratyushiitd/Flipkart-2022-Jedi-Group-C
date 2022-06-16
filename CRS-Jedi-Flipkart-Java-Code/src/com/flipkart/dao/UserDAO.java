package com.flipkart.dao;

public interface UserDAO {
    public void login(String userId, String password);
    public void reset_password(String userId,String old_password,String new_password);
    public void register_student(String userID, String name, String password, int role, String email_id, int semester, int section, String department, String gender);

}
