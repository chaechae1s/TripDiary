package com.toy.tripdiary.domain;

import static org.junit.Assert.*;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.toy.tripdiary.repository.AddressRepository;
import com.toy.tripdiary.repository.SiteRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SiteTest {

	@Autowired
	SiteRepository siteRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@After
	public void end() throws Exception {
		addressRepository.deleteAll();
		siteRepository.deleteAll();
	}
	
	@Test
	public void save() throws Exception {
		//given
		Site site = Site.builder()
				.title("연남닭발")
				.category("식당")
				.phoneNumber("023265084546")
				.build();
		Site saveSite = siteRepository.save(site);
		
		Address address = Address.builder()
				.site(saveSite)
				.address("서울시")
				.detailAddress("서대문구")
				.sigunguCode("328456")
				.build();
		Address saveAddress = addressRepository.save(address);
		
		//when
		Address searchAddress = addressRepository.findBySite(saveSite).get();
				

		//then
		Assertions.assertThat(searchAddress.getId()).isEqualTo(saveAddress.getId());
	}
	

}
