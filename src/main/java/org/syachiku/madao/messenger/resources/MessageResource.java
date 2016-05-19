package org.syachiku.madao.messenger.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.syachiku.madao.messenger.model.Message;
import org.syachiku.madao.messenger.resources.beans.MessageFilterBean;
import org.syachiku.madao.messenger.service.MessageService;

/**
 * Deinfes paths and methods of Message resource.
 * 
 * @author Ellis
 * @since 2016-5-19
 * @see Message
 */
@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService messageService = new MessageService();
	
	/**
	 * Provide messages in JSON format.
	 * 
	 * @param filterBean MessageFilterBean to set the condition of the messages retrieved.
	 * @return List of messages in JSON format.
	 * @see MessageFilterBean
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getJsonMessages(@BeanParam MessageFilterBean filterBean){
		System.out.println("JSON method called");
		
		if (filterBean.getYear() > 0) {
			return messageService.getAllMessagesForYear(filterBean.getYear());
		}
		
		if (filterBean.getStart() >= 0 && filterBean.getSize() > 0){
			return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		
		return messageService.getAllMessages();
	}
	
	/**
	 * Provide messages in XML format.
	 * 
	 * @param filterBean MessageFilterBean to set the condition of the messages retrieved.
	 * @return List of messages in XML format.
	 * @see MessageFilterBean
	 */
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Message> getXmlMessages(@BeanParam MessageFilterBean filterBean){
		System.out.println("XML method called");
		
		if (filterBean.getYear() > 0) {
			return messageService.getAllMessagesForYear(filterBean.getYear());
		}
		
		if (filterBean.getStart() >= 0 && filterBean.getSize() > 0){
			return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		
		return messageService.getAllMessages();
	}
	
	/**
	 * Retrieve a single message.
	 * 
	 * @param id the long number in the PathParam to specify the id of the message to be retrieved.
	 * @param uriInfo the UriInfo in the Context to determine the link.
	 * @return message
	 */
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long id, @Context UriInfo uriInfo){
		Message message = messageService.getMessage(id);
		message.addLink(getUriForSelf(uriInfo, message), "self");
		message.addLink(getUriForProfile(uriInfo, message), "profile");
		message.addLink(getUriForComments(uriInfo, message), "comments");
		return message;
	}
	
	/**
	 * Builds link to comments from UriInfo and Message provided.
	 * 
	 * @param uriInfo
	 * @param message the message to specify the link to be added.
	 * @return string of the builded link
	 */
	private String getUriForComments(UriInfo uriInfo, Message message) {
		URI uri = uriInfo.getBaseUriBuilder()
				.path(MessageResource.class)
				.path(MessageResource.class, "getCommentResource")
				.path(CommentResource.class)
				.resolveTemplate("messageId", message.getId())
				.build();
		return uri.toString();
	}
	
	
	/**
	 * Builds link to profile from UriInfo and Message provided.
	 * 
	 * @param uriInfo
	 * @param message the message to specify the link to be added.
	 * @return string of the builded link
	 */
	private String getUriForProfile(UriInfo uriInfo, Message message) {
		URI uri = uriInfo.getBaseUriBuilder()
					.path(ProfileResource.class)
					.path(message.getAuthor())
					.build();
		return uri.toString();
	}

	/**
	 * Builds link to itself from UriInfo and Message provided.
	 * 
	 * @param uriInfo
	 * @param message the message to specify the link to be added.
	 * @return string of the builded link
	 */
	private String getUriForSelf(UriInfo uriInfo, Message message) {
		String uri = uriInfo.getBaseUriBuilder()
							.path(MessageResource.class)
							.path(Long.toString(message.getId()))
							.build()
							.toString();
		return uri;
	}
	
	
	/**
	 * Adds message into the databaseClass.
	 * 
	 * @param message the message to be added.
	 * @param uriInfo the uriInfo to access the created message.
	 * @return a response of identical message which passed in when added successful, error page when failed.
	 * @throws URISyntaxException an Exception indicates error in syntax
	 */
	@POST
	public Response addMessage(Message message, @Context UriInfo uriInfo) throws URISyntaxException{
		Message newMessage = messageService.addMessage(message);
		String newId = String.valueOf(newMessage.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri).entity(newMessage).build();
		
		// First version of addMessage implementation
		//return messageService.addMessage(message);
	}
	
	/**
	 * Modifies existing message.
	 * 
	 * @param id long number to specify the id of the message to be modified.
	 * @param message the message to replace the existing one.
	 * @return the message passed in if success, otherwise will be an error page. 
	 */
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long id, Message message){
		message.setId(id);
		return messageService.updateMessage(message);
	}
	
	/**
	 * Deletes existing message.
	 * 
	 * @param id the long number of the id specifies which message to delete.
	 */
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long id){
		messageService.removeMessage(id);
	}
	
	/**
	 * An entry point to serve comments.
	 * 
	 * @return a commentResource to process the request of an message.
	 */
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource(){
		return new CommentResource();
	}
}