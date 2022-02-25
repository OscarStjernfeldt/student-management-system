package se.iths.rest;

import se.iths.entity.Student;
import se.iths.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PATCH;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("students")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentRest {

    @Inject
    StudentService studentService;

    @Path("")
    @POST
    public Response createStudent(Student student) {
        Student createdStudent = studentService.create(student);
        return Response.created(URI.create("/sms/students/" + student.getId()))
                .entity(createdStudent)
                .build();
    }

    @Path("{id}")
    @PUT
    public Response updateStudent(Student student, @PathParam("id") Long id) {
        Student updatedStudent = studentService.update(student, id);
        return Response.ok(updatedStudent)
                .build();
    }

    @Path("query")
    @GET
    public Response getStudents(@QueryParam("lastName") String lastName) {
        List<Student> foundStudents = studentService.getByLastName(lastName);
        return Response.ok(foundStudents)
                .build();
    }

    @Path("{id}")
    @GET
    public Response getStudentById(@PathParam("id") Long id) {
        Student foundStudent = studentService.getById(id);
        return Response.ok(foundStudent)
                .build();
    }

    @Path("")
    @GET
    public Response getAllStudents() {
        List<Student> foundStudents = studentService.getAll();
        return Response.ok(foundStudents)
                .build();
    }

    @Path("{id}")
    @DELETE
    public Response deleteStudent(@PathParam("id") Long id) {
        studentService.delete(id);
        return Response.ok()
                .build();
    }

    @Path("{id}")
    @PATCH
    public Response update(@PathParam("id") Long id, Student student) {
        Student patchedStudent = studentService.patch(student, id);

        return Response.ok(patchedStudent)
                .build();
    }
}
