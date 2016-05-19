package org.syachiku.madao.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.syachiku.madao.messenger.model.ErrorMessage;


/**
 * Generic ExceptionMapper for Jersey to handle any other exception that is not mapped, to prevent showing default tomcat error page.
 * <p>
 * In this simple implementation it returns message in the Exception and status code 500 and a link to google which should be the document.
 * 
 * @author Ellis
 * @since 2016-05-19
 */
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{
	@Override
	public Response toResponse(Throwable exception) {
		ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), 500, "http://www.google.com");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorMessage).build();
	}
}
