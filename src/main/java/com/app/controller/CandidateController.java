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


import com.app.service.CandidateServiceInterface;


@RestController
public class CandidateController {

	@Autowired
	private CandidateServiceInterface candidateServiceInterface;
	@GetMapping("/candidates")
	public @ResponseBody List<CandidateEntity> getAllcandidate()throws Exception{
		return candidateServiceInterface.getAllcandidates();
		
	}
	
	@PostMapping("/candidates")
	public ResponseEntity<CandidateEntity> saveUser(@Validated @RequestBody CandidateEntity candidateDto){
		
		return new ResponseEntity<>(candidateServiceInterface.addCandidate(candidateDto),HttpStatus.CREATED);
		
	}	
	


}
