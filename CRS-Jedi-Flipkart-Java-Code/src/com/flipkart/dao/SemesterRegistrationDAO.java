package com.flipkart.dao;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.CourseNotOptedException;

public interface SemesterRegistrationDAO {

    List<Course> viewOptedCourses(String studentId);

    void addCourse(String studentId, String courseId) throws CourseNotFoundException;

    String dropCourse(String studentId, String courseId) throws CourseNotFoundException, CourseNotOptedException;

    String submitOptedCourses(String studentId);

    boolean increaseStudentCount(String studentId);

}
