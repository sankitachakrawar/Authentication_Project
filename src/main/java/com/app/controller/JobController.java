package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.CandidateEntity;
import com.app.entities.JobEntity;
import com.app.service.JobServiceInterface;

@RestController
public class JobController {

	@Autowired
	private JobServiceInterface jobServiceInterface;
	
	@GetMapping("/jobs")
	public @ResponseBody List<JobEntity> GetJobDetails()throws Exception{
		return jobServiceInterface.GetJobDetails();
	
	}
	@PostMapping("jobs")
	public ResponseEntity<JobEntity> saveDetails(@Validated @RequestBody JobEntity jobEntity) {
		
		return new  ResponseEntity<>(jobServiceInterface.saveDetails(jobEntity),HttpStatus.CREATED);
		
	}
	
}
