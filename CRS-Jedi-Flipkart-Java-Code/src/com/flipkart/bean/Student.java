package com.flipkart.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student extends User{


    public List<Integer> coursesEnrolled;


    private String rollNo;
    private int semester;
    private char section;
    private String department;
    private float cg;
    private HashMap<String,Float> cg_course=new HashMap<>();
    private char gender;

    private boolean isRegistered;

    public Student(
        String name, 
        String role, 
        String userID,
        String password, 
        long mobile, 
        String email_id,
        String rollNo,
        int semester,
        char section,
        String department,
        float cg,
        char gender){

        super(name, role, userID, password, mobile, email_id);
        this.rollNo = rollNo;
        this.semester = semester;
        this.section = section;
        this.department = department;
        this.cg = cg;
        this.gender = gender;
    }

    public Student(){

    }
    
    public List<Integer> getCoursesEnrolled() {
        return coursesEnrolled;
    }

    public void setCoursesEnrolled(List<Integer> coursesEnrolled) {
        this.coursesEnrolled = coursesEnrolled;
    }



    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public float getCourseCg(String courseID) {
        try{
            return cg_course.get(courseID);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }
    public float getCg(){
        try{
            float sum_cg=0;
            float counter=0;
            for (Map.Entry mapElement : cg_course.entrySet()) {
                Float key = (Float)mapElement.getKey();
                sum_cg+=key;
                ++counter;

            }
            return sum_cg/counter;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }
    public void setCg(float cg,String courseID) {
        try{
            cg_course.put(courseID,cg);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean registered) {
        this.isRegistered = registered;
    }


    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public char getSection() {
        return section;
    }

    public void setSection(char section) {
        this.section = section;
    }

    public void viewStudent() {
        System.out.println("Id"+rollNo);
        System.out.println("role"+this.getRole());
        System.out.println("dep"+this.getDepartment());
        System.out.println("section"+getSection());
    }
}