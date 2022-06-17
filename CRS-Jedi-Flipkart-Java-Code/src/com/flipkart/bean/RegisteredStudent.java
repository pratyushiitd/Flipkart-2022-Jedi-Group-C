package com.flipkart.bean;
import com.flipkart.exception.CourseAlreadyRegisteredException;
import com.flipkart.exception.UserNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
public class RegisteredStudent extends User {

    HashMap<Student, List<Course>> courseEnrolled;
    HashMap<Student, GradeCard> gradeCards;
    List<Student> registeredStudents;

    // get students registered
    public int getnumcourses(String studentID) {
        // size of student list in courses enrolled
        int numcourses = 0;
        for (Student student : courseEnrolled.keySet()) {
            if (student.getUserID().equals(studentID)) {
                numcourses = courseEnrolled.get(student).size();
            }
        }
        return numcourses;
    }
    public void removeRegisteredCourse(String studentID, String courseID) {
        for (Student student : courseEnrolled.keySet()) {
            if (student.getUserID().equals(studentID)) {
                for (Course course : courseEnrolled.get(student)) {
                    if (course.getCourseID().equals(courseID)) {
                        courseEnrolled.get(student).remove(course);
                        return;
                    }
                }
            }
        }
    }
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
    public void clearRegisteredCourses(String studentID) {
        for(Student student : registeredStudents) {
            if(student.getUserID().equals(studentID)) {
                courseEnrolled.get(student).clear();
            }
        }
    }
    public void submitGrades(String studentID, Course course, int grade)
    throws UserNotFoundException {
        Student student = getStudent(studentID);
        UserNotFoundException UserNotFoundException = new UserNotFoundException(studentID);
        if (student == null) {
            assert UserNotFoundException != null;
            throw UserNotFoundException;
        }
        gradeCards.get(student).addGrade(course, grade);
    }
    public void addCourseforStudent(Student student, Course course)
    throws CourseAlreadyRegisteredException {
        if (courseEnrolled.get(student).contains(course)) {
            throw new CourseAlreadyRegisteredException(course.courseID);
        }
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
    public List<Course> getCourses(Student student) {
        return courseEnrolled.get(student);
    }
    public void showmycourses(String student_id){
        for(Student student : registeredStudents) {
            if(student.getUserID().equals(student_id)) {
                System.out.println("Courses of student with id: " + student_id +" are:") ;
                for(Course course : courseEnrolled.get(student)) {
                    System.out.println(course.getCourseID() + ": " + course.getCourseName());
                }
            }
        }
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
