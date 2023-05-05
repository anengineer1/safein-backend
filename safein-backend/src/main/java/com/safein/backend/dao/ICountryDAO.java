package com.safein.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safein.backend.dto.Country;

public interface ICountryDAO extends JpaRepository<Country, Long> {

	Country findByCountryCode(String countryCode);

}