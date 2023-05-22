package com.safein.backend.service;

import java.util.List;

import com.safein.backend.dto.City;
import com.safein.backend.dto.Country;

/**
 * ICityService
 * 
 * @author Elena, Alejandro, Francisco
 */
public interface ICityService {

	/**
	 * 
	 * Get all the cities from the database
	 * 
	 * @return List of City
	 */
	public List<City> listCities(); // List every city in the database

	/**
	 * 
	 * Given the id, it return the city
	 * 
	 * @param id (long)
	 * @return City
	 */
	public City getCityById(long id); // Get the city after

	/**
	 * 
	 * Given the name of the city, it returns a list of cities that
	 * share the same name
	 * 
	 * @param city_name (String)
	 * @return List of City
	 */
	public List<City> listCitiesByName(String city_name); // List cities by name

	// TODO: Thinking about its removal and use only listCitiesByCountryCode
	/**
	 * 
	 * Given the country id, it returns the cities in the same country
	 * 
	 * @param id_country (long)
	 * @return List of cities
	 */
	public List<City> listCitiesByCountry(Country country); // List every city in the same country given the internal
															// numerical code

	/**
	 * 
	 * It returns a list of cities in the same country
	 * 
	 * @param country_code (String) (ISO 3166-1 alpha-2)
	 * @return List of City
	 */
	public List<City> listCitiesByCountryCode(String country_code); // List every city in the same country

	/**
	 * Save a city
	 * 
	 * @param city
	 * @return the city introduced
	 */
	public City saveCity(City city); // POST PUT

	/**
	 * Delete a city given the internal id
	 * 
	 * @param id
	 */
	public void deleteCity(long id); // DELETE


	/** 
	 * Returns the cities sorted by country asc
	 *  
	 * @return List of cities sorted by country id
	 */
	public List<City> listAllCitiesSortedAscByCountry();
	
	/** 
	 * Returns the cities sorted by country desc
	 *  
	 * @return List of cities sorted by country id
	 */
	public List<City> listAllCitiesSortedDescByCountry();

}