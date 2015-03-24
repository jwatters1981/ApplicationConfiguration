package org.boynesoftware.configuration.model;


/**
 * An entity which map applications to users <br/>
 * Example<br/>
 * App1,jwatters <br/>
 * App2,jwatters <br/>
 * App2,jblogs <br/>
 * 
 * If an alert is triggered for App2 both jwatters and jblogs will be notified
 * 
 * @author johnwatters
 *
 */
public class UserApplication
{
	/**
	 * Holds the link to determine for this application and this user notify them in this way Example
	 * 
	 * userApplication.getApplicationProfile().getStartTime(); //get when userApplication.getApplicationProfile().getNotificationProfile().getNotificationMethod()//get how
	 */
	private UserApplicationProfile applicationProfile;

	public UserApplicationProfile getApplicationProfile()
	{
		return applicationProfile;
	}

	public void setApplicationProfile(UserApplicationProfile applicationProfiles)
	{
		this.applicationProfile = applicationProfiles;
	}
}
