package com.flipkart.bean;

public class User {
    private String name;
    private String role;
    private int userID;
    private String password;
    private int mobile;
    private String email_id;

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }

    public void setRole(String role){
        this.role=role;
    }

    public String getRole(){
        return this.role;
    }

    public void setUserID(int userID){
        this.userID=userID;
    }

    public int setUserID(){
        return this.userID;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public String getPassword(){
        return this.password;
    }

    public void setMobile(int mobile){
        this.mobile=mobile;
    }

    public int getMobile(){
        return this.mobile;
    }

    public void setEmail_id(String email_id){
        this.email_id=email_id;
    }

    public String getEmail_id(){
        return this.email_id;
    }

}
