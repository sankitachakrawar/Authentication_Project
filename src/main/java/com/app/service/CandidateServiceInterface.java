package com.app.service;

import java.util.List;
import org.springframework.data.domain.Page;
import com.app.dto.ICandidateListDto;
import com.app.entities.CandidateEntity;
import com.app.exceptionhandling.ResourceNotFoundException;


public interface CandidateServiceInterface {

	CandidateEntity findByEmail(String email) throws ResourceNotFoundException;
	
	List<CandidateEntity> getAllcandidates();
	Page<ICandidateListDto> getAllCandidates(String search, String from, String to);
	
	void updateStatus(Long id) throws ResourceNotFoundException;
	
	public CandidateEntity addCandidate(CandidateEntity candidateEntity);
	
	//void changePassword(Long id,ChangePasswordDto changePasswordDto,HttpServletRequest request)throws ResourceNotFoundException;

	//void forgotPassword(String token,ForgotPasswordDto forgotPassworddto,HttpServletRequest request)throws ResourceNotFoundException;

	public void updateResetPasswordToken(String token, String email) throws ResourceNotFoundException;

	 public CandidateEntity getByResetPasswordToken(String pass);
	
	 public void updatePassword(CandidateEntity candidateEntity, String newPassword);
	 
	 
	 
}
