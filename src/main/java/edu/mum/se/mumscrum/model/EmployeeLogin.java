package edu.mum.se.mumscrum.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class EmployeeLogin {

	@NotEmpty
	@Email
	private String email;
		
	@NotEmpty
	@Size(min=4, max=8)
	private String password;

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
}
