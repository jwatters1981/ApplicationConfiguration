package org.boynesoftware.configuration.user.service;

import org.boynesoftware.configuration.exception.UserApplicationProfileException;
import org.boynesoftware.configuration.exception.UserException;
import org.boynesoftware.configuration.model.User;
import org.boynesoftware.configuration.model.UserApplicationProfile;

/**
 * Contains all service operations regarding the user and its profiles
 * @author johnwatters
 *
 */
public interface IUserService {

	public User getUserById(String userId);
	
	/**
	 * Returns the currently active user application profile
	 * 
	 * @param userId
	 *            - must not be null
	 * @param applicationId
	 *            - must not be null
	 * @return the current UserApplicationProfile
	 * @throws UserApplicationProfileException
	 *             if the user has not active profile
	 */
	public UserApplicationProfile getCurrentUserApplicationProfile(String userId, String applicationId);
	

	/**
	 * Create a new user
	 * 
	 * @param user
	 *            - must not be null and also must contain a userid
	 * 
	 * @throws UserException
	 */
	public void createUser(User user);
	
	/** 
	 * Udate the user
	 * @param user
	 */
	public void updateUser(User user);
	
	public void deleteUser(User user);
	
	
}
