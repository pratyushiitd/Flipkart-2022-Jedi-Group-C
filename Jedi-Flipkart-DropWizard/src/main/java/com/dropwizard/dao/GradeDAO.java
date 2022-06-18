package com.flipkart.dao;

public interface GradeDAO {
    public void submitGrade(String studentId,String courseId,String gpa);
    public void generateGrade(String studentId);

}
