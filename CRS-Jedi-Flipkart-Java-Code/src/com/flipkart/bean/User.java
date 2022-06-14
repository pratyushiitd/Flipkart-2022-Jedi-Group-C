package com.flipkart.bean;

public abstract class User {
    private String name;
    private String role;
    private String userID;
    private String password;
    private String email_id;


    public User(String userID){
        this.userID = userID;
    }
    //constructor for user
    public User(String name, String role, String userID, String password,String email_id) {
        this.name = name;
        this.role = role;
        this.userID = userID;
        this.password = password;
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

    public void setUserID(String userID){
        this.userID=userID;
    }

    public String getUserID(){
        return this.userID;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public String getPassword(){
        return this.password;
    }

    public void setEmail_id(String email_id){
        this.email_id=email_id;
    }

    public String getEmail_id(){
        return this.email_id;
    }

}
