package org.syachiku.madao.messenger.model;

import java.util.Date;

/**
 * Comment model, which is the comment of a message.
 * 
 * @author Ellis
 * @see Message
 */
public class Comment {
	private long id;
	private String message;
	private Date created;
	private String author;
	
	public Comment(){
		
	}

	
	
	/**
	 * Constructs a new comment.
	 * 
	 * @param id the long number to indentify the comment
	 * @param message the string content of the comment 
	 * @param author the string of the author's name
	 */
	public Comment(long id, String message, String author) {
		this.id = id;
		this.message = message;
		this.author = author;
		this.created = new Date();
	}




	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}
