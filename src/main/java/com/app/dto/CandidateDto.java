package com.app.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CandidateDto {
	
	public CandidateDto() {
		super();
		
	}

	private Long id;
	
	@NotBlank(message = "Name is Required*nameRequired")
	@NotEmpty(message = "Name is Required*nameRequired")
	@NotNull(message = "Name is Required*nameRequired")
	private String name;
	
	@NotBlank(message = "Email is Required*emailRequired")
	@NotEmpty(message = "Email is Required*emailRequired")
	@NotNull(message = "Email is Required*emailRequired")
	private String email;
	
	private Date dob;
	
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
