package org.syachiku.madao.messenger.resources;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.syachiku.madao.messenger.model.Comment;
import org.syachiku.madao.messenger.service.CommentService;

/**
 * Defines the paths and methods of Comment resource.
 * 
 * @author Ellis
 * @since 2016-05-19
 * @see Comment
 */
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {
	
	private CommentService commentService = new CommentService();
	
	/**
	 * Retrieve all the comments for a message.
	 * 
	 * @param messageId the ID of message, automatically add from the path
	 * @return list of comments
	 */
	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long messageId){
		return commentService.getAllComments(messageId);
	}
	
	/**
	 * Retrieve single comment for a message
	 * @param messageId the ID of message, automatically add from the path
	 * @param commentId the ID of comment, automatically add from the path
	 * @return a comment of the message
	 */
	@GET
	@Path("/{commentId}")
	public Comment getMessage(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId){
		return commentService.getComment(messageId, commentId);
	}
	
	/**
	 * Creates new comment for the message.
	 * 
	 * @param messageId the ID of message, automatically add from the path
	 * @param comment a comment to create
	 * @return a comment that is identical which is passed in when success, otherwise error page.
	 */
	@POST
	public Comment addMessage(@PathParam("messageId") long messageId, Comment comment){
		return commentService.addComent(messageId, comment);
	}
	/**
	 * Replaces exist comment.
	 * 
	 * @param messageId the ID of message, automatically add from the path
	 * @param id the ID of comment, automatically add from the path
	 * @param comment the comment wish to replace
	 * @return identical comment when success, otherwise error page.
	 */
	@PUT
	@Path("/{commentId}")
	public Comment updateMessage(@PathParam("messageId") long messageId, @PathParam("commentId") long id, Comment comment){
		comment.setId(id);
		return commentService .updateComment(messageId, comment);
	}
	
	/**
	 * Deletes specified comment.
	 * 
	 * @param messageId the ID of message, automatically add from the path
	 * @param commentId the ID of comment, automatically add from the path
	 */
	@DELETE
	@Path("/{commentId}")
	public void deleteComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId){
		commentService.removeComment(messageId, commentId);
	}
	
}
