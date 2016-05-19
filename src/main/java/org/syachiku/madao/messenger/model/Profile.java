package org.syachiku.madao.messenger.model;

import java.util.Date;

/**
 * The profile for a user.
 * 
 * @author Ellis
 * @since 2016-05-19
 * 
 */
public class Profile {
	
	private long id;
	private String profileName;
	private String firstName;
	private String lastName;
	private Date created;
	
	public Profile(){
	
	}
	
	
	/**
	 * Constructs a new profile.
	 * 
	 * @param id long number to indentify the profile.
	 * @param profileName string name of the profile.
	 * @param firstName string firstName of the profile owner.
	 * @param lastName string lastName of the profile owner. 
	 */
	public Profile(long id, String profileName, String firstName, String lastName) {
		super();
		this.id = id;
		this.profileName = profileName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.created = new Date();
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
	
}
