package org.boynesoftware.configuration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
@Entity
@Table(name = "USER_APPLICATION")
@NamedQueries({ @NamedQuery(name = "UserApplication.findByApplication", query = "SELECT c FROM UserApplication c where c.application.id = :appId") })

public class UserApplication
{
	
	public static class QUERIES
	{
		public static String FIND_BY_APP =  "UserApplication.findByApplication";
	}
	@Id
	@Column(name = "ID")
	private Long id;

	@OneToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	@OneToOne
	@JoinColumn(name = "APP_ID")
	private Application application;

	public UserApplication()
	{
		super();

	}

	public UserApplication(User user, Application application)
	{
		super();
		this.user = user;
		this.application = application;
	}

	/**
	 * Holds the link to determine for this application and this user notify them in this way Example
	 * 
	 * userApplication.getApplicationProfile().getStartTime(); //get when userApplication.getApplicationProfile().getNotificationProfile().getNotificationMethod()//get how
	 */
	private UserApplicationProfile applicationProfile;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public Application getApplication()
	{
		return application;
	}

	public void setApplication(Application application)
	{
		this.application = application;
	}

	/**
	 * 
	 * @return
	 */
	public UserApplicationProfile getApplicationProfile()
	{
		return applicationProfile;
	}

	public void setApplicationProfile(UserApplicationProfile applicationProfiles)
	{
		this.applicationProfile = applicationProfiles;
	}

}
