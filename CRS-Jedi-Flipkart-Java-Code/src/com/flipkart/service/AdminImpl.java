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
    public void createAdmin(String name,String role,String userId,String password,long mobile,String emailID,String adminID) {
        Admin admin1=new Admin(name,role,userId,password,mobile,emailID,adminID);
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
    public String addCourse(Course course,int semester ) {
        List<Student> registeredStudents=new ArrayList<>();
        RegisteredStudent registeredStudent=new RegisteredStudent();
        registeredStudents=registeredStudent.getRegisteredStudentList(semester);
        List<String> courseList=new ArrayList<>();
        if(courseListSem.containsKey(semester)==true)
        {
            courseList=courseListSem.get(semester);
            courseList.add(course.courseID);
            courseListSem.put(semester,courseList);
        }
        else {
            courseList.add(course.courseID);
            courseListSem.put(semester,courseList);
        }
        System.out.println("Course added:"+course.courseName+" with course ID:"+course.courseID);
        return course.courseID;
    }

    @Override
    public boolean removeCourses(String courseID, int semester) {
        System.out.println("Course removed:"+courseID);
        (courseListSem.get(semester)).remove(courseID);
        return true;
    }


}
