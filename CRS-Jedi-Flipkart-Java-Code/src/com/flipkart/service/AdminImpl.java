package com.flipkart.service;

import com.flipkart.bean.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AdminImpl implements AdminInterface {
    List<Admin> admin=new ArrayList<Admin>();
    HashMap<Integer,List<String>> courseListSem=new HashMap<>();//list corresponding to list of courses
    HashMap<Professor,List<String>> professorList=new HashMap<>();//list corresponding to professorID
    @Override
    public void createAdmin() {
        Admin admin1=new Admin("admin1","admin","UA1","password1",
                1234567890,"admin@gmail.com","A1");
        admin.add(admin1);

    }
    @Override
    public boolean addProfessor(String name,String userID,String password,long mobile,String email_id,String professorID,String department,String designation,String office, List<String> courseList) {
        Professor professor=new Professor(name,"professor",userID,password,mobile,email_id,professorID,department,designation,office,courseList);
        professorList.put(professor,courseList);
        return true;
    }

    @Override
    public Professor professorDetails(List<Professor> professorsList,String professorID) {
        try{
            for(Professor professor:professorsList){
                if(professor.getProfessorId().equals(professorID)){
                    return professor;
                }
            }
        }
        catch (Exception e)
        {
            return null;
        }
        return null;
    }

    @Override
    public Student studentDetails(List<Student> studentsList,String studentID) {
        try{
            for(Student student:studentsList){
                if(student.getRollNo().equals(studentID)){
                    return student;
                }
            }
        }
        catch (Exception e)
        {
            return null;
        }
        return null;
    }

    @Override
    public boolean approveCourses(String studentID,List<Student> studentsList) {
        try{
            for(Student student:studentsList){
                if(student.getRollNo().equals(studentID)&&student.isRegistered()==true){
                    return true;
                }
            }
        }
        catch (Exception e)
        {
            return false;
        }
        return false;
    }

    @Override
    public String addCourse() {
        List<Student> registeredStudents1=new ArrayList<>();
        RegisteredStudent registeredStudent=new RegisteredStudent();
        registeredStudents1=registeredStudent.getRegisteredStudentList(1);
        Course course=new Course("C1","course 1","P1",registeredStudents1,10);
        List<String> courseList=new ArrayList<>();
        //check if sem already present just update the list of courses(list of string) in hashmap else make a new list
        courseList.add("C1");
        courseListSem.put(1,courseList);
        System.out.println("Course added:C1");
        return "C1";
    }

    @Override
    public boolean removeCourses(String courseID, int semester) {
        System.out.println("Course removed:"+courseID);
        (courseListSem.get(semester)).remove(courseID);
        return true;
    }


}
