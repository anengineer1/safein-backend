package com.safein.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.safein.backend.dao.IHotelsDAO;
import com.safein.backend.dto.Hotel;

public class HotelsServiceImpl  implements IHotelsService{
	@Autowired
IHotelsDAO iHotelsDAO;
	
	public List<Hotel> listarHotel(){
		return iHotelsDAO.findAll();
	}

	public Hotel hotelXID(Long id) {
		// TODO Auto-generated method stub
		return iHotelsDAO.findById(id).get();
	}
	public Hotel actualizarHotel( Long id) {
		
		return iHotelsDAO.save(id);
	}

	public List<Hotel> listHotel(Long id) {
		// TODO Auto-generated method stub
		return iHotelsDAO.findById(id);
	}

	public Hotel createHotel(Hotel hotels) {
		// TODO Auto-generated method stub
		return iHotelsDAO.save(hotels);
	}
	
	
	
	
	

}
