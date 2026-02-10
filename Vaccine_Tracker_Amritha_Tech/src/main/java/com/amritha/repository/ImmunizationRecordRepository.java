package com.amritha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amritha.entity.ImmunizationRecord;
@Repository
public interface ImmunizationRecordRepository extends JpaRepository<ImmunizationRecord, Long> {

	List<ImmunizationRecord> findByUser_UserId(Long userId);
}
