package org.syachiku.madao.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Sample resource to demo the Security filter.
 * 
 * @author Ellis
 * @since 2016-05-20
 * @see SecurityFilter
 */
@Path("secured")
public class SecuredResource {
	
	@GET
	@Path("message")
	@Produces(MediaType.TEXT_PLAIN)
	public String securedMethod(){
		return "This API is secured.";
	}
}
