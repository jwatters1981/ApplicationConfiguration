package org.boynesoftware.configuration.application.service;

import java.util.List;

import org.boynesoftware.configuration.Organization;
import org.boynesoftware.configuration.model.Application;

/**
 * Handles all operations regarding applications.  Including CRUD and listing
 * @author johnwatters
 *
 */
public interface IApplicationService
{

	public List<Application> getApplicationsForOrganization(Organization org);
}
