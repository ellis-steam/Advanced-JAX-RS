package org.syachiku.madao.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Takes a <code>MyDate</code> PathParam (by ParamConverter) and give a response of the date it is.<p>
 * Accepts <code>tomorrow</code>, <code>yesterday</code>, <code>today</code>, otherwise will be treat as <code>today</code>.
 * 
 * @author Ellis
 * @since 2016-05-20
 * @see MyDate
 * @see MyDateConverterProvider
 */
@Path("date/{dateString}")
public class DateResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getRequestedDate(@PathParam("dateString") MyDate myDate){
		return "Got " + myDate;
	}
}
