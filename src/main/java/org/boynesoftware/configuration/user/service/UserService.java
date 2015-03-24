package org.boynesoftware.configuration.user.service;

import org.boynesoftware.configuration.exception.ErrorCode;
import org.boynesoftware.configuration.exception.UserApplicationProfileException;
import org.boynesoftware.configuration.exception.UserException;
import org.boynesoftware.configuration.model.User;
import org.boynesoftware.configuration.model.UserApplicationProfile;
import org.boynesoftware.configuration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Preconditions;

@Service
public class UserService implements IUserService
{

	@Autowired
	private UserRepository userRepository;

	@Transactional(propagation = Propagation.REQUIRED)
	public User getUserById(String userId)
	{
		return userRepository.findById(userId);
	}

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
	public UserApplicationProfile getCurrentUserApplicationProfile(String userId, String applicationId) throws UserApplicationProfileException
	{
		Preconditions.checkArgument(userId != null, ErrorCode.INTERAL_ERROR + " User Id cannot be null");
		Preconditions.checkArgument(userId != null, ErrorCode.INTERAL_ERROR + " Application Id cannot be null");
		UserApplicationProfile activeUserApplicationProfile = userRepository.findActiveUserApplicationProfile(userId, applicationId);
		if (activeUserApplicationProfile == null)
		{
			throw new UserApplicationProfileException("Unable to find active user application profile for user", ErrorCode.NO_USER_APP_PROF);
		}
		return activeUserApplicationProfile;
	}

	/**
	 * Create a new user
	 * 
	 * @param user
	 *            - must not be null and also must contain a userid
	 * 
	 * @throws UserException
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void createUser(User user) throws UserException
	{
		Preconditions.checkNotNull(user, ErrorCode.INTERAL_ERROR + " User cannot be null");
		Preconditions.checkNotNull(user.getUserId(), ErrorCode.INTERAL_ERROR + " User Id cannot be null");

		if (doesUserExists(user))
		{
			throw new UserException("user " + user.getUserId() + " already exists", ErrorCode.USER_ALREADY_EXISTS);
		}
		userRepository.createUser(user);

	}

	private boolean doesUserExists(User user)
	{
		return getUserById(user.getUserId()) != null;
	}

	@Override
	public void updateUser(User user)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(User user)
	{
		// TODO Auto-generated method stub

	}
}
