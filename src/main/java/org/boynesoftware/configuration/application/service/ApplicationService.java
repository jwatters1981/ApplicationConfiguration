package org.boynesoftware.configuration.application.service;

import java.util.List;

import org.boynesoftware.configuration.Organization;
import org.boynesoftware.configuration.application.repository.ApplicationRepository;
import org.boynesoftware.configuration.exception.ErrorCode;
import org.boynesoftware.configuration.model.Application;
import org.boynesoftware.configuration.model.User;
import org.boynesoftware.configuration.model.UserApplication;
import org.boynesoftware.configuration.model.UserApplicationProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;

@Service
public class ApplicationService implements IApplicationService
{

	@Autowired
	private ApplicationRepository applicationRepository;
	
	@Override
	public List<Application> getApplicationsForOrganization(Organization org)
	{
		return applicationRepository.findApplicationsForOrganization(org);
	}

	@Override
	public void createApplication(Application application, Organization organization)
	{
		Preconditions.checkArgument(application != null,ErrorCode.APP_IS_NULL+" Application cannot be null");
		Preconditions.checkArgument(organization != null,ErrorCode.ORG_IS_NULL+" Organization cannot be null");
		application.setOrganization(organization);
		applicationRepository.createApplication(application);
	}

	@Override
	public UserApplication addUserToApplicationsToBeNotifiedList(User user, Application application)
	{
		Preconditions.checkArgument(user != null,ErrorCode.USER_IS_NULL+" User cannot be null");
		Preconditions.checkArgument(application != null,ErrorCode.APP_IS_NULL+" Application cannot be null");
		UserApplication userApplication = new UserApplication(user,application);
		applicationRepository.createUserApplication(userApplication);
		return userApplication;
	}

	@Override
	public void createForUserApplicationProfile(UserApplicationProfile applicationProfile)
	{
		applicationRepository.createUserApplicationProfile(applicationProfile);
	}

	@Override
	public List<UserApplication> getUserApplicationsForApplication(Application application)
	{
		Preconditions.checkArgument(application != null,ErrorCode.APP_IS_NULL+" Application cannot be null");
		Preconditions.checkArgument(application.getId() != null,ErrorCode.APP_IS_NULL+" Application cannot be null");
		return applicationRepository.findUserApplicationsByApplicationId(application.getId());
	}

}
