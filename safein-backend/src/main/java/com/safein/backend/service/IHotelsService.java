package com.safein.backend.service;

import java.util.List;

import com.safein.backend.dto.Hotel;

public interface IHotelsService {
	public List<Hotel> listHotels();

	public Hotel hotelsById(Long id);

	public void eliminarHotels(Long id);

	public Hotel updateHotels(Hotel hotels);

	public Hotel saveHotels(Hotel hotels);
}
