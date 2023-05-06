package com.safein.backend.controller;

import java.util.List;

import com.safein.backend.dto.Country;
import com.safein.backend.service.CountryServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

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

	/**
	 * POST to save the country
	 * 
	 * @param country
	 * @return
	 */
	@PostMapping("countries")
	public Country SaveCountry(@RequestBody Country country) { // POST
		return countryServiceImpl.saveCountry(country);
	}

	/**
	 * PUT to update a country
	 * 
	 * @param country
	 * @return
	 */
	@PutMapping("countries")
	public Country updateCountry(@RequestBody Country country) {

		Country selected_country = new Country();
		Country updated_country = new Country();

		selected_country = countryServiceImpl.getCountryById(country.getId());

		selected_country.setCountryCode(country.getCountryCode());
		selected_country.setCountryName(country.getCountryName());
		selected_country.setLatitude(country.getLatitude());
		selected_country.setLongitude(country.getLongitude());
		selected_country.setSituation(country.getSituation());

		updated_country = countryServiceImpl.saveCountry(selected_country);

		return updated_country;
	}

	/**
	 * Delete a country given the id
	 * 
	 * @param id
	 */
	@DeleteMapping("countries/{id}")
	public void deleteCountry(@PathVariable(name = "id") long id) {
		countryServiceImpl.deleteCountry(id);
	}

}
