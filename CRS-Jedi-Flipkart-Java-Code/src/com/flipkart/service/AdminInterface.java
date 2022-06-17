package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.exception.*;

public interface AdminInterface {
        public Professor addProfessor(String name,String userID,String password,String email_id,
                                    String department);
        public boolean viewprofessorDetails(String professorID) throws ProfessorNotAddedException;
        public boolean viewstudentDetails(String studentID);
        public void viewcoursedetail(int semester, String courseID);
        // public boolean approveCourses(String studentID,List<Student> studentsList);
        public void addCourse(Course course, int semester );
        public boolean approveCourseforStudent(String studentID, String courseID) throws CourseNotFoundException, StudentNotFoundForApprovalException, CourseAlreadyRegisteredException;
        // public int getNumProf();
        // public boolean removeCourses(String courseID,int semester);
        // public void createAdmin(String name,String role,String userId,String password,long mobile,String emailID
        //         ,String adminID) ;

        public Student addStudent(String name_student, String userId_student, String password_student, String email_id_student, int semester_student, char section_student, String department, char gender);
        public void displayAdminMenu();
        public Professor addProfessorAdmin();
        public Student addStudentAdmin();
        public void addCourseAdmin();

        public void viewEnrolledStudents(String courseID);
        public void submitGrades(String studentId, String courseId, int grade,int semester) throws UserNotFoundException;

    void viewallcourses();

        void viewmycourse(String userId);

        void clearRegisteredCourses_student(String studentId1);

        void removeRegisteredCourse_student(String userId, String courseId1);
}
