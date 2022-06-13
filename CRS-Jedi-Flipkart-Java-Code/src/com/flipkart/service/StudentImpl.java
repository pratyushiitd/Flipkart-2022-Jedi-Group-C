package com.flipkart.service;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import com.flipkart.bean.GradeCard;
import com.flipkart.bean.Student;
;
public class StudentImpl implements StudentInterface{

        List<Student> students = new ArrayList<Student>();

        //hashmap student grade
        public HashMap<String, GradeCard> studentGrade = new HashMap<String, GradeCard>();


        // add student to the list
        public void addStudent() {
                Student student = new Student(
                        "John",
                        "student",
<<<<<<< HEAD
                        "12345",
                        "password",
                        1234567890,
                        "abc@flipkart.com",
                        "1",
=======
                        "us1",
                        "password",
                        1234567890,
                        "abc@flipkart.com",
                        "s1",
>>>>>>> 3c24676ecd8c37d0604e6df4d43d386ab90fb637
                        1,
                        'A',
                        "CSE",
                        9.5f,
                        'M'
                );
                students.add(student);
        }
        // delelete student from the list
        public void deleteStudent(String studentid) {
                for(Student student : students) {
                        if(student.getUserID().equals(studentid)) {
                                students.remove(student);
                                break;
                        }
                }
        }
        // update student details
        public void updateStudent(String studentid, String name, String password, long mobile, String email_id, char section) {
                for(Student student : students) {
                        if(student.getUserID().equals(studentid)) {
                                student.setName(name);
                                student.setPassword(password);
                                student.setMobile(mobile);
                                student.setEmail_id(email_id);
                                student.setSection(section);
                                break;
                        }
                }
        }
        // view student details


        public void viewStudent(String studentid) {
                for(Student student : students) {
                        if(student.getUserID().equals(studentid)) {
                                System.out.println(student.getName());
                                System.out.println(student.getRole());
                                System.out.println(student.getUserID());
                                System.out.println(student.getPassword());
                                System.out.println(student.getMobile());
                                System.out.println(student.getEmail_id());
                                System.out.println(student.getRollNo());
                                System.out.println(student.getSemester());
                                System.out.println(student.getSection());
                                System.out.println(student.getDepartment());
                                System.out.println(student.getCg());
                                System.out.println(student.getGender());
                                break;
                        }
                }
        }
        // view all students

        public void viewAllStudents() {
                for(Student student : students) {
                        System.out.println(student.getName());
                        System.out.println(student.getRole());
                        System.out.println(student.getUserID());
                        System.out.println(student.getPassword());
                        System.out.println(student.getMobile());
                        System.out.println(student.getEmail_id());
                        System.out.println(student.getRollNo());
                        System.out.println(student.getSemester());
                        System.out.println(student.getSection());
                        System.out.println(student.getDepartment());
                        System.out.println(student.getCg());
                        System.out.println(student.getGender());
                }
        }

        public void viewCoursesEnrolled(String studentid) {
                for(Student student : students) {
                        if(student.getUserID().equals(studentid)) {
                                System.out.println(student.getCoursesEnrolled());
                                break;
                        }
                }
        }

<<<<<<< HEAD
       public void addCourseEnrolled(String studentid, int courseid) {
=======
       public void addCourseEnrolled(String studentid, String courseid) {
>>>>>>> 3c24676ecd8c37d0604e6df4d43d386ab90fb637
                for(Student student : students) {
                        if(student.getUserID().equals(studentid)) {
                                student.getCoursesEnrolled().add(courseid);
                                break;
                        }
                }
        }

<<<<<<< HEAD
        public void dropCourseEnrolled(String studentid, int courseid) {
=======
        public void dropCourseEnrolled(String studentid, String courseid) {
>>>>>>> 3c24676ecd8c37d0604e6df4d43d386ab90fb637
                for(Student student : students) {
                        if(student.getUserID().equals(studentid)) {
                                student.getCoursesEnrolled().remove(courseid);
                                break;
                        }
                }
        }

        // view student grade
        public void viewStudentGrade(String studentID){
<<<<<<< HEAD
        // iterate over hash map
                for(String key : studentGrade.keySet()) {
                        if(key.equals(studentID)) {
=======
                // iterate over hash map
                for(String key : studentGrade.keySet()) {
                        if(key == studentID) {
>>>>>>> 3c24676ecd8c37d0604e6df4d43d386ab90fb637
                                studentGrade.get(key).printGrades();
                                break;
                        }
                }
        }

        // pay fees

        public void payFees(String studentID, int courseID, float fees) {
                for(String key : studentGrade.keySet()) {
                        if(key.equals(studentID)) {
                                // studentGrade.get(key).payFees(courseID, fees);
                                break;
                        }
                }
        }
        @Override
        public List<Student> getStudents() {
                // TODO Auto-generated method stub
                return null;
        }
        @Override
        public void setStudents(List<Student> students) {
                // TODO Auto-generated method stub
                
        }
}
