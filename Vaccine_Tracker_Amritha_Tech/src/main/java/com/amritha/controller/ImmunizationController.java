package com.amritha.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amritha.dto.ImmunizationRequest;
import com.amritha.entity.ImmunizationRecord;
import com.amritha.service.ImmunizationService;

@RestController
@RequestMapping("/api/immunizations")
@CrossOrigin(origins = "*")
public class ImmunizationController {

	private final ImmunizationService immunizationService;

	public ImmunizationController(ImmunizationService immunizationService) {
		this.immunizationService = immunizationService;
	}

	// Add a vaccine dose
	@PostMapping
	public ImmunizationRecord addImmunization(@RequestBody ImmunizationRequest request) {

		return immunizationService.addImmunization(request.getUserId(), request.getVaccineId(), request.getDoseDate());
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<ImmunizationRecord>> getRecordsByUser(@PathVariable Long userId) {
	    List<ImmunizationRecord> records = immunizationService.getRecordsByUser(userId);
	    return ResponseEntity.ok(records);
	}

	// Delete a record by id
	@DeleteMapping("/{id}")
	public void deleteImmunization(@PathVariable Long id) {
		immunizationService.deleteImmunization(id);
	}

	// New: Update existing record
    @PutMapping("/{id}")
    public ResponseEntity<ImmunizationRecord> updateRecord(
            @PathVariable Long id,
            @RequestBody ImmunizationRequest request) {
        ImmunizationRecord updatedRecord = immunizationService.updateImmunization(
                id,
                request.getVaccineId(),
                request.getDoseDate());
        return ResponseEntity.ok(updatedRecord);
    }
}
