package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

import java.util.List;

public interface AdminInterface {
        public Professor addProfessor(String name,String userID,String password,String email_id,
                                    String department);
        public boolean viewprofessorDetails(String professorID);
        public boolean viewstudentDetails(String studentID);
        public void viewcoursedetail(int semester, String courseID);
        // public boolean approveCourses(String studentID,List<Student> studentsList);
        public void addCourse(Course course, int semester );
        public void approveCourseforStudent(String studentID, String courseID, int semester);
        // public int getNumProf();
        // public boolean removeCourses(String courseID,int semester);
        // public void createAdmin(String name,String role,String userId,String password,long mobile,String emailID
        //         ,String adminID) ;
        public  void approveStudent(String studentId, List<Course> courseChoiceList, int semester);
        public Student addStudent(String name_student, String userId_student, String password_student, String email_id_student, int semester_student, int section_student, String department, String gender);
        public void displayAdminMenu();
        public Professor addProfessorAdmin(String uid);
        public Student addStudentAdmin();
        public void addCourseAdmin();

        public void viewEnrolledStudents(String courseID);
        public void submitGrades(String studentId, String courseId, int grade,int semester);

    void viewallcourses();
}
