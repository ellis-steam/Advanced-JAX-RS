package org.syachiku.madao.messenger.model;

/**
 * Links that can be included in the response to make the api more HATEOAS.
 * 
 * @author Ellis
 * @since 2016-05-19
 */
public class Link {
	private String link;
	private String rel;
	
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getRel() {
		return rel;
	}
	public void setRel(String rel) {
		this.rel = rel;
	}
	
}
