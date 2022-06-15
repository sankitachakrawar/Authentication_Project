package com.app.controller;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CandidateDto;
import com.app.dto.ErrorResponseDto;
import com.app.dto.ICandidateListDto;
import com.app.dto.ListResponseDto;
import com.app.dto.SuccessResponseDto;
import com.app.entities.CandidateEntity;
import com.app.exceptionhandling.ResourceNotFoundException;
import com.app.repository.CandidateRepository;
import com.app.service.CandidateServiceInterface;

@RestController
@ComponentScan
public class CandidateController {

	public CandidateController() {
		super();
		
	}
	@Autowired
	private CandidateServiceInterface candidateServiceInterface;

	
	
	@Autowired
	private CandidateRepository candidateRepository;
	
	
	
	
	@GetMapping("/candidates")

	public ResponseEntity<?> getAllcandidates(@RequestParam(defaultValue = "") String search, @RequestParam(defaultValue = "1") String pageNo, @RequestParam(defaultValue = "25") String size) {
		Page<ICandidateListDto> users = candidateServiceInterface.getAllCandidates(search, pageNo, size);

		if (users.getTotalElements() != 0) {

			return new ResponseEntity<>(new SuccessResponseDto("Success", "success", new ListResponseDto(users.getContent(), users.getTotalElements())), HttpStatus.OK);
			
		}
		return new ResponseEntity<>(new ErrorResponseDto("Data Not Found", "dataNotFound"), HttpStatus.NOT_FOUND);
		
	}

	@PreAuthorize("hasRole('addCandidate')")

	//@RequestMapping(value = "", method = RequestMethod.POST)
	@PostMapping("/candidates")
	public ResponseEntity<?> saveUser(@Valid @RequestBody CandidateDto candidate, HttpServletRequest request)

			throws Exception, DataIntegrityViolationException {

		String email = candidate.getEmail();

		Optional<CandidateEntity> databaseName = candidateRepository.findByEmailContainingIgnoreCase(email);


		if (databaseName.isEmpty()) {

			candidateServiceInterface.addCandidate(candidate, ((CandidateDto) request.getAttribute("candidateData")).getId());

			return new ResponseEntity<>(new SuccessResponseDto("Candidate Created", "candidateCreated", null),

					HttpStatus.CREATED);

		} else {

			return new ResponseEntity<>(new ErrorResponseDto("Candidate Email Id Already Exist", "candidateEmailIdAlreadyExist"),

					HttpStatus.BAD_REQUEST);

		}

	}
	
	@PreAuthorize("hasRole('changeCandidateStatus')")

	@PutMapping("/status/{id}")

	public ResponseEntity<?> editUserStatus(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {

		try {
			candidateServiceInterface.updateStatus(id);

			return new ResponseEntity<>(new SuccessResponseDto("Success", "success", null), HttpStatus.OK);

		} catch (ResourceNotFoundException e) {

			return new ResponseEntity<>(new ErrorResponseDto(e.getMessage(), "userNotFound"), HttpStatus.NOT_FOUND);
		}
	}

	/*
	 * @PreAuthorize("hasRole('getCandidateById')")
	 * 
	 * @GetMapping("/{id}")
	 * 
	 * public ResponseEntity<?> getUserById(@PathVariable(value = "id") Long id)
	 * throws ResourceNotFoundException {
	 * 
	 * 
	 * try {
	 * 
	 * 
	 * CandidateDto candidateDetail =
	 * candidateServiceInterface.getAllCandidates(null, null, null)
	 * 
	 * return new ResponseEntity<>(new SuccessResponseDto("Success", "success",
	 * candidateDetail), HttpStatus.OK);
	 * 
	 * 
	 * } catch (ResourceNotFoundException e) {
	 * 
	 * 
	 * return new ResponseEntity<>(new ErrorResponseDto(e.getMessage(),
	 * "userNotFound"), HttpStatus.NOT_FOUND);
	 * 
	 * 
	 * }
	 * 
	 * 
	 * }
	 */



}
