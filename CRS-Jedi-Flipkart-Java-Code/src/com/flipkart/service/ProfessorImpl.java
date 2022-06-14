package com.flipkart.service;

import com.flipkart.bean.Professor;
import com.flipkart.bean.GradeCard;
import com.flipkart.bean.Student;

import java.util.*;

public class ProfessorImpl implements ProfessorInterface{


        HashMap<String, List<String>> prof_course_map= new HashMap<>();
        HashMap<String, List<List<String>>> course_stu_grade_map=new HashMap<>();

        public void viewResults(String courseid){
                System.out.println("Course ID = " + courseid + "\n");
                System.out.println("Student\t\tGrade");
                List<List<String>> s_g= course_stu_grade_map.get(courseid);
                for(List<String> st_gr: s_g)
                        System.out.println(st_gr.get(0)+"\t\t"+st_gr.get(1));
        }

//        public void viewSchedule(String professorid){
//
//        }

        public void viewProfile(String professorid,List<Professor> prof_list){
                for(Professor p : prof_list) {
                        if(p.getUserID().equals(professorid)) {
                                System.out.println("Name: " + p.getName());
                                System.out.println("Role: " + p.getRole());
                                System.out.println("Professor Id: " + p.getUserID());
                                System.out.println("Mobile: " +p.getMobile());
                                System.out.println("Email: " +p.getEmail_id());
                                System.out.println("Department: " +p.getDepartment());
                                System.out.println("Designation: " +p.getDesignation());
                                System.out.println("Office: " + p.getOffice());
                                break;
                        }
                }
        }

        //@Override
        public List<Student> getStudentsList(String courseID, HashMap<String,List<Student>> course_student_list) {
                return course_student_list.get(courseID);
        }

        //@Override
        public void submitGrades(String courseID, String studentID, String grade) {
                List<String> stud_grade= new ArrayList<>();
                stud_grade.add(studentID);
                stud_grade.add(grade);

                if(course_stu_grade_map.containsKey(courseID)){
                        List<List<String>> s_g=course_stu_grade_map.get(courseID);
                        s_g.add(stud_grade);
                        course_stu_grade_map.put(courseID,s_g);
                }
                else {
                        List<List<String>> s_g=new ArrayList<>();
                        s_g.add(stud_grade);
                        course_stu_grade_map.put(courseID,s_g);
                }
        }

        //@Override
        public void selectCoursestoTeach(String professorID, String courseID) {
                if(prof_course_map.containsKey(professorID)) {
                        List<String> course_list = prof_course_map.get(professorID);
                        course_list.add(courseID);
                        prof_course_map.put(professorID,course_list);
                }
                else
                {
                        List<String> course_list = new ArrayList<>();
                        course_list.add(courseID);
                        prof_course_map.put(professorID,course_list);
                }
        }

        //@Override
        public void dropCoursestoTeach(String professorID, String courseID) {
                List<String> course_list= prof_course_map.get(professorID);
                course_list.remove(courseID);
        }

        //@Override
        public void viewCourses(String professorID) {
                List<String> course_list= prof_course_map.get(professorID);
                System.out.println("The courses taught by "+professorID+" are: ");
                for(int i=0;i<course_list.size();i++)
                        System.out.println(i+" "+ course_list.get(i));

        }

}
