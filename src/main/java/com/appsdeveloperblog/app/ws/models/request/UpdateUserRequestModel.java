package com.appsdeveloperblog.app.ws.models.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUserRequestModel {
	@NotNull(message="First name cannot be null")
	@Size(min = 2)
	private String firstName;
	
	@NotNull(message="Last name cannot be null")
	private String lastName;
	

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

}
