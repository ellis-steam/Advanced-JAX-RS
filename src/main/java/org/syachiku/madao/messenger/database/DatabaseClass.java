package org.syachiku.madao.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.syachiku.madao.messenger.model.Message;
import org.syachiku.madao.messenger.model.Profile;

/**
 * Dummy volatile database as a quick datasource to go through JAX-RS courses.
 * 
 * @author Ellis
 * @since 2016-05-17
 * @version 1.0
 */
public class DatabaseClass {
	
	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();
	
	/**
	 * Returns all the messages in the database.
	 * 
	 * @return All messages in a Hashmap.
	 * @see Message
	 */
	public static Map<Long, Message> getMessages(){
		return messages;
	}
	
	/**
	 * Returns all the profiles in the database.
	 * 
	 * @return All profiles in a Hashmap.
	 * @see Profile
	 */
	public static Map<String, Profile> getProfiles(){
		return profiles;
	}
}
