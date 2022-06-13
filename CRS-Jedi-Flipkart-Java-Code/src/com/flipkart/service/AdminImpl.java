package com.flipkart.service;

import com.flipkart.bean.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AdminImpl implements AdminInterface {
    List<Admin> admin=new ArrayList<Admin>();
    HashMap<Integer,List<String>> courseListSem=new HashMap<>();
    @Override
    public void createAdmin() {
        Admin admin1=new Admin("admin1","admin","UA1","password1",
                1234567890,"admin@gmail.com","A1");
        admin.add(admin1);

    }
    @Override
    public boolean addProfessor(String professorID, String courseID) {

        return false;
    }

    @Override
    public Professor professorDetails(String professorID) {

        return null;
    }

    @Override
    public Student studentDetails(String studentID) {
        Student student=
        return null;
    }

    @Override
    public boolean approveCourses(String studentID) {

        return false;
    }

    @Override
    public String addCourse() {
        List<Student> registeredStudents1=new ArrayList<>();
        RegisteredStudent registeredStudent=new RegisteredStudent();
        registeredStudents1=registeredStudent.getRegisteredStudents(1);
        Course course=new Course("C1","course 1","P1",registeredStudents1,10);
        List<String> courseList=new ArrayList<>();
        //check if sem already present just update the list of courses(list of string) in hashmap else make a new list
        courseList.add("C1");
        courseListSem.put(1,courseList);
        //courseList.add()
        return "C1";
    }

    @Override
    public boolean removeCourses(String courseID, int semester) {
        System.out.println("Course removed:"+courseID);
        (courseListSem.get(semester)).remove(courseID);
        return true;
    }


}
