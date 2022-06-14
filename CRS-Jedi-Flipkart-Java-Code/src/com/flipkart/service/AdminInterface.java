package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

import java.util.List;

public interface AdminInterface {
        public boolean addProfessor(String name,String userID,String password,long mobile,String email_id,
                                    String professorID,String department,String designation,String office, List<String> courseList);
                public Professor professorDetails(List<Professor> professorsList, String professorID);
        public Student studentDetails(List<Student> studentList,String studentID);
        public boolean approveCourses(String studentID,List<Student> studentsList);
        public String addCourse(Course course, int semester );
        public int getNumProf();
        public boolean removeCourses(String courseID,int semester);
        public void createAdmin(String name,String role,String userId,String password,long mobile,String emailID
                ,String adminID) ;

        }
