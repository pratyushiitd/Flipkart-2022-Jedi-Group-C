package com.flipkart.bean;

public abstract class User {
    private String name;
    private String role;
    private int userID;
    private String password;
    private long mobile;
    private String email_id;


    public User(int userID){
        this.userID = userID;
    }
    //constructor for user
    public User(String name, String role, int userID, String password, long mobile, String email_id) {
        this.name = name;
        this.role = role;
        this.userID = userID;
        this.password = password;
        this.mobile = mobile;
        this.email_id = email_id;
    }
    public User(){

    }
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

    public int getUserID(){
        return this.userID;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public String getPassword(){
        return this.password;
    }

    public void setMobile(long mobile){
        this.mobile=mobile;
    }

    public long getMobile(){
        return this.mobile;
    }

    public void setEmail_id(String email_id){
        this.email_id=email_id;
    }

    public String getEmail_id(){
        return this.email_id;
    }

}
