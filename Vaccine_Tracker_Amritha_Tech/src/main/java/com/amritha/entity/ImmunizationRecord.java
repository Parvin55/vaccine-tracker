package com.amritha.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "immunization_record")
public class ImmunizationRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="imm_id")
	private Long immId;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@ManyToOne
	@JoinColumn(name = "vaccine_id", nullable = false)
	private Vaccine vaccine;

	@Column(name = "dose_date", nullable = false)
	private LocalDate doseDate;

	@Column(name = "next_due_date", nullable = false)
	private LocalDate nextDueDate;

	@Column(nullable = false)
	private String status;

	public Long getImmId() {
		return immId;
	}

	public void setImmId(Long immId) {
		this.immId = immId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Vaccine getVaccine() {
		return vaccine;
	}

	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}

	public LocalDate getDoseDate() {
		return doseDate;
	}

	public void setDoseDate(LocalDate doseDate) {
		this.doseDate = doseDate;
	}

	public LocalDate getNextDueDate() {
		return nextDueDate;
	}

	public void setNextDueDate(LocalDate nextDueDate) {
		this.nextDueDate = nextDueDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
