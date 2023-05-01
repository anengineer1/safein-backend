package com.safein.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safein.backend.dto.Country;

public interface ICountryDAO extends JpaRepository<Country, Long> {

	// List countries by country code should be only 1 value
	public Country findByCountryCode(String country_code);

}
