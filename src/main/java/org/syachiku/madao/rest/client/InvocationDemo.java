 package org.syachiku.madao.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Shows a way to build request with QueryParam year=2016 and invoke it separately, prints the status code.
 * 
 * @author Ellis
 * @since 2016-05-20
 */
public class InvocationDemo {

	public static void main(String[] args) {
		
		InvocationDemo demo = new InvocationDemo();
		Invocation invocation = demo.prepareRequestForMessagesByYear(2016);
		Response response = invocation.invoke();
		
		System.out.println(response.getStatus());
	}
	
	/**
	 * Builds a client request for message with year filter.
	 * 
	 * @param year int for year filter. ex: 2016
	 * @return invocation which is ready to invoke anytime.
	 */
	public Invocation prepareRequestForMessagesByYear(int year) {
		Client client = ClientBuilder.newClient();
		return client.target("http://localhost:8080/advanced-jaxrs-01/webapi/")
									 .path("messages")
									 .queryParam("year", 2016)
									 .request(MediaType.APPLICATION_JSON)
									 .buildGet();
		
	}
}
