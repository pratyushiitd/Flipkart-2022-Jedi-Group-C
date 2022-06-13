package com.flipkart.service;

import java.util.List;
import java.util.ArrayList;

import com.flipkart.bean.GradeCard;
import com.flipkart.bean.Student;
;
public class StudentImpl implements StudentInterface{

        List<Student> students = new ArrayList<Student>();

        public GradeCard gc = new GradeCard();
        public void addCourse(int studentId, int courseid) {
            
        }

        public void dropCourse(int studentid, int courseid) {
            
        }

        public void viewResults(int studentid) {
            
        }   

        public void viewSchedule(int studentid) {
            
        }

        // add student to the list
        public void addStudent() {
                Student student = new Student(
                        "John",
                        "student",
                        1,
                        "password",
                        1234567890,
                        "abc@flipkart.com",
                        1,
                        1,
                        'A',
                        "CSE",
                        9.5f,
                        'M'
                );
                students.add(student);
        }
        // delelete student from the list
        public void deleteStudent(int studentid) {
                for(Student student : students) {
                        if(student.getUserID() == studentid) {
                                students.remove(student);
                                break;
                        }
                }
        }
        // update student details
        public void updateStudent(int studentid, String name, String password, long mobile, String email_id, char section) {
                for(Student student : students) {
                        if(student.getUserID() == studentid) {
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


        public void viewStudent(int studentid) {
                for(Student student : students) {
                        if(student.getUserID() == studentid) {
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

        public void viewCoursesEnrolled(int studentid) {
                for(Student student : students) {
                        if(student.getUserID() == studentid) {
                                System.out.println(student.getCoursesEnrolled());
                                break;
                        }
                }
        }

       public void addCourseEnrolled(int studentid, int courseid) {
                for(Student student : students) {
                        if(student.getUserID() == studentid) {
                                student.getCoursesEnrolled().add(courseid);
                                break;
                        }
                }
        }

        public void dropCourseEnrolled(int studentid, int courseid) {
                for(Student student : students) {
                        if(student.getUserID() == studentid) {
                                student.getCoursesEnrolled().remove(courseid);
                                break;
                        }
                }
        }

        // view grade card
        public void viewGradeCard(int studentid) {
                for(Student student : students) {
                        if(student.getUserID() == studentid) {
                                gc.printGrades();
                                break;
                        }
                }
        }
}
