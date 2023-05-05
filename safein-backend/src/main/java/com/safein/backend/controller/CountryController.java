package com.safein.backend.controller;

import java.util.List;

import com.safein.backend.dto.Country;
import com.safein.backend.service.CountryServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * CountryController
 * 
 * @author Elena, Alejandro, Francisco
 */
@RestController
public class CountryController {

	@Autowired
	CountryServiceImpl countryServiceImpl;

	/**
	 * Returns all countries from the database
	 * 
	 * @return List of Country
	 */
	@GetMapping("/countries")
	public List<Country> listAllCountries() {
		return countryServiceImpl.listCountries();
	}

	/**
	 * Returns a Country given its internal id
	 * 
	 * @param id
	 * @return Country
	 */
	@GetMapping("countries/id/{id}")
	public Country giveCountryContentById(@PathVariable(name = "id") long id) {
		return countryServiceImpl.getCountryById(id);
	}

	/**
	 * Returns a Country given the ISO 3166-1 alpha-2 code
	 * 
	 * @param country_code
	 * @return Country
	 */
	@GetMapping("countries/countrycode/{code}")
	public Country giveCountryContentByCountryCode(@PathVariable(name = "code") String country_code) {
		return countryServiceImpl.getCountryByCountryCode(country_code);
	}

}
