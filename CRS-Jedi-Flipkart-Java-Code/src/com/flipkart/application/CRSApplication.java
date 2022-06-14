package com.flipkart.application;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.service.UserImpl;
import com.flipkart.service.UserInterface;
import com.flipkart.service.AdminImpl;
import com.flipkart.service.AdminInterface;
import com.flipkart.service.ProfessorImpl;
import com.flipkart.service.ProfessorInterface;
import com.flipkart.service.StudentImpl;
import com.flipkart.service.StudentInterface;
// list
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.Course;
import com.flipkart.bean.CourseCatalogue;
// import scanner
import java.util.Scanner;

public class CRSApplication {
    //call all menus

    // scanner object
    Scanner scanner_main = new Scanner(System.in);

    // main function
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        UserInterface userRef = new UserImpl();
        AdminInterface adminRef = new AdminImpl();
        ProfessorInterface profRef = new ProfessorImpl();
        StudentInterface studentRef = new StudentImpl();
        // list of professor
        List<Professor> professorsList = new ArrayList<Professor>();

        // list of students
        List<Student> studentsList = new ArrayList<Student>();

        // new course catalog
        CourseCatalogue courseCatalogue = new CourseCatalogue();
        // list of courses
        List<Course> coursesList = new ArrayList<Course>();
        // println
        System.out.println("Welcome to the Course Registration System!");
        // while loop   
        while (true) {
            // println
            System.out.println("\nPlease select an option from the following menu:");
            // println
            System.out.println("1. Admin");
            // println
            System.out.println("2. Professor");
            // println
            System.out.println("3. Student");
            // println
            System.out.println("4. Exit");
            //switch case
            switch (scanner.nextInt()) {
                // case 1
                case 1:
                    //println
                    System.out.println("\nEnter your userID:");
                    String userId = scanner.next();
                    //println
                    System.out.println("\nEnter your password:");
                    String password = scanner.next();
                    int count_fail = 0;
                    if (userRef.login(userId, password)) {
                        //println
                        System.out.println("\nLogin successful!");
                        //println
                        System.out.println("\nPlease select an option from the following menu:");
                        //println
                        System.out.println("1. Add Professor");
                        //println
                        System.out.println("2. Add Student");
                        //println
                        System.out.println("3. Add Course");
                        //println
                        System.out.println("4. Get Professor Details");
                        //println
                        System.out.println("5. Get Student Details");
                        //println
                        System.out.println("6. Get Course Details");
                        //println
                        System.out.println("7. Approve Course for Student");
                        //println
                        System.out.println("8. Remove Course");
                        //println
                        System.out.println("9. Logout");

                        int type = scanner.nextInt();
                        // switch case
                        switch (type) {
                            // case 1
                            case 1:
                                //println
                                System.out.println("\nEnter the name of the professor:");
                                String name = scanner.next();
                                //println
                                System.out.println("\nEnter the userID of the professor:");
                                String userId_prof = scanner.next();
                                //println
                                System.out.println("\nEnter the password of the professor:");
                                String password_prof = scanner.next();
                                //println
                                System.out.println("\nEnter the department of the professor:");
                                String department = scanner.next();
                                //println
                                System.out.println("\nEnter the mobile number of the professor:");
                                long mobile = scanner.nextLong();
                                //println
                                System.out.println("\nEnter the email ID of the professor:");
                                String email_id = scanner.next();
                                //println
                                System.out.println("\nEnter the roll number of the professor:");
                                String rollNo = scanner.next();
                                //println
                                System.out.println("\nEnter the semester of the professor:");
                                int semester = scanner.nextInt();
                                //println
                                System.out.println("\nEnter the section of the professor:");
                                char section = scanner.next().charAt(0);
                                //println
                                // take space seperated list of courses
                                System.out.println("\nEnter the courses of the professor:");
                                String courses = scanner.nextLine();
                                // split the courses
                                String[] courses_array = courses.split(" ");
                                // convert the courses to integer
                                int[] courses_int = new int[courses_array.length];
                                for (int i = 0; i < courses_array.length; i++) {
                                    courses_int[i] = Integer.parseInt(courses_array[i]);
                                }
                                // call the addProfessor function
                                //int to string


                                String professorID = Integer.toString(adminRef.getNumProf() + 1);
                                // adminRef.addProfessor(name, userId_prof, password_prof, department, mobile, email_id, rollNo, semester, section, courses_int);
                                // new professor
                                Professor professor = new Professor();
                                // set the values
                                professor.setProfessorId(professorID);
                                professorsList.add(professor);

                                break;
                            // if (adminRef.addProfessor(name, userId_prof, password_prof, department, mobile, email_id, rollNo, semester, section)) {
                            //     //println
                            //     System.out.println("\nProfessor added successfully!");
                            // } else {
                            //     //println
                            //     System.out.println("\nProfessor addition failed!");
                            // }
                            // take integer
                            case 2:
                                //println
                                System.out.println("\nEnter the name of the student:");
                                String name_student = scanner.next();
                                //println
                                System.out.println("\nEnter the userID of the student:");
                                String userId_student = scanner.next();
                                //println
                                System.out.println("\nEnter the password of the student:");
                                String password_student = scanner.next();
                                //println
                                System.out.println("\nEnter the mobile number of the student:");
                                long mobile_student = scanner.nextLong();
                                //println
                                System.out.println("\nEnter the email ID of the student:");
                                String email_id_student = scanner.next();
                                //println
                                System.out.println("\nEnter the roll number of the student:");
                                String rollNo_student = scanner.next();
                                //println
                                System.out.println("\nEnter the semester of the student:");
                                int semester_student = scanner.nextInt();
                                //println
                                System.out.println("\nEnter the section of the student:");
                                char section_student = scanner.next().charAt(0);
                                //println
                                // take space seperated list of courses
                                System.out.println("\nEnter the courses of the student:");
                                String courses_student = scanner.next();
                                // split the courses
                                String[] courses_array_student = courses_student.split(" ");
                                // convert the courses to integer
                                int[] courses_int_student = new int[courses_array_student.length];
                                for (int i = 0; i < courses_array_student.length; i++) {
                                    courses_int_student[i] = Integer.parseInt(courses_array_student[i]);
                                }
                                // call the addStudent function
                                // int studentID = adminRef.getNumStudent()+1;
                                // adminRef.addStudent(name_student, userId_student, password_student, mobile_student, email_id_student, rollNo_student, semester_student, section_student, courses_int_student);
                                break;
                            if (adminRef.addStudent(name_student, userId_student, password_student, mobile_student, email_id_student, rollNo_student, semester_student, section_student)) {
                                //     //println
                                System.out.println("\nStudent added successfully!");
                            } else {
                                //println
                                System.out.println("\nStudent addition failed!");
                            }
                            // take integer
                            case 3:
                                //println
                                System.out.println("\nEnter the name of the course:");
                                String name_course = scanner.next();
                                //println
                                System.out.println("\nEnter the course ID of the course:");
                                int courseID = scanner.nextInt();
                                //println
                                System.out.println("\nEnter the department of the course:");
                                String department_course = scanner.next();
                                //println
                                System.out.println("\nEnter the semester of the course:");
                                int semester_course = scanner.nextInt();
                                //println
                                // add course
                                courseCatalogue.addCourse(semester_course, courseID);
                                break;
                            // take integer
                            case 4:
                                //get professor details
                                System.out.println("\nEnter the userID of the professor:");
                                String userId_prof_4 = scanner.next();
                                // get professor details
                                // iterate over professor list

                                for (int i = 0; i < adminRef.getNumProf(); i++) {
                                    // if userId_prof_delete matches with userId of professor
                                    if (adminRef.professorDetails(professorsList, professorID).getUserID() == userId_prof_4)
                                        adminRef.professorDetails(professorsList, professorID).showProfessorDetails();
                                }
                                break;
                            case 5:
                                //get student details
                                System.out.println("\nEnter the userID of the student:");
                                String userId_student_5 = scanner.next();
                                // get student details
                                // iterate over student list
                                for (int i = 0; i < studentsList.size(); i++) {
                                    // if userId_student_delete matches with userId of student
                                    if (studentsList.get(i).getRollNo() == userId_student_5) {
                                        studentsList.get(i).viewStudent();
                                    }
                                }
                                break;
                            case 6:
                                //get course details
                                System.out.println("\nEnter the course ID of the course:");
                                String courseID_6 = scanner.next();
                                // System.out.println("\nEnter the semester of the course:");
                                // int sem_6 = scanner.nextInt();
                                // get course details
                                // iterate over courselist
                                for (int i = 0; i < coursesList.size(); i++) {
                                    // if courseID_delete matches with courseID of course
                                    if (coursesList.get(i).getCourseID() == courseID_6) {
                                        coursesList.get(i).printCourseDetails();
                                    }
                                }

                                break;
                            case 7:
                                // Approve course for student
                                System.out.println("\nEnter the userID of the student:");
                                String userId_student_7 = scanner.next();
                                System.out.println("\nEnter the course ID of the course:");
                                int courseID_7 = scanner.nextInt();
                                System.out.println("\nEnter the semester of the course:");
                                int sem_7 = scanner.nextInt();
                                // println
                                System.out.println("Course approved successfully!");
                                break;
                            case 8:
                                // remove course
                                System.out.println("\nEnter the course ID of the course:");
                                int courseID_8 = scanner.nextInt();
                                System.out.println("\nEnter the semester of the course:");
                                int sem_8 = scanner.nextInt();
                                // remove course
                                courseCatalogue.removeCourse(sem_8, courseID_8);
                        }
                    else{
                            //println
                            count_fail++;
                            System.out.println("\nLogin failed!");
                            if (count_fail == 5) {
                                //println
                                System.out.println("\nYou have failed to login 5 times. Please try again later.");
                                //break
                                // wait for 10 sec
                                try {
                                    Thread.sleep(10000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                            }
                        }
                        break;
                        // case 2
                        case 2:
                            // call professor menu
                            // profRef.professorMenu();
                            //println
                            System.out.println("\nEnter your userID:");
                            userId = scanner.next();
                            //println
                            System.out.println("\nEnter your password:");
                            password = scanner.next();
                            count_fail = 0;
                            if (userRef.login(userId, password)) {
                                //println
                                System.out.println("\nLogin successful!");
                                //println
                                System.out.println("\nPlease select an option from the following menu:");
                                //println
                                System.out.println("1. View professor details");
                                System.out.println("2. View Students list ");
                                System.out.println("3. Submit grades ");
                                System.out.println("4. Logout");
                                type = scanner.nextInt();
                                switch (type) {
                                    case 1:
                                        profRef.viewProfile(userId);
                                        break;
                                    case 2:
                                        System.out.println("You have the following courses under you,Select " +
                                                "any one to view students list");
                                        profRef.viewCourses(userId);
                                        System.out.println("Enter the courseId to view students list:");
                                        String courseID = scanner.next();
                                        try {
                                            List<Student> studentsListCourse;

                                            for (Course course : coursesList) {
                                                if (course.getCourseID().equals(courseID)) {
                                                    studentsListCourse = course.getStudentsEnrolled(courseID);
                                                    for (int i = 0; i < studentsListCourse.size(); i++) {
                                                        System.out.println("Student name: " + studentsListCourse.get(i).getName());
                                                        System.out.println("Student roll number: " + studentsListCourse.get(i).getRollNo());
                                                    }
                                                }
                                            }
                                        } catch (Exception e) {
                                            System.out.println("Incorrect course id chosen");
                                        }

                                        break;
                                    case 3:
                                        System.out.println("Enter the courseId to submit grades of students:");
                                        String courseIDP = scanner.next();
                                        try {
                                            List<Student> studentsListCourse;

                                            for (Course course : coursesList) {
                                                if (course.getCourseID().equals(courseIDP)) {
                                                    studentsListCourse = course.getStudentsEnrolled(courseIDP);
                                                    for (int i = 0; i < studentsListCourse.size(); i++) {
                                                        System.out.println("Student name: " + studentsListCourse.get(i).getName());
                                                        System.out.println("Student roll number: " + studentsListCourse.get(i).getRollNo());
                                                        System.out.println("Enter grade for this student: ");
                                                        float grade = scanner.nextFloat();
                                                        studentsListCourse.get(i).setCg(grade, courseIDP);
                                                    }
                                                }
                                            }
                                        } catch (Exception e) {
                                            System.out.println("Incorrect course id chosen");
                                        }
                                        break;
                                    case 4:
                                        System.out.println("Successfully logged out.");
                                        break;
                                    default:
                                        System.out.println("Invalid choice");
                                        break;
                                }
                                break;
                                // case 3
                                case 3:
                                    // call student menu
                                    // studentRef.studentMenu();
                                    System.out.println("\nEnter your userID:");
                                    userId = scanner.next();
                                    //println
                                    System.out.println("\nEnter your password:");
                                    password = scanner.next();
                                    count_fail = 0;
                                    if (userRef.login(userId, password)) {
                                        //println
                                        System.out.println("\nLogin successful!");
                                        //println
                                        System.out.println("\nPlease select an option from the following menu:");
                                        //println
                                        System.out.println("1. View Courses");
                                        System.out.println("2. Registration and payment");
                                        System.out.println("3. Courses opted");
                                        System.out.println("4. Updated course list");
                                        System.out.println("5. Add Courses");
                                        System.out.println("6. Drop Courses");
                                        System.out.println("7. View Grades");
                                        System.out.println("8. Logout");
                                        type = scanner.nextInt();
                                        switch (type) {
                                            case 1:
                                        }
                                        break;
                                        // case 4
                                        case 4:
                                            // println
                                            System.out.println("Thank you for using the Course Registration System!");
                                            // exit
                                            System.exit(0);
                                            break;
                                        // default
                                        default:
                                            // println
                                            System.out.println("Invalid option. Please try again.");
                                            break;
                                    }
                            }
                    }
            }
        }
