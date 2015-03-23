package org.boynesoftware.profiles.service;

import org.boynesoftware.configuration.model.UserApplicationProfile;
import org.boynesoftware.configuration.user.service.IUserService;
import org.junit.Test;
import org.mockito.Mockito;

public class UserServiceTest {

	@Test
	public void testGetUserProfile()
	{
		IUserService userService = Mockito.mock(IUserService.class);
		UserApplicationProfile userApplicationProfile = new UserApplicationProfile();
		userApplicationProfile.setActivated(true);
		userApplicationProfile.setEndTimeEnd(4);
		//Mockito.when(userService.getCurrentUserApplicationProfile("john.watters")).thenReturn(userApplicationProfile);
		//UserApplicationProfile applicationProfile = userService.getCurrentUserApplicationProfile("john.watters");
		
		
	}
}
