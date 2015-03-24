package org.boynesoftware.configuration.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Holds the notification details per user
 * 
 * @author johnwatters
 *
 */
@Entity
@Table(name = "NOTIFICATION_PROFILE")
public class NotificationProfile implements Serializable
{

	private static final long serialVersionUID = 8161215917690496063L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "NOTIFICATION_ID")
	private Notification notification;

	public Notification getNotification()
	{
		return notification;
	}

	public void setNotification(Notification notification)
	{
		this.notification = notification;
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}

}
