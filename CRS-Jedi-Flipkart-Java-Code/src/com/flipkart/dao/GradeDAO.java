package com.flipkart.dao;

public interface GradeDAO {
    public void submitGrade(String studentId, String courseId, float gpa);
    public void generateGrade(String studentId);
    public float calc_gpa(String student_ID);

}
