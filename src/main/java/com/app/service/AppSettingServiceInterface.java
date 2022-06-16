package com.app.service;

import java.util.List;

import com.app.dto.AddSettingDto;
import com.app.entities.AppSettingsEntity;
import com.app.exceptionhandling.ResourceNotFoundException;

public interface AppSettingServiceInterface {

	public List<AppSettingsEntity> getAllSetting();


	public void addSetting(AddSettingDto settingDetail);


	public void updateSettingById(Long id, AddSettingDto settingDetail) throws ResourceNotFoundException;



}
