package org.boynesoftware.configuration.model;

public enum ApplicationCriticality {
	CRITICAL("Critical"),HIGH("High"), NORMAL("Normal"), LOW("Low");
	private String name;
	
	private ApplicationCriticality(String name)
	{
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
