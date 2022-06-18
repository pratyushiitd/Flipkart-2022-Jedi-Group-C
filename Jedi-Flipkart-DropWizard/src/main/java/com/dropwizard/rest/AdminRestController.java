package com.dropwizard.rest;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)

public class AdminRestController {


    @GET
    @Path("/getdepartmentcouse/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
    public Response getDepartmentCourse(@PathParam("id")String id){

        return Response.ok(200).build();
    }

    @POST
    @Path("/addprofessor/{id}/{name}/{password}/{mail}/{department}")
//    @Produces(MediaType.APPLICATION_JSON)
    public Response addProfessor(@PathParam("id")String id,
                             @PathParam("name")String name,
                             @PathParam("password")String password,
                             @PathParam("mail")String mail,
                             @PathParam("department")String department)
    {

        return Response.ok(200).build();
    }

    // addStudent()
    // addCourse()

    @GET
    @Path("/getstudent/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentDetails(@PathParam("id")String StudentId){
        return Response.ok(200).build();
    }

    @GET
    @Path("/getcoursedetails/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
    public Response getCourseDetails(@PathParam("id")String CourseId){
        return Response.ok(200).build();
    }

}
