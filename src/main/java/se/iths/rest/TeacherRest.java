package se.iths.rest;

import se.iths.entity.Teacher;
import se.iths.service.TeacherService;

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

@Path("teachers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeacherRest {

    @Inject
    TeacherService TeacherService;

    @Path("")
    @POST
    public Response createTeacher(Teacher teacher) {
        Teacher createdTeacher = TeacherService.create(teacher);
        return Response.created(URI.create("/sms/teachers/" + teacher.getId()))
                .entity(createdTeacher)
                .build();
    }

    @Path("{id}")
    @PUT
    public Response updateTeacher(Teacher teacher, @PathParam("id") Long id) {
        Teacher updateTeacher = TeacherService.update(teacher, id);
        return Response.ok(updateTeacher)
                .build();
    }

    @Path("query")
    @GET
    public Response getTeacher(@QueryParam("lastName") String lastName) {
        List<Teacher> foundTeacher = TeacherService.getByLastName(lastName);
        return Response.ok(foundTeacher)
                .build();
    }

    @Path("{id}")
    @GET
    public Response getTeacherById(@PathParam("id") Long id) {
        Teacher foundTeacher = TeacherService.getById(id);
        return Response.ok(foundTeacher)
                .build();
    }

    @Path("")
    @GET
    public Response getAllTeachers() {
        List<Teacher> foundStudents = TeacherService.getAll();
        return Response.ok(foundStudents)
                .build();
    }

    @Path("{id}")
    @DELETE
    public Response deleteTeacher(@PathParam("id") Long id) {
        TeacherService.delete(id);
        return Response.ok()
                .build();
    }

    @Path("{id}")
    @PATCH
    public Response update(@PathParam("id") Long id, Teacher teacher) {
        Teacher patchedTeacher = TeacherService.patch(teacher, id);

        return Response.ok(patchedTeacher)
                .build();
    }
}
