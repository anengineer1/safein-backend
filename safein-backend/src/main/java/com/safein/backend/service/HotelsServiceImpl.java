package com.safein.backend.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safein.backend.dao.IHotelsDAO;
import com.safein.backend.dto.Hotel;

@Service
public class HotelsServiceImpl implements IHotelsService {
	
	@Autowired
	IHotelsDAO iHotelsDAO;

	public Hotel createHotel(Hotel hotels) {

		return iHotelsDAO.save(hotels);
	}

	public List<Hotel> listHotels() {
		
		return iHotelsDAO.findAll();
	}

	@Override
	public Hotel saveHotels(Hotel hotels) {

		return iHotelsDAO.save(hotels);
	}

	@Override
	public Hotel updateHotels(Hotel hotels) {

		return iHotelsDAO.save(hotels);
	}

	@Override
	public void eliminarHotels(Long id) {

		iHotelsDAO.deleteById(id);
	}

	public List<Hotel> listHotelXCityId(int idcity) {

		return iHotelsDAO.findHotelsByCityId(idcity);
	}

	public List<Hotel> listHotelXSecLvl(String seclevel) {

		return iHotelsDAO.findHotelsBySecurityLevel(seclevel);
	}

	public List<Hotel> listHotelByEnSuf(boolean ensuf) {

		return iHotelsDAO.findByEnergySuficient(ensuf);
	}

	public Hotel hotelsById(Long id) {

		return iHotelsDAO.findById(id).get();
	}

}
