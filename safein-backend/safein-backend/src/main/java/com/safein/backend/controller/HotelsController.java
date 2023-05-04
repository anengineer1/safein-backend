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
public List<Hotel> listarHoteles() {
	return hotelsServiceImpl.listarHotel();
}
@GetMapping("/hotels/{id}")
public List<Hotel> listHotel(@PathVariable(name = "id") Long  id) {
	return hotelsServiceImpl.listHotel(id);
}

@GetMapping("/hotels/cities/{idcity}")
public List<Hotel> listHotelXCityId(@PathVariable(name = "idcity") int  idcity) {
	return hotelsServiceImpl.listHotelXCityId(idcity);
}


@GetMapping("/hotels/security_level/{seclevel}")
public List<Hotel> listHotelXSecLvl(@PathVariable(name = "seclevel") int  seclevel) {
	return hotelsServiceImpl.listHotelXSecLvl(seclevel);
}
@GetMapping("/hotels/energy_suficient/{ensuf}")
public List<Hotel> listHotelXEnSuf(@PathVariable(name = "ensuf") String ensuf) {
	return hotelsServiceImpl.listHotelXEnSuf(ensuf);
}

@PostMapping("/hotels")
public Hotel createHotel(@RequestBody Hotel hotels) {
	return hotelsServiceImpl.createHotel(hotels);
}

@PutMapping("/hotels/{id}")
public Hotel actualizarHotel(@PathVariable(name = "id") int id, @RequestBody Hotel hotels) {

	Hotel hotels_seleccionado = new Hotel();
	Hotel hotels_actualizado = new Hotel();

	hotels_seleccionado = hotelsServiceImpl.hotelXID(id);

	hotels_seleccionado.setNombre(hotels.getNombre());
	hotels_seleccionado.setTrabajo(hotels.getTrabajo());
	hotels_seleccionado.setSalario(hotels.getSalario());

	hotels_seleccionado = hotelsServiceImpl.actualizarHotel(hotels_seleccionado);

	System.out.println("El empleado actualizado es: " + hotels_actualizado);

	return hotels_actualizado;
}

}
