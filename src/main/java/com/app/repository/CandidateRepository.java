package com.app.repository;

import java.util.Optional;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.dto.ICandidateListDto;
import com.app.entities.CandidateEntity;



public interface CandidateRepository extends JpaRepository<CandidateEntity, Long> {

	
	Optional<CandidateEntity> findByEmailAndIsActiveTrue(String email);
	
	Page<ICandidateListDto> findByOrderByIdDesc(Pageable page,Class<ICandidateListDto> candidateListDto);



	//Page<ICandidateListDto> findByNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrDesignationIdNameContainingIgnoreCaseOrderByIdDesc(
		//	String search, String search2, String search3, Pageable paging, Class<ICandidateListDto> class1);

	Optional<CandidateEntity> findByEmailContainingIgnoreCase(String email);

	Optional<CandidateEntity> findByIdAndIsActiveTrue(Long id);


}

