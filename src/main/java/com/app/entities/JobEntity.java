package com.app.entities;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class JobEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long jobId;
	
	private String jobRole;
	
	private String location;

	
	
	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

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

	public JobEntity() {
		super();
		
	}

	public JobEntity(Long jobId, String jobRole, String location) {
		super();
		this.jobId = jobId;
		this.jobRole = jobRole;
		this.location = location;
	}

	@Override
	public String toString() {
		return "JobEntity [jobId=" + jobId + ", jobRole=" + jobRole + ", location=" + location + "]";
	}
	
}
