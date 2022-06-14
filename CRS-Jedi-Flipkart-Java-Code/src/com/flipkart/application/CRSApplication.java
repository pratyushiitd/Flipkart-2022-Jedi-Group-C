package com.flipkart.application;

import com.flipkart.service.UserImpl;
import com.flipkart.service.UserInterface;
import com.flipkart.service.AdminImpl;
import com.flipkart.service.AdminInterface;
import com.flipkart.service.ProfessorImpl;
import com.flipkart.service.ProfessorInterface;
import com.flipkart.service.StudentImpl;
import com.flipkart.service.StudentInterface;
// list
import java.util.List;
import java.util.ArrayList;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.Course;
import com.flipkart.bean.CourseCatalogue;
// import scanner
import java.util.Scanner;

public class CRSApplication {

    public static UserInterface userRef=new UserImpl();
    public static AdminInterface adminRef=new AdminImpl();
    public static ProfessorInterface profRef = new ProfessorImpl();
    public static StudentInterface studentRef = new StudentImpl();


    public static void admin(){

    }
    public static void professor(){

    }
    public static void student(){

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
                    else if (role == "student") student();
                    else System.out.println("\nInvalid role!");
                }
                else{
                    System.out.println("\nLogin failed!");
                    continue;
                }
            }
            else if (login_option == 2){
                // register a student
                adminRef.addStudentAdmin();;
            }
        }
    }
}

