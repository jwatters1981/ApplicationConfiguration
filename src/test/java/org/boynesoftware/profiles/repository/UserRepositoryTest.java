package org.boynesoftware.profiles.repository;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.boynesoftware.configuration.model.User;
import org.boynesoftware.configuration.repository.UserRepository;
import org.boynesoftware.profiles.App;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=App.class)
public class UserRepositoryTest
{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private UserRepository repo;

	@Test
	@Transactional
	public void testCreateUser()
	{
		User user = new User();
		user.setUserId("jwatters"+Calendar.getInstance().getTimeInMillis());
		
		repo.createUser(user);
		//entityManager.find(User.class, user.getUserId());
		repo.findById(user.getUserId());
	}
}
