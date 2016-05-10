package org.syachiku.madao.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.syachiku.madao.messenger.model.Message;

public class RestApiClient {

	public static void main(String[] args) {
		
		Client client = ClientBuilder.newClient();
		
		Message message = client.target("http://localhost:8080/advanced-jaxrs-01/webapi/messages/2")
				.request(MediaType.APPLICATION_JSON)
				.get(Message.class);
		
		/*
		 * You can convert the retrieved content into String class, get the actual http payload, to debug, which is much less possible to go wrong.  
		*/
		/*
		 * WebTarget target = client.target("http://localhost:8080/advanced-jaxrs-01/webapi/messages/1");
		Builder builder = target.request();
		Response response = builder.get();
		*/
		//Message message = response.readEntity(Message.class);
		System.out.println(message);
	}

}
