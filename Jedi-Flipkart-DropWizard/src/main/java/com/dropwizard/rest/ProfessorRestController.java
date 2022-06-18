package com.dropwizard.rest;

import com.dropwizard.bean.Professor;
import com.dropwizard.bean.Student;
import com.dropwizard.dao.ProfessorDAOImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.validation.Validator;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.dropwizard.constants.SQLQueryConstants.*;
@Path("/professor")
@Produces(MediaType.APPLICATION_JSON)
public class ProfessorRestController {

    private final Validator validator;
    public ProfessorDAOImpl ProfessorRef;
    public ProfessorRestController (Validator validator){
        this.validator = validator;
        ProfessorRef = new ProfessorDAOImpl();
    }
    @GET
    @Path("/viewprofessordetails/{id}")
    public Response viewProfessorDetails(@PathParam("id")String professorID){
        List<Professor> res = ProfessorRef.viewProfessorDetails(professorID);
//        System.out.println(res);
//        return Response.ok(res).build();
        if (res.size() == 0) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(res).build();
    }

    @POST
    @Path("/submitgrades/{id}/{gpa}/{c_id}")
    public Response submitGrades(@PathParam("id")String studentId,
                             @PathParam("gpa")int gpa,
                             @PathParam("c_id")String courseId)
    {
        System.out.println(studentId);
        System.out.println(gpa);
        System.out.println(courseId);
        boolean f= ProfessorRef.submitGrades(studentId,gpa,courseId);

        if(f){
            return Response.ok().build();
        }
        else return Response.status(Response.Status.NOT_FOUND).build();
    }



}
