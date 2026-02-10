package com.amritha.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.amritha.entity.ImmunizationRecord;
import com.amritha.entity.User;
import com.amritha.entity.Vaccine;
import com.amritha.repository.ImmunizationRecordRepository;
import com.amritha.repository.UserRepository;
import com.amritha.repository.VaccineRepository;

@Service
public class ImmunizationServiceImpl implements ImmunizationService {

	private final ImmunizationRecordRepository recordRepo;
	private final UserRepository userRepo;
	private final VaccineRepository vaccineRepo;

	public ImmunizationServiceImpl(ImmunizationRecordRepository recordRepo, UserRepository userRepo,
			VaccineRepository vaccineRepo) {
		this.recordRepo = recordRepo;
		this.userRepo = userRepo;
		this.vaccineRepo = vaccineRepo;
	}

	@Override
	public ImmunizationRecord addImmunization(Long userId, Long vaccineId, LocalDate doseDate) {

		User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

		Vaccine vaccine = vaccineRepo.findById(vaccineId).orElseThrow(() -> new RuntimeException("Vaccine not found"));

		LocalDate nextDueDate = doseDate.plusDays(vaccine.getIntervalDays());
		String status = calculateStatus(nextDueDate);

		ImmunizationRecord record = new ImmunizationRecord();
		record.setUser(user);
		record.setVaccine(vaccine);
		record.setDoseDate(doseDate);
		record.setNextDueDate(nextDueDate);
		record.setStatus(status);

		return recordRepo.save(record);
	}

	@Override
	public List<ImmunizationRecord> getRecordsByUser(Long userId) {
		List<ImmunizationRecord> records = recordRepo.findByUser_UserId(userId);
		records.forEach(r -> r.setStatus(calculateStatus(r.getNextDueDate())));
		return records;
	}

	private String calculateStatus(LocalDate nextDueDate) {
		LocalDate today = LocalDate.now();

		if (today.isBefore(nextDueDate)) {
			return "UPCOMING";
		} else if (today.isEqual(nextDueDate)) {
			return "DUE TODAY";
		} else {
			return "OVERDUE";
		}
	}
	
	@Override
	public void deleteImmunization(Long id) {
	    if (!recordRepo.existsById(id)) {
	        throw new RuntimeException("Record not found");
	    }
	    recordRepo.deleteById(id);
	}
	
	@Override
	public ImmunizationRecord updateImmunization(Long recordId, Long vaccineId, LocalDate doseDate) {
	    ImmunizationRecord record = recordRepo.findById(recordId)
	            .orElseThrow(() -> new RuntimeException("Record not found"));

	    Vaccine vaccine = vaccineRepo.findById(vaccineId)
	            .orElseThrow(() -> new RuntimeException("Vaccine not found"));

	    record.setVaccine(vaccine);
	    record.setDoseDate(doseDate);
	    LocalDate nextDueDate = doseDate.plusDays(vaccine.getIntervalDays());
	    record.setNextDueDate(nextDueDate);
	    record.setStatus(calculateStatus(nextDueDate));

	    return recordRepo.save(record);
	}
}