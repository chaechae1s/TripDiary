package com.toy.tripdiary.dto;

import java.util.ArrayList;
import java.util.List;

import com.toy.tripdiary.domain.Address;
import com.toy.tripdiary.domain.BusinessHours;
import com.toy.tripdiary.domain.Site;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SiteRequestDTO {
	
	private String title;
	private String category;
	private Address address;
	private Integer star;
	private Integer hits;
	private String phoneNumber;
	private List<BusinessHours> hours = new ArrayList<BusinessHours>();
	private String etc;
	
	public Site toEntity() {
		return Site.builder()
				.title(title)
				.category(category)
				.address(address)
				.star(star)
				.hits(hits)
				.phoneNumber(phoneNumber)
				.hours(hours)
				.etc(etc)
				.build();
	}
	
	public void update(String title, String category, Address address, String phoneNumber, List<BusinessHours> hours, String etc) {
		this.title = title;
		this.category = category;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.hours = hours;
		this.etc = etc;
	}

}
