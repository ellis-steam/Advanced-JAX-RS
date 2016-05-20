package org.syachiku.madao.rest;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

/**
 * Sample filter for adding headers, also added some headers for Swagger UI to work with.
 * 
 * @author Ellis
 * @since 2016-05-20
 * 
 */
@Provider
public class PoweredByResponseFilter implements ContainerResponseFilter{

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		responseContext.getHeaders().add("X-Powered-By", "Syachiku Madao");
		
		//for CORS support to use Swagger UI
		responseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
		responseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, PATCH, OPTIONS");
		responseContext.getHeaders().add("Access-Control-Allow-Headers", "Content-Type, api_key, Authorization");
		
		
	}
	
}
