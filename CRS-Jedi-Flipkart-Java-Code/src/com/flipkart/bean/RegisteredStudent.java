package com.flipkart.bean;
import java.util.HashMap;
import java.util.List;
import com.flipkart.bean.Student;

public class RegisteredStudent extends User {

    HashMap<Integer, List<Student>> registeredStudents;

    public List<Student> getRegisteredStudentList(int semester){
        return registeredStudents.get(semester);
    }


    public void setRegisteredStudents(int semester, List<Student> registeredStudentsList) {
        registeredStudents.put(semester,registeredStudentsList);
    }
}
