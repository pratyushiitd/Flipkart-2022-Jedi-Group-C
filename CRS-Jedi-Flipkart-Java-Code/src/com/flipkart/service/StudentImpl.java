package com.flipkart.service;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import com.flipkart.bean.Course;
import com.flipkart.bean.GradeCard;
import com.flipkart.bean.Student;
;
public class StudentImpl implements StudentInterface{

        public HashMap<Student, List<String>> registeredCourses_pending;

        // constructor
        public StudentImpl() {
            this.registeredCourses_pending = new HashMap<Student, List<String>>();
        }
        /**
         * @param studentID
         * @param courseID
         * @return
         */
        public boolean isCourseforStudent(String studentID, String courseID) {
            for(Student student : registeredCourses_pending.keySet()) {
                if(student.getUserID().equals(studentID)) {
                    for(String course : registeredCourses_pending.get(student)) {
                        if(course.equals(courseID)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        /**
         * @param studentID
         * @param courseID
         */
        public void setRegisteredCourse_student(String studentID, String courseID)
        {
                boolean found = false;
            for(Student student : registeredCourses_pending.keySet())
            {
                if(student.getUserID().equals(studentID))
                {
                    registeredCourses_pending.get(student).add(courseID);
                    found = true;
                    break;
                }
            }
            if (!found){
                    // print student not found
                    System.out.println("Student not found, Register first");
            }
        }

        /**
         * @param student
         */
        public void addStudent(Student student){
            registeredCourses_pending.put(student, new ArrayList<String>());
        }
        public void showStudentMenu() {
                System.out.println("1. Register for a course");
                System.out.println("2. Pay Fees");
                System.out.println("3. Update Student");
                System.out.println("4. View Grade Card");
                System.out.println("5. Add Course");
                System.out.println("6. Remove Course");
                System.out.println("7. View All Courses");
                System.out.println("8. Logout");
        }
}
