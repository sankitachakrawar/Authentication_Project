package com.app.serviceImpl;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.app.dto.ChangePasswordDto;
import com.app.dto.ForgotPasswordDto;
import com.app.dto.ICandidateListDto;
import com.app.entities.CandidateEntity;
import com.app.exceptionhandling.ResourceNotFoundException;
import com.app.repository.CandidateRepository;
import com.app.service.CandidateServiceInterface;
import com.app.utils.AppSetting;


@Service

public class CandidateServiceImpl implements CandidateServiceInterface{

	
	@Autowired
	private CandidateRepository candidateRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	@Autowired
	private AppSetting appSetting;

	
	@Override
	public CandidateEntity addCandidate(CandidateEntity candidateDto) {
		
		CandidateEntity candidateEntity=new CandidateEntity();
		candidateEntity.setName(candidateDto.getName());
		candidateEntity.setEmail(candidateDto.getEmail());
		candidateEntity.setAddress(candidateDto.getAddress());
		candidateEntity.setDob(candidateDto.getDob());
		candidateEntity.setPassword(bcryptEncoder.encode(appSetting.getAllAppSetting().getSettings().get("vinay")));
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
	public void forgotPassword(String token, ForgotPasswordDto forgotPassworddto, HttpServletRequest request)
			throws ResourceNotFoundException {	
		
	}

	@Override
	public void changePassword(Long id, ChangePasswordDto changePasswordDto, HttpServletRequest request)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<ICandidateListDto> getAllCandidates(String search, String from, String to) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
