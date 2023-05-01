package com.safein.backend.service;

import java.util.List;

import com.safein.backend.dto.City;

import org.springframework.beans.factory.annotation.Autowired;

import com.safein.backend.dao.ICityDAO;
import com.safein.backend.dao.ICountryDAO;

/**
 * CityServiceImpl
 */
public class CityServiceImpl implements ICityService {

	@Autowired
	ICityDAO iCityDAO;

	@Autowired
	ICountryDAO iCountryDAO;

	@Override
	public List<City> listCities() {
		return iCityDAO.findAll();
	}

	@Override
	public City getCityById(long id) {
		return iCityDAO.findById(id).get();
	}

	@Override
	public List<City> listCitiesByName(String city_name) {
		return iCityDAO.findByName(city_name);
	}

	@Override
	public List<City> listCitiesByIdCountry(long id_country) {
		return iCityDAO.findByIdCountry(id_country);
	}

	@Override
	public List<City> listCitiesByCountryCode(String country_code) {
		return iCityDAO.findByIdCountry(iCountryDAO.findByCountryCode(country_code).getId());
	}

}
