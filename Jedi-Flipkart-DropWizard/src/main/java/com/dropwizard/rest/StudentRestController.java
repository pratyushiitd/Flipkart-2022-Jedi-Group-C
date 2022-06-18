package com.dropwizard.rest;

import com.dropwizard.dao.StudentDAOImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.validation.Validator;
import com.dropwizard.bean.Student;
import static com.dropwizard.constants.SQLQueryConstants.*;
import java.sql.*;
@Path("/student")
@Produces(MediaType.APPLICATION_JSON)
public class StudentRestController {

    private final Validator validator;
    public StudentDAOImpl studentRef;

    public StudentRestController (Validator validator){

        this.validator = validator;
        this.studentRef = new StudentDAOImpl();
    }
    @POST
    @Path("/addstudent/{name}/{role}/{userid}/{password}/{email}/{semester}/{section}/{department}/{cg}/{gender}/{paymentid}")
    public Response addStudent(@PathParam("name") String name,
                           @PathParam("role")int role,
                           @PathParam("userid")String userId,
                           @PathParam("password")String password,
                           @PathParam("email")String emailId,
                           @PathParam("semester")int semester,
                           @PathParam("section")int section,
                           @PathParam("department")String department,
                           @PathParam("cg")float cg,
                           @PathParam("gender")String gender,
                           @PathParam("paymentid")String paymentid){
        return Response.ok(200).build();

    }

    @POST
    @Path("/addstudentregistration/{c_id}/{s_id}/{name}")
    public Response addStudentRegistration(@PathParam("c_id")String courseId,
                                       @PathParam("s_id")String studentId,
                                       @PathParam("name")String student_name){
        return Response.ok(200).build();

    }

    @GET
    @Path("/viewstudentdetails/{id}")
    public Response viewStudentDetails(@PathParam("id")String studentID){
        System.out.println(studentID);
        Student std = studentRef.viewStudentDetails(studentID);

        if (std==null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(std).build();
    }

    @GET
    @Path("/viewstudentlist/{c_id}/{sem}")
    public Response viewStudentsList(@PathParam("c_id")String courseId,
                                 @PathParam("sem") int sem){
        return Response.ok(200).build();

    }
}
