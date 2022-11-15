package com.toy.tripdiary.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter
@ToString
@NoArgsConstructor
public class Address {
	
	@Id @GeneratedValue
	private Long id;
	@OneToOne
	@JoinColumn(name = "site_id")
	private Site site;
	private String address;
	private String detailAddress;
	private String sigunguCode;
	
	@Builder
	public Address(Site site, String address, String detailAddress, String sigunguCode) {
		this.site = site;
		this.address = address;
		this.detailAddress = detailAddress;
		this.sigunguCode = sigunguCode;
	}

}
