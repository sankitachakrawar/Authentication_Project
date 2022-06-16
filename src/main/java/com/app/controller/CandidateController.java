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
	/*
	 * public ResponseEntity<?> getAllcandidates(@RequestParam(defaultValue = "")
	 * String search, @RequestParam(defaultValue = "1") String
	 * pageNo, @RequestParam(defaultValue = "25") String size) {
	 * Page<ICandidateListDto> candidates =
	 * candidateServiceInterface.getAllCandidates(search, pageNo, size);
	 * 
	 * if (candidates.getTotalElements() != 0) {
	 * 
	 * return new ResponseEntity<>(new SuccessResponseDto("Success", "success", new
	 * ListResponseDto(candidates.getContent(), candidates.getTotalElements())),
	 * HttpStatus.OK);
	 * 
	 * } return new ResponseEntity<>(new ErrorResponseDto("Data Not Found",
	 * "dataNotFound"), HttpStatus.NOT_FOUND);
	 * 
	 * }
	 */
	

	//@PreAuthorize("hasRole('addCandidate')")

	//@RequestMapping(value = "", method = RequestMethod.POST)
	
	/*
	 * public ResponseEntity<?> saveUser(@Valid @RequestBody CandidateDto candidate,
	 * HttpServletRequest request)
	 * 
	 * throws Exception, DataIntegrityViolationException {
	 * 
	 * String email = candidate.getEmail();
	 * 
	 * Optional<CandidateEntity> databaseName =
	 * candidateRepository.findByEmailContainingIgnoreCase(email);
	 * 
	 * 
	 * if (databaseName.isEmpty()) {
	 * 
	 * candidateServiceInterface.addCandidate(candidate, ((CandidateDto)
	 * request.getAttribute("candidateData")).getId());
	 * 
	 * return new ResponseEntity<>(new SuccessResponseDto("Candidate Created",
	 * "candidateCreated", null),
	 * 
	 * HttpStatus.CREATED);
	 * 
	 * } else {
	 * 
	 * return new ResponseEntity<>(new
	 * ErrorResponseDto("Candidate Email Id Already Exist",
	 * "candidateEmailIdAlreadyExist"),
	 * 
	 * HttpStatus.BAD_REQUEST);
	 * 
	 * }
	 * 
	 * }
	 */
	
	
	
	/*
	 * @PreAuthorize("hasRole('changeCandidateStatus')")
	 * 
	 * @PutMapping("/status/{id}")
	 * 
	 * public ResponseEntity<?> editUserStatus(@PathVariable(value = "id") Long id)
	 * throws ResourceNotFoundException {
	 * 
	 * try { candidateServiceInterface.updateStatus(id);
	 * 
	 * return new ResponseEntity<>(new SuccessResponseDto("Success", "success",
	 * null), HttpStatus.OK);
	 * 
	 * } catch (ResourceNotFoundException e) {
	 * 
	 * return new ResponseEntity<>(new ErrorResponseDto(e.getMessage(),
	 * "userNotFound"), HttpStatus.NOT_FOUND); } }
	 */

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
