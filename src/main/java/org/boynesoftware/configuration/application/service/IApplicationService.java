package org.boynesoftware.configuration.application.service;

import java.util.List;

import org.boynesoftware.configuration.Organization;
import org.boynesoftware.configuration.model.Application;
import org.boynesoftware.configuration.model.User;
import org.boynesoftware.configuration.model.UserApplication;
import org.boynesoftware.configuration.model.UserApplicationProfile;

/**
 * Handles all operations regarding applications.  Including CRUD and listing
 * @author johnwatters
 *
 */
public interface IApplicationService
{

	/**
	 * Returns all appliations for a give organization
	 * @param org
	 * @return List of applications
	 */
	public List<Application> getApplicationsForOrganization(Organization org);
	
	/**
	 * Creates a new application for the organization
	 * @param application
	 * @throws IllegalArgumentException if application of organization is null
	 */
	public void createApplication(Application application, Organization organization) throws IllegalArgumentException;
	
	/**
	 * Create a new entry into the UserApplication table
	 * @param user The user to be notified if alerts are triggered for this application
	 * @param application - the application in question
	 * @return UserApplication - created from the user and application
	 * @throws IllegalArgumentException if user or application is null
	 */
	public UserApplication addUserToApplicationsToBeNotifiedList(User user, Application application);
	
	/**
	 * Saves the user preferences on how and when they want to be notified when an alert is triggers for an
	 * application
	 * @param applicationProfile
	 */
	public void createForUserApplicationProfile(UserApplicationProfile applicationProfile);
	
	/**
	 * Returns a list of user applications for an application.  This list can be used to determine what
	 * users need to be notified about an alert
	 * @param application
	 * @return List of UserApplication
	 */
	public List<UserApplication> getUserApplicationsForApplication(Application application);
}
