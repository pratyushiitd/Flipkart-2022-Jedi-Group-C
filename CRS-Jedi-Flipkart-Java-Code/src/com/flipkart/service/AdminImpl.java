package com.flipkart.service;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

public class AdminImpl implements AdminInterface {

    @Override
    public boolean addProfessor(int professorID, int courseID) {
        return false;
    }

    @Override
    public Professor professorDetails(int professorID) {
        return null;
    }

    @Override
    public Student studentDetails(int studentID) {
        return null;
    }

    @Override
    public boolean approveCourses(int studentID) {
        return false;
    }

    @Override
    public boolean addCourse(int courseID, int semester) {
        return false;
    }

    @Override
    public boolean removeCourses(int courseID, int semester) {
        return false;
    }
}
