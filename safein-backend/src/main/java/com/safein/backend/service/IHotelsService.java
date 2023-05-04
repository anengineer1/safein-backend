package com.safein.backend.service;

import java.util.List;

import com.safein.backend.dto.Hotel;


public interface IHotelsService {
	public List<Hotel> listHotels();


	public Hotel hotelsById(Long id);



	void eliminarHotels(Long id);

	Hotel updateHotels(Hotel hotels);

	Hotel saveHotels(Hotel hotels);
}
