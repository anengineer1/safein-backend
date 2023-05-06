package com.safein.backend.service;

import java.util.List;

import com.safein.backend.dao.ICountryDAO;
import com.safein.backend.dto.Country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CountryServiceImpl
 * 
 * @author Elena, Alejandro, Francisco
 */
@Service
public class CountryServiceImpl implements ICountryService {

	@Autowired
	ICountryDAO iCountryDAO;

	@Override
	public List<Country> listCountries() {
		return iCountryDAO.findAll();
	}

	@Override
	public Country getCountryById(long id) {
		return iCountryDAO.findById(id).get();
	}

	@Override
	public Country getCountryByCountryCode(String country_code) {
		return iCountryDAO.findByCountryCode(country_code);
	}

	@Override
	public Country saveCountry(Country country) {
		return iCountryDAO.save(country);
	}

	@Override
	public void deleteCountry(long id) {
		iCountryDAO.deleteById(id);
	}

}
