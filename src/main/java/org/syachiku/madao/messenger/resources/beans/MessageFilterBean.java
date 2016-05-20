package org.syachiku.madao.messenger.resources.beans;

import javax.ws.rs.QueryParam;

/**
 * Provides pagination and filtering information for <code>MessageResource</code>.
 * <p>
 * Filtering by <code>year</code>, pagination with <code>start</code> offset and <code>size</code>.
 * 
 * @author Ellis
 * @since 2016-05-20
 * @see org.syachiku.madao.messenger.resources.MessageResource#getJsonMessages(MessageFilterBean)
 * @see org.syachiku.madao.messenger.resources.MessageResource#getXmlMessages(MessageFilterBean)
 */
public class MessageFilterBean {
	private @QueryParam("year") int year;
	private @QueryParam("start") int start;
	private @QueryParam("size") int size;
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
}
