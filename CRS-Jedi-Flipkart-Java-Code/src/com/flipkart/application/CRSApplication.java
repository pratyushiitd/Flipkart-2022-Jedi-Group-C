package com.flipkart.application;


import com.flipkart.bean.Student;
import com.flipkart.bean.CourseCatalogue;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Course;
import com.flipkart.bean.Admin;
import com.flipkart.bean.RegisteredStudent;
import com.flipkart.bean.Billing;
import com.flipkart.bean.User;
import com.flipkart.bean.GradeCard;

import com.flipkart.service.UserImpl;
import com.flipkart.service.UserInterface;
import com.flipkart.service.AdminImpl;
import com.flipkart.service.AdminInterface;
import com.flipkart.service.ProfessorImpl;
import com.flipkart.service.ProfessorInterface;
import com.flipkart.service.StudentImpl;
import com.flipkart.service.StudentInterface;


public class CRSApplication {
    //call all menus
    UserInterface userRef=new UserImpl();
    AdminInterface adminRef=new AdminImpl();
    ProfessorInterface profRef=new ProfessorImpl();
    StudentInterface studentRef=new StudentImpl();
}
