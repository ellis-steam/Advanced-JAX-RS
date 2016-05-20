package org.syachiku.madao.rest.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.syachiku.madao.messenger.model.Message;


/**
 * Shows a way to get list of objects back from server using GenericType.
 * 
 * @author Ellis
 * @since 2016-05-20
 */
public class GenericDemo {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		List<Message> messages = client.target("http://localhost:8080/advanced-jaxrs-01/webapi/")
									 .path("messages")
									 .queryParam("year", 2016)
									 .request(MediaType.APPLICATION_JSON)
									 .get(new GenericType<List<Message>>(){
										 
									 });
		System.out.println(messages);
	}

}
