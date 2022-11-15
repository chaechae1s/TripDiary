package com.toy.tripdiary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toy.tripdiary.domain.BusinessHours;

public interface BusinessHoursRepository extends JpaRepository<BusinessHours, Long>{
	

}
