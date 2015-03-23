package org.boynesoftware.configuration.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@NamedQueries({
		@NamedQuery(name = "User.findByUserId", query = "SELECT c FROM User c where c.userId = :userId") })
@Table(name = "USERS")
public class User implements Serializable {

	public static class QUERIES{
		public static String FIND_BY_USER_ID ="User.findByUserId";
	}
	private static final long serialVersionUID = 3353648245631959561L;
	
	@Id
	@Column(name="USER_ID")
	private String userId;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="MOBILE_NUMBER")
	private String mobileNumber;

	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString()
	{
		return "User [userId=" + userId + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", mobileNumber=" + mobileNumber + "]";
	}

	

}
