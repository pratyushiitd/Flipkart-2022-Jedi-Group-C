package com.flipkart.service;

import com.flipkart.bean.*;
import com.flipkart.constants.SQLQueryConstants;
import com.flipkart.dao.CourseDAO;
import com.flipkart.dao.CourseDAOImpl;
import com.flipkart.dao.StudentDAO;
import com.flipkart.dao.StudentDAOImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
// import scanner
import java.util.Scanner;

import java.sql.*;


import static com.flipkart.constants.SQLQueryConstants.*;

public class AdminImpl implements AdminInterface {
    Admin admin;
    public CourseCatalogue courseCatalogue;
    RegisteredStudent registeredStudent;
    List<Professor> professorsList;

    //constructor
    public AdminImpl() {
        this.admin = new Admin(
                "flipkart",
                SQLQueryConstants.adminRole,
                "a001",
                "jedi",
                "admin@fk.com"
        );
        this.courseCatalogue = new CourseCatalogue();
        this.registeredStudent = new RegisteredStudent();
        this.professorsList = new ArrayList<Professor>();
    }

    public void viewallcourses() {
        courseCatalogue.showCourseCatalogue();
    }
    @Override
    public Student addStudent(String name_student, String userId_student, String password_student, String email_id_student, int semester_student, int section_student, String department, String gender){

        try{
            Student student = new Student(name_student, userId_student,SQLQueryConstants.studentRole,password_student,email_id_student,semester_student,section_student, department, 0.0f, gender);
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
        Professor professor = new Professor(name,SQLQueryConstants.professorRole,userID, password,email_id,department);
        professorsList.add(professor);
        return professor;
    }

    public Student addStudentAdmin()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the student:");
        String name_student = scanner.next();
        //println
//        System.out.println("Enter the userID of the student:");
//        String userId_student = scanner.next();
        //println
        System.out.println("Enter the password of the student:");
        String password_student = scanner.next();
        //println
        System.out.println("Enter the email ID of the student:");
        String email_id_student = scanner.next();
        //println
        System.out.println("Enter the semester of the student:");
        int semester_student = scanner.nextInt();
        scanner.nextLine();
        //println
//        System.out.println("Enter the section of the student:");
//        char section_student = scanner.next().charAt(0);

        //take department
        System.out.println("Enter the department of the student:");
        String department = scanner.next();
        System.out.println("Enter the gender of the student:");
        String gender = scanner.next();
        //
        //println
        // take space separated list of courses
        // System.out.println("Enter the courses of the student:");
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
        //System.out.println("Student Registeration success!:\n");
        StudentDAO studentDAO=new StudentDAOImpl();
        int size=studentDAO.studentSize()+1;
         String uid="s00"+size;
        return addStudent(name_student, uid, password_student, email_id_student, semester_student, 1, department, gender);
        //
        // //println
    
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
                    registeredStudent.showCourses(studentID);
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
        System.out.println("Please select an option from the following menu:");
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
        else{
            if (course==null){
                System.out.println("Course not found");
            }
            if (student==null){
                System.out.println("Student not found");
            }
        }
    }
    //add professor to course table
    @Override
    public Professor addProfessorAdmin(String uid)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the professor:");
        String name = scanner.next();
        //println
//        System.out.println("Enter the userID of the professor:");
//        String userId_prof = scanner.next();
        //println
        System.out.println("Enter the password of the professor:");
        String password_prof = scanner.next();
        //println
        System.out.println("Enter the department of the professor:");
        String department = scanner.next();
        //println
        System.out.println("Enter the email ID of the professor:");
        String email_id = scanner.next();
        // take professor id
        //println
        // take semester
//        System.out.println("Enter the semester of the professor:");
//        int semester = scanner.nextInt();
        //scanner.nextLine();

        CourseDAO courseDAO=new CourseDAOImpl();
        if(courseDAO.showCoursesNoProfessor(department))
        {
        // take space seperated list of courses
            Professor newProf = addProfessor(name, uid, password_prof, email_id, department);
        System.out.println("Enter the number of courses of the professor:");
        int number= scanner.nextInt();
        while(number!=0&&newProf!=null)
        {
            number--;
            System.out.println("Enter course name:");
            String courseName=scanner.next();
            System.out.println("Enter course id:");
            String courseId=scanner.next();
            //add to course table
            courseDAO.updateCourseProfessor(newProf.getProfessorId(),courseId);
        }
            return newProf;
        }
        return null;

    }

    @Override
    public  void approveStudent(String studentId, List<Course> courseChoiceList, int semester){
        List<Course>l=new ArrayList<>();

        try{
            int count=4;
            for(Course course: courseChoiceList){
                if(course.vacancy>0 && count>0){
                    count--;
                    course.setVacancy(course.vacancy-1);
                    approveCourseforStudent(studentId, course.getCourseID(), semester);
                    l.add(course);

                    Connection conn = null;
                    PreparedStatement stmt = null;
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        conn = DriverManager.getConnection(DB_URL,USER, PASS);

                        String sql = "insert into student_course_enrolled values ('"+studentId+"','"+course+"')";
                        stmt = conn.prepareStatement(sql);
                        stmt.executeUpdate(sql);
                        stmt.close();
                        conn.close();
                    }catch(SQLException se){
                        se.printStackTrace();
                    }catch(Exception e){
                        e.printStackTrace();
                    }finally{
                        try{
                            if(stmt!=null)
                                stmt.close();
                        }catch(SQLException se2){
                        }
                        try{
                            if(conn!=null)
                                conn.close();
                        }catch(SQLException se){
                            se.printStackTrace();
                        }
                    }
                }
            }
            //return l;
        } catch(Exception e)
        {
            e.printStackTrace();
        }

    }
    @Override
    public void viewEnrolledStudents(String courseID) {
        System.out.println("Enrolled Students:");
        for(Student student:registeredStudent.getRegisteredStudents()){
            for(Course course:registeredStudent.getCourses(student)){
                if(course.getCourseID().equals(courseID)){
                    System.out.println(student.getUserID() + ": " + student.getName());
                }
            }
        }
    }
    @Override
    public void submitGrades(String studentId, String courseID, int grade, int semester) {
        Course course = courseCatalogue.getCourse(semester, courseID);
        registeredStudent.submitGrades(studentId, course, grade);
    }
    @Override
    public void addCourseAdmin(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the course:");
        String name = scanner.next();
        //println
//        System.out.println("Enter the course ID of the course:");
        CourseDAO courseDAO=new CourseDAOImpl();
        int size=courseDAO.viewSize()+1;
        String courseID = "c00"+size;
        //println
        System.out.println("Enter the semester of the course:");
        int semester = scanner.nextInt();
        System.out.println("Enter the department of the course:");
        String department = scanner.next();
        //println
        // take professor id
        //System.out.println("Enter the professor ID of the course:");
        //String professorID = scanner.next();
        //println
        // take vacancy count
        System.out.println("Enter the vacancy count of the course:");
        int vacancyCount = scanner.nextInt();
        //println
        courseDAO.addCourseProfessor(null,courseID,name,vacancyCount,department);
    }

//    public static void main(String[] args)
//    {
//        ArrayList<Course> courseList=new ArrayList<>();
//        Course c1= new Course("c001","dsa" , "p001", 10);
//        Course c2= new Course("c002","maths" , "p001", 10);
//        Course c3= new Course("c003","physics" , "p003", 10);
//        Course c4= new Course("c004","big data analysis" , "p005", 10);
//        Course c5= new Course("c005","AI" , "p003", 10);
//        Course c6= new Course("c006","dbms" , "p005", 10);
//
//        courseList.add(c1);
//        courseList.add(c2);
//        courseList.add(c3);
//        courseList.add(c4);
//        courseList.add(c5);
//        courseList.add(c6);
//
//        approveStudent("s001", courseList,2);
//    }


}
