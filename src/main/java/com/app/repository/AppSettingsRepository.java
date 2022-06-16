package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.AppSettingsEntity;

public interface AppSettingsRepository extends JpaRepository<AppSettingsEntity, Long>{

}
