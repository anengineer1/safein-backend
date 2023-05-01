package com.safein.backend.controller;

import java.util.List;

import com.safein.backend.dto.City;
import com.safein.backend.service.CityServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * CityController
 * 
 * @author Elena, Alejandro, Francisco
 */
@RestController
public class CityController {

	@Autowired
	CityServiceImpl cityServiceImpl;

	/**
	 * Returns all cities inside the database
	 * 
	 * @return List of City
	 */
	@GetMapping("/cities")
	public List<City> listAllCities() {
		return cityServiceImpl.listCities();
	}

	/**
	 * Returns a City given its internal id on the database
	 * 
	 * @param id (long)
	 * @return City
	 */
	@GetMapping("/cities/id/{id}")
	public City getCityById(@PathVariable(name = "id") long id) {
		return cityServiceImpl.getCityById(id);
	}

	/**
	 * Returns all citie that share the same name
	 * 
	 * @param name (String)
	 * @return List of cities
	 */
	@GetMapping("/cities/name/{name}")
	public List<City> getCitiesByName(@PathVariable(name = "name") String name) {
		return cityServiceImpl.listCitiesByName(name);
	}

	/**
	 * Returns all cities in the country
	 * 
	 * @param country_code (String of 2 char) (ISO 3166-1 alpha-2)
	 * @return List of City
	 */
	@GetMapping("/cities/country/{country_code}")
	public List<City> getCitiesByCountryCode(@PathVariable(name = "country_code") String country_code) {
		return cityServiceImpl.listCitiesByCountryCode(country_code);
	}

}
