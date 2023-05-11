package com.safein.backend.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.safein.backend.dto.Country;

public interface ICountryDAO extends JpaRepository<Country, Long> {

	Country findByCountryCode(String countryCode);
	
	List<Country> findAll(Sort sort);

}