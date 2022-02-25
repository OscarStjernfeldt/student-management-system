package se.iths.exceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

public class InvalidIdException extends RuntimeException {

    public InvalidIdException() {
        super();
    }

    public InvalidIdException(String message) {
        super(message);
    }

    public InvalidIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidIdException(Throwable cause) {
        super(cause);
    }

    protected InvalidIdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

@Provider
class InvalidIdExceptionMapper implements ExceptionMapper<InvalidIdException> {

    @Override
    public Response toResponse(InvalidIdException e) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ExceptionsAsJson(e.getMessage(), Response.Status.BAD_REQUEST.getStatusCode()))
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }
}
