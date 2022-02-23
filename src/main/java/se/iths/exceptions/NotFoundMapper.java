package se.iths.exceptions;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotFoundMapper implements ExceptionMapper<NotFoundException> {

    @Override
    public Response toResponse(NotFoundException e) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(new ExceptionAsJson(e.getMessage(), Response.Status.NOT_FOUND.getStatusCode()))
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }
}
