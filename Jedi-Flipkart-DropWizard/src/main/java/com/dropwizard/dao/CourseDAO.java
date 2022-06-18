package com.flipkart.dao;

public interface CourseDAO {
    public void showCourses(String dept);
    public int viewSize();
    public boolean showCoursesNoProfessor(String dept);
    public void addCourseProfessor(String professorId,String courseId,String courseName,int vacancy,String department);

    void updateCourseProfessor(String professorId, String courseId);
    public void viewCourseDetails(String courseId);
    public void viewCourseStudent(String studentId);
}
