package com.app.serviceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.app.dto.ICandidateListDto;
import com.app.entities.CandidateEntity;
import com.app.exceptionhandling.ResourceNotFoundException;
import com.app.repository.CandidateRepository;
import com.app.service.CandidateServiceInterface;



@Service

public class CandidateServiceImpl implements CandidateServiceInterface{

	
	@Autowired
	private CandidateRepository candidateRepository;



	@Override
	public CandidateEntity addCandidate(CandidateEntity candidateDto) {
		
		CandidateEntity candidateEntity=new CandidateEntity();
		candidateEntity.setName(candidateDto.getName());
		candidateEntity.setEmail(candidateDto.getEmail());
		candidateEntity.setAddress(candidateDto.getAddress());
		candidateEntity.setDob(candidateDto.getDob());
		candidateEntity.setPassword(candidateDto.getPassword());
		//candidateEntity.setPassword(bcryptEncoder.encode(appSetting.getAllAppSetting().getSettings().get("vinay")));
		return candidateRepository.save(candidateEntity);
	
	}
	
	@Override
	public CandidateEntity findByEmail(String email) throws ResourceNotFoundException {
		
		CandidateEntity candidateEntity=candidateRepository.findByEmailAndIsActiveTrue(email).orElseThrow(() -> new ResourceNotFoundException("Candidate Not Found"));
		return candidateEntity;
	}

	@Override
	public List<CandidateEntity> getAllcandidates() {
		
		return candidateRepository.findAll();
	}

	@Override
	public void updateStatus(Long id) throws ResourceNotFoundException {
		CandidateEntity candidateEntity=candidateRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Candidate Not Found"));
		candidateEntity.setIsActive(!candidateEntity.getIsActive());
		return;
	}
	
	@Override
	public Page<ICandidateListDto> getAllCandidates(String search, String from, String to) {
	
		return null;
	}
	@Override
	public void updateResetPasswordToken(String token, String email) throws ResourceNotFoundException {
		
		CandidateEntity candidateEntity = candidateRepository.findByEmail(email);
        if (candidateEntity != null) {
        	candidateEntity.setResetPassword(token);
        	candidateRepository.save(candidateEntity);
        } else {
            throw new ResourceNotFoundException("Could not find any candidate with the email " + email);
        }
	}

	@Override
	public CandidateEntity getByResetPasswordToken(String pass) {
	
		return candidateRepository.findByResetPassword(pass);
	}

	@Override
	public void updatePassword(CandidateEntity candidateEntity, String newPassword) {
		
		
	}

	/*
	 * @Override public void updatePassword(CandidateEntity candidateEntity, String
	 * newPassword) { BCryptPasswordEncoder passwordEncoder = new
	 * BCryptPasswordEncoder(); String encodedPassword =
	 * passwordEncoder.encode(newPassword);
	 * candidateEntity.setPassword(encodedPassword);
	 * 
	 * candidateEntity.setResetPassword(null);
	 * candidateRepository.save(candidateEntity); }
	 */
		
}

