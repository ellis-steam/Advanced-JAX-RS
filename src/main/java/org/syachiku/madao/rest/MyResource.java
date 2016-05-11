package org.syachiku.madao.rest;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("test")
public class MyResource {
	
	@GET
	@Produces(value = {MediaType.TEXT_PLAIN, "text/shortdate"} )
	public Date testMethod(){
		return Calendar.getInstance().getTime();
	}
}
