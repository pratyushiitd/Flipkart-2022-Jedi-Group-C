package com.flipkart.service;
import java.util.*;

public class ProfessorImpl implements ProfessorInterface{

        HashMap<String, List<String>> prof_course_map= new HashMap<>();
        public void addCourse(String professorid,String courseid){
                if(prof_course_map.containsKey(professorid)) {
                        List<String> course_list = prof_course_map.get(professorid);
                        course_list.add(courseid);
                        prof_course_map.put(professorid,course_list);
                }
                else
                {
                        List<String> course_list = new ArrayList<>();
                        course_list.add(courseid);
                        prof_course_map.put(professorid,course_list);
                }

        }
        
        public void dropCourse(String professorid, String courseid){
                List<String> course_list= prof_course_map.get(professorid);
                course_list.remove(courseid);
        }
        
        public void viewCourses(String professorid){
                List<String> course_list= prof_course_map.get(professorid);
                System.out.println("The courses taught by "+professorid+" are: ");
                for(int i=0;i<course_list.size();i++)
                        System.out.println(i+" "+ course_list.get(i));
        }
        
        public void viewResults(String professorid){

        }
        
        public void viewSchedule(String professorid){

        }
        
        public void viewProfile(String professorid){

        }
        
}
