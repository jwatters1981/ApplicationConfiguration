package org.boynesoftware.configuration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="APPLICATION")
public class Application {

	@Id
	@Column(name="APP_ID")
	private Long applicationId;
	
	@Column(name="APP_NAME")
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="APP_URL")
	private String applicationURL;
	
	@Column(name="APP_CRITICALITY")
	@Enumerated(EnumType.STRING)
	private ApplicationCriticality criticality;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getApplicationURL() {
		return applicationURL;
	}
	public void setApplicationURL(String applicationURL) {
		this.applicationURL = applicationURL;
	}
	public ApplicationCriticality getCriticality() {
		return criticality;
	}
	public void setCriticality(ApplicationCriticality criticality) {
		this.criticality = criticality;
	}
	
	
}
