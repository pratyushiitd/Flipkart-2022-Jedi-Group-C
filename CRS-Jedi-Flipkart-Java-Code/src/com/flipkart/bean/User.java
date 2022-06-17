package com.flipkart.bean;

public class User {
    private String name;
    private int role;
    private String userID;
    private String password;
    private String email_id;


    public User(String userID, String role,String id, String password, String email_id){
        this.userID = userID;
    }
    //constructor for user
    public User(String name, int role, String userID, String password,String email_id) {
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

    public void setRole(int role){
        this.role=role;
    }

    public int getRole(){
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
