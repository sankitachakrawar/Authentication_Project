package com.app.dto;

public class JobDto {

private String jobRole;
	
	private String location;

	public String getJobRole() {
		return jobRole;
	}

	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "JobDto [jobRole=" + jobRole + ", location=" + location + "]";
	}
	
}
