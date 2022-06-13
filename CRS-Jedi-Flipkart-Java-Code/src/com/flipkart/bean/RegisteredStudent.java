package com.flipkart.bean;
import java.util.HashMap;
import java.util.List;
import com.flipkart.bean.Student;

public class RegisteredStudent extends User {

    HashMap<Integer, List<Student>> registeredStudents;

    public List<Student> getRegisteredStudentList(int semester){
        return registeredStudents.get(semester);
    }

    public HashMap<Integer, List<Student>> getRegisteredStudents() {
        return registeredStudents;
    }

    public void setRegisteredStudents(HashMap<Integer, List<Student>> registeredStudents) {
        this.registeredStudents = registeredStudents;
    }
}
