package com.app.service;

import java.util.List;

import com.app.entities.JobEntity;

public interface JobServiceInterface {

	List<JobEntity> GetJobDetails();
	
	public JobEntity saveDetails(JobEntity jobEntity);
}
