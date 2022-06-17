package com.dropwizard.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
public class StudentRestController {

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
        return Response.ok(200).build();

    }

    @GET
    @Path("/viewstudentlist/{c_id}/{sem}")
    public Response viewStudentsList(@PathParam("c_id")String courseId,
                                 @PathParam("sem") int sem){
        return Response.ok(200).build();

    }
}
