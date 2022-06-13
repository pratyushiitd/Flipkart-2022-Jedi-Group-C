package com.flipkart.service;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

public interface AdminInterface {
        public boolean addProfessor(String professorID,String courseID);
        public Professor professorDetails(String professorID);
        public Student studentDetails(String studentID);
        public boolean approveCourses(String studentID);
        public String addCourse();
        public boolean removeCourses(String courseID,int semester);
        public void createAdmin();
}
