package org.boynesoftware.configuration.model;

import java.util.ArrayList;
import java.util.List;

/**
 * An entity which map applications to users <br/>
 * Example<br/>
 * App1,jwatters 
 * <br/>
 * App2,jwatters
 * <br/>
 * App2,jblogs 
 * <br/>
 * 
 * If an alert is triggered for App2 both jwatters and jblogs will be notified
 * @author johnwatters
 *
 */
public class UserApplication
{
	/**
	 * Holds the link to determine for this application and this user notify them in this way
	 * Example 
	 * 
	 * userApplication.getApplicationProfiles().get(x).getStartTime(); //get when
	 * userApplication.getApplicationProfiles().get(x),getNotificationProfile().getNotificationMethod()//get how
	 */
	private List<UserApplicationProfile> applicationProfiles = new ArrayList<>();

	public List<UserApplicationProfile> getApplicationProfiles()
	{
		return applicationProfiles;
	}

	public void setApplicationProfiles(List<UserApplicationProfile> applicationProfiles)
	{
		this.applicationProfiles = applicationProfiles;
	}
}
