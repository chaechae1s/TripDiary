package com.toy.tripdiary.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toy.tripdiary.domain.Site;

public interface SiteRepository extends JpaRepository<Site, Long>{
	
	Optional<Site> findById(Long id);
}
