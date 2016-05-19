package org.syachiku.madao.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
/**
 * A demo of a variety of parameters.
 * 
 * @author Ellis
 * @since 2016-05-19
 */
@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
	
	/**
	 * Simple demo for use of MatrixParam, HeaderParam, CookieParam.
	 * 
	 * @param martrixParam matrixParam
	 * @param header header
	 * @param cookie cookie
	 * @return a string of those three params combination
	 */
	@GET
	@Path("/annotations")
	public String getParamsUsingAnnotation(@MatrixParam("param") String martrixParam,
										   @HeaderParam("customHeaderValue") String header,
										   @CookieParam("name") String cookie){
		
		return "Matrix Param: " + martrixParam + ", Header: " + header + ", Cookie: " + cookie;
	}
	
	/**
	 * A demo of context uri and cookie usage.
	 * 
	 * @param uriInfo uri
	 * @param headers header
	 * @return string of the path follows the cookie
	 */
	@GET
	@Path("/context")
	public String getParamsUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders headers){
		String path = uriInfo.getAbsolutePath().toString();
		String cookie = headers.getCookies().toString();
		return "Path: " + path + ", Cookie: " + cookie;
	}
}
