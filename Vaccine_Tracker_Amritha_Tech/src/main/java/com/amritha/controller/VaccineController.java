package com.amritha.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amritha.entity.Vaccine;
import com.amritha.repository.VaccineRepository;

@RestController
@RequestMapping("/api/vaccines")
@CrossOrigin(origins = "*")
public class VaccineController {
	
	private final VaccineRepository vaccineRepo;

    public VaccineController(VaccineRepository vaccineRepo) {
        this.vaccineRepo = vaccineRepo;
    }

    @GetMapping
    public List<Vaccine> getAllVaccines() {
        return vaccineRepo.findAll();
    }

}
