package com.amritha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amritha.entity.Vaccine;
@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Long> {
	
}
