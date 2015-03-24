package org.boynesoftware.configuration.user.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.boynesoftware.configuration.model.User;
import org.boynesoftware.configuration.model.UserApplicationProfile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Iterables;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class UserRepository
{

	@PersistenceContext
	private EntityManager entityManager;

	public UserApplicationProfile findActiveUserApplicationProfile(String userId, String applicationId)
	{
		TypedQuery<UserApplicationProfile> query = entityManager.createNamedQuery(UserApplicationProfile.QUERIES.FIND_BY_USER_ID_APP_ID_AND_IS_ACTIVE, UserApplicationProfile.class);
		query.setParameter(1, userId);
		query.setParameter(2, applicationId);
		return Iterables.getFirst(query.getResultList(), null);
	}

	@Transactional
	public void createUser(User user)
	{
		entityManager.persist(user);
	}
	
	@Transactional
	public User findById(String userId)
	{
		return entityManager.find(User.class, userId);
		
	}
}
