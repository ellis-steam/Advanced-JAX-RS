package org.syachiku.madao.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.syachiku.madao.messenger.exception.DataNotFoundExceptionMapper;
import org.syachiku.madao.messenger.exception.GenericExceptionMapper;

/**
 * The error message be provide to the ExceptionMapper to return.
 * 
 * @author Ellis
 * @since 2016-05-19
 * @see DataNotFoundExceptionMapper
 * @see GenericExceptionMapper
 */
@XmlRootElement
public class ErrorMessage {
	
	private String errorMessage;
	private int errorCode;
	private String documentation;
	
	public ErrorMessage(){
		
	}
	
	/**
	 * Contructs a new errorMessage.
	 * 
	 * @param errorMessage string content to describe the error
	 * @param errorCode the int number of the HTTP status code
	 * @param documentation string of docs that contain any information to solve the error. Typically a URL link. 
	 */
	public ErrorMessage(String errorMessage, int errorCode, String documentation) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
		this.documentation = documentation;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getDocumentation() {
		return documentation;
	}
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
	
}
