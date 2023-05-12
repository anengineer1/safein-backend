package com.safein.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.safein.backend.dto.Country;
import com.safein.backend.dto.Hotel;
import com.safein.backend.service.HotelsServiceImpl;

@RestController
public class HotelsController {
	@Autowired
	HotelsServiceImpl hotelsServiceImpl;

	@GetMapping("/hotels")
	public List<Hotel> listHotels() {
		return hotelsServiceImpl.listHotels();
	}

	@GetMapping("/hotels/{id}")
	public Hotel listHotelById(@PathVariable(name = "id") Long id) {
		return hotelsServiceImpl.hotelsById(id);
	}

	@GetMapping("/hotels/cities/{idcity}")
	public List<Hotel> listHotelXCityId(@PathVariable(name = "idcity") int idcity) {
		return hotelsServiceImpl.listHotelXCityId(idcity);
	}

	@GetMapping("/hotels/security_level/{seclevel}")
	public List<Hotel> listHotelXSecLvl(@PathVariable(name = "seclevel") String seclevel) {
		return hotelsServiceImpl.listHotelXSecLvl(seclevel);
	}
	
	@GetMapping("/hotels/energy_suficient/{energy_suficient}")
	public List<Hotel> listHotelsByEngSuf(@PathVariable(name = "energy_suficient") boolean ensuf){
		
		return hotelsServiceImpl.listHotelByEnSuf(ensuf);
	}
	
	@GetMapping("/hotels/asc")
	public List<Hotel> listAllCountriesAscCountryCode() {
		return hotelsServiceImpl.getHotelByCountryCodeAsc();
	}

	@GetMapping("/hotels/desc")
	public List<Hotel> listAllHotelsDescCountryCode() {
		return hotelsServiceImpl.listHotels();
	}

	@PostMapping("/hotels")
	public Hotel createHotel(@RequestBody Hotel hotels) {
		return hotelsServiceImpl.createHotel(hotels);
	}

	@PutMapping("/hotels/{id}")
	public Hotel updateHotel(@PathVariable(name = "id") Long id, @RequestBody Hotel hotels) {


		Hotel hotels_seleccionado = hotelsServiceImpl.hotelsById(id);

		hotels_seleccionado.setAddress(hotels.getAddress());
		hotels_seleccionado.setName(hotels.getName());
		hotels_seleccionado.setPhonenumber(hotels.getPhonenumber());
		hotels_seleccionado.setEnergySuficient(hotels.isEnergySuficient());
		hotels_seleccionado.setCity(hotels.getCity());
		hotels_seleccionado.setEmail(hotels.getEmail());
		hotels_seleccionado.setSecurityLevel(hotels.getSecurityLevel());
		
		hotels_seleccionado.setLatitude(hotels.getLatitude());
		hotels_seleccionado.setLongitude(hotels.getLongitude());



		return hotelsServiceImpl.updateHotels(hotels_seleccionado);
	}

}
