package org.boynesoftware.configuration.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Entity to hold a users application profile in terms of how and when the want
 * to receive notifications about applications.
 * 
 * @author johnwatters
 *
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "UserApplicationProfile.findAll", query = "SELECT c FROM UserApplicationProfile c"),
		@NamedQuery(name = "UserApplicationProfile.findByUserIdAndApplicationId", query = "SELECT c FROM UserApplicationProfile c WHERE c.application.applicationId = :applicationId and c.user.userId = :userId"),
		@NamedQuery(name = "UserApplicationProfile.findByUserIdAndApplicationIdAndActive", 
		query = "SELECT c FROM UserApplicationProfile c WHERE c.application.applicationId = :applicationId and c.user.userId = :userId and c.activated = true") })
@Table(name = "USER_APP_PROFILE")
public class UserApplicationProfile implements Serializable {

	public static class QUERIES {
		public static String FIND_ALL = "UserApplicationProfile.findAll";
		public static String FIND_BY_USER_ID_APP_ID = "UserApplicationProfile.findByUserIdAndApplicationId";
		public static String FIND_BY_USER_ID_APP_ID_AND_IS_ACTIVE = "UserApplicationProfile.findByUserIdAndApplicationIdAndActive";
	}

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private static final long serialVersionUID = 7842708881787791219L;

	@ManyToOne
	@JoinColumn(name="APP_ID")
	private Application application;

	@ManyToOne
	@JoinColumn(name="NOT_PROFILE_ID")
	private NotificationProfile notificationProfile;

	@ManyToOne
	private User user;

	@ManyToOne
	private UserApplication userApplication;
	
	private Boolean activated;

	private int startTimeHour;

	private int endTimeHour;

	private int startTimeMin;

	private int endTimeEnd;

	private String days;

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public int getStartTimeHour() {
		return startTimeHour;
	}

	public void setStartTimeHour(int startTimeHour) {
		this.startTimeHour = startTimeHour;
	}

	public int getEndTimeHour() {
		return endTimeHour;
	}

	public void setEndTimeHour(int endTimeHour) {
		this.endTimeHour = endTimeHour;
	}

	public int getStartTimeMin() {
		return startTimeMin;
	}

	public void setStartTimeMin(int startTimeMin) {
		this.startTimeMin = startTimeMin;
	}

	public int getEndTimeEnd() {
		return endTimeEnd;
	}

	public void setEndTimeEnd(int endTimeEnd) {
		this.endTimeEnd = endTimeEnd;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public NotificationProfile getNotificationProfile() {
		return notificationProfile;
	}

	public void setNotificationProfile(NotificationProfile notificationProfile) {
		this.notificationProfile = notificationProfile;
	}

}
