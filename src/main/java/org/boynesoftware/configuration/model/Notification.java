package org.boynesoftware.configuration.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="NOTIFICATION")
public class Notification implements Serializable{

	
	private static final long serialVersionUID = 2774901816035107122L;
	
	@Id
	@Column(name="ID")
	private Long id;
	
	@Column(name="NOT_METHOD")
	private String notificationMethod;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getNotificationMethod()
	{
		return notificationMethod;
	}

	public void setNotificationMethod(String notificationMethod)
	{
		this.notificationMethod = notificationMethod;
	}
	
	

}
