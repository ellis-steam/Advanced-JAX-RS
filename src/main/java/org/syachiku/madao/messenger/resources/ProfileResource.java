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

import org.syachiku.madao.messenger.model.Message;
import org.syachiku.madao.messenger.model.Profile;
import org.syachiku.madao.messenger.service.ProfileService;

/**
 * Deinfes paths and methods of Profile resource.
 * 
 * @author Ellis
 * @since 2016-5-19
 * @see Message
 */
@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
	
	private ProfileService profileService = new ProfileService();
	
	/**
	 * Provide all profiles.
	 * 
	 * @return list of profiles.
	 */
	@GET
	public List<Profile> getProfiles(){
		return profileService.getAllProfiles();
	}
	
	/**
	 * Provide single profile.
	 * 
	 * @param profileName the string name of the profile, which is a PathParam
	 * @return profile specified by profileName
	 */
	@GET
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName") String profileName){
		return profileService.getProfile(profileName);
	}
	
	/**
	 * Creates a new profile.
	 * 
	 * @param profile the profile to be added on the server
	 * @return identical profile instance to the profile passed in when success, otherwise error page.
	 */
	@POST
	public Profile addProfile(Profile profile){
		return profileService.addProfile(profile);
	}
	
	/**
	 * Modifies a profile on the server.
	 * 
	 * @param profileName the string name of the profile to be modified
	 * @param profile the profile object to replace the existing one on the server.
	 * @return identical profile instance to the profile passed in when success, otherwise error page.
	 */
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile){
		profile.setProfileName(profileName);
		return profileService.updateProfile(profile);
	}
	
	/**
	 * Deletes a profile on the server.
	 * 
	 * @param profileName the string name of the profile to be deleted.
	 */
	@DELETE
	@Path("/{profileName}")
	public void removeProfile(@PathParam("profileName") String profileName){
		profileService.removeProfile(profileName);
	}
}
