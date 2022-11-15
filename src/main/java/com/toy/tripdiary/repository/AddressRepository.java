package com.toy.tripdiary.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toy.tripdiary.domain.Address;
import com.toy.tripdiary.domain.Site;

public interface AddressRepository extends JpaRepository<Address, Long> {

	Optional<Address> findBySite(Site site);

}
