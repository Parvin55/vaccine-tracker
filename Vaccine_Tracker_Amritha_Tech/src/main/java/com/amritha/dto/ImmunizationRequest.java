package com.amritha.dto;

import java.time.LocalDate;

public class ImmunizationRequest {
	
	private Long userId;
    private Long vaccineId;
    private LocalDate doseDate;
    
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getVaccineId() {
		return vaccineId;
	}
	public void setVaccineId(Long vaccineId) {
		this.vaccineId = vaccineId;
	}
	public LocalDate getDoseDate() {
		return doseDate;
	}
	public void setDoseDate(LocalDate doseDate) {
		this.doseDate = doseDate;
	}
}
