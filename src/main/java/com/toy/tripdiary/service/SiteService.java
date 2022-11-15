package com.toy.tripdiary.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.toy.tripdiary.domain.Address;
import com.toy.tripdiary.domain.Site;
import com.toy.tripdiary.dto.SiteRequestDTO;
import com.toy.tripdiary.repository.AddressRepository;
import com.toy.tripdiary.repository.BusinessHoursRepository;
import com.toy.tripdiary.repository.SiteRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SiteService {
	
	@Autowired
	private final SiteRepository siteRepository;
	@Autowired
	private final AddressRepository addressRepository;
	@Autowired
	private final BusinessHoursRepository businessHoursRepository;
	
	@Transactional
	public void saveSite(SiteRequestDTO siteRequestDTO, Address address) {
		Site site = siteRepository.save(siteRequestDTO.toEntity());
		address.setSite(site);
		
		addressRepository.save(address);
		
	}

}
