package com.flipkart.dao;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.CourseNotOptedException;
import com.flipkart.exception.UserNotFoundException;

public interface SemesterRegistrationDAO {

    List<Course> viewOptedCourses(String studentId) throws UserNotFoundException;

    void addCourse(String studentId, String courseId) throws CourseNotFoundException;

    String dropCourse(String studentId, String courseId) throws CourseNotFoundException, CourseNotOptedException;

    String submitOptedCourses(String studentId) throws UserNotFoundException;

    boolean increaseStudentCount(String studentId);

}
