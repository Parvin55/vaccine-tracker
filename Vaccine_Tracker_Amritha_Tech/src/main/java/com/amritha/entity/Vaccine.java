package com.amritha.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vaccine")
public class Vaccine {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="vaccine_id")
    private Long vaccineId;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "interval_days", nullable = false)
    private int intervalDays;

	public Long getVaccineId() {
		return vaccineId;
	}

	public void setVaccineId(Long vaccineId) {
		this.vaccineId = vaccineId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIntervalDays() {
		return intervalDays;
	}

	public void setIntervalDays(int intervalDays) {
		this.intervalDays = intervalDays;
	}

}
