package com.safein.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safein.backend.dto.Hotel;
import com.safein.backend.service.HotelsServiceImpl;

@RestController
@RequestMapping("/api")
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
	public List<Hotel> listHotelXSecLvl(@PathVariable(name = "seclevel") int seclevel) {
		return hotelsServiceImpl.listHotelXSecLvl(seclevel);
	}
	
	@GetMapping("/hotels/energy_suf/{ensuf}")
	public List<Hotel> listHotelsByEngSuf(@PathVariable(name = "en_suf") boolean ensuf){
		
		return hotelsServiceImpl.listHotelByEnSuf(ensuf);
	}

	@PostMapping("/hotels")
	public Hotel createHotel(@RequestBody Hotel hotels) {
		return hotelsServiceImpl.createHotel(hotels);
	}

	@PutMapping("/hotels/{id}")
	public Hotel updateHotel(@PathVariable(name = "id") Long id, @RequestBody Hotel hotels) {

		Hotel hotels_actualizado = new Hotel();

		Hotel hotels_seleccionado = hotelsServiceImpl.hotelsById(id);

		hotels_seleccionado.setAddress(hotels.getAddress());

		hotels_seleccionado.setCities(hotels.getCities());
		hotels_seleccionado.setEmail(hotels.getEmail());
		hotels_seleccionado.setSecurityLevel(hotels.getSecurityLevel());
		hotels_seleccionado.setLocation(hotels.getLocation());

		hotels_seleccionado = hotelsServiceImpl.updateHotels(hotels_seleccionado);

		System.out.println("El empleado actualizado es: " + hotels_actualizado);

		return hotels_actualizado;
	}

}
