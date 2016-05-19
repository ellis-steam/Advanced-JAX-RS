package org.syachiku.madao.messenger.exception;

/**
 * Custom Exception for data could not be found situation. 
 * Thrown in MessageSercvice
 * 
 * @author Ellis
 * @since 2016-05-19
 * @see org.syachiku.madao.messenger.service.MessageService#getMessage(long)
 */
public class DataNotFoundException extends RuntimeException{

	
	private static final long serialVersionUID = 2983270983171361935L;
	
	/**
	 * 
	 * @param message the detail message string of this instance (which may be null).
	 */
	public DataNotFoundException(String message){
		super(message);
	}
}
