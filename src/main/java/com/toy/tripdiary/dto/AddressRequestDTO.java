package com.toy.tripdiary.dto;

import com.toy.tripdiary.domain.Address;
import com.toy.tripdiary.domain.Site;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AddressRequestDTO {
	
	private Site site;
	private String address;
	private String detailAddress;
	private String sigunguCode;
	
	public Address toEntity() {
		return Address.builder()
				.site(site)
				.address(address)
				.detailAddress(detailAddress)
				.sigunguCode(sigunguCode)
				.build();
	}
	
	public void update(Site site, String address, String detailAddress, String sigunguCode) {
		this.site = site;
		this.address = address;
		this.detailAddress = detailAddress;
		this.sigunguCode = sigunguCode;
	}

}
