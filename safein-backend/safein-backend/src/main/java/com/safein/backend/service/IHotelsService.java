package com.safein.backend.service;

import java.util.List;

import com.safein.backend.dto.Hotel;


public interface IHotelsService {
	public List<Hotel> listarHotels();

	public Hotel guardarHotels(Hotel hotels);

	public Hotel hotelsById(int id);

	public Hotel actualizarHotels(Hotel hotels);

	public void eliminarHotels(int id);
}
