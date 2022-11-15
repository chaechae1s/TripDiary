package com.toy.tripdiary.domain;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
public class Site extends BaseTimeEntity {
	
	@Id @GeneratedValue
	private Long id;
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private String category;
	@OneToOne(mappedBy = "site")
	private Address address;
	@Column(columnDefinition = "integer default 0")
	private Integer star;
	@Column(columnDefinition = "integer default 0")
	private Integer hits;
	private String phoneNumber;
	@OneToMany(mappedBy = "site", cascade = CascadeType.ALL)
	private List<BusinessHours> hours = new ArrayList<BusinessHours>();
	private String etc;
	
	@Builder
	public Site(String title, String category, Address address, Integer star, Integer hits, String phoneNumber, List<BusinessHours> hours, String etc) {
		this.title = title;
		this.category = category;
		this.address = address;
		this.star = star;
		this.hits = hits;
		this.phoneNumber = phoneNumber;
		this.hours = hours;
		this.etc = etc;
	}
	
	

	

}
