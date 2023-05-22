package com.safein.backend.service;

import java.util.List;

import com.safein.backend.dto.Country;

/**
 * ICountryService
 * 
 * @author Elena, Alejandro, Francisco
 */
public interface ICountryService {

	/**
	 * Get every country in the database
	 * 
	 * @return List of Country
	 */
	public List<Country> listCountries(); // List every country in the database

	/**
	 * Get country from id
	 * 
	 * @param id (long)
	 * @return Country
	 */
	public Country getCountryById(long id); // Get by Id

	/**
	 * Get country given the ISO 3166-1 alpha-2 code
	 * 
	 * @param country_code (String of 2 char) (ISO 3166-1 alpha-2)
	 * @return
	 */
	public Country getCountryByCountryCode(String country_code); // Get by Country code
	
	
	/**
	 * Get countries ordered by country code
	 * 
	 * @return
	 */
	public List<Country> getCountriesByCountryCodeAsc(); // Get by Country code

	/**
	 * Get countries ordered by country code
	 * 
	 * @return
	 */
	public List<Country> getCountriesByCountryCodeDesc(); // Get by Country code

	/**
	 * save a Country
	 * 
	 * @param country (Country)
	 * @return Country
	 */
	public Country saveCountry(Country country); // POST PUT

	/**
	 * delete a Country given its internal id
	 * 
	 * @param country
	 */
	public void deleteCountry(long id); // DELETE
}
