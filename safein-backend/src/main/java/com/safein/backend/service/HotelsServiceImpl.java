package com.safein.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.safein.backend.dao.IHotelsDAO;
import com.safein.backend.dto.Hotel;

public class HotelsServiceImpl implements IHotelsService {
	@Autowired
	IHotelsDAO iHotelsDAO;

	public Hotel createHotel(Hotel hotels) {
		// TODO Auto-generated method stub
		return iHotelsDAO.save(hotels);
	}

	public List<Hotel> listHotels() {
		// TODO Auto-generat method stub
		return iHotelsDAO.findAll();
	}

	@Override
	public Hotel saveHotels(Hotel hotels) {
		// TODO Auto-generated method stub
		return iHotelsDAO.save(hotels);
	}

	@Override
	public Hotel updateHotels(Hotel hotels) {
		// TODO Auto-generated method stub
		return iHotelsDAO.save(hotels);
	}

	@Override
	public void eliminarHotels(Long id) {
		// TODO Auto-generated method stub
		iHotelsDAO.deleteById(id);
	}

	public List<Hotel> listHotelXCityId(int idcity) {
		// TODO Auto-generated method stub
		return iHotelsDAO.findHotelsByCityId(idcity);
	}

	public List<Hotel> listHotelXSecLvl(int seclevel) {
		// TODO Auto-generated method stub
		return iHotelsDAO.findHotelsBySecLvl(seclevel);
	}
	public List<Hotel> listHotelByEnSuf(boolean ensuf){
		
		return iHotelsDAO.findByEnergy_suficient(ensuf);
	}

	public Hotel hotelsById(Long id) {
		// TODO Auto-generated method stub
		return iHotelsDAO.findById(id).get();
	}

}
