package com.flipkart.service;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

import java.util.List;

public interface AdminInterface {
        public boolean addProfessor(String professorID, List<String> courseList);
        public Professor professorDetails(List<Professor> professorsList, String professorID);
        public Student studentDetails(List<Student> studentList,String studentID);
        public boolean approveCourses(String studentID,List<Student> studentsList);
        public String addCourse();
        public boolean removeCourses(String courseID,int semester);
        public void createAdmin();
}
