package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.JobEntity;

public interface JobRepository extends JpaRepository<JobEntity, Long>{

}
