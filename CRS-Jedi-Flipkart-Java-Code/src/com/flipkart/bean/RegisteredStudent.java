package com.flipkart.bean;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
public class RegisteredStudent extends User {

    HashMap<Student, List<Course>> courseEnrolled;
    HashMap<Student, GradeCard> gradeCards;
    List<Student> registeredStudents;

    // get students registered 
    public RegisteredStudent() {
        this.courseEnrolled = new HashMap<Student, List<Course>>();
        this.gradeCards = new HashMap<Student, GradeCard>();
        this.registeredStudents = new ArrayList<Student>();
    }
    public List<Student> getRegisteredStudents() {
        return registeredStudents;
    }
    // add student to registered students
    public void addStudent(Student student) {
        registeredStudents.add(student);
        courseEnrolled.put(student, new ArrayList<Course>());
        gradeCards.put(student, new GradeCard(student));
    }
    public void submitGrades(String studentID, Course course, int grade) {
        Student student = getStudent(studentID);
        gradeCards.get(student).addGrade(course, grade);
    }
    public void addCourseforStudent(Student student, Course course) {
        courseEnrolled.get(student).add(course);
    }
    public Student getStudent(String studentID) {
        for(Student student : registeredStudents) {
            if(student.getUserID().equals(studentID)) {
                return student;
            }
        }
        return null;
    }
    // show courses of student
    public void showCourses(String studentID) {
        Student student = getStudent(studentID);
        if (student == null) {
            System.out.println("Student not found");
        } else {
            System.out.println("Courses of " + student.getName());
            for(Course course : courseEnrolled.get(student)) {
                System.out.println(course.getCourseName());
            }
        }
    }
}
