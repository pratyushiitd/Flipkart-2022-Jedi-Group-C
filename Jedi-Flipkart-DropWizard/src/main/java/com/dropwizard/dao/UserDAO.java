package com.dropwizard.dao;

import com.dropwizard.exception.EmailAlreadyInUseException;
import com.dropwizard.exception.UserNotAddedException;

public interface UserDAO {
    public void login(String userId, String password);
    public boolean reset_password(String userId,String old_password,String new_password);
    public void addUser(String userID, String name, String password, int role, String email_id) throws UserNotAddedException, EmailAlreadyInUseException ;
    public int getRole(String userId);
}
