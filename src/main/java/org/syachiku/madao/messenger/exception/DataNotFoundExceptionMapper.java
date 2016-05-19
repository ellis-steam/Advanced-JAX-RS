package org.syachiku.madao.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.syachiku.madao.messenger.model.ErrorMessage;


/**
 * The ExceptionMapper for Jersey to handle the DataNotFoundException.
 * <p>
 * In this simple implementation it returns message in the Exception and status code 404 and a link to google which should be the document.
 * 
 * @author Ellis
 * @since 2016-05-19
 * @see DataNotFoundException
 */
@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{
	
	@Override
	public Response toResponse(DataNotFoundException exception) {
		ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), 404, "http://www.google.com");
		return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
	}
	
}
