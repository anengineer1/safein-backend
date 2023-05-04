package com.safein.backend.dao;

import java.util.List;

import com.safein.backend.dto.City;
import com.safein.backend.dto.Country;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ICityDAO
 * 
 * @author Elena, Alejandro, Francisco
 */
public interface ICityDAO extends JpaRepository<City, Long> {

	// List Cities by its name
	List<City> findByName(String name);
	
	// We will use the ICountryDAO and CountryServiceImpl
	// to get the country id number from the country code
	// and then parse the id number into this
	List<City> findByCountry(Country country);
}