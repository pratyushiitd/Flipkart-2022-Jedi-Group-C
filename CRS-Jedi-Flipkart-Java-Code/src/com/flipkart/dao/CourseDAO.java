package com.flipkart.dao;

public interface CourseDAO {
    public void showCourses(String dept);
    public int viewSize();
    public void addCourseProfessor(String professorId,String courseId,String courseName,int vacancy,String department);
}
