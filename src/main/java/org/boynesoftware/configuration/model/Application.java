package org.boynesoftware.configuration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.boynesoftware.configuration.Organization;

@Entity
@Table(name = "APPLICATION")
@NamedQueries({ @NamedQuery(name = "Application.findByOrginization", query = "SELECT c FROM Application c where c.organization.id = :orgId") })
public class Application
{

	public static class QUERIES
	{
		public static String FIND_BY_ORG = "Application.findByOrginization";
	}

	@Id
	@Column(name = "APP_ID")
	private Long id;

	@Column(name = "APP_NAME")
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "APP_URL")
	private String applicationURL;

	@Column(name = "APP_CRITICALITY")
	@Enumerated(EnumType.STRING)
	private ApplicationCriticality criticality;

	@ManyToOne
	@JoinColumn(name = "ORG_ID")
	private Organization organization;

	public Long getId()
	{
		return id;
	}

	public void setId(Long applicationId)
	{
		this.id = applicationId;
	}

	public Organization getOrganization()
	{
		return organization;
	}

	public void setOrganization(Organization organization)
	{
		this.organization = organization;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getApplicationURL()
	{
		return applicationURL;
	}

	public void setApplicationURL(String applicationURL)
	{
		this.applicationURL = applicationURL;
	}

	public ApplicationCriticality getCriticality()
	{
		return criticality;
	}

	public void setCriticality(ApplicationCriticality criticality)
	{
		this.criticality = criticality;
	}

}
