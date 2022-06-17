package com.app.repository;

import java.util.Optional;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.dto.ICandidateListDto;
import com.app.entities.CandidateEntity;



public interface CandidateRepository extends JpaRepository<CandidateEntity, Long> {

	
	Optional<CandidateEntity> findByEmailAndIsActiveTrue(String email);
	
	Page<ICandidateListDto> findByOrderByIdDesc(Pageable page,Class<ICandidateListDto> candidateListDto);

	Optional<CandidateEntity> findByEmailContainingIgnoreCase(String email);

	Optional<CandidateEntity> findByIdAndIsActiveTrue(Long id);

	@Query("SELECT c FROM CandidateEntity c WHERE c.email = ?1")
    public CandidateEntity findByEmail(String email); 
     
    public CandidateEntity findByResetPassword(String pass);

}

