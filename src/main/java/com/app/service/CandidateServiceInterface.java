package com.app.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;

import com.app.dto.CandidateDto;
import com.app.dto.ChangePasswordDto;
import com.app.dto.ForgotPasswordDto;
import com.app.dto.ICandidateListDto;
import com.app.entities.CandidateEntity;
import com.app.exceptionhandling.ResourceNotFoundException;

public interface CandidateServiceInterface {

	CandidateEntity findByEmail(String email) throws ResourceNotFoundException;
	
	List<CandidateEntity> getAllcandidates();
	Page<ICandidateListDto> getAllCandidates(String search, String from, String to);
	
	void updateStatus(Long id) throws ResourceNotFoundException;
	
	void addCandidate(CandidateDto candidateDto,Long id);
	
	void changePassword(Long id,ChangePasswordDto changePasswordDto,HttpServletRequest request)throws ResourceNotFoundException;

	void forgotPassword(String token,ForgotPasswordDto forgotPassworddto,HttpServletRequest request)throws ResourceNotFoundException;



}
