package com.flipkart.application;

import com.flipkart.bean.Course;
import com.flipkart.bean.CourseCatalogue;
import com.flipkart.constants.SQLQueryConstants;
import com.flipkart.dao.*;
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
import java.util.List;
import java.util.Scanner;

public class CRSApplication {

    public static CourseDAO courseDAO=new CourseDAOImpl();
    public static GradeDAO gradeDAO=new GradeDAOImp();
    public static PaymentDAO paymentDAO=new PaymentDAOImpl();
    public static ProfessorDAO profRefDAO= new ProfessorDAOImpl();
    public static UserDAO userRefDAO= new UserDAOImpl();
    public static StudentDAO studentRefDAO= new StudentDAOImpl();
    public static AdminDAO adminRefDAO= new AdminDAOImpl() ;
    public static UserInterface userRef=new UserImpl();
    public static AdminInterface adminRef=new AdminImpl();
    public static ProfessorInterface profRef = new ProfessorImpl();
    public static StudentInterface studentRef = new StudentImpl();


    public static void admin() throws ProfessorNotAddedException, UserIDAlreadyInUseException, UserNotAddedException, EmailAlreadyInUseException, UserNotFoundException {
        while(true){
            adminRef.displayAdminMenu();
            int choice=new Scanner(System.in).nextInt();
            if (choice == 8)break;
            switch(choice){
                case 1:
                    int size=adminRefDAO.professorSize()+1;
                    String uid="p00"+size;
                    Professor prof = adminRef.addProfessorAdmin(uid);
                    // register prof

                    //userRef.register(prof.getName(), SQLQueryConstants.professorRole, prof.getUserID(), prof.getPassword(), prof.getEmail_id());
                    //add professor to user table
                    userRefDAO.addUser(prof.getUserID(),prof.getName(),prof.getPassword(),SQLQueryConstants.professorRole,prof.getEmail_id());
                    //add professor to professor table
                    adminRefDAO.addProfessor(prof.getUserID(),prof.getName(), prof.getPassword(), prof.getEmail_id(),prof.getDepartment());

                    break;
                case 2:
                    Student stud = adminRef.addStudentAdmin();
                    studentRef.addStudent(stud);
                    //added to student table
                    studentRefDAO.addStudent( stud.getName(), SQLQueryConstants.studentRole,stud.getUserID(), stud.getPassword(), stud.getEmail_id(), stud.getSemester(),
                            stud.getSection(), stud.getDepartment(), 0.0f, stud.getGender(), null);
                    //added to user table
                    userRefDAO.addUser(stud.getUserID(), stud.getName(), stud.getPassword(), SQLQueryConstants.studentRole, stud.getEmail_id());
                    // register stud

                    //studentRefDAO.addStudentRegistration(stud.(),stud.getUserID());
                    //userRef.register(stud.getName(), SQLQueryConstants.studentRole, stud.getUserID(), stud.getPassword(), stud.getEmail_id());

                    break;
                case 3:

                    adminRef.addCourseAdmin();

                    break;
                case 4:
                    // view professor details
                    // take professor id as input
                    System.out.println("Enter professor id");
                    String professorId = new Scanner(System.in).nextLine();
                    //adminRef.viewprofessorDetails(professorId);
                    profRefDAO.viewProfessorDetails(professorId);
                    break;
                case 5:
                    // view student details
                    // take student id as input
                    System.out.println("Enter student id");
                    String studentId = new Scanner(System.in).nextLine();
                    studentRefDAO.viewStudentDetails(studentId);
                    //adminRef.viewstudentDetails(studentId);
                    break;
                case 6:

                    // view course details
                    // take semester and course id as input
                    System.out.println("Enter semester");
                    int semester = new Scanner(System.in).nextInt();
                    System.out.println("Enter course id");
                    String courseId = new Scanner(System.in).nextLine();
                    //adminRef.viewcoursedetail(semester,courseId);
                    courseDAO.viewCourseDetails(courseId);
                    break;
                case 7:

                    // approve course for student
                    // take student id and course id as input
                    adminRefDAO.approveCourses();
//                    adminRef.approveCourseforStudent(studentId1,courseId1,semester1);
//                    // student found
//                    if (studentRef.isCourseforStudent(studentId1,courseId1)){
//                        adminRef.approveCourseforStudent(studentId1,courseId1,semester1);
//                        // println
//                        System.out.println("Course approved");
//                    }
//                    else{
//                        System.out.println("Course not Registered!");
//                    }
                    break;
            }
        }
    }
    public static void professor() throws CourseNotFoundException {
        while(true){
            profRef.professorMenu();
            int choice=new Scanner(System.in).nextInt();
            if (choice == 4)break;
            switch(choice){
                case 1:
                    // view professor details
                    // take professor id as input
                    System.out.println("Enter professor id");
                    String professorId = new Scanner(System.in).nextLine();                    //adminRef.viewprofessorDetails(professorId);

                    profRefDAO.viewProfessorDetails(professorId);

                    break;
                case 2:
                    // view student details
                    // take student id as input
                     System.out.println("Enter course id");
                     String courseId = new Scanner(System.in).nextLine();

                        System.out.println("Enter semester");
                        int semester = new Scanner(System.in).nextInt();
//                     adminRef.viewstudentDetails(studentId);
                    //adminRef.viewEnrolledStudents(courseId);
                    profRefDAO.viewStudentsList(courseId,semester);

                    break;
                    //to do
                case 3:
                    // submit grades
                    // take student id, course id and grade as input after approval
                   // System.out.println("Enter student id");
                    //String studentId1 = new Scanner(System.in).nextLine();
                    System.out.println("Enter course id");
                    String courseId1 = new Scanner(System.in).nextLine();

                    System.out.println("Enter grade");
                    //take semester as input
                    int semester1 = new Scanner(System.in).nextInt();


                    int grade = new Scanner(System.in).nextInt();
                    //adminRef.submitGrades(studentId1,courseId1,grade, semester1);
                   // profRefDAO.submitGrades(studentId1,grade,courseId1);
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
                    // pay fees
                    // take semester as input
                    System.out.println("Enter semester");
                    int semester1 = new Scanner(System.in).nextInt();
                    System.out.println("Pay Rs 100000");
                    //int amount = new Scanner(System.in).nextInt();
                    System.out.println("Fees paid successfully!");
                    int size= paymentDAO.getSize()+1;
                    String paymentId="py00"+size;
                    paymentDAO.makePayment(userId,paymentId);
                    paymentDAO.getDetails(userId);
                    break;
                case 2:
                    // view grade card
                    // take semester as input
                    System.out.println("Enter semester");
                    int semester2 = new Scanner(System.in).nextInt();
                    gradeDAO.generateGrade(userId);
                    //gpa karo generate
                    //update in student
                    break;
                case 3:
                    //addcourse

                    break;
                case 4:
                    //remove course
                    break;
                case 5:
                    // view all courses
                    // take semester as input
//                    System.out.println("Enter semester");
//                    int semester3 = new Scanner(System.in).nextInt();
                    courseDAO.viewCourseStudent(userId);
                   // adminRef.viewallcourses();
                    break;
                case 6:
                    //exit
                    System.out.println("Logged out successfully");
                    break;
            }
        }
    }
        // main method
    public static void main(String[] args) throws ProfessorNotAddedException, UserIDAlreadyInUseException, UserNotAddedException, EmailAlreadyInUseException, UserNotFoundException, CourseNotFoundException {
        userRef.register("flipkart",SQLQueryConstants.adminRole,"a001","jedi","admin@fk.com");
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
                //exit
                break;
            }
            if (login_option == 3) {
                //reset password
                System.out.println("Enter your user id");
                String userId = scanner.next();
                System.out.println("Enter your password");
                String password = scanner.next();
                userRefDAO.login(userId, password);
                    {
                    // take new password as input
                    System.out.println("Enter new password");
                    String newPassword = scanner.next();
                    if(userRefDAO.reset_password(userId,password,newPassword))
                    {
                        System.out.println("Password reset successfully!");
                    }
                    else {
                        System.out.println("Password couldn't be reset");
                    }
                }}
            if (login_option == 1){
                // login
                System.out.println("Enter the userID:");
               String userId = scanner.next();
                //println
                System.out.println("Enter the password:");
                String password = scanner.next();
                userRefDAO.login(userId, password);
                //    System.out.println("Login successful!");
                    //println
                    int role = userRefDAO.getRole(userId);
                    if (role == SQLQueryConstants.adminRole) admin();
                    else if (role == SQLQueryConstants.professorRole) professor();
                    else if (role == SQLQueryConstants.studentRole) student(userId);
                    else System.out.println("Invalid role!");
            }
            else if (login_option == 2){
                // register a student
                Student stud = adminRef.addStudentAdmin();
                studentRef.addStudent(stud);
                int size=studentRefDAO.studentSize()+1;
                stud.setUserID("s0"+size);
                //adding in student table
                studentRefDAO.addStudent(stud.getName(),SQLQueryConstants.studentRole,stud.getUserID(),stud.getPassword()
                ,stud.getEmail_id(),stud.getSemester(),stud.getSection(),stud.getDepartment(), stud.getCg(), stud.getGender()
                ,null);
                //view all courses of dept of student
                courseDAO.showCourses(stud.getDepartment());
                System.out.println("Enter 6 courses of your choice(course id)");
                String studID=stud.getUserID();
                String studName=stud.getUserID();
                for(int i=0;i<6;i++)
                {
                    String courseId=scanner.next();
                    //registration table
                    studentRefDAO.addStudentRegistration(studID,courseId,studName);
                }
                // register stud in users table
                userRef.register(stud.getName(), SQLQueryConstants.adminRole, stud.getUserID(), stud.getPassword(), stud.getEmail_id());
                userRefDAO.addUser(studID,studName,stud.getPassword(),SQLQueryConstants.studentRole,stud.getEmail_id());
            }
        }
    }
}


//mvn archetype:generate -DgroupId=com.dropwizard -DartifactId=Jedi-Flipkart-DropWizard -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false