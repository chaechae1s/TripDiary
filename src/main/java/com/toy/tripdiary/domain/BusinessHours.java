package com.toy.tripdiary.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter
@ToString
@NoArgsConstructor
public class BusinessHours {
	
	@Id @GeneratedValue
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "site_id")
	private Site site;
	private String day;
	private String dayOff;
	private String open;
	private String close;
	private String etc;

}
