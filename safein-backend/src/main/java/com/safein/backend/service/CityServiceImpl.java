package com.safein.backend.service;

import java.util.List;

import com.safein.backend.dto.City;
import com.safein.backend.dto.Country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.safein.backend.dao.ICityDAO;
import com.safein.backend.dao.ICountryDAO;

/**
 * CityServiceImpl
 */
@Service
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
	public List<City> listCitiesByCountry(Country id_country) {
		return iCityDAO.findByCountry(id_country);
	}

	@Override
	public List<City> listCitiesByCountryCode(String country_code) {
		return iCityDAO.findByCountry(iCountryDAO.findByCountryCode(country_code));
	}

	@Override
	public City saveCity(City city) {
		return iCityDAO.save(city);
	}

	@Override
	public void deleteCity(long id) {
		iCityDAO.deleteById(id);
	}

	@Override
	public List<City> listAllCitiesSortedAscByCountry() {
		return iCityDAO.findAll(Sort.by("country.id").ascending());
	}

	@Override
	public List<City> listAllCitiesSortedDescByCountry() {
		return iCityDAO.findAll(Sort.by("country.id").descending());
	}


}
