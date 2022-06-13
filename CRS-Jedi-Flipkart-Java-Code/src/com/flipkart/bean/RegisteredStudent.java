package com.flipkart.bean;
import java.util.List;

public class RegisteredStudent extends User {
    List<Student> registeredStudents;

    public List<Student> getRegisteredStudents() {
        return registeredStudents;
    }

    public void setRegisteredStudents(List<Student> registeredStudents) {
        this.registeredStudents = registeredStudents;
    }
}
