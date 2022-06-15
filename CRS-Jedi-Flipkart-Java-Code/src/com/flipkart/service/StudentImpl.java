package com.flipkart.service;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import com.flipkart.bean.GradeCard;
import com.flipkart.bean.Student;
;
public class StudentImpl implements StudentInterface{

       
        public void showStudentMenu() {
                System.out.println("1. Register for a course");
                System.out.println("2. Pay Fees");
                System.out.println("3. Update Student");
                System.out.println("4. View Grade Card");
                System.out.println("5. Add Course");
                System.out.println("6. Remove Course");
                System.out.println("7. Logout");
        }
}
