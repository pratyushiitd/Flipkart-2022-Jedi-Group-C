package com.flipkart.service;

public class ProfessorImpl implements ProfessorInterface{
        public void professorMenu()
        {
            System.out.println("\nPlease select an option from the following menu:");
            //println
            System.out.println("1. View professor details");
            System.out.println("2. View Students list ");
            System.out.println("3. Submit grades ");
            System.out.println("4. Logout");
        }
}
