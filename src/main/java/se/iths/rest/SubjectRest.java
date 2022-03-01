package se.iths.rest;

        import se.iths.entity.Subject;
        import se.iths.service.SubjectService;

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
        import javax.ws.rs.core.MediaType;
        import javax.ws.rs.core.Response;
        import java.net.URI;
        import java.util.List;

@Path("subjects")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SubjectRest {

    @Inject
    SubjectService subjectService;

    @Path("")
    @POST
    public Response createSubject(Subject subject) {
        Subject createdSubject = subjectService.create(subject);
        return Response.created(URI.create("/sms/subjects/" + subject.getId()))
                .entity(createdSubject)
                .build();
    }

    @Path("{id}")
    @PUT
    public Response updateSubject(Subject subject, @PathParam("id") Long id) {
        Subject updatedSubject = subjectService.update(subject, id);
        return Response.ok(updatedSubject)
                .build();
    }

    @Path("{id}")
    @GET
    public Response getSubjectById(@PathParam("id") Long id) {
        Subject foundSubject = subjectService.getById(id);
        return Response.ok(foundSubject)
                .build();
    }

    @Path("")
    @GET
    public Response getAllSubjects() {
        List<Subject> foundSubjects = subjectService.getAll();
        return Response.ok(foundSubjects)
                .build();
    }

    @Path("{id}")
    @DELETE
    public Response deleteSubject(@PathParam("id") Long id) {
        subjectService.delete(id);
        return Response.ok()
                .build();
    }

    @Path("{id}")
    @PATCH
    public Response update(@PathParam("id") Long id, Subject subject) {
        Subject patchedSubject = subjectService.patch(subject, id);

        return Response.ok(patchedSubject)
                .build();
    }

    @Path("{id}/students")
    @GET
    public Response getAllStudentsInSubject(@PathParam("id") Long id) {
        return Response.ok(subjectService.getAllStudents(id)).build();
    }
}
