package com.amritha.service;

import java.time.LocalDate;
import java.util.List;

import com.amritha.entity.ImmunizationRecord;

public interface ImmunizationService {

	ImmunizationRecord addImmunization(Long userId, Long vaccineId, LocalDate doseDate);

	List<ImmunizationRecord> getRecordsByUser(Long userId);
	
	void deleteImmunization(Long id);
	
	 ImmunizationRecord updateImmunization(Long recordId, Long vaccineId, LocalDate doseDate);
}
