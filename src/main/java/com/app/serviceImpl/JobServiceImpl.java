package com.app.serviceImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.entities.JobEntity;
import com.app.repository.JobRepository;
import com.app.service.JobServiceInterface;



@Service
public class JobServiceImpl implements JobServiceInterface{

	@Autowired
	private JobRepository jobRepository;
	public List<JobEntity> GetJobDetails() {
		
		return jobRepository.findAll();
	}

	@Override
	public JobEntity saveDetails(JobEntity jobEntity) {

		JobEntity jobEntity2=new JobEntity();
		jobEntity2.setJobRole(jobEntity.getJobRole());
		jobEntity2.setLocation(jobEntity.getLocation());
		
		return jobRepository.save(jobEntity2);
	}

}
