package org.boynesoftware.configuration.application.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.boynesoftware.configuration.Organization;
import org.boynesoftware.configuration.model.Application;
import org.boynesoftware.configuration.model.UserApplication;
import org.boynesoftware.configuration.model.UserApplicationProfile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ApplicationRepository
{

	@PersistenceContext
	private EntityManager entityManager;

	public List<Application> findApplicationsForOrganization(Organization organization)
	{
		TypedQuery<Application> query = entityManager.createNamedQuery(Application.QUERIES.FIND_BY_ORG, Application.class);
		return query.setParameter("orgId", organization.getId()).getResultList();
	}

	public void createApplication(Application application)
	{
		entityManager.persist(application);
	}

	public void createUserApplication(UserApplication userApplication)
	{
		entityManager.persist(userApplication);
	}

	public void createUserApplicationProfile(UserApplicationProfile userApplicationProfile)
	{
		entityManager.persist(userApplicationProfile);
	}
	
	public List<UserApplication> findUserApplicationsByApplicationId(Long applicationId)
	{
		TypedQuery<UserApplication> query = entityManager.createNamedQuery(UserApplication.QUERIES.FIND_BY_APP, UserApplication.class);
		query.setParameter("appId", applicationId);
		return query.getResultList();
	}
}
