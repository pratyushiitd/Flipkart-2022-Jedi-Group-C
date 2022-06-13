package com.flipkart.service;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

public interface AdminInterface {
        public boolean addProfessor(int professorID,int courseID);
        public Professor professorDetails(int professorID);
        public Student studentDetails(int studentID);
        public boolean approveCourses(int studentID);
        public boolean addCourse(int courseID,int semester);
        public boolean removeCourses(int courseID,int semester);
}
