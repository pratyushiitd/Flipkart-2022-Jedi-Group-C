package com.flipkart.application;

import com.flipkart.exception.*;
import com.flipkart.service.UserImpl;
import com.flipkart.service.UserInterface;
import com.flipkart.service.AdminImpl;
import com.flipkart.service.AdminInterface;
import com.flipkart.service.ProfessorImpl;
import com.flipkart.service.ProfessorInterface;
import com.flipkart.service.StudentImpl;
import com.flipkart.service.StudentInterface;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

// list
// import scanner
import java.util.Scanner;

public class CRSApplication {

    public static UserInterface userRef=new UserImpl();
    public static AdminInterface adminRef=new AdminImpl();
    public static ProfessorInterface profRef = new ProfessorImpl();
    public static StudentInterface studentRef = new StudentImpl();


    public static void admin() throws ProfessorNotAddedException, UserIDAlreadyInUseException, CourseNotFoundException, StudentNotFoundForApprovalException, CourseAlreadyRegisteredException {
        while(true){
            adminRef.displayAdminMenu();
            int choice=new Scanner(System.in).nextInt();
            if (choice == 8)break;
            switch(choice){
                case 1:
                    adminRef.viewallcourses();
                    Professor prof = adminRef.addProfessorAdmin();
                    // register prof
                    userRef.register(prof.getName(), "professor", prof.getUserID(), prof.getPassword(), prof.getEmail_id());
                    break;
                case 2:
                    Student stud = adminRef.addStudentAdmin();
                    studentRef.addStudent(stud);
                    // register stud
                    userRef.register(stud.getName(), "student", stud.getUserID(), stud.getPassword(), stud.getEmail_id());
                    break;
                case 3:
                    adminRef.addCourseAdmin();
                    break;
                case 4:
                    // view professor details
                    // take professor id as input
                    System.out.println("Enter professor id");
                    String professorId = new Scanner(System.in).nextLine();
                    adminRef.viewprofessorDetails(professorId);
                    break;
                case 5:
                    // view student details
                    // take student id as input
                    System.out.println("Enter student id");
                    String studentId = new Scanner(System.in).nextLine();
                    adminRef.viewstudentDetails(studentId);
                    break;
                case 6:

                    // view course details
                    // take semester and course id as input
                    System.out.println("Enter semester");
                    int semester = new Scanner(System.in).nextInt();
                    System.out.println("Enter course id");
                    String courseId = new Scanner(System.in).nextLine();
                    adminRef.viewcoursedetail(semester,courseId);
                    break;
                case 7:

                    // approve course for student
                    // take student id and course id as input
                    System.out.println("Enter student id");
                    String studentId1 = new Scanner(System.in).next();

//                    adminRef.approveCourseforStudent(studentId1,courseId1,semester1);
                    // student found
                    int num_approved = 0;
                    for (String courseID: studentRef.getRegisteredCourses_student(studentId1)) {

                        boolean status = adminRef.approveCourseforStudent(studentId1, courseID);
                        // println
                        if (!status)continue;
                        System.out.println("Course approved");
                        if (++num_approved == 4)break;
                    }
                    break;
            }
        }
    }
    public static void professor() throws ProfessorNotAddedException {
        while(true){
            profRef.professorMenu();
            int choice=new Scanner(System.in).nextInt();
            if (choice == 4)break;
            switch(choice){
                case 1:
                    // view professor details
                    // take professor id as input
                    System.out.println("Enter professor id");
                    String professorId = new Scanner(System.in).nextLine();
                    adminRef.viewprofessorDetails(professorId);
                    break;
                case 2:
                    // view student details
                    // take student id as input
                     System.out.println("Enter course id");
                     String studentId = new Scanner(System.in).nextLine();

                        System.out.println("Enter semester");
                        int semester = new Scanner(System.in).nextInt();
//                     adminRef.viewstudentDetails(studentId);
                    adminRef.viewEnrolledStudents(studentId);


                    break;
                case 3:
                    // submit grades
                    // take student id, course id and grade as input
                    System.out.println("Enter student id");
                    String studentId1 = new Scanner(System.in).nextLine();
                    System.out.println("Enter course id");
                    String courseId1 = new Scanner(System.in).nextLine();
                    System.out.println("Enter grade");
                    //take semester as input
                    int semester1 = new Scanner(System.in).nextInt();


                    int grade = new Scanner(System.in).nextInt();
                    adminRef.submitGrades(studentId1,courseId1,grade, semester1);
                    break;
            }
        }
    }
    public static void student(String userId){
        while(true) {
            studentRef.showStudentMenu();
            int choice = new Scanner(System.in).nextInt();
            if (choice == 8)break;
            switch (choice) {
                case 1:
                    // register for course
                    // take course id as input
                    adminRef.viewallcourses();
                    for(int i = 1; i <= 6; i++) {
                        // println
                        System.out.println("Enter course"+Integer.toString(i)+ " id:");
                        String courseId = new Scanner(System.in).nextLine();
                        // take semester as input
                        studentRef.setRegisteredCourse_student(userId, courseId);
                    }
                    break;
                case 2:
                    // pay fees
                    // take semester as input
                    System.out.println("Enter semester");
                    int semester1 = new Scanner(System.in).nextInt();
                    System.out.println("Enter Amount");
                    int amount = new Scanner(System.in).nextInt();
                    System.out.println("Fees paid :)");
                    break;
                case 3:
                    // update student info
                    break;
                case 4:
                    // view grade card
                    // take semester as input
                    System.out.println("Enter semester");
                    int semester2 = new Scanner(System.in).nextInt();
                    break;
                case 7:
                    // view all courses
                    // take semester as input
//                    System.out.println("Enter semester");
//                    int semester3 = new Scanner(System.in).nextInt();
                    adminRef.viewmycourse(userId);
                    break;
            }
        }
    }
        // main method
    public static void main(String[] args) throws ProfessorNotAddedException, UserIDAlreadyInUseException, CourseAlreadyRegisteredException, CourseNotFoundException, StudentNotFoundForApprovalException {
        userRef.register("flipkart","admin","admin","jedi","admin@fk.com");
        // print welcome to course registration system
        System.out.println("-----------Welcome to Course Registration System!-------------");
        // WHILE LOOP -> LOGIN / LOGOUT
        while(true){
            int login_option = -1;
            System.out.println("Please select an option from the following menu:");
            //println
            System.out.println("1. Login");
            System.out.println("2. Register a student");
            System.out.println("3. Reset password");
            System.out.println("4. Exit");
            //scanner
            Scanner scanner = new Scanner(System.in);
            login_option = scanner.nextInt();
            if (login_option == 4){
                break;
            }
            if (login_option == 3) {
                System.out.println("Enter your user id");
                String userId = scanner.next();
                System.out.println("Enter your password");
                String password = scanner.next();
                if (!userRef.login(userId, password)) {
                    System.out.println("Invalid user id or password");
                } else {
                    // take new password as input
                    System.out.println("Enter new password");
                    String newPassword = scanner.next();
                        if (userRef.resetPassword(userId, newPassword)) {
                            System.out.println("Password reset successfully");
                        } else {
                            System.out.println("Password reset failed");
                        }
                    }
                }
            if (login_option == 1){
                // login
                System.out.println("Enter the userID:");
                String userId = scanner.next();
                //println
                System.out.println("Enter the password:");
                String password = scanner.next();
                if (userRef.login(userId, password)){
                    System.out.println("Login successful!");
                    //println
                    String role = userRef.getRole(userId);
                    if (role == "admin") admin(); 
                    else if (role == "professor") professor();
                    else if (role == "student") student(userId);
                    else System.out.println("Invalid role!");
                }
                else{
                    System.out.println("Login failed!");
                    continue;
                }
            }
            else if (login_option == 2){
                // register a student
                Student stud = adminRef.addStudentAdmin();
                studentRef.addStudent(stud);
                // register stud
                userRef.register(stud.getName(), "student", stud.getUserID(), stud.getPassword(), stud.getEmail_id());
            }
        }
    }
}

