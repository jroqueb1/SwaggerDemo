package com.appsdeveloperblog.app.ws.models.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

public class UserDetailRequestModel {
	@ApiModelProperty(required = true)
	@NotNull(message="First name cannot be null")
	@Size(min = 2)
	private String firstName;
		
	@NotNull(message="Last name cannot be null")
	private String lastName;
	
	@ApiModelProperty(value="Correo electronico del usuario.", required = true)
	@NotNull(message="Email cannot be null")
	@Email(message = "Invalid email address")
	private String email;
	
	@ApiModelProperty(required = true)
	@NotNull(message="Password cannot be null")
	@Size(min = 6, max = 16, message = "Invalid password. Must be 6-16 characters")
	private String password;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
