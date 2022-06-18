package com.dropwizard.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
public class ProfessorRestController {

    @GET
    @Path("/viewprofessordetails/{id}")
    public Response viewProfessorDetails(@PathParam("id")String professorID){
        return Response.ok(200).build();

    }

    @POST
    @Path("/submitgrades/{id}/{gpa}/{c_id}")
    public Response submitGrades(@PathParam("id")String studentId,
                             @PathParam("gpa")int gpa,
                             @PathParam("c_id")String courseId){
        return Response.ok(200).build();

    }

    @GET
    @Path("/viewstudentlist/{c_id}/{sem}")
    public Response viewStudentsList(@PathParam("c_id")String courseId,
                                 @PathParam("sem") int sem){
        return Response.ok(200).build();
    }

}
