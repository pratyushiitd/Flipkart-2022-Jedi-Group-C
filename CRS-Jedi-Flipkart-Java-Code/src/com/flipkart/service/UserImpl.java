package com.flipkart.service;
import java.util.List;
import java.util.ArrayList;

import com.flipkart.bean.User;

public class UserImpl implements UserInterface{

    List<User> users = new ArrayList<User>();

    @Override 
    public int getRole(String userID) {
        for(User user : users) {
            if(user.getUserID().equals(userID)) {
                return user.getRole();
            }
        }
        return -1;
    }
    @Override
    public boolean resetPassword(String userID, String newPassword) {
        try{
            for(User user: users){
                if(user.getUserID().equals(userID)){
                    user.setPassword(newPassword);
                    return true;
                }
            }
        }
        catch(Exception e){
            return false;
        }
        return false;
    }

    @Override
    public boolean login(String userID, String password) {
        try{
            for(User user: users){
                if(user.getUserID().equals(userID) && user.getPassword().equals(password)){
                    return true;
                }
            }
        }
        catch(Exception e){
            return false;
        }
        return false;
    }

    @Override
    public boolean register(String name, int role, String userID, String password, String email_id) {
        try{
            User user= new User(name, role, userID, password, email_id);
            users.add(user);
            return true;
        }
        catch(Exception e){

        }
        return false;
    }

    @Override
    public boolean setname(String userId,String name) {
        try{
            for(User user: users){
                if(user.getUserID().equals(userId)){
                    user.setName(name);
                    return true;
                }
            }
        }
        catch(Exception e){
            return false;
        }
        return false;
    }

    @Override
    public boolean setrole(String userId,int role) {
        try{
            for(User user: users){
                if(user.getUserID().equals( userId)){
                    user.setRole(role);
                    return true;
                }
            }
        }
        catch(Exception e){
            return false;
        }
        return false;
    }


    @Override
    public boolean setemail(String userId, String email_id) {
        try{
            for(User user: users){
                if(user.getUserID().equals(userId)){
                    user.setEmail_id(email_id);
                    return true;
                }
            }
        }
        catch(Exception e){
            return false;
        }
        return false;
    }

    @Override
    public boolean setpassword(String userId, String password) {
        try{
            for(User user: users){
                if(user.getUserID().equals(userId)){
                    user.setPassword(password);
                    return true;
                }
            }
        }
        catch(Exception e){
            return false;
        }
        return false;
    }
}
