package com.flipkart.application;

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


    public static void admin(){
        while(true){
            adminRef.displayAdminMenu();
            int choice=new Scanner(System.in).nextInt();
            if (choice == 8)break;
            switch(choice){
                case 1:
                    Professor prof = adminRef.addProfessorAdmin();
                    // register prof
                    userRef.register(prof.getName(), "professor", prof.getUserID(), prof.getPassword(), prof.getEmail_id());
                    break;
                case 2:
                    Student stud = adminRef.addStudentAdmin();
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
                    System.out.println("Enter course id");
                    String courseId1 = new Scanner(System.in).nextLine();
                    System.out.println("Enter semester");
                    int semester1 = new Scanner(System.in).nextInt();
                    adminRef.approveCourseforStudent(studentId1,courseId1,semester1);
                    break;
            }
        }
    }
    public static void professor(){
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
            if (choice == 7)break;
            switch (choice) {
                case 1:
                    // register for course
                    // take course id as input
                    System.out.println("Enter course id");
                    String courseId = new Scanner(System.in).nextLine();
                    // take semester as input
                    System.out.println("Enter semester");
                    int semester = new Scanner(System.in).nextInt();
                    adminRef.approveCourseforStudent(userId, courseId, semester);
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
            }
        }
    }
        // main method
    public static void main(String[] args) {
        userRef.register("flipkart","admin","admin","jedi","admin@fk.com");
        // print welcome to course registration system
        System.out.println("Welcome to Course Registration System!");
        // WHILE LOOP -> LOGIN / LOGOUT
        while(true){
            int login_option = -1;
            System.out.println("\nPlease select an option from the following menu:");
            //println
            System.out.println("1. Login");
            System.out.println("2. Register a student");
            System.out.println("3. Exit");
            //scanner
            Scanner scanner = new Scanner(System.in);
            login_option = scanner.nextInt();
            if (login_option == 3){
                break;
            }
            if (login_option == 1){
                // login
                System.out.println("\nEnter the userID:");
                String userId = scanner.next();
                //println
                System.out.println("\nEnter the password:");
                String password = scanner.next();
                if (userRef.login(userId, password)){
                    System.out.println("\nLogin successful!");
                    //println
                    String role = userRef.getRole(userId);
                    if (role == "admin") admin(); 
                    else if (role == "professor") professor();
                    else if (role == "student") student(userId);
                    else System.out.println("\nInvalid role!");
                }
                else{
                    System.out.println("\nLogin failed!");
                    continue;
                }
            }
            else if (login_option == 2){
                // register a student
                Student stud = adminRef.addStudentAdmin();
                // register stud
                userRef.register(stud.getName(), "student", stud.getUserID(), stud.getPassword(), stud.getEmail_id());
            }
        }
    }
}

