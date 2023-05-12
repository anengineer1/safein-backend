package com.safein.backend.controller;

import java.util.List;

import com.safein.backend.dto.City;
import com.safein.backend.dto.Handle;
import com.safein.backend.service.CityServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public List<City> getCitiesByCityCode(@PathVariable(name = "country_code") String country_code) {
		return cityServiceImpl.listCitiesByCountryCode(country_code);
	}

	/**
	 * Adds a city to the database
	 * 
	 * @param city
	 * @return
	 */
	@PostMapping("/cities")
	public City saveCity(@RequestBody City city) {
		return cityServiceImpl.saveCity(city);
	}

	/**
	 * Updates the info of a city
	 * 
	 * @param city
	 * @return
	 */
	@PutMapping("/cities/{id}")
	public City updateCity(@RequestBody City city) {
		City selected_city = new City();
		City updated_city = new City();

		selected_city = cityServiceImpl.getCityById(city.getId());

		selected_city.setLatitude(city.getLatitude());
		selected_city.setLongitude(city.getLongitude());
		selected_city.setName(city.getName());
		selected_city.setCountry(city.getCountry());

		updated_city = cityServiceImpl.saveCity(selected_city);

		return updated_city;
	}

	/**
	 * Deletes a city given its internal id
	 * 
	 * @param id
	 */
	@DeleteMapping("cities/{id}")
	public void deleteCity(@PathVariable(name = "id") long id) {
		cityServiceImpl.deleteCity(id);
	}

	/*
	 * Returns list of cities sorted by country id Asc
	 */
	@GetMapping("cities/countries_asc")
	public List<City> listCitiesOrderedByCountryAsc(){
		return cityServiceImpl.listAllCitiesSortedAscByCountry();
	}
	
	/*
	 * Returns list of cities sorted by country id Desc
	 */
	@GetMapping("cities/countries_desc")
	public List<City> listCitiesOrderedByCountryDesc(){
		return cityServiceImpl.listAllCitiesSortedDescByCountry();
	}
	
	
}
