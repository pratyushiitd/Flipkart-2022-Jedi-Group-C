package com.flipkart.service;

import com.flipkart.bean.*;

import java.util.ArrayList;
import java.util.List;
// import scanner
import java.util.Scanner;
public class AdminImpl implements AdminInterface {
    Admin admin;
    CourseCatalogue courseCatalogue;
    RegisteredStudent registeredStudent;
    List<Professor> professorsList;

    //constructor
    public AdminImpl() {
        this.admin = new Admin(
                "flipkart",
                "admin",
                "admin",
                "jedi",
                "admin@fk.com"
        );
        this.courseCatalogue = new CourseCatalogue();
        this.registeredStudent = new RegisteredStudent();
        this.professorsList = new ArrayList<Professor>();
    }
    @Override
    public Student addStudent(String name_student, String userId_student, String password_student, String email_id_student, int semester_student, char section_student, String department, char gender){

        try{
            Student student = new Student(name_student,"student",userId_student,password_student,email_id_student,semester_student,section_student, department, 0.0f, gender);
            registeredStudent.addStudent(student);
            student.setRegistered(true);
            return student;
        }
        catch (Exception e){
            e.printStackTrace();
        }

        //incomplete
        return null;
    }
    @Override
    public Professor addProfessor(String name,String userID,String password,String email_id,
    String department){
        // check if professorID already exists
        boolean taken = false;
        for(Professor pf: professorsList){
            if(userID.equals(pf.getUserID())){
                taken = true;
            }
        }
        if (taken){
            //println
            System.out.println("Professor ID already exists");
            return null;
        }
        Professor professor = new Professor(name,"professor",userID, password,email_id,department);
        professorsList.add(professor);
        return professor;
    }

    public Student addStudentAdmin()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter the name of the student:");
        String name_student = scanner.next();
        //println
        System.out.println("\nEnter the userID of the student:");
        String userId_student = scanner.next();
        //println
        System.out.println("\nEnter the password of the student:");
        String password_student = scanner.next();
        //println
        System.out.println("\nEnter the email ID of the student:");
        String email_id_student = scanner.next();
        //println
        System.out.println("\nEnter the semester of the student:");
        int semester_student = scanner.nextInt();
        //println
        System.out.println("\nEnter the section of the student:");
        char section_student = scanner.next().charAt(0);

        //take department
        System.out.println("\nEnter the department of the student:");
        String department = scanner.next();
        //
        System.out.println("\nEnter gender:");
        char gender = scanner.next().charAt(0);
        //println
        // take space separated list of courses
        // System.out.println("\nEnter the courses of the student:");
        // String courses_student = scanner.next();
        // // split the courses
        // String[] courses_array_student = courses_student.split(" ");
        // // convert the courses to integer
        // int[] courses_int_student = new int[courses_array_student.length];
        // for (int i = 0; i < courses_array_student.length; i++) {
        //     courses_int_student[i] = Integer.parseInt(courses_array_student[i]);
        // }
        // call the addStudent function
        // int studentID = adminRef.getNumStudent()+1;
        // adminRef.addStudent(name_student, userId_student, password_student, mobile_student, email_id_student, rollNo_student, semester_student, section_student, courses_int_student);
        return addStudent(name_student, userId_student, password_student, email_id_student, semester_student, section_student, department, gender);
    
    }
    @Override
    public boolean viewprofessorDetails(String professorID) {
        try{
            for(Professor professor:professorsList){
                if(professor.getProfessorId().equals(professorID)){
                    professor.showProfessorDetails();
                    return true;
                }
            }
        }
        catch (Exception e)
        {
            return false;
        }
        return false;
    }

    @Override
    public boolean viewstudentDetails(String studentID) {
        try{
            for(Student student:registeredStudent.getRegisteredStudents()){
                if(student.getUserID().equals(studentID)){
                    student.viewStudentDetails();
                    return true;
                }
            }
        }
        catch (Exception e)
        {
            return false;
        }
        return false;
    }

    // @Override
    // public boolean approveCourses(String studentID,List<Student> studentsList) {
    //     try{
    //         for(Student student:studentsList){
    //             if(student.getRollNo().equals(studentID)&&student.isRegistered()==true){
    //                 return true;
    //             }
    //         }
    //     }
    //     catch (Exception e)
    //     {
    //         return false;
    //     }
    //     return false;
    // }

    @Override
    public void addCourse(Course course,int semester ) {
        //add course to course catalog
        courseCatalogue.addCourse(semester, course);
    }

    // @Override
    // public boolean removeCourses(String courseID, int semester) {
    //     System.out.println("Course removed:"+courseID);
    //     (courseListSem.get(semester)).remove(courseID);
    //     return true;
    // }
    //incomplete
    @Override
    public void viewcoursedetail(int semester, String courseID) {
        Course course = courseCatalogue.getCourse(semester, courseID);
        if(course!=null){
            course.printCourseDetails();
        }
        else{
            System.out.println("Course not found");
        }
    }
    @Override
    public void displayAdminMenu() {
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
        System.out.println("8. Logout");
    }

    @Override
    public void approveCourseforStudent(String studentID, String courseID, int semester) {
        //incomplete
        Course course = courseCatalogue.getCourse(semester, courseID);
        Student student = registeredStudent.getStudent(studentID);
        if (course!= null && student!=null){
            registeredStudent.addCourseforStudent(student, course);
        }
    }
    @Override
    public Professor addProfessorAdmin()
    {
        Scanner scanner = new Scanner(System.in);
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
        System.out.println("\nEnter the email ID of the professor:");
        String email_id = scanner.next();
        // take professor id
        //println
        // take semester
        System.out.println("\nEnter the semester of the professor:");
        int semester = scanner.nextInt();
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
        // add the professor to the list of professors
        Professor newProf = addProfessor(name, userId_prof, password_prof, email_id, department);
        // add the courses to the professor
        if (newProf!=null){
            for (int i = 0; i < courses_int.length; i++) {
                Course toAdd = courseCatalogue.getCourse(semester, Integer.toString(courses_int[i]));
                newProf.addCourse(toAdd);
            }
        }
        return newProf;

    }
    @Override
    public void submitGrades(String studentId, String courseID, int grade, int semester) {
        Course course = courseCatalogue.getCourse(semester, courseID);
        registeredStudent.submitGrades(studentId, course, grade);
    }
    @Override
    public void addCourseAdmin(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter the name of the course:");
        String name = scanner.next();
        //println
        System.out.println("\nEnter the course ID of the course:");
        String courseID = scanner.next();
        //println
        System.out.println("\nEnter the semester of the course:");
        int semester = scanner.nextInt();
        //println
        // take professor id
        System.out.println("\nEnter the professor ID of the course:");
        String professorID = scanner.next();
        //println
        // take vacancy count
        System.out.println("\nEnter the vacancy count of the course:");
        int vacancyCount = scanner.nextInt();
        //println
        Course course_to_add = new Course(courseID, name, professorID, vacancyCount);
        addCourse(course_to_add, semester);
    }
}
