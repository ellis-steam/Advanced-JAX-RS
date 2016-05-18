package org.syachiku.madao.rest;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * <h1>MyResouce dummy api</h1>
 * 
 * Returns current date and time when accessing /webapi/test/ with GET method.
 * <p>
 * @author Ellis
 * @version 1.0
 * @since 2016-05-13
 */

@Path("test")
public class MyResource {
	
	/**
	 * 
	 * 
	 * @return current date and time
	 */
	
	@GET
	@Produces(value = {MediaType.TEXT_PLAIN, "text/shortdate"} )
	public Date testMethod(){
		return Calendar.getInstance().getTime();
	}
}
