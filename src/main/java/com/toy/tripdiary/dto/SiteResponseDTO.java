package com.toy.tripdiary.dto;

import java.util.ArrayList;
import java.util.List;

import com.toy.tripdiary.domain.Address;
import com.toy.tripdiary.domain.BusinessHours;
import com.toy.tripdiary.domain.Site;

import lombok.Getter;

@Getter
public class SiteResponseDTO {
	
	private Long id;
	private String title;
	private String category;
	private Address address;
	private Integer star;
	private Integer hits;
	private String phoneNumber;
	private List<BusinessHours> hours = new ArrayList<BusinessHours>();
	private String etc;
	
	public SiteResponseDTO(Site entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.category = entity.getCategory();
		this.address = entity.getAddress();
		this.star = entity.getStar();
		this.hits = entity.getHits();
		this.phoneNumber = entity.getPhoneNumber();
		this.hours = entity.getHours();
		this.etc = entity.getEtc();
		
	}
	
}
